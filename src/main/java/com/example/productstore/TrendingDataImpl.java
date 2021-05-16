package com.example.productstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendingDataImpl extends JpaRepository<trendingproduct, Long>{

	List<trendingproduct> findByprodName(String prodName);

	void save(user add_user);

	
}
