package com.kitm.penktadienio_darbas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="nt")
public class NTObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "adresas")
    private String address;

    @Column(name = "plotas_kv_m")
    private double area;

    @Column(name = "kaina_eur")
    private double price;

    @Column(name = "ivertinimas")
    private int rating;

    @Column(name = "tipas")
    private String type;

    @Column(name = "vip")
    private boolean vip;

    public NTObject(String address, double area, double price, int rating, String type, boolean vip) {
        this.address = address;
        this.area = area;
        this.price = price;
        this.rating = rating;
        this.type = type;
        this.vip = vip;
    }

    public NTObject()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "NTObject{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                ", vip=" + vip +
                '}';
    }
}
