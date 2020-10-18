package org.mxn.rdsu.spring.starter.test.entity;

public class Product {
    private String no;
    private String name;
    private Integer stock;

    public Product(String no, String name, Integer stock) {
        this.no = no;
        this.name = name;
        this.stock = stock;
    }

    public Product() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
