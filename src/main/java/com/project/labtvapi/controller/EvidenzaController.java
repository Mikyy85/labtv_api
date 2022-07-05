package com.project.labtvapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.labtvapi.dao.EvidenzaDao;
import com.project.labtvapi.model.Evidenza;

@RestController
@RequestMapping("/api/evidenza")
public class EvidenzaController {

  @Autowired
  private EvidenzaDao eDao;

  // 1. Lista dei film in evidenza nella home page

  @CrossOrigin(origins = "http://localhost:4200/")
  @GetMapping(value = "/list", produces = "application/json")
  public ResponseEntity<ArrayList<Evidenza>> getEvidenzaList() {
    ArrayList<Evidenza> evidenzaList = (ArrayList<Evidenza>) eDao.findAll();

    if (evidenzaList == null)
      return new ResponseEntity<ArrayList<Evidenza>>(HttpStatus.NO_CONTENT);

    return new ResponseEntity<ArrayList<Evidenza>>(evidenzaList, HttpStatus.OK);
  }

}