package com.cognizant.orderservice.dto;

public class OrderResponseDTO {
    private Long orderId;
    private String product;
    private Double price;
    private UserDTO user;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long orderId, String product, Double price, UserDTO user) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
        this.user = user;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
