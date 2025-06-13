package com.codeit.mini.book;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.SampleData.SampleMemberRepo;
import com.codeit.mini.entity.member.MemberEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class SampleRegTests {
	
	@Autowired
	private SampleMemberRepo memberRepo;
	
	@Test
	void testRegMember() {
		List<MemberEntity> dummyMembers = IntStream.rangeClosed(1, 100)
				.mapToObj(i -> {
					String loginId = "user" + String.format("%03d", i); // user001, user002...
					String email = "email" + String.format("%03d", i) + "@example.com";
					String password = "user" + String.format("%03d", i); // 비밀번호를 평문으로 사용

					return MemberEntity.builder()
							.loginId(loginId)
							.memberPw(password) // 비밀번호를 평문으로 저장
							.memberName("테스터" + i)
							.memberEmail(email)
							.emailVerified('Y') // 이메일 인증 완료
							.termsAgreed('Y')   // 약관 동의
							.lastLogin(null) // 초기에는 마지막 로그인 시간 없음
							.status(0)       // 0: 활성 상태
							.points(i * 100) // 포인트 (100, 200, ...)
							.coupon(i % 5)   // 쿠폰 (0~4 반복)
							.role(0)         // 0: 일반 사용자
							.build();
				})
				.collect(Collectors.toList());
		
		List<MemberEntity> saveDum = memberRepo.saveAll(dummyMembers);
		
		if (!saveDum.isEmpty()) {
			log.info("첫 번째 저장된 회원: {}", saveDum.get(0).getLoginId());
			if (saveDum.size() >= 50) {
				log.info("50번째 저장된 회원: {}", saveDum.get(49).getLoginId());
			}
			log.info("마지막 저장된 회원: {}", saveDum.get(saveDum.size() - 1).getLoginId());
		}
	}

}
