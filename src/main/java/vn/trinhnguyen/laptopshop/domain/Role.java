package vn.trinhnguyen.laptopshop.domain;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Đánh dấu lớp này là một entity để ánh xạ với bảng trong cơ sở dữ liệu
@Table(name = "roles") // Chỉ định bảng "roles" trong cơ sở dữ liệu sẽ được ánh xạ tới entity này
public class Role {
    @Id // Đánh dấu thuộc tính này là khóa chính của bảng
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tạo giá trị khóa chính, theo chiến lược tăng tự động
                                                        // (auto increment)
    private long id;

    private String name, description;

    // Mối quan hệ: một role có thể gán cho nhiều user (OneToMany)
    @OneToMany(mappedBy = "Role") // Thiết lập mối quan hệ một role - nhiều user, ánh xạ thông qua thuộc tính
                                  // `Role` trong lớp `user`
    Set<User> users;

    // Các getter, setter và phương thức khác
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "role [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
