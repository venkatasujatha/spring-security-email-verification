package com.example.demo.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.appuser.AppUser;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	Optional<AppUser> findByEmail(String Email);

}
