package com.geekbrains.FilmsForTheEvening.repository;

import com.geekbrains.FilmsForTheEvening.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
public interface UserDetailRepo extends JpaRepository<User,Long> {


    @Transactional(timeout = 10)
    void deleteByNickname(String nickname); // удаляет пользователя из БД по нику

    User findByNickname(String nickname); // находит пользователя из бд по нику

}
