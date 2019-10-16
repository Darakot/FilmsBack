package com.geekbrains.FilmsForTheEvening.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Выбор конкретного пользователя
 * 4 возможных выбора(Посмотреть, Нравится, Смотрел, Больше не показывать)
 */

@Entity
@Table(name = "choiceUser")
@Data
public class ChoiceUser {
    @Id
    @GeneratedValue(generator = "increment") // выбор генератора для автоID
    @GenericGenerator(name = "increment", strategy = "increment") // стратегия генирорование id
    private Long id;

    private String user;
    private String look;
    private String favorite;
    private String watched;
    private String dontShowAgain;
}
