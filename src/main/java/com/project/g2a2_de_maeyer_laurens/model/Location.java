package com.project.g2a2_de_maeyer_laurens.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "placeCode1")
    private String placeCode1;

    @Column(name = "placeCode2")
    private String placeCode2;

    @Column(name = "placeName")
    private String placeName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;


    public Location(String placeCode1, String placeCode2, String placeName) {
        this.placeCode1 = placeCode1;
        this.placeCode2 = placeCode2;
        this.placeName = placeName;
    }

    public Location() {
    }

    public long getId() {
        return id;
    }

    public String getPlaceCode1() {
        return placeCode1;
    }

    public String getPlaceCode2() {
        return placeCode2;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceCode1(String placeCode1) {
        this.placeCode1 = placeCode1;
    }

    public void setPlaceCode2(String placeCode2) {
        this.placeCode2 = placeCode2;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
