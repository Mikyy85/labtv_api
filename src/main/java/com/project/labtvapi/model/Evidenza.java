package com.project.labtvapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Evidenza")
@Table(name = "evidenza")
public class Evidenza implements Serializable {

	private static final long serialVersionUID = -5428063675564257820L;

	@Id
  private String id;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "full_title", nullable = false, length = 100)
  private String fullTitle;

  @Column(name = "image", nullable = false, length = 200)
  private String image;

  @Column(name = "crew", nullable = false, length = 100)
  private String crew;

  @Column(name = "imdbrating", nullable = false, length = 100)
  private String imDbRating;

  @Column(name = "imdbratingcount", nullable = false, length = 100)
  private String imDbRatingCount;

  @Column(name = "rank", nullable = false)
  private Double rank;

  @Column(name = "rankupdown", nullable = false)
  private Double rankUpDown;

  @Column(name = "year", nullable = false)
  private Double year;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFullTitle() {
    return fullTitle;
  }

  public void setFullTitle(String fullTitle) {
    this.fullTitle = fullTitle;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public String getImDbRating() {
    return imDbRating;
  }

  public void setImDbRating(String imDbRating) {
    this.imDbRating = imDbRating;
  }

  public String getImDbRatingCount() {
    return imDbRatingCount;
  }

  public void setImDbRatingCount(String imDbRatingCount) {
    this.imDbRatingCount = imDbRatingCount;
  }

  public Double getRank() {
    return rank;
  }

  public void setRank(Double rank) {
    this.rank = rank;
  }

  public Double getRankUpDown() {
    return rankUpDown;
  }

  public void setRankUpDown(Double rankUpDown) {
    this.rankUpDown = rankUpDown;
  }

  public Double getYear() {
    return year;
  }

  public void setYear(Double year) {
    this.year = year;
  }

}
