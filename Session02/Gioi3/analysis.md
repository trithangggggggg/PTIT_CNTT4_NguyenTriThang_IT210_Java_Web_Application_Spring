# Phân tích Scope và Implicit Objects trong hệ thống quản lý đơn hàng

## 1. Tại sao thông báo lỗi đăng nhập phải lưu vào Request Scope mà không phải Session Scope?

Thông báo lỗi đăng nhập chỉ có ý nghĩa trong đúng một lần submit form bị sai. Sau khi request đó kết thúc, thông báo nên biến mất.

Nếu lưu vào Request Scope:
- Thông báo chỉ tồn tại trong một request.
- Khi người dùng tải lại trang hoặc truy cập lại trang login sau đó, lỗi sẽ không còn.

Nếu lưu nhầm vào Session Scope:
- Thông báo sẽ tồn tại suốt phiên làm việc.
- Người dùng có thể tiếp tục thấy lỗi cũ dù lần sau chưa đăng nhập sai.
- Gây trải nghiệm sai và làm dữ liệu trạng thái bị bẩn.

Vì vậy, lỗi đăng nhập phải để trong Request Scope.

## 2. Tại sao totalViewCount phải lưu vào Application Scope?

`totalViewCount` là dữ liệu dùng chung cho toàn bộ hệ thống, tức là mọi nhân viên đều phải nhìn thấy cùng một giá trị tổng.

Nếu lưu vào Application Scope:
- Mọi người dùng cùng chia sẻ một bộ đếm.
- Sau mỗi lần xem `/orders`, bộ đếm tăng lên cho toàn hệ thống.

Nếu lưu vào Session Scope:
- Mỗi nhân viên sẽ có một bộ đếm riêng.
- Ví dụ:
    - Nhân viên A xem 2 lần thì thấy 2.
    - Nhân viên B mới vào có thể thấy 1 hoặc 0.
- Kết quả đó không còn là tổng lượt xem toàn hệ thống.

Vì vậy `totalViewCount` phải nằm ở Application Scope.

## 3. Race Condition là gì?

Race Condition là tình huống nhiều luồng hoặc nhiều request cùng thao tác trên một dữ liệu dùng chung tại cùng thời điểm, dẫn đến kết quả cuối cùng không đúng như mong muốn.

Trong ứng dụng web, Application Scope là vùng dữ liệu chia sẻ cho tất cả người dùng, nên rất dễ gặp Race Condition nếu cập nhật không an toàn.

## 4. Vì sao đoạn code sau có thể gây Race Condition?

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);