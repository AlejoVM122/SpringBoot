package com.Alejandro.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alejandro.Users.Entities.Profiel;

@Repository
public interface ProfileRepository extends JpaRepository<Profiel, Integer>{

}
