package com.lililli.restfull.user;

import java.util.Date;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @Entity
public class User {
    // @Id // pk 설정
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 설정
    private Integer id;
    private String name;
    private Date joinDate;
}
