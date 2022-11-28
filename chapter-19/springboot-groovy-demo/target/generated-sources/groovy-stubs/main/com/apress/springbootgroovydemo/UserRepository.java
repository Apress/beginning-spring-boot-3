package com.apress.springbootgroovydemo;

public interface UserRepository
  extends
    org.springframework.data.jpa.repository.JpaRepository<com.apress.springbootgroovydemo.User, java.lang.Long> {
;
 com.apress.springbootgroovydemo.User findByEmail(java.lang.String email);
}
