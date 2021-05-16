package com.example.productstore;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public interface userDataImpl extends JpaRepository<user, Long> {

	@Query("FROM users_tb WHERE emailId = ?1 AND password = ?2")
	List<user> findByemailId(@PathParam("emailId") String emailId,@PathParam("password") String password);
	//user findByusername(String username);
	
}
