package com.project.labtvapi.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.labtvapi.dao.MovieDao;
import com.project.labtvapi.model.Movie;
import com.project.labtvapi.model.Trailer;
import com.project.labtvapi.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

  @Autowired
  private MovieDao mDao;

  @Autowired
  private MovieService mService;

  // Lista Films
  @GetMapping(value = "/list", produces = "application/json")
  ResponseEntity<Object> getMovieList() {

    ArrayList<Movie> movies = (ArrayList<Movie>) mDao.findAll();

    if (movies != null && !movies.isEmpty())
      return new ResponseEntity<Object>(movies, HttpStatus.OK);
    return new ResponseEntity<Object>("Errore", HttpStatus.NO_CONTENT);
  }

  // Lista Film Paginata
  // baseurl/api/movie/list?nPage=1&pageSize=50
  @GetMapping(value = "/list/paged")
  ResponseEntity<Page<Movie>> getMovieListPaginated(
      @RequestParam(name = "nPage", required = false, defaultValue = "0") int nPage,
      @RequestParam(name = "pageSize", required = false, defaultValue = "50") int pageSize) {
    return new ResponseEntity<>(mService.getListMovie(nPage, pageSize, mDao), HttpStatus.OK);
  }

  // 3. Visualizzazione dettaglio film
  @GetMapping(value = "")
  ResponseEntity<Movie> getMovieByIdWithParam(@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
    if (id == 0)
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    Optional<Movie> movie = (Optional<Movie>) mDao.findById(id);
    return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
  }

  // 3. Visualizzazione dettaglio film
  @GetMapping(value = "/{id}")
  ResponseEntity<Movie> getMovieByIdWithPath(@PathVariable(name = "id", required = false) int id) {
    if (id == 0)
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    Optional<Movie> movie = (Optional<Movie>) mDao.findById(id);
    return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
  }

  // 2. Ricerca di un titolo con inserimento testo

  @GetMapping(value = "/search")
  ResponseEntity<Object> searchMovie(@RequestParam(name = "by", required = false, defaultValue = "title") String by,
      @RequestParam(name = "query", required = false, defaultValue = "") String query) {
    return mService.searchMovie(by, query, mDao);
  }

  // 3. Get Trailer
  @GetMapping(value = "/trailer/{id}")
  ResponseEntity<Set<Trailer>> getTrailerById(@PathVariable(name = "id", required = false) int id) {
    if (id == 0)
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
    Movie movies = (Movie) mDao.findById(id).get();
    Set<Trailer> trailers = movies.getTrailers();
    return new ResponseEntity<Set<Trailer>>((Set<Trailer>) trailers, HttpStatus.OK);
  }

}
