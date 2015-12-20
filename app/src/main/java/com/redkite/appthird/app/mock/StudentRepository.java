package com.redkite.appthird.app.mock;

import com.redkite.appthird.app.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Liubun on 20/12/2015.
 */
public class StudentRepository {

    private static List<Student> students = new ArrayList<Student>();

//    TODO stub
    static {
        Student s = new Student();
        s.setLogin("kreol");
        s.setPass("send08");
        s.setFirstName("Кирило");
        s.setFirstName("Любунь");
        s.setFirstName("Олександрович");
        students.add(s);
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<Student>(students);
    }

    public static Student getStudentByLogin(String login) {
        for (Student student : students) {
            if(student.getLogin().equals(login))
                return student;
        }
        return new Student();
    }
}
