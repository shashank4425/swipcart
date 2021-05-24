package com.example.productstore;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@Controller
public class CartlistHandler {

	@RequestMapping("/VCLSwipcartDetails/cartilist")
	public ResponseEntity<Object> UserAuthorisation(cartlistitem cartitem, HttpSession session,HttpServletResponse res) throws NotFoundException{
		System.out.println(cartitem);
		return new ResponseEntity<Object>(cartitem,HttpStatus.OK);
	}
}
