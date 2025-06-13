package com.codeit.mini.service.book;

public interface IWishService {
	
	boolean toggleWish (Long memberId, Long bookId) throws Exception;
}
