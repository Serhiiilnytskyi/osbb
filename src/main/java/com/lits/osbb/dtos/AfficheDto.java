package com.lits.osbb.dtos;

import com.lits.osbb.entities.Affiche;
import org.apache.tomcat.jni.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class AfficheDto extends Affiche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Date beginDate;
    @Column
    private Date endDate;
    @Column
    private User author;



    public AfficheDto(String title, String body, Date beginDate, Date endDate, User author) {
        super(title, body, beginDate, endDate, author);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getBody() {
        return super.getBody();
    }

    @Override
    public void setBody(String body) {
        super.setBody(body);
    }

    @Override
    public Date getBeginDate() {
        return super.getBeginDate();
    }

    @Override
    public void setBeginDate(Date beginDate) {
        super.setBeginDate(beginDate);
    }

    @Override
    public Date getEndDate() {
        return super.getEndDate();
    }

    @Override
    public void setEndDate(Date endDate) {
        super.setEndDate(endDate);
    }

    @Override
    public User getAuthor() {
        return super.getAuthor();
    }

    @Override
    public void setAuthor(User author) {
        super.setAuthor(author);
    }

    @Override
    public void makePost() {
        super.makePost();
    }

    @Override
    public Double getId() {
        return super.getId();
    }

    @Override
    public void setId(Double id) {
        super.setId(id);
    }
}
