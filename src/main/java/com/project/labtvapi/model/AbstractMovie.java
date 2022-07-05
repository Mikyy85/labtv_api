package com.project.labtvapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractMovie implements Serializable {

  private static final long serialVersionUID = 1983606165328348782L;

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

  // @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch =
  // FetchType.EAGER, orphanRemoval = true)
  // private Set<Trailer> trailers = new HashSet<>();

  // public int getId() {
  // return id;
  // }

  @EmbeddedId
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

  // public Set<Trailer> getTrailers() {
  // return trailers;
  // }

  // public void setTrailers(Set<Trailer> trailers) {
  // this.trailers = trailers;
  // }

}