package com.codeit.mini.book;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codeit.mini.SampleData.SampleMemberRepo;
import com.codeit.mini.dto.book.ReviewDTO;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.entity.book.ReviewEntity;
import com.codeit.mini.entity.member.MemberEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.book.IReviewRepository;
import com.codeit.mini.repository.book.IWishRepository;
import com.codeit.mini.service.book.IBookService;
import com.codeit.mini.service.book.IRentService;
import com.codeit.mini.service.book.IReviewService;
import com.codeit.mini.service.book.IWishService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class SampleRegTests {
	
	@Autowired
	private SampleMemberRepo memberRepo;
	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private IRentRepository rentRepository;
	@Autowired
	private IWishRepository wishRepository;
	@Autowired
	private IReviewRepository reviewRepository;
	
	@Autowired
	private IBookService bookService;
	@Autowired
	private IRentService rentService;
	@Autowired
	private IWishService wishService;
	@Autowired
	private IReviewService reviewService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final int NUM_LENGTH = 200;
    private static final int MAX_MEMBER_ID = 200;
    private static final int MAX_BOOK_ID = 63;
    private static final int MAX_RENT_ID = 202;
    private static final int MAX_RATING = 5;
	
	
	// 테스트용 회원 입력
//	@Test
//	void testRegMember() {
//		List<MemberEntity> dummyMembers = IntStream.rangeClosed(1, MAX_MEMBER_ID)
//				.mapToObj(i -> {
//					String loginId = "user" + String.format("%03d", i); // user001, user002...
//					String email = "email" + String.format("%03d", i) + "@example.com";
//					String rawPassword = "user" + String.format("%03d", i); // 비밀번호를 평문으로 사용
//					String encodePassword = passwordEncoder.encode(rawPassword);
//
//					return MemberEntity.builder()
//							.loginId(loginId)
//							.memberPw(encodePassword) // 비밀번호를 평문으로 저장
//							.memberName("테스터" + i)
//							.memberEmail(email)
//							.emailVerified('Y') // 이메일 인증 완료
//							.termsAgreed('Y')   // 약관 동의
//							.lastLogin(null) // 초기에는 마지막 로그인 시간 없음
//							.status(0)       // 0: 활성 상태
//							.points(i * 100) // 포인트 (100, 200, ...)
//							.role(0)         // 0: 일반 사용자
//							.build();
//				})
//				.collect(Collectors.toList());
//		
//		List<MemberEntity> saveDum = memberRepo.saveAll(dummyMembers);
//		
//		if (!saveDum.isEmpty()) {
//			log.info("첫 번째 저장된 회원: {}", saveDum.get(0).getLoginId());
//			if (saveDum.size() >= 50) {
//				log.info("50번째 저장된 회원: {}", saveDum.get(49).getLoginId());
//			}
//			log.info("마지막 저장된 회원: {}", saveDum.get(saveDum.size() - 1).getLoginId());
//		}
//	}

	// 테스트용 대여 등록
//	@Test
//	void testRegRandomRent() throws Exception {
//		Random random = new Random();
//		int successfulRentals = 0;
//		int failedRentals = 0;
//		
//		
//		for (int i = 0; i < NUM_LENGTH; i++) {
//			Long memberId = (long)(random.nextInt(MAX_MEMBER_ID) + 1);
//			Long bookId = (long)(random.nextInt(MAX_BOOK_ID) + 1);
//			
//			try {
//				rentService.rentBook(bookId, memberId);
//				log.info("대여 성공: 회원 ID = {}, 도서 ID = {}", memberId, bookId);
//                successfulRentals++;
//			} catch (Exception e) {
//				log.warn("대여 실패: 회원 ID = {}, 도서 ID = {}, 원인: {}", memberId, bookId, e.getMessage());
//                failedRentals++;
//			}
//		}
//		log.info("--- 무작위 대여 시도 요약 ---");
//        log.info("총 시도 횟수: {}", NUM_LENGTH);
//        log.info("성공한 대여: {}", successfulRentals);
//        log.info("실패한 대여: {}", failedRentals);
//	}
	
	// 테스트용 찜 등록
//	@Test
//	void testRegRandomWish() throws Exception {
//		Random random = new Random();
//		int success = 0;
//		int failed = 0;
//		
//		for (int i = 0; i < NUM_LENGTH; i++) {
//			Long memberId = (long)(random.nextInt(MAX_MEMBER_ID) + 1);
//			Long bookId = (long)(random.nextInt(MAX_BOOK_ID) + 1);
//			
//			try {
//				wishService.addWished(bookId, memberId);
//				log.info("찜 성공 mem : {}, book : {}", memberId, bookId);
//				success++;
//			} catch (Exception e) {
//				log.warn("찜 실패 mem : {}, book : {}, 원인 : {}", memberId, bookId, e.getMessage());
//				failed++;
//			}
//		}
//		log.info("--- 무작위 찜 시도 요약 ---");
//        log.info("총 시도 횟수: {}", NUM_LENGTH);
//        log.info("성공한 찜: {}", success);
//        log.info("실패한 찜: {}", failed);
//	}
	
	// 테스트용 리뷰 작성
//	@Test
//	void testRegRandomReview() throws Exception {
//		Random random = new Random();
//		int success = 0;
//		int failed = 0;
//		int skip = 0;
//		
//		for (int i = 0; i < NUM_LENGTH; i++) {
//			Long rentId = (long)(random.nextInt(MAX_RENT_ID) + 1);
//			Long memberId = (long)(random.nextInt(MAX_MEMBER_ID) + 1);
//			int rating = (random.nextInt(MAX_RATING) + 1);
//			String title  = "테스트용 리뷰 제목" + i;
//			String content = "테스트용 리뷰 내용" + i;
//			
//			Optional<RentEntity> optional = rentRepository.findById(rentId);
//			
//			if (optional.isEmpty()) {
//				log.warn("리뷰 스킵: rentId {} 에 해당하는 대여 기록 없음.", rentId);
//				skip++;
//				continue;
//			}
//			
//			RentEntity rentEntity = optional.get();
//			
//			if (rentEntity.getHasReview() != null && rentEntity.getHasReview() == 1) {
//				log.warn("리뷰 스킵: rentId {} 에 이미 리뷰가 작성되어 있음.", rentId);
//                skip++;
//				continue;
//			}
//			
//			Long bookId = null;
//			
//			if (rentEntity.getBookEntity() != null) {
//                bookId = rentEntity.getBookEntity().getBookId();
//            } else {
//                log.warn("리뷰 스킵: rentId {} 에 연결된 BookEntity가 없음.", rentId);
//                skip++;
//                continue;
//            }
//			
//			ReviewDTO reviewDTO = ReviewDTO.builder().rentId(rentId)
//													 .bookId(bookId)
//													 .memberId(memberId)
//													 .rating(rating)
//													 .title(title)
//													 .content(content)
//													 .build();
//			
//			try {
//				ReviewEntity reviewEntity = reviewService.regReview(reviewDTO);
//				assertNotNull(reviewEntity);
//				
//				log.info("리뷰 성공: rentId = {}, memberId = {}, bookId = {}", rentId, memberId, bookId);
//                success++;
//			} catch (Exception e) {
//				log.warn("리뷰 실패: rentId = {}, memberId = {}, bookId = {}, 원인: {}",
//                        rentId, memberId, bookId, e.getMessage());
//				failed++;
//			}
//		}
//		log.info("--- 무작위 리뷰 등록 시도 요약 ---");
//		log.info("총 시도 횟수: {}", NUM_LENGTH);
//		log.info("성공한 리뷰 등록: {}", success);
//		log.info("실패한 리뷰 등록 (서비스 오류): {}", failed);
//		log.info("스킵된 리뷰 등록 (조건 불충족): {}", skip);
//	}

}
