package com.geekbrains.FilmsForTheEvening.controller;

import com.geekbrains.FilmsForTheEvening.domain.ChoiceUser;
import com.geekbrains.FilmsForTheEvening.repository.ChoiceUserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private final ChoiceUserDetailRepo choiceUserDetailRepo;

    @Autowired
    public ChoiceUserController(ChoiceUserDetailRepo choiceUserDetailRepo) {
        this.choiceUserDetailRepo = choiceUserDetailRepo;
    }

    @PutMapping("/addChoice")
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

    @GetMapping("/getfilms")
    public List<ChoiceUser> getfilms() {
        return choiceUserDetailRepo.findAll();
    }

}
