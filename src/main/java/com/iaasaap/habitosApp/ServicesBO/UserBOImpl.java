package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.SketchHabit;
import com.iaasaap.habitosApp.habits.SketchHabitRepository;
import com.iaasaap.habitosApp.users.User;
import com.iaasaap.habitosApp.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBOImpl implements UserBO {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SketchHabitRepository sketchHabitRepository;

    @Override
    public List<User> getAllUsers() {
        List userList = new ArrayList();
        userRepository.findAll().forEach(x -> userList.add(x));
        return userList;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public void linkHabit(String userId,String habitId){

        User user = userRepository.findById(Long.parseLong(userId)).get();
        System.out.println(user);
        List<SketchHabit> lista = (List<SketchHabit>) sketchHabitRepository.findAll();
        lista.stream().forEach(x-> System.out.println(x));
        SketchHabit sketchHabit = sketchHabitRepository.findById(Long.parseLong(habitId)).get();
        System.out.println(sketchHabit);
        user.getSketchedHabits().add(sketchHabit);
        System.out.println(user);
        userRepository.save(user);
    }

}
