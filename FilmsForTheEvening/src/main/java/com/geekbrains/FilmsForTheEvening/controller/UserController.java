package com.geekbrains.FilmsForTheEvening.controller;

import com.geekbrains.FilmsForTheEvening.domain.User;
import com.geekbrains.FilmsForTheEvening.repository.UserDetailRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Рест контроллер.
 * Можем получить всех юзеров
 * Создать нового,если юзер с таким ником уже есть, вернет ошибку 410
 * Редактировать созданного юзера
 * Удалить созданного юезера
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDetailRepo userDetailRepo;

    @Autowired
    public UserController(UserDetailRepo userDetailRepo) {
        this.userDetailRepo = userDetailRepo;
    }


    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userDetailRepo.findAll();
    }

    @PutMapping("/createUser")  // создание юзера
    public User createUser(@RequestBody User user, HttpServletResponse response) {
        if (userDetailRepo.findByNickname(user.getNickname()) != null) {
            response.setStatus(410);
            return user;
        } else {
            response.setStatus(201);
            return userDetailRepo.save(user);
        }
    }

    @PostMapping("/edit/{nickname}") // обновление методом post по никнейму
    public User updateUsr(
            @PathVariable("nickname") String nickname,
            @RequestBody User updateUsr) {
        User userFromDb = userDetailRepo.findByNickname(nickname); // находим юзера по нику

        BeanUtils.copyProperties(updateUsr, userFromDb, "id"); // обновляем данный игнорируя id

        return userDetailRepo.save(userFromDb);
    }

    @DeleteMapping("/delete/{nickname}")
    public void deleteUsr(@PathVariable("nickname") String deleteUsr) {
        userDetailRepo.deleteByNickname(deleteUsr);
    }


}
