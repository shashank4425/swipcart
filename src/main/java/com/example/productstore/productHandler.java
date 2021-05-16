package com.example.productstore;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.function.Consumer;

import javax.jws.soap.SOAPBinding.Use;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.print.attribute.standard.Media;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javassist.NotFoundException;
@Controller
public class productHandler{
	
	@Autowired
	ProductServices prodService;
    
	@Autowired
	ServletContext context;
	
	ArrayList<List> arrList=new ArrayList<List>();
	List<trendingproduct> trend_prod=new ArrayList<trendingproduct>();
	
	@RequestMapping("/")
	public String IndexProduct(HttpSession session, Model mv, HttpServletResponse res) {
		
		return "index";
	}
	@RequestMapping("/smartphone")
	public String SmartPhone() {
		return "smartphone";
	}
	
	@RequestMapping("/smartphones")
	public String SmartPhones() {
		return "smartphones";
	}
	@RequestMapping("/accessories")
	public String EarPhone() {
		return "accessories";
	}
	@RequestMapping("/products")
	public String Products() {
		return "products";
	}
	
	@RequestMapping(value="user-authorisation", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> UserAuthorisation(HttpSession session,HttpServletResponse res) throws NotFoundException{
		HashMap<String, Object> hm=new HashMap<String, Object>();
		  hm.put("sessionId", session.getAttribute("userId"));
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
	
	int otp;
	@PostMapping(value="/api-user_reg", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> addUser(@ModelAttribute user users,@RequestParam("emailId") String emailId,@RequestParam("password") String Password, @RequestParam("confirmpassword") String confirmPassword,HttpSession session, HttpServletResponse res){
		HashMap<String, Object> hm=new HashMap<String, Object>();
		List<Object> lists=new ArrayList<Object>();
		user add_user=new user();
		add_user.setEmailId(emailId);
		add_user.setPassword(Password);
		add_user.setConfirmPassword(confirmPassword);
		Random random=new Random();
		 otp=100101+random.nextInt(900000);
		// email send start
		  Properties props=new Properties();
		  props.setProperty("mail.smtp.user", emailId);
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
		  
		  Session mailsession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication("thanksbtc03@gmail.com", "Singh@4425");
				}
			});
		  try{
				 
				String body="<p>Hi,</p> <br>"
						+ "<p>Your verification code : "+ otp +"</p> <br>"
						+ "<p>Please do not share your otp with anyone.</p><br>"
						+ "<p>Thanks & Regards</p>"
						+ "<p>Swipe Cart Team</p> <br>";
						
				
				MimeMultipart mimemultipart=new MimeMultipart();
				BodyPart mimebody=new MimeBodyPart();
				mimebody.setContent(body,"text/html");
				mimemultipart.addBodyPart(mimebody);
				
				MimeMessage mess=new MimeMessage(mailsession);
				 mess.setFrom(new InternetAddress(emailId));
				 mess.setSubject("[Swipe Cart] Your Verification code");
				 mess.setText("this is from the admin");
				 mess.setContent(mimemultipart);
				 mess.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
				 Transport.send(mess);
				 System.out.println("called success..");
				 System.out.println("Mail sent success");
				 }catch(Exception e) {
				 e.printStackTrace();
	 	   }
		 // email end
		lists.add(add_user);	
		hm.put("resCode", res.getStatus());
		hm.put("resMess", "Your (OTP) sent successfully to "+emailId);
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
	
	@PostMapping(value="/api-varification_user_auth", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> VerifyUser(@RequestParam("emailId") String emailId,@RequestParam("password") String Password, @RequestParam("confirmpassword") String confirmPassword,@RequestParam("otp") String otppin,HttpSession session, HttpServletResponse res){
		HashMap<String, Object> hm=new HashMap<String, Object>();
		List<Object> lists=new ArrayList<Object>();
		
		if(otppin.isEmpty() || otppin==null || Integer.parseInt(otppin)!=otp) {
			hm.put("resCode", "1");
			hm.put("resStatus", res.getStatus());
			hm.put("resMess", "Entered "+otppin+" is invalid ");
		}
		else {
			user add_user=new user();
			add_user.setEmailId(emailId);
			add_user.setPassword(Password);
			add_user.setConfirmPassword(confirmPassword);
			
			prodService.addUser(add_user);
			session.setAttribute("userId",add_user.getId());
		}	
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
	@PostMapping(value="/api-user_logauth", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> loginUser(@ModelAttribute user users, @RequestParam("emailId") String emailId,@RequestParam("Password") String password,HttpSession session,HttpServletResponse res) throws NotFoundException{
		HashMap<String, Object> hm=new HashMap<String, Object>();
		List<user> user=new ArrayList<user>();
		List<Object> lists=new ArrayList<Object>();
				
		user=prodService.UserAuthLogin(emailId,password);
	   if(user.size()>0) {
		    hm.put("resCode","0");
		    hm.put("resSatus",res.getStatus());
		    session.setAttribute("userId",user.get(0).id);
	   }
	   else {
		   hm.put("resCode","1");
		   hm.put("resStatus",res.SC_NOT_FOUND);
		   hm.put("errMess", "Sorry! We can't recognize you. Try again");
	   }
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
	
	@GetMapping(value="user-profile-authentication={id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> UserProfile(@PathVariable Long id,HttpSession session,HttpServletResponse res) throws NotFoundException{
		HashMap<String, Object> hm=new HashMap<String, Object>();
			hm.put("details", prodService.UserAuthProfile(id));
			
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
		
	@RequestMapping(value="/logout_auth", produces = MediaType.APPLICATION_JSON)
	public ModelAndView logouUser(HttpSession session,HttpServletResponse res) throws NotFoundException{
		HashMap<String, Object> hm=new HashMap<String, Object>();
		session.removeAttribute("userId");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("/ProductStore/addTrendingProduct")
    public ResponseEntity<Object> list(HttpServletResponse res) {	
		List<Object> lists=new ArrayList<Object>();
		JSONParser parser=new JSONParser();
		
		try {
		 FileReader file=new FileReader("src/main/resources/json/product.json");
		Object object=parser.parse(file);
		
			lists.add(object);
			JSONObject jobje=new JSONObject(object.toString());
			//JSONObject jsondata=jobje.getJSONObject("trending_prod");
			Iterator<String> itr=jobje.keys();
			String key = (String) itr.next();

			JSONArray tags = jobje.optJSONArray(key);
			for(int i=0;i<tags.length();i++) {
				trendingproduct trendProd=new trendingproduct();
				trendProd.setId(Long.parseLong(tags.getJSONObject(i).get("id").toString()));
				 trendProd.setProdid(tags.getJSONObject(i).get("prodid").toString());
				 trendProd.setProdName(tags.getJSONObject(i).get("prodName").toString());
				 trendProd.setProdTitle(tags.getJSONObject(i).get("prodTitle").toString());
				 trendProd.setProdPath(ServletUriComponentsBuilder.fromCurrentContextPath().path("/content/resource").build()+tags.getJSONObject(i).get("prodPath").toString());
				 trendProd.setProdCamara(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodCamara").toString());
			     trendProd.setProdBattery(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodBattery").toString());
				 trendProd.setProdOfferPrice(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodOfferPrice").toString());
				 trendProd.setProdPrevPrice(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodPrevPrice").toString());
				 trendProd.setProdRam(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodRam").toString());
				 trendProd.setProdRom(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodRom").toString());
				 trendProd.setProdDisplaySize(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodDisplaySize").toString());
				 trendProd.setProdColor(tags.getJSONObject(i).getJSONObject("prod_spec").getString("prodColor").toString());
				String ProdUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/smartphone?brand_new_id=").build()+tags.getJSONObject(i).get("id").toString();
				 trendProd.setProdUri(ProdUri);
				 prodService.addTrendProd(trendProd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(lists, HttpStatus.OK);
    	
    }
	
	@RequestMapping("/trending/api-product-list")
    public ResponseEntity<Object> trending_list(HttpSession session,HttpServletResponse res) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		if(session.getAttribute("emailId")==null) {
			System.out.println("null");
			hm.put("user_sess", null);
		}
		else{
			System.out.println(session.getAttribute("emailId"));	
			hm.put("user_sess", "not_null");
		}
		
		trend_prod=prodService.getTrendingProdList();
		hm.put("trendingProducts", trend_prod);
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
		
	}

	@GetMapping("brand_new_id={id}")
	public ResponseEntity<Object> getProduct(@PathVariable Long id, HttpServletResponse res,HttpSession session){
		List<trendingproduct> product_item=new ArrayList<trendingproduct>();
		HashMap<String, Object> hm=new HashMap<String, Object>();
		trendingproduct prodStore=new trendingproduct();
		if(session.getAttribute("emailId")==null) {
			System.out.println("null");
			hm.put("user_sess", null);
		}
		else{
			System.out.println(session.getAttribute("emailId"));	
			hm.put("user_sess", "not_null");
		}
       prodStore=prodService.getProductById(id);
       
       product_item.add(prodStore);
       hm.put("product_Detail", product_item);
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
	}
	@RequestMapping("brand_products_id={prodid}")
    public ResponseEntity<Object> getProducts(@PathVariable String prodid,HttpServletResponse res,HttpSession session) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		if(session.getAttribute("emailId")==null) {
			System.out.println("null");
			hm.put("user_sess", null);
		}
		else{
			System.out.println(session.getAttribute("emailId"));	
			hm.put("user_sess", "not_null");
		}
		trend_prod=prodService.getProductsById(prodid);
		hm.put("trendingProducts", trend_prod);
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
		
	}
	@RequestMapping("api-brand-prod-name={prodName}")
    public ResponseEntity<Object> getProductbyName(@PathVariable String prodName,HttpServletResponse res) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		trend_prod=prodService.getProductByprod_name(prodName);
		hm.put("trendingProduct", trend_prod);
		return new ResponseEntity<Object>(hm,HttpStatus.OK);
		
	}
	
	@GetMapping("/ProductStore/getTrendlist")
    public ResponseEntity<Object> listItems(HttpServletResponse res) {	
		List<Object> lists=new ArrayList<Object>();
		JSONParser parser=new JSONParser();
		Object object=new Object();
		try {
		 FileReader file=new FileReader("src/main/resources/json/home_prod_list.json");
		 object=parser.parse(file);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(object, HttpStatus.OK);	
    }
	
	@RequestMapping(value="attr_brand_new_id={elcid}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> getEarphone(@PathVariable String elcid, HttpServletResponse res,HttpSession session,Model model){
		System.out.println("called");
		HashMap<String, Object> hm=new HashMap<String, Object>();
		List<Object> lists=new ArrayList<Object>();
		JSONParser parser=new JSONParser();
		Object object=new Object();
		int t=0;
		try {
			 FileReader file=new FileReader("src/main/resources/json/home_prod_list.json");
			 object=parser.parse(file);
			 JSONObject jobje=new JSONObject(object.toString());	
				Iterator<String> itr=jobje.keys();
				
				String key = (String) itr.next();
				JSONObject jobj=jobje.getJSONObject(key);
				JSONArray jarr=jobj.getJSONArray("products");
			     for(int i=0;i<jarr.length();i++) {
					jarr.length();
					JSONArray arrlist=jarr.getJSONArray(i);
					 JSONObject rec = arrlist.getJSONObject(0);
					 JSONArray jar=rec.getJSONArray("tabs");
				
					 JSONObject jobjj=jar.getJSONObject(0);
						for (int j = 0; j < jobjj.getJSONArray("columns").length(); ++j) {
							if(jobjj.getJSONArray("columns").getJSONObject(j).getString("elcid").toString().matches(elcid)) {
								object=jobjj.getJSONArray("columns").getJSONObject(j).toString();
							}  
				}
			}		
			}catch(Exception e) {
				e.printStackTrace();
			}       
	
		return new ResponseEntity<Object>(object,HttpStatus.OK);
	}
	
	@RequestMapping(value="api-brand-elec-name={name}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Object> getAccessoriesbyName(@PathVariable String name,HttpServletResponse res) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		List<Object> lists=new ArrayList<Object>();
		JSONParser parser=new JSONParser();
		Object object=new Object();
		try {
			 FileReader file=new FileReader("src/main/resources/json/home_prod_list.json");
			 object=parser.parse(file);
			 System.out.println(object.toString());
			 JSONObject jobje=new JSONObject(object.toString());
			 System.out.println(object);
				Iterator<String> itr=jobje.keys();
				String key = (String) itr.next();
				JSONObject jobj=jobje.getJSONObject(key);
				JSONArray jarr=jobj.getJSONArray("products");
						
				for(int i=0;i<jarr.length();i++) {
					jarr.length();
					JSONArray arrlist=jarr.getJSONArray(i);
					 JSONObject rec = arrlist.getJSONObject(0);
					 JSONArray jar=rec.getJSONArray("tabs");
				
					 JSONObject jobjj=jar.getJSONObject(0);
						for (int j = 0; j < jobjj.getJSONArray("columns").length(); ++j) {
							if(jobjj.getJSONArray("columns").getJSONObject(j).getString("name").toString().matches(name)) {
								object=jobjj.getJSONArray("columns").getJSONObject(j).toString();
								lists.add(object);
								lists.toString();	
							}	  
				}
			}		
		
			}catch(Exception e) {
				e.printStackTrace();
			}       
	
		return new ResponseEntity<Object>(lists.toString(),HttpStatus.OK);
	}
		
	@RequestMapping(value="/All_brand_products_id={prodid}")
    public ResponseEntity<Object> getProductsItems(@PathVariable String prodid,HttpServletResponse res,HttpSession session) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		JSONParser parser=new JSONParser();
		Object object=new Object();
		JSONObject productobj=null;
		try {
			 FileReader file=new FileReader("src/main/resources/json/home_prod_list.json");
			 object=parser.parse(file);
			 System.out.println(object.toString());
			 JSONObject jobje=new JSONObject(object.toString());
				//JSONObject jsondata=jobje.getJSONObject("trending_prod");
			 System.out.println(object);
				Iterator<String> itr=jobje.keys();
				
				String key = (String) itr.next();
				productobj=jobje.getJSONObject(key);
				
				
		   }catch(Exception e) {
			  e.printStackTrace();
		   }
		return new ResponseEntity<Object>(object,HttpStatus.OK);
	}

	@GetMapping(value="/content/resource/{fileNames}")
	@CrossOrigin
	ResponseEntity<Resource> getImageList(@PathVariable String fileNames){
	
		Resource resource=ProductServices.getImages(fileNames);
		org.springframework.http.MediaType contType= org.springframework.http.MediaType.IMAGE_PNG;
			return ResponseEntity.ok()
					.contentType(contType)
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:fileName="+resource.getFilename()).body(resource);
	}
	
	
	@PostMapping(value="/api-save-rating")
	public ResponseEntity<Object> updateRating(@ModelAttribute ProductRating rateObj, Long id, HttpServletResponse res) throws NotFoundException{
		HashMap<String, Object> hm=new HashMap<String, Object>();
		JSONArray jarr=new JSONArray();
		System.out.println(rateObj.getRateVal());
		Optional<ProductRating> data=prodService.getProdRating(id);
		Long noOfVotes=data.get().getNoOfVotes()+1;
		rateObj.setProdId(id);
		rateObj.setNoOfVotes(noOfVotes);
		rateObj.setRateVal(rateObj.getRateVal()+data.get().getRateVal());
		double rateAvg=Math.round(rateObj.getRateVal() / ((double)noOfVotes)*10.0)/10.0;
		
	   rateObj.setRatingAvg(rateAvg);
				
		prodService.updateProdRate(rateObj);
		if(res.getStatus()==200) {
			hm.put("statusCode", res.getStatus());
			hm.put("statusMess","Your Details has been saved successfully.");
		}
		else {
			hm.put("statusCode", res.getStatus());
			hm.put("statusMess",res.SC_BAD_REQUEST);
		}
		return new ResponseEntity<Object>(hm, HttpStatus.OK);
	}
	
	@GetMapping("/api-get-rating")
    public ResponseEntity<Object> getRating(Long id,HttpServletResponse res) {	
		List<Object> lists=new ArrayList<Object>();
		Optional<ProductRating> hm=prodService.getProdRating(id);
		return new ResponseEntity<Object>(hm, HttpStatus.OK);	
    }
}
   