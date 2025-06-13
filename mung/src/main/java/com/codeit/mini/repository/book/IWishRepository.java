package com.codeit.mini.repository.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.WishEntity;
import com.codeit.mini.entity.member.MemberEntity;

public interface IWishRepository extends JpaRepository<WishEntity, Long> {
	
	Optional<WishEntity> findByMemberEntityAndBookEntity(MemberEntity memberEntity, BookEntity bookEntity);
}
