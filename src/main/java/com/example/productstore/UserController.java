package com.example.productstore;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String Profile() {
		return "profile";
	}
	@RequestMapping(value="/viewcart", method = RequestMethod.GET)
	public String ViewCarts() {
		return "cart";
	}
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public String ViewOrders() {
		return "orders";
	}
	@RequestMapping("/user-auth")
	public String userAuth() {
		return "user-auth";
	}
}
