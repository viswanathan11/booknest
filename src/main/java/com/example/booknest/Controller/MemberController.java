package com.example.booknest.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booknest.Entity.Member;
import com.example.booknest.Service.MemberService;
import com.example.booknest.dto.request.MemberRequest;
import com.example.booknest.dto.response.MemberResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController 
@RequestMapping ("/api/member")
  @Tag(name = "Members", description = "Member management endpoints")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
    @PostMapping
    @Operation (summary = "Register a new member")
    public ResponseEntity<MemberResponse> addMember(@Valid @RequestBody  MemberRequest request){
        Member member=new Member(request.name(),request.email(),LocalDateTime.now());
        Member saved=memberService.createMember(member);

        MemberResponse response=new MemberResponse(saved.getId(),saved.getName(),saved.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a member by ID")
    public ResponseEntity<MemberResponse> getMember(@PathVariable  Long id){
        Member member=memberService.getByMemberId(id);

        MemberResponse response=new MemberResponse(member.getId(),member.getName(),member.getEmail());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation (summary = "List all members")
    public ResponseEntity<List<MemberResponse>> getAllMembers(){
        List<MemberResponse> members=memberService.getAllMember().stream().map(m->new MemberResponse(m.getId(),m.getName(),m.getEmail())).toList();
        return ResponseEntity.ok(members);
    }

    @DeleteMapping("/{id}")
    @Operation(summary ="Delete a member by Id")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
    
}
