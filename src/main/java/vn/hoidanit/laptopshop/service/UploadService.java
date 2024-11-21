package vn.hoidanit.laptopshop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(
            ServletContext servletContext) {

        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // Hàm này xử lý việc lưu trữ file tải lên vào một thư mục cụ thể.

        // don't upload file if it is empty
        if (file.isEmpty())
            return "";
        // Nếu file trống (không có nội dung), trả về chuỗi rỗng để báo lỗi hoặc dừng xử
        // lý.
        targetFolder = targetFolder.replaceAll("[/\\\\]+", "");
        // Loại bỏ các ký tự "/" và "\" dư thừa từ `targetFolder` để tránh tạo thư mục
        // lồng không mong muốn.

        // relative path: absolute path
        String rootPath = this.servletContext.getRealPath("/resources/images");
        // Xác định đường dẫn tuyệt đối tới thư mục lưu trữ file, trong thư mục
        // `resources/images/product`.

        String finalName = ""; // Biến lưu tên file cuối cùng sau khi xử lý.

        try {
            byte[] bytes = file.getBytes();
            // Đọc nội dung file tải lên dưới dạng mảng byte.

            File dir = new File(rootPath + File.separator + targetFolder);
            // Tạo đối tượng File đại diện cho thư mục lưu trữ file.

            if (!dir.exists())
                dir.mkdirs();
            // Nếu thư mục chưa tồn tại, tạo mới thư mục.

            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            // Đặt tên file bằng cách ghép timestamp hiện tại với tên gốc của file.

            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
            // Tạo đối tượng File đại diện cho file sẽ lưu trên server.

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            // Tạo luồng ghi file ra server.

            stream.write(bytes); // Ghi dữ liệu file vào server.
            stream.close(); // Đóng luồng sau khi ghi xong.
        } catch (IOException e) {
            e.printStackTrace();
            // Ghi log lỗi nếu xảy ra ngoại lệ trong quá trình xử lý file.
        }
        return finalName;
        // Trả về tên file cuối cùng sau khi xử lý thành công.
    }

}
