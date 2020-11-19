package lk.kingsland.mng.dao;

import lk.kingsland.mng.dao.custom.impl.CourseDaoImpl;
import lk.kingsland.mng.dao.custom.impl.QueryDaoImpl;
import lk.kingsland.mng.dao.custom.impl.RegistrationDaoImpl;
import lk.kingsland.mng.dao.custom.impl.StudentDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (null == daoFactory) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOType {
        STUDENT, COURSE, REGISTRATION, QUERY
    }

    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDaoImpl();
            case COURSE:
                return (T) new CourseDaoImpl();
            case REGISTRATION:
                return (T) new RegistrationDaoImpl();
            case QUERY:
                return (T) new QueryDaoImpl();
            default:
                return null;
        }
    }
}
