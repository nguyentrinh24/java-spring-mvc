package vn.trinhnguyen.laptopshop.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.trinhnguyen.laptopshop.domain.User;
import vn.trinhnguyen.laptopshop.service.UserService;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    protected void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }

        // Xóa thuộc tính lỗi xác thực
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        // Lấy email của người dùng từ đối tượng Authentication
        String email = authentication.getName();

        // Tìm thông tin người dùng từ email
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            // Gắn thông tin người dùng vào session
            session.setAttribute("fullname", user.getFullName());
            session.setAttribute("avatar", user.getAvatar());
            session.setAttribute("id", user.getId());
            session.setAttribute("email", user.getEmail());

            // Kiểm tra và lấy tổng số sản phẩm trong giỏ
            int sum = 0;
            if (user.getCart() != null) {
                sum = user.getCart().getSum();
            }
            session.setAttribute("sum", sum);
        }
    }

    protected String determineTargetUrl(final Authentication authentication) {

        Map<String, String> roleTargetUrlMap = new HashMap<>();
        roleTargetUrlMap.put("ROLE_USER", "/");
        roleTargetUrlMap.put("ROLE_ADMIN", "/admin");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {

            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request, authentication);

    }

}
