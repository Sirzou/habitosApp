package com.iaasaap.habitosApp.RESTservices;

import com.iaasaap.habitosApp.ServicesBO.UserBO;
import com.iaasaap.habitosApp.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBO userBO;

    @GetMapping(Constants.GET_USERS)
    public List<User> getUsers() {
        return userBO.getAllUsers();
    }

    @GetMapping(Constants.GET_USER)
    public User getUser(@PathVariable String userId) {
        return userBO.getUserById(Long.parseLong(userId));
    }

    @PostMapping(Constants.GET_USERS)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userBO.createUser(user);
    }

    @DeleteMapping(Constants.GET_USER)
    public void deleteUser(@PathVariable String userId){
        userBO.deleteUserById(Long.parseLong(userId));
    }

    @PutMapping(Constants.LINK_USER_WITH_HABIT)
    public void linkUserWithHabit(@PathVariable String userId,@PathVariable String habitId){
        System.out.println(""+userId+" "+habitId);
        userBO.linkHabit(userId,habitId);
    }
}
