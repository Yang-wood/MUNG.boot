package com.codeit.mini.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeit.mini.entity.book.ReviewEntity;

public interface IReviewRepository extends JpaRepository<ReviewEntity, Long>{

}
