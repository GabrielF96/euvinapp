package com.euvin.euvin.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.euvin.euvin.models.PontoModel;
import com.euvin.euvin.models.User;

public interface PontoRepository extends JpaRepository<PontoModel, Long>{
	PontoModel findByDataPontoAndUsuarioPonto(LocalDate dataPonto, User usuarioPonto);
}
