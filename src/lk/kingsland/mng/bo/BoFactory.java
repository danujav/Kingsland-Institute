package lk.kingsland.mng.bo;

import lk.kingsland.mng.bo.custom.impl.CourseBoImpl;
import lk.kingsland.mng.bo.custom.impl.RegistrationBoImpl;
import lk.kingsland.mng.bo.custom.impl.StudentBoImpl;
import lk.kingsland.mng.dao.custom.impl.CourseDaoImpl;
import lk.kingsland.mng.dao.custom.impl.RegistrationDaoImpl;
import lk.kingsland.mng.dao.custom.impl.StudentDaoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (null == boFactory) ? (boFactory = new BoFactory()) : boFactory;
    }

    public enum BoType{
        STUDENT, COURSE, REGISTRATION
    }

    public <T> T getBo(BoType type){
        switch (type){
            case STUDENT:
                return (T) new StudentBoImpl();
            case COURSE:
                return (T) new CourseBoImpl();
            case REGISTRATION:
                return (T) new RegistrationBoImpl();
            default:
                return null;
        }
    }
}
