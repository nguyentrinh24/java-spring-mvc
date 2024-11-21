package vn.trinhnguyen.laptopshop.domain.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vn.trinhnguyen.laptopshop.service.validator.RegisterChecked;
import vn.trinhnguyen.laptopshop.service.validator.StrongPassword;

@RegisterChecked
public class RegisterDTO {
    @NotNull(message = "Không được bỏ trống")
    @Size(min = 4, message = "trường này phải dài hơn 4 kí tự")
    private String firstName;

    @Size(min = 1, message = "không được bỏ trống trường này")
    private String lastName;
    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    private String password;
    // @StrongPassword(message = "Mật khẩu phải dài hơn 8 kí tự")
    private String confirmPassword;

    public RegisterDTO(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public RegisterDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
