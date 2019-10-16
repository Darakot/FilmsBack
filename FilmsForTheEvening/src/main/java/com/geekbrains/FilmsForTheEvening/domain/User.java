package com.geekbrains.FilmsForTheEvening.domain;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Информация о Юзере
 * Приходит с фронта при регистрации или создании нового пользователя
 */
@Entity
@Table(name = "usr")
@Data
public class User {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Id
    @GeneratedValue(generator = "increment") // выбор генератора для автоID
    @GenericGenerator(name = "increment", strategy = "increment") // стратегия генирорование id
    private Long id;

    private String firstName;
    private String lastName;
    private String password;
    private String nickname;

}
