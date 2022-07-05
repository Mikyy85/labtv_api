package com.project.labtvapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Sesso")
@Table(name = "sesso")
public class Sesso implements Serializable {

  private static final long serialVersionUID = 6348993405876823503L;

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "sesso")
  private String sesso;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSesso() {
    return sesso;
  }

  public void setSesso(String sesso) {
    this.sesso = sesso;
  }

}