package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Quantity không được để trống")
    @Positive(message = "Quantity phải là số dương")
    private long quantity;

    @NotNull(message = "Sold không được để trống")

    private long sold;

    @NotNull(message = "Price không được để trống")
    @Positive(message = "Price phải là số dương")
    private double price;

    @NotNull(message = "Name không được để trống")
    @NotEmpty(message = "Name không được để trống")
    private String name;

    private String image;

    @NotNull(message = "detailDesc không được để trống")
    @NotEmpty(message = "detailDesc không được để trống")
    @Column(columnDefinition = "MEDIUMTEXT")
    private String detailDesc;

    @NotNull(message = "shortDesc không được để trống")
    @NotEmpty(message = "shortDesc không được để trống")
    private String shortDesc;

    @NotNull(message = "Factory không được để trống")
    @NotEmpty(message = "Factory không được để trống")
    private String factory;

    @NotNull(message = "Target không được để trống")
    @NotEmpty(message = "Target không được để trống")
    private String target;

    // Các getter và setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
