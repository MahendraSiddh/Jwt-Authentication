package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.CustomUser;

@Repository
public interface CustomUserDeatilsRepo extends JpaRepository<CustomUser,Integer> {
    
    CustomUser findByUsername(String username);
}
