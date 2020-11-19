package lk.kingsland.mng.bo.custom;

import lk.kingsland.mng.dto.CourseDTO;

import java.util.ArrayList;

public interface CourseBo {
    public boolean saveCourse(CourseDTO dto)throws Exception;
    public boolean updateCourse(CourseDTO dto)throws Exception;
    public boolean deleteCourse(String id)throws Exception;
    public CourseDTO getCourse(String id)throws Exception;
    public ArrayList<CourseDTO> getAllCourse()throws Exception;
}
