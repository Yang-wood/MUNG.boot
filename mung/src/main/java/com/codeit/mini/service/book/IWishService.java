package com.codeit.mini.service.book;

import com.codeit.mini.entity.book.WishEntity;

public interface IWishService {
	
	WishEntity addWished(Long bookId, Long memberId) throws Exception;
	
	boolean removeWished(Long bookId, Long memberId) throws Exception;
	
	boolean isWished(Long bookId, Long memberId) throws Exception;
}
