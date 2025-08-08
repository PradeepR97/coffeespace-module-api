package com.coffeespace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile_education")
public class ProfileEducation extends com.coffeespace.entity.BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileid;
    private String institutename;
    private String department;

    // Newly added field
    private String degree;

    private String startdate;
    private String enddate;
}
