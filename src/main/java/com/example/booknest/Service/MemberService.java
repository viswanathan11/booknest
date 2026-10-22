package com.example.booknest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booknest.Repository.MemberRepository;

@Service 
public class MemberService {
    @Autowired 
    MemberRepository memberRepository;
}
