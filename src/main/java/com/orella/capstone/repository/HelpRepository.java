package com.orella.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orella.capstone.models.HelpModel;


@Repository
public interface HelpRepository extends JpaRepository <HelpModel, Integer> {

	List<HelpModel> findByIssuetype(String issuetype);

	

}
