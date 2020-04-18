package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.SketchHabit;
import com.iaasaap.habitosApp.habits.SketchHabitRepository;
import com.iaasaap.habitosApp.users.User;
import com.iaasaap.habitosApp.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBOImpl implements UserBO {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SketchHabitRepository sketchHabitRepository;
    @Autowired
    private AbstractHabitRepository abstractHabitRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
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
        SketchHabit sketchHabit = sketchHabitRepository.findById(Long.parseLong(habitId)).get();
        user.getSketchedHabits().add(sketchHabit);
        userRepository.save(user);
    }

    public void cloneAbstractIntoSketch(String userId, String abstractHabitId){
        User user = userRepository.findById(Long.parseLong(userId)).get();
        AbstractHabit abstractHabit = abstractHabitRepository.findById(Long.parseLong(abstractHabitId)).get();
        SketchHabit sketchHabit = new SketchHabit(abstractHabit);
        SketchHabit savedSketchHabit = sketchHabitRepository.save(sketchHabit);
        user.getSketchedHabits().add(savedSketchHabit);
        userRepository.save(user);
    }

}
