package com.example.booknest.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor 
@Getter 
@Setter 
public class Member {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String email;
    private LocalDateTime joinedAt;

    Member(String name,String email,LocalDateTime joinedAt){
        this.name=name;
        this.email=email;
        this.joinedAt=joinedAt;
    }
}
