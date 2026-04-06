package phanMot;

public class Main {

    // ================== KHÁ 2 ==================
    // Giải phẫu trang JSP lộn xộn

    // 1. <%! private int requestCounter = 0; %>
    // => Race Condition
    // Biến này là biến dùng chung cho toàn bộ servlet (shared instance).
    // Khi nhiều request truy cập cùng lúc sẽ gây sai lệch dữ liệu.

    // 2. <% requestCounter++; %>
    // => Logic trong View (vi phạm Thin View)
    // JSP đang xử lý logic Java, không đúng nguyên tắc MVC.
    // View chỉ nên hiển thị dữ liệu.

    // 3. request.getAttribute + ép kiểu
    // => Coupling giữa View và Controller
    // JSP phải biết class Java và tự ép kiểu -> khó bảo trì.

    // 4. for (int i = 0; i < list.size(); i++)
    // => Scriptlet loop
    // Dùng Java loop trong JSP là cách viết cũ, nên thay bằng JSTL <c:forEach>.

    // 5. if/else tính rank trong JSP
    // => Business logic nằm trong View
    // Xếp loại học lực là logic nghiệp vụ, không nên viết trong JSP.

    // 6. <%= sv.getFullName() %>
    // => XSS
    // Không escape dữ liệu người dùng -> có thể chèn script độc.

    // 7. <%= sv.getScore()%>;
    // => Lỗi hiển thị
    // Dấu ; bị render ra HTML → hiển thị sai.

    // 8. <!-- comment -->
    // => Sai loại comment
    // HTML comment vẫn hiển thị ra trình duyệt.
    // Nên dùng JSP comment <%-- --%>.

    // 9. Dùng <%= %> thay vì EL
    // => Code cũ, khó đọc
    // Nên dùng ${} để clean code.

    // 10. import Java trong JSP
    // => View phụ thuộc Java
    // Không cần nếu dùng EL + JSTL.
}