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
	
	// 테스트용 회원 입력
//	@Test
//	void testRegMember() {
//		List<MemberEntity> dummyMembers = IntStream.rangeClosed(1, 200)
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
//		
//		for (int i = 0; i < 200; i++) {
//			Long memberId = (long)(random.nextInt(200) + 1);
//			Long bookId = (long)(random.nextInt(126) + 1);
//			
//			try {
//				rentService.rentBook(bookId, memberId);
//				log.info("대여 성공 mem : {}, book : {}", memberId, bookId);
//			} catch (Exception e) {
//				log.warn("대여 실패 mem : {}, book : {}, 원인 : {}", memberId, bookId, e.getMessage());
//			}
//		}
//	}
	
	// 테스트용 찜 등록
//	@Test
//	void testRegRandomWish() throws Exception {
//		Random random = new Random();
//		
//		for (int i = 0; i < 200; i++) {
//			Long memberId = (long)(random.nextInt(200) + 1);
//			Long bookId = (long)(random.nextInt(126) + 1);
//			
//			try {
//				wishService.addWished(bookId, memberId);
//				log.info("찜 성공 mem : {}, book : {}", memberId, bookId);
//			} catch (Exception e) {
//				log.warn("찜 실패 mem : {}, book : {}, 원인 : {}", memberId, bookId, e.getMessage());
//			}
//		}
//	}
	
	// 테스트용 리뷰 작성
//	@Test
//	void testRegRandomReview() throws Exception {
//		Random random = new Random();
//		
//		for (int i = 0; i < 200; i++) {
//			Long rentId = (long)(random.nextInt(389) + 1);
//			Long memberId = (long)(random.nextInt(200) + 1);
//			int rating = (random.nextInt(5) + 1);
//			String title  = "테스트용 리뷰 제목" + i;
//			String content = "테스트용 리뷰 내용" + i;
//			
//			Optional<RentEntity> optional = rentRepository.findById(rentId);
//			
//			if (optional.isEmpty()) {
//				continue;
//			}
//			
//			RentEntity rentEntity = optional.get();
//			
//			if (rentEntity.getHasReview() != null && rentEntity.getHasReview() == 1) {
//				continue;
//			}
//			
//			Long bookId = rentEntity.getBookEntity().getBookId();
//			
//			ReviewDTO reviewDTO = ReviewDTO.builder().rentId(rentId)
//													 .bookId(bookId)
//													 .memberId(memberId)
//													 .rating(rating)
//													 .title(title)
//													 .content(content)
//													 .build();
//			
//			ReviewEntity reviewEntity = reviewService.regReview(reviewDTO);
//			
//			assertNotNull(reviewEntity);
//		}
//	}

}
