# BÀI 2 - PHÂN TÍCH LUỒNG INPUT / OUTPUT TRANG DANH SÁCH MÓN ĂN

## 1. Cấu trúc đối tượng Dish

Đối tượng `Dish` dùng để biểu diễn một món ăn trong nhà hàng, gồm các thuộc tính:

- `id`: mã món ăn
- `name`: tên món ăn
- `price`: giá món ăn
- `isAvailable`: trạng thái còn hàng hay hết hàng

## 2. Ý nghĩa dữ liệu

- Nếu `isAvailable = true`:
    - View hiển thị: `Còn hàng`
    - Màu chữ bình thường hoặc xanh

- Nếu `isAvailable = false`:
    - View hiển thị: `Hết hàng`
    - Màu chữ đỏ để cảnh báo

## 3. Luồng Input / Output

### Input
Người dùng truy cập đường dẫn:

`/bai2/dishes`

### Xử lý
- `DishController` nhận request từ trình duyệt
- Controller gọi `DishService`
- `DishService` trả về danh sách `List<Dish>`
- Controller đưa danh sách này vào `Model` với tên là `dishes`

### Output
- View `dish-list.html` nhận dữ liệu từ `Model`
- Dùng `th:each` để lặp danh sách món ăn
- Dùng `th:if` và `th:unless` để hiển thị trạng thái:
    - `Còn hàng`
    - `Hết hàng`
- Nếu danh sách rỗng hoặc null:
    - Hiển thị thông báo:
      `Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau`

## 4. Sơ đồ I/O

Người dùng
→ gửi request `/bai2/dishes`
→ `DishController`
→ `DishService`
→ trả về `List<Dish>`
→ `Model`
→ `dish-list.html`
→ hiển thị danh sách món ăn ra giao diện

## 5. Kết luận

Bài này giúp minh họa cách Thymeleaf lấy dữ liệu từ Controller để render ra giao diện động.
Các kỹ thuật chính sử dụng là:

- `th:each`
- `th:text`
- `th:if`
- `th:unless`

Đồng thời xử lý thêm trường hợp danh sách rỗng để giao diện không bị trống.