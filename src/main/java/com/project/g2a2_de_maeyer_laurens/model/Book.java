package com.project.g2a2_de_maeyer_laurens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    @NotBlank
    @Size(min=3, max=128)
    private String name;
    @ManyToMany
    private List<Author> authors;
    @Column(name = "ISBNnumber")
    private long ISBNnumber;
    @Column(name = "price")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double price;
    @Column(name = "rating")
    private int rating;
    @OneToMany
    private List<Location> locations;


    public Book(String name, List<Author> authors, long ISBNnumber, double price, int rating, List<Location> locations) {
        this.name = name;
        this.authors = authors;
        this.ISBNnumber = ISBNnumber;
        this.price = price;
        this.rating = rating;
        this.locations = locations;
    }
    public Book() {
    }

    public String getId() {
        return id;
    }

    //generate getters for all attributes
    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public long getISBNnumber() {
        return ISBNnumber;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public List<Location> getLocations() {
        return locations;
    }

    //generate setters for all attributes
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setISBNnumber(long ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStarRating(int rating) {
        this.rating = rating;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
