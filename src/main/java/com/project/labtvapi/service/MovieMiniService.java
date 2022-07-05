package com.project.labtvapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.labtvapi.dao.MovieMiniDao;
import com.project.labtvapi.model.MovieMini;

@Service
public class MovieMiniService {

  public ResponseEntity<Object> searchMovie(String by, String query, MovieMiniDao mDao) {

    switch (by) {
      case "title":
        return new ResponseEntity<>(mDao.findByTitleContaining(query), HttpStatus.OK);
      default:
        return new ResponseEntity<>("Nessun risultato", HttpStatus.OK);
    }

  }

  public Page<MovieMini> getListMovie(int nPage, int pageSize, MovieMiniDao mDao) {
    if (nPage < 0 && pageSize < 0)
      return (Page<MovieMini>) mDao.findAll(PageRequest.of(0, 50));
    if (nPage == 0 && pageSize != 0)
      return mDao.findAll(PageRequest.of(0, pageSize));
    return mDao.findAll(PageRequest.of(nPage, pageSize));
  }

}
