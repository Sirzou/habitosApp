package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.users.User;

import java.util.List;

public interface UserBO {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    void deleteUserById(Long userId);
    void linkHabit(String userId, String habitId);
}
