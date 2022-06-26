package com.project.labtvapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.JoinTable;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Trailer")
@Table(name = "trailer")
public class Trailer implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "video_url", nullable = false)
  private String video_url;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "id_film", referencedColumnName = "id")
  private Movie movie = new Movie();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getVideo_url() {
    return video_url;
  }

  public void setVideo_url(String video_url) {
    this.video_url = video_url;
  }

  // public Movie getMovie() {
  // return movie;
  // }

  // public void setMovie(Movie movie) {
  // this.movie = movie;
  // }

}
