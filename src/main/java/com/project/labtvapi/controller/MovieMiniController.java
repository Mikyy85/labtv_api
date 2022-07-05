package com.project.labtvapi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.labtvapi.dao.MovieMiniDao;
import com.project.labtvapi.model.MovieMini;
import com.project.labtvapi.service.MovieMiniService;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "http://localhost:4200/")
public class MovieMiniController {

  @Autowired
  private MovieMiniDao mDao;

  @Autowired
  private MovieMiniService mService;

  @GetMapping(value = "/list", produces = "application/json")
  ResponseEntity<Object> getMovieList() {

    ArrayList<MovieMini> movies = (ArrayList<MovieMini>) mDao.findAll();

    if (movies != null && !movies.isEmpty())
      return new ResponseEntity<Object>(movies, HttpStatus.OK);
    return new ResponseEntity<Object>("Errore", HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "/search")
  ResponseEntity<Object> searchMovie(@RequestParam(name = "by", required = false, defaultValue = "title") String by,
      @RequestParam(name = "query", required = false, defaultValue = "") String query) {
    return mService.searchMovie(by, query, mDao);
  }

  @GetMapping(value = "/list/paged")
  ResponseEntity<Page<MovieMini>> getMovieListPaginated(
      @RequestParam(name = "nPage", required = false, defaultValue = "0") int nPage,
      @RequestParam(name = "pageSize", required = false, defaultValue = "50") int pageSize) {
    return new ResponseEntity<>(mService.getListMovie(nPage, pageSize, mDao), HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @GetMapping(value = "")
  ResponseEntity<MovieMini> getMovieByIdWithParam(
      @RequestParam(name = "id", required = false, defaultValue = "0") int id) {
    if (id == 0)
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    Optional<MovieMini> movie = (Optional<MovieMini>) mDao.findById(id);
    return new ResponseEntity<MovieMini>(movie.get(), HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @GetMapping(value = "/{id}")
  ResponseEntity<MovieMini> getMovieByIdWithPath(@PathVariable(name = "id", required = false) int id) {
    if (id == 0)
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    Optional<MovieMini> movie = (Optional<MovieMini>) mDao.findById(id);
    return new ResponseEntity<MovieMini>(movie.get(), HttpStatus.OK);
  }

}