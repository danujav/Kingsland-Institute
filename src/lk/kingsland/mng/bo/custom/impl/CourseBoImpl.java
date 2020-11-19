package lk.kingsland.mng.bo.custom.impl;

import lk.kingsland.mng.bo.BoFactory;
import lk.kingsland.mng.bo.custom.CourseBo;
import lk.kingsland.mng.dao.DaoFactory;
import lk.kingsland.mng.dao.custom.CourseDAO;
import lk.kingsland.mng.dao.custom.StudentDAO;
import lk.kingsland.mng.dto.CourseDTO;
import lk.kingsland.mng.entity.Course;
import lk.kingsland.mng.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl implements CourseBo {

    private CourseDAO dao =  DaoFactory.getInstance().getDao(DaoFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return dao.save(new Course(
                dto.getCode(),
                dto.getCourseName(),
                dto.getCourseType(),
                dto.getDuration()
        ));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception {
        List<Course> all = dao.getAll();
        ArrayList<CourseDTO> dtoList = new ArrayList<>();

        for(Course c : all){
            dtoList.add(new CourseDTO(
                    c.getCode(),
                    c.getCourseName(),
                    c.getCourseType(),
                    c.getDuration()));
        }

        return dtoList;
    }
}
