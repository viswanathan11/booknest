package com.example.booknest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booknest.Entity.Member;
import com.example.booknest.Exception.ResourceNotFoundException;
import com.example.booknest.Repository.MemberRepository;

@Service 
public class MemberService {
    @Autowired 
    MemberRepository memberRepository;

    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMemeber(Member member){
        memberRepository.delete(member);
    }
    
    public List<Member> getAllMember(){
        return  memberRepository.findAll();
    }

    public Member getByMemberId(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(()-> new ResourceNotFoundException("Member Not found with ID: "+memberId));
    }
}
