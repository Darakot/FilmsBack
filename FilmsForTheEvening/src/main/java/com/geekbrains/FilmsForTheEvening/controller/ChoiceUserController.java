package com.geekbrains.FilmsForTheEvening.controller;

import com.geekbrains.FilmsForTheEvening.domain.ChoiceUser;
import com.geekbrains.FilmsForTheEvening.repository.ChoiceUserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Рест контроллер.
 * Можем добавить отклик юзера а затем получить список того , что
 * 1)Больше не показывать
 * 2)Нравится
 * 3)Смотрел
 * 4)Посмотреть
 */

@RestController
@RequestMapping("/choiceUser")
public class ChoiceUserController {
    //Вынести вызовы репозитория в *Service класс
    private final ChoiceUserDetailRepo choiceUserDetailRepo;

    @Autowired
    public ChoiceUserController(ChoiceUserDetailRepo choiceUserDetailRepo) {
        this.choiceUserDetailRepo = choiceUserDetailRepo;
    }

    @PostMapping("/addChoice")
    public ChoiceUser addChoice(@RequestBody ChoiceUser choiceUser) {
        return choiceUserDetailRepo.save(choiceUser);
    }

    @GetMapping("/getDontShAg/{user}")
    public List<String> getDontShAg(@PathVariable("user") String user) {
        return choiceUserDetailRepo.findByDShAgWhereUser(user);
    }

    @GetMapping("/getFavorite/{user}")
    public List<String> getFavorite(@PathVariable("user") String user) {
        return choiceUserDetailRepo.findByFavoriteWhereUser(user);
    }

    @GetMapping("/getLook/{user}")
    public List<String> getLook(@PathVariable("user") String user) {
        return choiceUserDetailRepo.findByLookWhereUser(user);
    }

    @GetMapping("/getWatched/{user}")
    public List<String> getWatched(@PathVariable("user") String user) {
        return choiceUserDetailRepo.findByWatchedWhereUser(user);
    }


    //Не возвращать Entity, мапить его в DTO(Data transfer object)
    @GetMapping("/getfilms")
    public List<ChoiceUser> getFilms() {
        return choiceUserDetailRepo.findAll();
    }

}
