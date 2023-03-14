package com.Alejandro.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alejandro.Users.Entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
