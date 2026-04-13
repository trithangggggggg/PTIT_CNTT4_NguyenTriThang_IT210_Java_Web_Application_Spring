# BÀI 2 - TỐI ƯU HÓA FORM DROPDOWN VỚI @ModelAttribute
## Phần 1 - Phân tích logic

Việc lặp lại đoạn code `model.addAttribute("categories", ...)` trong cả 3 hàm GET đã vi phạm nguyên tắc DRY (Don't Repeat Yourself), tức là không lặp lại cùng một logic ở nhiều nơi trong chương trình.

Mặc dù chương trình vẫn chạy đúng, nhưng cách viết này làm cho Controller bị dài dòng, khó bảo trì và dễ phát sinh lỗi. Khi nhiều method cùng chứa một đoạn code giống nhau, chỉ cần thay đổi dữ liệu danh sách nhóm món ăn thì lập trình viên phải sửa ở tất cả các nơi đã lặp lại.

Nếu sau này hệ thống mở rộng thành 20 trang đều cần dropdown "Nhóm món ăn", rủi ro bảo trì sẽ rất lớn. Cụ thể, khi thêm hoặc sửa một nhóm món ăn, lập trình viên có thể sửa thiếu một vài chỗ, dẫn đến dữ liệu hiển thị không đồng nhất giữa các trang. Ngoài ra, code lặp nhiều còn làm Controller phình to, khó đọc và giảm chất lượng thiết kế.

Vì vậy, thay vì lặp lại `model.addAttribute("categories", ...)` ở từng method, nên dùng method-level `@ModelAttribute` của Spring MVC để khai báo danh sách này một lần duy nhất. Khi đó, mọi request đi vào Controller đều tự động có sẵn dữ liệu `categories` để đưa ra giao diện.