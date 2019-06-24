package com.lits.osbb.entities;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table
public class Affiche implements Post {


    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Double id;
    private String title;
    private String body;
    private Date beginDate;
    private Date endDate;
    private User author;

    public Affiche(String title, String body, Date beginDate, Date endDate, User author) {
        this.title = title;
        this.body = body;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.author = author;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void makePost() {

    }
}
