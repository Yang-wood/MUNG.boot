package com.codeit.mini.repository.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.WishEntity;
import com.codeit.mini.entity.member.MemberEntity;

@Repository
public interface IWishRepository extends JpaRepository<WishEntity, Long> {
	
	List<WishEntity> findAllByMemberEntity(MemberEntity memberEntity);
	
	Optional<WishEntity> findByMemberEntityAndBookEntity(BookEntity bookEntity,
														 MemberEntity memberEntity);
}
