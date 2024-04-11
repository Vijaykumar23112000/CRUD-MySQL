package com.magret.userRepository;

import com.magret.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Long> {

    List<User> findByName(String name);

    @Query("from User where location = :location")
    List<User> fetchByLocation(@Param("location") String location);

}
