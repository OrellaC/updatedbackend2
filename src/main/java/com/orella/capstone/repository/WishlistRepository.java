package com.orella.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orella.capstone.models.WishlistModel;

@Repository
public interface WishlistRepository extends JpaRepository <WishlistModel, Integer>{

		List<WishlistModel> findByItemname(String itemname);

	
		
	}


