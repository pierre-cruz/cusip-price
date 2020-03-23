package com.ice.cusipprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cusips")
public class Cusip {

    private String cusipId;
    private Double price;

    public Cusip(){

    };

    public Cusip(String cusipId, Double price){
        this.cusipId = cusipId;
        this.price = price;
    }

    @Id
    @Column(name="cusip_id", nullable = false)
    public String getCusipId() {
        return cusipId;
    }

    public void setCusipId(String cusipId) {
        this.cusipId = cusipId;
    }

    @Column(name="price", nullable = true)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cusip [cusipId = " + cusipId + ", price = " + price.toString() + "]";
    }
}