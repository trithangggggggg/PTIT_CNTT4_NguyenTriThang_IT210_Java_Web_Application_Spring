# BÀI 1 - PHÁT HIỆN LỖI CẤU HÌNH THYMELEAF

## Các lỗi trong cấu hình

### 1. Sai thư mục chứa template

Cấu hình cũ:

```
/WEB-INF/views
```

Đúng phải là:

```
/WEB-INF/templates/
```

---

### 2. Sai phần mở rộng file

Cấu hình cũ:

```
.jsp
```

Đúng phải là:

```
.html
```

---

### 3. Thiếu TemplateMode

Chưa khai báo:

```
resolver.setTemplateMode("HTML");
```

---

### 4. Thiếu các bean cần thiết cho Thymeleaf

Cấu hình chưa có:

* SpringTemplateEngine
* ThymeleafViewResolver

=> Hệ thống không thể render Thymeleaf đúng cách

---

## Kết luận

Lỗi xuất phát từ việc:

* Nhầm lẫn giữa JSP và Thymeleaf
* Cấu hình sai đường dẫn và định dạng file
* Thiếu các thành phần quan trọng trong Thymeleaf
