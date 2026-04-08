package org.example.kha1.service;

import org.example.kha1.dao.StudentDAO;
import org.example.kha1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    // tiem su phu thuoc DI
    @Autowired
    private StudentDAO studentDAO;
    public List<Student> getAllStudents() {
        // Logic để lấy danh sách sinh viên từ cơ sở dữ liệu hoặc nguồn dữ liệu khác
        // Ví dụ: return studentRepository.findAll();
        List<Student> students = studentDAO.getAllStudents();
        return students;  // Trả về danh sách sinh viên
    }
}
