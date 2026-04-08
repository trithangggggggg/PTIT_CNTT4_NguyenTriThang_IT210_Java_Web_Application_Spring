package org.example.kha1.dao;

import org.example.kha1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentDAO {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("John", 20),
                    new Student("Jane", 22),
                    new Student("Bob", 19)
            )
    );

    // Phương thức để lấy danh sách sinh viên
    public List<Student> getAllStudents() {
        return this.students;
    }
}
