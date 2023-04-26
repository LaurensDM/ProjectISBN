package com.project.g2a2_de_maeyer_laurens.service;

import com.project.g2a2_de_maeyer_laurens.model.User;

public interface UserService {

    public String getRole(Long id);

    public String addUser(User user);
}
