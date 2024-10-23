package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_details")
public class order_details {
    @Id
    private long id;

    private long quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private order orders;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private product products;

}
