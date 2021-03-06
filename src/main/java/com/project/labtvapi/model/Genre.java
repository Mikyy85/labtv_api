package com.project.labtvapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Genre")
@Table(name = "genre")
public class Genre implements Serializable {


	private static final long serialVersionUID = 2410961658388509769L;

	@Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "genre")
  private String genre;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}
