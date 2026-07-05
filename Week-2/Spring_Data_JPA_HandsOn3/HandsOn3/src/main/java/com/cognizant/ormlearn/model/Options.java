package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text", length = 100, nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "op_qn_id")
    private Question question;

    public Options() {
    }

    public Options(int id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Options [id=" + id + ", text=" + text + "]";
    }
}
