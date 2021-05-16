package com.example.productstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public interface ProductRateDataImpl extends JpaRepository<ProductRating, Long> {


	//@Modifying
	//@Query("UPDATE prod_rating_tb set rateVal=:rateVal, noOfVotes = :noOfVotes, ratingAvg = :ratingAvg, pageURL = :pageURL WHERE id = :id");
	//List<ProductRating> updateProdRate(@ModelAttribute ProductRating rateObj);
}
