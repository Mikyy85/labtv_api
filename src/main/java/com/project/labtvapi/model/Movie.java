package com.project.labtvapi.model;

import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "plot", nullable = false)
  private String plot;

  @Column(name = "posterurl", nullable = false)
  private String posterUrl;

  @Column(name = "year", nullable = false)
  private int year;

  @Column(name = "runtime", nullable = false)
  private int runtime;

  @Column(name = "vote", nullable = false, length = 4)
  private int vote;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_genre", referencedColumnName = "id"))
  private Set<Genre> genres = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "movie_star", joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_star", referencedColumnName = "id"))
  private Set<Star> stars = new HashSet<>();

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Trailer> trailers = new HashSet<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public String getPosterUrl() {
    return posterUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

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

}
