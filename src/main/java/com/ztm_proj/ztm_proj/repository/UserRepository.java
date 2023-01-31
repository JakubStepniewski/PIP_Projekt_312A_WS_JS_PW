package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Trips;
import com.ztm_proj.ztm_proj.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}