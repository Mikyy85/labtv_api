package com.project.labtvapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieMini extends AbstractMovie {

	private static final long serialVersionUID = 6516209422008419842L;

}
