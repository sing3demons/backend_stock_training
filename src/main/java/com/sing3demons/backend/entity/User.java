package com.sing3demons.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "m_user")
public class User extends BaseEntity {
    @Column(nullable = false,unique = true,length = 60)
    private String email;
    private String name;
    private String passworld;
}
