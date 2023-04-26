package com.project.g2a2_de_maeyer_laurens.repository;

import com.project.g2a2_de_maeyer_laurens.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);


}
