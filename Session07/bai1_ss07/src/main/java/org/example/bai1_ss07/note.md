# BÀI 1 - MODULE CẬP NHẬT THÔNG TIN NHÀ HÀNG
## Phần 1 - Phân tích logic

Trong class RestaurantProfile, hệ thống có thuộc tính name kiểu String và active kiểu boolean để nhận dữ liệu từ form.

Lỗi thứ nhất xảy ra với tên cửa hàng. Trong object, thuộc tính là name nhưng trong form HTML lại sử dụng tên restaurantName. Spring Data Binding hoạt động dựa trên việc tên field trong form phải trùng với tên thuộc tính trong object. Do restaurantName không trùng với name nên Spring không thể map dữ liệu, dẫn đến khi submit form thì giá trị name luôn bị null.

Lỗi thứ hai xảy ra với checkbox active. Thuộc tính active có kiểu boolean nhưng trong form lại gán value là một chuỗi "MỞ_CỬA". Kiểu boolean chỉ nhận true hoặc false nên giá trị này không thể chuyển đổi chính xác, dẫn đến sai hoặc lỗi khi binding.

Ngoài ra, checkbox trong HTML chỉ gửi dữ liệu khi được tích. Nếu người dùng không tích thì request sẽ không có field active, khiến backend không nhận được giá trị và dễ gây sai lệch logic khi xử lý dữ liệu.

Tóm lại, hệ thống lỗi do hai nguyên nhân chính: thứ nhất là sai tên field giữa form và object khiến dữ liệu không bind được; thứ hai là sử dụng giá trị không phù hợp cho checkbox boolean và không xử lý đúng cơ chế gửi dữ liệu của checkbox.