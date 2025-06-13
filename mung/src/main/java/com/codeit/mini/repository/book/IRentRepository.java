package com.codeit.mini.repository.book;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeit.mini.entity.book.RentEntity;

public interface IRentRepository extends JpaRepository<RentEntity, Long>{
	
	List<RentEntity> findByIsReturnedAndReturnDateLessThanEqual(Integer isReturned, LocalDateTime returnDate);


}
