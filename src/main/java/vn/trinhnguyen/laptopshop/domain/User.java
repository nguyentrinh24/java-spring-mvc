package vn.trinhnguyen.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import vn.trinhnguyen.laptopshop.domain.User;
import vn.trinhnguyen.laptopshop.service.validator.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // Đánh dấu lớp này là một entity để ánh xạ với bảng trong cơ sở dữ liệu
@Table(name = "users") // Chỉ định bảng "users" trong cơ sở dữ liệu sẽ được ánh xạ tới entity này
public class User {
    @Id // Đánh dấu thuộc tính này là khóa chính của bảng
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tạo giá trị khóa chính, theo chiến lược tăng tự động
                                                        // (auto increment)
    Long id;
    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")

    String email;

    @NotNull

    @Size(min = 4, message = "trường này phải dài hơn 4 kí tự")
    @StrongPassword(message = "mật khẩu phải dài hơn 8 kí tự")
    String passWord;

    @NotNull
    @Size(min = 4, message = "trường này phải dài hơn 4 kí tự")
    String fullName;

    @NotNull
    @Size(min = 4, message = "trường này phải dài hơn 4 kí tự")
    String phone;

    String address;

    String avatar;

    // Mối quan hệ: nhiều user có thể có một role (ManyToOne)
    @ManyToOne // Thiết lập mối quan hệ nhiều user - một role
    @JoinColumn(name = "role_id") // Khóa ngoại `role_id` trong bảng `users` ánh xạ đến `role` trong bảng `roles`
    private Role Role;

    // Mối quan hệ: một user có thể có nhiều order (OneToMany)
    @OneToMany(mappedBy = "users") // Thiết lập mối quan hệ một user - nhiều order, ánh xạ thông qua thuộc tính
                                   // `users` trong class `order`
    Set<Order> orders;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
