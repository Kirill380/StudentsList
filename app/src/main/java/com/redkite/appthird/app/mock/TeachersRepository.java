package com.redkite.appthird.app.mock;

import com.redkite.appthird.app.R;
import com.redkite.appthird.app.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Liubun on 20/12/2015.
 */
public class TeachersRepository {

    private List<Teacher> teachers = new ArrayList<Teacher>();
    
    //    TODO stub
    {
        teachers.add(new Teacher(
                "iragen",
                "Ірина",
                "Козубська",
                "Генадівна",
                "pass",
                R.drawable.default_profile,
                "Іноземна мова профісійного спрямування"
        ));

        teachers.add(new Teacher(
                "savart123",
                "Артем",
                "Савицький",
                "Йосипович",
                "pass",
                R.drawable.default_profile,
                "Технології розробки програмного забезрпечення"
        ));

        teachers.add(new Teacher(
                "palish123",
                "Михайло",
                "Поліщук",
                "Миколайович",
                "pass",
                R.drawable.default_profile,
                "CAD/CAM/CAE системи"
        ));

        teachers.add(new Teacher(
                "passko380",
                "Віктор",
                "Пасько",
                "Петрович",
                "pass",
                R.drawable.default_profile,
                "Захист інформіції в комп`ютерних мережах"
        ));

        teachers.add(new Teacher(
                "djakov",
                "Сергій",
                "Дьяков",
                "О",
                "pass",
                R.drawable.default_profile,
                "CAD/CAM/CAE системи та ЗІКС"
        ));

    }


    public List<Teacher> getAllTeachers() {
        return new ArrayList<Teacher>(teachers);
    }

    public Teacher getTeacherByLogin(String login) {
        for (Teacher teacher : teachers) {
            if(teacher.getLogin().equals(login))
                return teacher;
        }
        return new Teacher();
    }


    public String[] getNames() {
        List<String> res = new ArrayList<String>();
        for (Teacher teacher : teachers) {
            res.add(teacher.getLastName() + " " + teacher.getFirstName().substring(0,1) + ". " + teacher.getMiddleName().substring(0, 1) + ".");
        }
        return res.toArray(new String[res.size()]);
    }


    public Integer[] getPhotos() {
        List<Integer> res = new ArrayList<Integer>();
        for (Teacher teacher : teachers) {
            res.add(teacher.getPhoto());
        }
        return res.toArray(new Integer[res.size()]);
    }

    public  String[] getDescriptions() {
        List<String> res = new ArrayList<String>();
        for (Teacher teacher : teachers) {
            res.add(teacher.getDescription());
        }
        return res.toArray(new String[res.size()]);
    }
}
