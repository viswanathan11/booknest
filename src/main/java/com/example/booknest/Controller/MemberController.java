package com.example.booknest.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.booknest.Entity.Member;
import com.example.booknest.Service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController("/member")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
    @PostMapping
    public Member addMember(@RequestBody Member member){
        return memberService.createMember(member);
    }

    @GetMapping("/{id}")
    public Member getMember(@RequestParam Long id){
        return memberService.getByMemberId(id);
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMember();
    }
    
}
