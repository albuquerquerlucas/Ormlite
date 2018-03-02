package br.com.prot.ormpersistence;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.util.List;

/**
 * Created by fredericom on 02/03/2018.
 */

public abstract class GenericDAO<E> extends DataBaseHelper<E> {

    protected Dao<E, Integer> dao;
    private Class<E> type;

    public GenericDAO(Context context, Class<E> type) {
        super(context);
        this.type = type;
        setDao();
    }

    protected void setDao() {
        try{
            dao = DaoManager.createDao(getConnectionSource(), type);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<E> getAll() {
        try{
            List<E> result = dao.queryForAll();
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public E getById(int id) {
        try{
            E obj = dao.queryForId(id);
            return obj;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void insert(E obj) {
        try{
            dao.create(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(E obj) {
        try{
            dao.delete(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(E obj) {
        try{
            dao.update(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
