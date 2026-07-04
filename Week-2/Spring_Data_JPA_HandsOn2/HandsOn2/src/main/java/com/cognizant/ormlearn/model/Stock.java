package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code", length = 10, nullable = false)
    private String code;

    @Column(name = "st_date", nullable = false)
    private LocalDate date;

    @Column(name = "st_open", nullable = false)
    private double open;

    @Column(name = "st_close", nullable = false)
    private double close;

    @Column(name = "st_volume", nullable = false)
    private long volume;

    public Stock() {
    }

    public Stock(String code, LocalDate date, double open, double close, long volume) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
    }
}
