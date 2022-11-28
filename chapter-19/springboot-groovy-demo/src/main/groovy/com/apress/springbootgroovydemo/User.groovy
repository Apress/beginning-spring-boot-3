package com.apress.springbootgroovydemo

import jakarta.persistence.*

@Entity
@Table(name="users")
class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name
    String email
}
