package br.com.prot.ormpersistence;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by fredericom on 02/03/2018.
 */

public class DataBaseHelper<E> extends OrmLiteSqliteOpenHelper {

    private static final String DATA_BASE = "orm.db";
    private static final int VER = 1;

    public DataBaseHelper(Context context) {
        super(context, DATA_BASE, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Contatos.class);
        } catch (java.sql.SQLException e) {
            Log.e(DataBaseHelper.class.getName(), "Erro ao criar o banco : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            TableUtils.dropTable(connectionSource, Contatos.class, true);
            onCreate(database, connectionSource);
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
