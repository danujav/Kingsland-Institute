package lk.kingsland.mng.bo.custom.impl;

import lk.kingsland.mng.bo.custom.StudentBo;
import lk.kingsland.mng.dao.DaoFactory;
import lk.kingsland.mng.dao.custom.StudentDAO;
import lk.kingsland.mng.dao.custom.impl.StudentDaoImpl;
import lk.kingsland.mng.dto.StudentDTO;
import lk.kingsland.mng.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    private StudentDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return dao.save(new Student(dto.getId(), dto.getStudentName(),
                dto.getAddress(), dto.getContact(), dto.getDob(),dto.getGender()));

    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student s = dao.get(id);
        return new StudentDTO(s.getId(), s.getStudentName(), s.getAddress(), s.getContact(),
                s.getDob(), s.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        List<Student> all = dao.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();
        for(Student s : all){
            dtoList.add(new StudentDTO(
                    s.getId(),
                    s.getStudentName(),
                    s.getAddress(),
                    s.getContact(),
                    s.getDob(),
                    s.getGender()
            ));
        }
        return dtoList;
    }
}
