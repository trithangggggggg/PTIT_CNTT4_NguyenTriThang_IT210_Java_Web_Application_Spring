package phanMot;

public class Main {
    // cau 1
    // "/api/*" làm DispatcherServlet chỉ xử lý các URL bắt đầu bằng /api/,
    // nên request /welcome không vào Spring MVC và bị 404.
    // cau 2
    // @ComponentScan(basePackages = "com.demo.service") quét sai package,
    // nên Spring không tìm thấy WelcomeController trong com.demo.controller.
    // cau 3
    // Nếu chỉ sửa servlet mapping mà không sửa component scan thì ứng dụng
    // vẫn không chạy được, vì request vào được Spring nhưng Spring không
    //  có controller nào xử lý /welcome.
}
