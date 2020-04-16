package com.euvin.euvin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.euvin.euvin.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    List<User> findByRoles(String roles);

    @Modifying(clearAutomatically = true)
    @Query("update User set password = :password where id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);

}