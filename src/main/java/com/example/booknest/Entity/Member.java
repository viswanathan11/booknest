package com.example.booknest.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name="members")
@NoArgsConstructor 
@Getter 
@Setter 
public class Member {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String name;
    private String email;
    private LocalDateTime joinedAt;

    public Member(String name,String email,LocalDateTime joinedAt){
        this.name=name;
        this.email=email;
        this.joinedAt=joinedAt;
    }
}
