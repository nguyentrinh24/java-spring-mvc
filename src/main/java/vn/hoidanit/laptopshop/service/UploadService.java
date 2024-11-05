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

    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // Kiểm tra nếu file rỗng
        if (file.isEmpty()) {
            return "";
        }
        // Đường dẫn thư mục gốc lưu ảnh
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();
            // Tạo tên file duy nhất bằng timestamp + tên file gốc
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            // Tạo file trên server
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                stream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalName; // Trả về tên file để lưu vào Product
    }
}
