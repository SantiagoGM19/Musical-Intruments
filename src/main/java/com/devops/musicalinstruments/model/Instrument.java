package com.devops.musicalinstruments.model;


import jakarta.persistence.*;

@Entity(name = "Instrument")
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String model;

    private Long category_id;

    private Double price;

    //years
    private Integer usefullLifeTime;


    public Instrument(Long id, String name, String model, Double price, Integer usefullLifeTime, Long category_id) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.usefullLifeTime = usefullLifeTime;
        this.category_id = category_id;
    }

    public Instrument(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUsefullLifeTime() {
        return usefullLifeTime;
    }

    public void setUsefullLifeTime(Integer usefullLifeTime) {
        this.usefullLifeTime = usefullLifeTime;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
