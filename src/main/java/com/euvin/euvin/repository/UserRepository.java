package com.euvin.euvin.repository;

import com.euvin.euvin.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query("update User set password = :password where id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);

}