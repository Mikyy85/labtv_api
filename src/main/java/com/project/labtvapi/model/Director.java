package com.project.labtvapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Director")
@Table(name = "director")
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "full_name", length = 255, nullable = false)
  private String fullName;

  @Column(name = "birth_date", nullable = false)
  private Date birth_date;

  @ManyToOne
  @JoinColumn(name = "id_sesso")
  private Sesso sesso;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

  public Sesso getSesso() {
    return sesso;
  }

  public void setSesso(Sesso sesso) {
    this.sesso = sesso;
  }

}