package phanMot;

public class Main {

    // ================== GIỎI 3 ==================
    // Xây dựng hệ thống quản lý đơn hàng — Scope & Implicit Objects

    // 1. Vì sao thông báo lỗi đăng nhập phải lưu vào Request Scope?
    // Vì thông báo lỗi chỉ cần tồn tại đúng 1 request khi submit form đăng nhập sai.
    // Sau khi reload hoặc mở lại trang login, thông báo đó phải biến mất.
    // Nếu lưu nhầm vào Session Scope thì lỗi sẽ còn tồn tại ở các request sau,
    // làm người dùng thấy lại thông báo cũ dù chưa nhập sai lần mới.

    // 2. Vì sao tên nhân viên và role phải lưu vào Session Scope?
    // Vì đây là dữ liệu của riêng từng người dùng và cần tồn tại xuyên suốt phiên làm việc.
    // Nếu lưu vào Request Scope thì sang request tiếp theo dữ liệu sẽ mất.
    // Nếu lưu vào Application Scope thì toàn bộ người dùng sẽ bị dùng chung dữ liệu,
    // dẫn đến lẫn thông tin nhân viên A và B.

    // 3. Vì sao totalViewCount phải lưu vào Application Scope?
    // Vì đây là bộ đếm dùng chung cho toàn hệ thống, mọi nhân viên đều nhìn thấy cùng một giá trị.
    // Nếu lưu vào Session Scope thì mỗi nhân viên sẽ có bộ đếm riêng.
    // Ví dụ A xem 2 lần sẽ thấy 2, B mới vào có thể chỉ thấy 1 hoặc 0, không phản ánh toàn hệ thống.

    // 4. Race Condition là gì?
    // Race Condition là tình huống nhiều request cùng đọc và ghi một dữ liệu dùng chung
    // tại cùng thời điểm, làm kết quả cuối cùng bị sai do ghi đè lẫn nhau.

    // 5. Vì sao đoạn code sau có Race Condition?
    // Integer count = (Integer) application.getAttribute("totalViewCount");
    // if (count == null) count = 0;
    // count++;
    // application.setAttribute("totalViewCount", count);
    //
    // Vì 2 request có thể cùng đọc count = 5, sau đó cả hai cùng tăng lên 6,
    // rồi cùng set lại 6. Đúng ra sau 2 lần truy cập phải là 7.

    // 6. Cách phòng tránh Race Condition
    // Có thể dùng synchronized khi cập nhật application scope,
    // hoặc tốt hơn là dùng AtomicInteger để tăng an toàn trong môi trường nhiều luồng.

    // 7. Scope dùng trong bài
    // - Request Scope: thông báo lỗi login, danh sách đơn hàng cho 1 lần render trang
    // - Session Scope: loggedUser, role
    // - Application Scope: totalViewCount
    // - Page Scope: dữ liệu chỉ dùng nội bộ trong 1 trang JSP nếu cần qua pageContext

    // 8. Implicit Objects dùng trong JSP
    // - request: đọc dữ liệu request scope
    // - session: đọc dữ liệu session scope
    // - application: đọc dữ liệu application scope
    // - pageContext: truy cập nhiều scope hoặc biến cục bộ của trang
}