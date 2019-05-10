package com.starv.firstspringboot.bean;

import java.util.Date;

public class Order {
    private Double idno;

    private String pay;

    private Date date;

    private String orderiddetail;

    public Double getIdno() {
        return idno;
    }

    public void setIdno(Double idno) {
        this.idno = idno;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderiddetail() {
        return orderiddetail;
    }

    public void setOrderiddetail(String orderiddetail) {
        this.orderiddetail = orderiddetail;
    }
}