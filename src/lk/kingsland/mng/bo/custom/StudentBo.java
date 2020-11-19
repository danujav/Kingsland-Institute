package lk.kingsland.mng.bo.custom;

import lk.kingsland.mng.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBo {
    public boolean saveStudent(StudentDTO dto)throws Exception;
    public boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public ArrayList<StudentDTO> getAllStudent()throws Exception;
}
