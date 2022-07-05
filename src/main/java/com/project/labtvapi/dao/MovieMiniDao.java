package com.project.labtvapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.labtvapi.model.MovieMini;

public interface MovieMiniDao extends JpaRepository<MovieMini, Integer> {

  List<MovieMini> findByTitleContaining(String title);

}
