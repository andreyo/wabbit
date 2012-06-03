package com.wabbit.selenium.auto.bean;

/**
 * Created by IntelliJ IDEA.
 * User: Elena
 * Date: 05.02.2011
 * Time: 11:38:28
 * To change this template use File | Settings | File Templates.
 */
public class Auto {
    //Specific AutoRia parameters
    private String id;
    private String link;
    private String description;

    //Common Auto parameters
    private String make_model;
    private String year;
    private String city;
    private String price;
    private String type_kuzov;
    private String km;
    private String transmision;
    private String volume;
    private String color;
    private String date_reklama;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMake_model() {
        return make_model;
    }

    public void setMake_model(String make_model) {
        this.make_model = make_model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType_kuzov() {
        return type_kuzov;
    }

    public void setType_kuzov(String type_kuzov) {
        this.type_kuzov = type_kuzov;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate_reklama() {
        return date_reklama;
    }

    public void setDate_reklama(String date_reklama) {
        this.date_reklama = date_reklama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Auto{" + "id='" + id + '\'' + ", link='" + link + '\'' + ", make_model='" + make_model + '\''
                + ", year='" + year + '\'' + ", city='" + city + '\'' + ", price='" + price + '\'' + ", type_kuzov='"
                + type_kuzov + '\'' + ", km='" + km + '\'' + ", transmision='" + transmision + '\'' + ", volume='"
                + volume + '\'' + ", color='" + color + '\'' + ", date_reklama='" + date_reklama + '\'' + ", phone='"
                + phone + '\'' + '}';
    }
}
