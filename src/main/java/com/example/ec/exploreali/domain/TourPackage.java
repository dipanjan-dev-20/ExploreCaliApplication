package com.example.ec.exploreali.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage {

    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage(){

    }

    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
