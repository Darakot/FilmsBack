package com.geekbrains.FilmsForTheEvening.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Фильмы которые просмотрел юзер, откликом.
 * Отклик(response) может быть положительным или отрицательным, на основе этой информации
 * можно попробовать построить предложку
 */
@Entity
@Table(name = "filmsUser")
@Data
public class FilmsUser {
    @Id
    @GeneratedValue(generator = "increment") // выбор генератора для автоID
    @GenericGenerator(name = "increment", strategy = "increment") // стратегия генирорование id
    private Long id;
    private String movieTitle;
    private String genre;
    private String director;
    private String actors;
    private Boolean response;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User autor;
}
