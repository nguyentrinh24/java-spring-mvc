package vn.hoidanit.laptopshop.domain;

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
@Table(name = "users") // Chỉ định bảng "users" trong cơ sở dữ liệu sẽ được ánh xạ tới entity này
public class user {
    @Id // Đánh dấu thuộc tính này là khóa chính của bảng
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tạo giá trị khóa chính, theo chiến lược tăng tự động
                                                        // (auto increment)
    Long id;

    String email, passWord, fullName, address, phone, avatar;

    // Mối quan hệ: nhiều user có thể có một role (ManyToOne)
    @ManyToOne // Thiết lập mối quan hệ nhiều user - một role
    @JoinColumn(name = "role_id") // Khóa ngoại `role_id` trong bảng `users` ánh xạ đến `role` trong bảng `roles`
    private role Role;

    // Mối quan hệ: một user có thể có nhiều order (OneToMany)
    @OneToMany(mappedBy = "users") // Thiết lập mối quan hệ một user - nhiều order, ánh xạ thông qua thuộc tính
                                   // `users` trong class `order`
    Set<order> orders;

    public role getRole() {
        return Role;
    }

    public void setRole(role role) {
        Role = role;
    }

    public Set<order> getOrders() {
        return orders;
    }

    public void setOrders(Set<order> orders) {
        this.orders = orders;
    }

    // Các getter, setter và phương thức khác
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

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "user [id=" + id + ", email=" + email + ", passWord=" + passWord + ", fullName=" + fullName
                + ", address=" + address + ", phone=" + phone + ", avatar=" + avatar + "]";
    }

}
