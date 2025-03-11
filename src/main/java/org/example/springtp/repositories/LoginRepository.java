package org.example.springtp.repositories;

import org.example.springtp.model.Login;
import org.example.springtp.model.ManageLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

        Login findByEmail(String email);

}
