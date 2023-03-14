package com.Alejandro.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alejandro.Users.Entities.UserInRole;


@Repository
public interface RolinUser extends JpaRepository<UserInRole, Integer> {

}
