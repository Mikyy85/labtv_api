package com.project.labtvapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Star")
@Table(name = "star")
public class Star implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  public int id;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "surname", length = 50, nullable = false)
  private String surname;

  @Column(name = "birth_date", nullable = false)
  private Date birth_date;

  // @OneToOne()
  // private Sesso sesso;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

}
