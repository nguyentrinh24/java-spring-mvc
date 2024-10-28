package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Đánh dấu lớp này là một entity để ánh xạ với bảng trong cơ sở dữ liệu
@Table(name = "orders_details") // Chỉ định bảng "orders_details" trong cơ sở dữ liệu sẽ được ánh xạ tới entity
                                // này
public class Order_details {
    @Id // Đánh dấu thuộc tính này là khóa chính của bảng
    private long id;

    private long quantity; // Số lượng sản phẩm trong chi tiết đơn hàng
    private double price; // Giá của sản phẩm trong chi tiết đơn hàng

    // Mối quan hệ: nhiều order_details thuộc về một order (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "orders_id") // Chỉ định cột khóa ngoại `orders_id` trong bảng `orders_details` liên kết đến
                                    // bảng `orders`
    private Order orders; // Đối tượng order mà chi tiết đơn hàng này thuộc về

    // Mối quan hệ: nhiều order_details thuộc về một product (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "products_id") // Chỉ định cột khóa ngoại `products_id` trong bảng `orders_details` liên kết
                                      // đến bảng `products`
    private Product products; // Đối tượng product mà chi tiết đơn hàng này liên kết

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
