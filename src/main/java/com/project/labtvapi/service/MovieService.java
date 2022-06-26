package com.project.labtvapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.labtvapi.dao.MovieDao;
import com.project.labtvapi.model.Movie;

@Service
public class MovieService {

  public Page<Movie> getListMovie(int nPage, int pageSize, MovieDao mDao) {
    if (nPage < 0 && pageSize < 0)
      return (Page<Movie>) mDao.findAll(PageRequest.of(0, 50));
    if (nPage == 0 && pageSize != 0)
      return mDao.findAll(PageRequest.of(0, pageSize));
    return mDao.findAll(PageRequest.of(nPage, pageSize));
  }

  public ResponseEntity<Object> searchMovie(String by, String query, MovieDao mDao) {

    switch (by) {
      case "title":
        return new ResponseEntity<>(mDao.findByTitleContaining(query), HttpStatus.OK);
      default:
        return new ResponseEntity<>("Nessun risultato", HttpStatus.OK);
    }

  }

}
