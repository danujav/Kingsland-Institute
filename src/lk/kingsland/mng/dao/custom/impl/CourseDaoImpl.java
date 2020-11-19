package lk.kingsland.mng.dao.custom.impl;

import lk.kingsland.mng.dao.CrudUtil;
import lk.kingsland.mng.dao.custom.CourseDAO;
import lk.kingsland.mng.entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDAO {
    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO Course VALUES (?, ?, ?, ?)",
                course.getCode(),
                course.getCourseName(),
                course.getCourseType(),
                course.getDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Course WHERE code = ?", s);
    }

    @Override
    public Course get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Course> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course");
        ArrayList<Course> coursesList = new ArrayList<>();
        while(set.next()){
            coursesList.add(new Course(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4)));
        }
        return coursesList;
    }
}
