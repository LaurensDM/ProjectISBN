package com.project.g2a2_de_maeyer_laurens.service;

import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.User;

public interface UserService {

    String getRole(Long id);

    String addUser(User user);

    User getUserByEmail(String email);

    Book addFavorite(Long id);

    Book removeFavorite(Long id);
}
