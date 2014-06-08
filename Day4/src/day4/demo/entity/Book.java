package day4.demo.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 14-6-8.
 */
public class Book implements Serializable {//序列化

    private Integer id;
    private String title;
    private String author;
    private String press;
    private String picture;
    private String date;
    private String price;
    private String amount;

    public Book() {
    }

    public Book(Integer id, String title, String author, String press, String picture, String date, String price, String amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.press = press;
        this.picture = picture;
        this.date = date;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
