package com.example.booknest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booknest.Entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
    
}
