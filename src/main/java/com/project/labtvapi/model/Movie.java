package com.project.labtvapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie extends AbstractMovie {

  private static final long serialVersionUID = -1465678815242395309L;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_genre", referencedColumnName = "id"))
  private Set<Genre> genres = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "movie_star", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_star", referencedColumnName = "id"))
  private Set<Star> stars = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_director", referencedColumnName = "id"))
  private Set<Director> directors = new HashSet<>();

  @ManyToMany()
  @JoinTable(name = "similar_movie", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "similar_to", referencedColumnName = "id"))
  private Set<MovieMini> similarTo;

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Trailer> trailers = new HashSet<>();

  public Set<Genre> getGenres() {
    return genres;
  }

  public void setGenres(Set<Genre> genres) {
    this.genres = genres;
  }

  public Set<Star> getStars() {
    return stars;
  }

  public void setStars(Set<Star> stars) {
    this.stars = stars;
  }

  public Set<Trailer> getTrailers() {
    return trailers;
  }

  public void setTrailers(Set<Trailer> trailers) {
    this.trailers = trailers;
  }

  public Set<MovieMini> getSimilarTo() {
    return similarTo;
  }

  public void setSimilarTo(Set<MovieMini> similarTo) {
    this.similarTo = similarTo;
  }

  public Set<Director> getDirectors() {
    return directors;
  }

  public void setDirectors(Set<Director> directors) {
    this.directors = directors;
  }

  

}
