package com.shop.repository;

import com.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long>{
    Member findByEmail(String email); //추상메소드, 구현하는 클래스에서 오버라이딩해서 사용

}
