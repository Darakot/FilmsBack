package com.geekbrains.FilmsForTheEvening.controller;


import com.geekbrains.FilmsForTheEvening.domain.User;
import com.geekbrains.FilmsForTheEvening.repository.UserDetailRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // обращение к /users

public class UserController {

    private final UserDetailRepo userDetailRepo;

    @Autowired
    public UserController(UserDetailRepo userDetailRepo) {
        this.userDetailRepo = userDetailRepo;
    }


    @GetMapping ("/")
    public List<User> getUsers(){
        return userDetailRepo.findAll();
    }

    @PostMapping("/createUser")  // создание юзера
    public User createUser(@RequestBody User user){
//        if(user.getNickname() == userDetailRepo.findByNickname(user.getNickname()).getNickname()) {
//
//        }

        return userDetailRepo.save(user);
    }

    @PutMapping("{nickname}") // обновление методом put по никнейму
    public User updateUsr(
            @PathVariable("nickname") String nickname,
            @RequestBody User updateUsr){
        User userFromDb = userDetailRepo.findByNickname(nickname); // находим юзера по нику

        BeanUtils.copyProperties(updateUsr, userFromDb,"id"); // обновляем данный игнорируя id

        return userDetailRepo.save(userFromDb);
    }

    @DeleteMapping("{nickname}")
    public void deleteUsr (@PathVariable("nickname") String deleteUsr) {
        userDetailRepo.deleteByNickname(deleteUsr);
    }


}
