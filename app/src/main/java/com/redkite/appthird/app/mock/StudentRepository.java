package com.redkite.appthird.app.mock;

import com.google.gson.Gson;
import com.redkite.appthird.app.R;
import com.redkite.appthird.app.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Liubun on 20/12/2015.
 */
public class StudentRepository {

    private  List<Student> students = new ArrayList<Student>();

//    TODO stub
   {
        students.add(new Student(
                "kreol",
                "Кирило",
                "Любунь",
                "Олександрович",
                "pass",
                R.drawable.default_profile,
                "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
        ));

       students.add(new Student(
               "blz123",
               "Близнюк",
               "Аліна",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

       students.add(new Student(
               "avg345",
               "Віталій",
               "Гомонов",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

       students.add(new Student(
               "egorka",
               "Егор",
               "Калмиков",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

       students.add(new Student(
               "oleks123",
               "Олексій",
               "Димитров",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));
       students.add(new Student(
               "balash",
               "Юрій",
               "Балашкевич",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

       students.add(new Student(
               "alex567",
               "Олександ",
               "Жучинський",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

       students.add(new Student(
               "artcow",
               "Артем",
               "Коровниченко",
               "",
               "pass",
               R.drawable.default_profile,
               "ФІОТ. Группа ІК-22. Курс 4. Спеціальність системна інженерія"
       ));

    }



    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students);
    }

    public Student getStudentByLogin(String login) {
        for (Student student : students) {
            if(student.getLogin().equals(login))
                return student;
        }
        return new Student();
    }



    public String[] getNames() {
        List<String> res = new ArrayList<String>();
        for (Student student : students) {
            res.add(student.getLastName() + " " + student.getFirstName());
        }
        return res.toArray(new String[res.size()]);
    }


    public Integer[] getPhotos() {
        List<Integer> res = new ArrayList<Integer>();
        for (Student student : students) {
            res.add(student.getPhoto());
        }
        return res.toArray(new Integer[res.size()]);
    }

    public  String[] getDescriptions() {
        List<String> res = new ArrayList<String>();
        for (Student student : students) {
            res.add(student.getDescription());
        }
        return res.toArray(new String[res.size()]);
    }



    public  void save() {
        Gson gson = new Gson();
        String json = gson.toJson(students);

    }

}
