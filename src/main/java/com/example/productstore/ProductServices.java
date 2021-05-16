package com.example.productstore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antlr.StringUtils;
import javassist.NotFoundException;

@org.springframework.stereotype.Service
class ProductServices{

	
	@Autowired
	private userDataImpl userdataimpl;
	@Autowired
	private TrendingDataImpl trenDataImpl;
	
	@Autowired
	ProductRateDataImpl proddataImpl;
	EntityManager entitymgr;
//	public productstore addProduct(productstore product) {
//		return prodDataImpl.save(product);
//	}

//	public List<productstore> getProducts() {
//		// TODO Auto-generated method stub
//		return prodDataImpl.findAll();
//	}

	private static Path fileStoragePath;
	private static String FileStorageLocation;	
	public ProductServices(@Value("${file.storage.location:images}") String FileStorageLocation){
		this.FileStorageLocation=FileStorageLocation;
		fileStoragePath=Paths.get(FileStorageLocation).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(fileStoragePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String StoreFile(MultipartFile file) {
		// TODO Auto-generated method stub
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		Path filesPath=Paths.get(fileStoragePath + "\\"+ fileName);
		try {
			Files.copy(file.getInputStream(), filesPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

	public static org.springframework.core.io.Resource getImages(String fileNames) {
		Path path=Paths.get(FileStorageLocation).toAbsolutePath().resolve(fileNames);
		org.springframework.core.io.Resource resource;
		try {
			 resource=new UrlResource(path.toUri());
		}catch(Exception e) {
			throw new RuntimeException("issue to read file");
		}
		if(resource.exists() || resource.isReadable()) {
			return resource;
		}
		else {
			throw new RuntimeException("file not exists");
		}
		// TODO Auto-generated method stub
		
	}


	public trendingproduct  getProductById(Long id) {
		trendingproduct prodst=new trendingproduct();
		trendingproduct trendingproduct=null;
		Optional<trendingproduct> optionalId=trenDataImpl.findById(id);
		
		if(optionalId.isPresent()) {
			trendingproduct=optionalId.get();		
		}
		return trendingproduct;
	}

	public void addTrendProd(trendingproduct trendProd) {
		// TODO Auto-generated method stub
		trenDataImpl.save(trendProd);
	}

	public List<trendingproduct> getTrendingProdList() {
		
		return trenDataImpl.findAll();
		// TODO Auto-generated method stub
		
	}

	public List<trendingproduct> getProductsById(String prodid) {
		// TODO Auto-generated method stub
		return trenDataImpl.findAll();
	}

	public List<trendingproduct> getProductByprod_name(String prodName) {
		// TODO Auto-generated method stub
		System.out.println(trenDataImpl.findByprodName(prodName));

		return trenDataImpl.findByprodName(prodName);
	}

	public void addUser(user add_user) {
		// TODO Auto-generated method stub
		trenDataImpl.save(add_user);
	}

	public List<user> UserAuthLogin(String emailId,String password) throws NotFoundException {
		// TODO Auto-generated method stub
	List<user> users=userdataimpl.findByemailId(emailId,password);
	if(users == null) {
		 throw new NotFoundException("not found emailid");
	}
	return users;
	}
	
	public Optional<user> UserAuthProfile(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
    Optional<user> users= userdataimpl.findById(id);
	if(users != null) {
		return users;
	}
	throw new NotFoundException("Profile not found");
	}

	
	public void updateProdRate(ProductRating rateObj) {
	
		proddataImpl.save(rateObj);
	}

	

	public Optional<ProductRating> getProdRating(Long id) {
		// TODO Auto-generated method stub
		Optional<ProductRating> jObj=proddataImpl.findById(id);
		if(jObj != null) {
			return jObj;
		}
		try {
			throw new NotFoundException("Profile not found");
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jObj;
	}

	/*public Optional<ProductRating> getProdRate(Long id) throws NotFoundException {
	Optional<ProductRating> ratings=proddataImpl.findById(id);
	if(ratings.isPresent()) {
		return ratings;
	}
		throw new NotFoundException("not found");
	}*/

}
