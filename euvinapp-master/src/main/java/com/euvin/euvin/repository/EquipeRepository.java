package com.euvin.euvin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.euvin.euvin.models.EquipeModel;

@Repository
public interface EquipeRepository extends JpaRepository<EquipeModel, Long>{
	
}
