package lk.kingsland.mng.dao.custom.impl;

import lk.kingsland.mng.dao.CrudUtil;
import lk.kingsland.mng.dao.custom.StudentDAO;
import lk.kingsland.mng.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO {
    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?)",
                student.getId(), student.getStudentName(),
                student.getAddress(), student.getContact(), student.getDob(), student.getGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Student get(String s) throws Exception {
         ResultSet set = CrudUtil.execute("SELECT * FROM Student WHERE Id = ?", s);
         if(set.next()){
             return new Student(
                     set.getString(1),
                     set.getString(2),
                     set.getString(3),
                     set.getString(4),
                     set.getString(5),
                     set.getString(6));
         }else{
             return null;
         }
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Student");
        ArrayList<Student> studentList = new ArrayList<>();

        while(set.next()){
            studentList.add(new Student(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6)
            ));
        }
        return studentList;
    }
}
