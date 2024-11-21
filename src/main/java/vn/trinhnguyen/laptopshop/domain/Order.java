package vn.trinhnguyen.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity // Đánh dấu lớp này là một entity để ánh xạ với bảng trong cơ sở dữ liệu
@Table(name = "orders") // Chỉ định bảng "orders" trong cơ sở dữ liệu sẽ được ánh xạ tới entity này
public class Order {
    @Id // Đánh dấu thuộc tính này là khóa chính của bảng
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tạo giá trị khóa chính, theo chiến lược tăng tự động
                                                        // (auto increment)
    private long id;

    private double totalPrice;

    // Mối quan hệ: nhiều order thuộc về một user (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "users_id") // Chỉ định cột khóa ngoại `users_id` trong bảng `orders`
    private User users;

    // Mối quan hệ: một order có thể có nhiều order_details (OneToMany)
    @OneToMany(mappedBy = "orders") // Thiết lập mối quan hệ một order - nhiều order_details, ánh xạ thông qua thuộc
                                    // tính `orders` trong lớp `order_details`
    Set<Order_details> orders_details;

    // Phương thức toString để hiển thị thông tin về order
    @Override
    public String toString() {
        return "order [id=" + id + ", totalPrice=" + totalPrice + "]";
    }

    // Các getter và setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
