package lk.kingsland.mng.dao;

import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO{
    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T get(ID id) throws Exception;

    public List<T> getAll() throws Exception;
}
