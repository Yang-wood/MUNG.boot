package com.codeit.mini.SampleData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeit.mini.entity.member.MemberEntity;

@Repository
public interface SampleMemberRepo extends JpaRepository<MemberEntity, Long> {
	
}
