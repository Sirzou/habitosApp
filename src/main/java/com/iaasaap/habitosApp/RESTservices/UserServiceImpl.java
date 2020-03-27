package com.iaasaap.habitosApp.RESTservices;

import com.iaasaap.habitosApp.ServicesBO.UserBOImpl;
import com.iaasaap.habitosApp.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBOImpl userBOImpl;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userBOImpl.getAllUsers();
    }

    //@GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userBOImpl.getUserById(Long.parseLong(id));
    }

    @PostMapping("/createUser")
    @ResponseBody
    public User createHabit(@RequestBody User user) {
        return userBOImpl.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id){
        userBOImpl.deleteUserById(Long.parseLong(id));
    }
}
