package com.pr.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pr.entity.ClientOrderEntity;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrderEntity, Long> {

	List<ClientOrderEntity> findAllByOrderDate(LocalDate date);
	
}