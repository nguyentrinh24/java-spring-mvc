# Java Spring Starter template(update)
Template này được sử dụng cho series Java Spring MVC (dự án laptopshop) của tác giả Hỏi Dân IT (Eric)

# Tổng kết về MVC vs Spring Data   
Các thành phần tham gia vào mô hình MVC với Spring :

M: model, trong dự án này, chúng ta code tại thư mục domain (domain-driven design)
Model sẽ chịu trách nhiệm quản lý các “đối tượng/tác nhân” tham gia vào hệ thống,
chính là các tables lưu trữ tại database

V : view, là các file jsp (html), tạo ra giao diện cho người dùng nhìn thấy

C : controller, code tại thư mục controller, có tác dụng điều hướng hoạt động của
website


Mối quan hệ giữa các thành phần:

Bước 1: người dùng truy cập vào 1 route (url tại website), ví dụ
localhost:8081/abc
abc là url người dùng “muốn truy cập”

Bước 2: Server java nhận được yêu cầu của người dùng, sẽ quét qua tất cả controller để
tìm ra controller nào phụ trách xử lý yêu cầu trên. Nếu có (chuyển bước 3), còn không sẽ
trả ra lỗi 404 not found

Bước 3: Nếu cần lấy dữ liệu, controller sẽ gọi -> service -> gọi repository để lấy data

Bước 4: Controller truyền data sang view

Bước 5: View render (tạo ra giao diện) và hiển thị kết quả cho người dùng