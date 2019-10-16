package com.geekbrains.FilmsForTheEvening.repository;

import com.geekbrains.FilmsForTheEvening.domain.ChoiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChoiceUserDetailRepo extends JpaRepository<ChoiceUser,Long> {

    @Query("SELECT dontShowAgain FROM ChoiceUser where user=:user and dontShowAgain IS NOT NULL")
    List<String> findByDShAgWhereUser (@Param("user") String user);

    @Query("SELECT favorite FROM ChoiceUser where user=:user and favorite IS NOT NULL")
    List<String> findByFavoriteWhereUser (@Param("user") String user);

    @Query("SELECT look FROM ChoiceUser where user=:user and look IS NOT NULL")
    List<String> findByLookWhereUser (@Param("user") String user);

    @Query("SELECT watched FROM ChoiceUser where user=:user and watched IS NOT NULL")
    List<String> findByWatchedWhereUser (@Param("user") String user);

}
