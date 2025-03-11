package org.example.springtp.repositories;

import org.example.springtp.model.Login;
import org.example.springtp.model.ManageLogin;
import org.example.springtp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select l from User u inner join u.logins l")
    List<Login> getAllLogins();


}
