package org.example.demo.repository;

import org.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Nguyen Tri Thang", true, 20, "Hai Phong"),
                    new Student(2, "Nguyen Tuan Minh", false, 21, "Lao Cai"),
                    new Student(3, "Vu Viet Tien", true, 22, "Ninh Binh"),
                    new Student(4, "Pham Quoc Loc", false, 23, "Ha Noi"),
                    new Student(5, "Dao Xuan Khanh", true, 24, "Hung Yen")
            )
    );

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return this.students;
    }
}
