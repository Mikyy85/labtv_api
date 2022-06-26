package com.project.labtvapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.labtvapi.model.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {

  List<Movie> findByTitleContaining(String title);

}
