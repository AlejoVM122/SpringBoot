package com.Alejandro.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alejandro.Users.Entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{


}
