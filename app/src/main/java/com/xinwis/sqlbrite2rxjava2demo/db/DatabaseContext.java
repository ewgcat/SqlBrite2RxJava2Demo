package com.xinwis.sqlbrite2rxjava2demo.db;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;


public class DatabaseContext extends ContextWrapper {
    protected static final String TAG = DatabaseContext.class.getSimpleName();

    /**
     * 构造函数
     *
     * @param base 上下文环境
     */
    public DatabaseContext(Context base) {
        super(base);
    }

    /**
     * 获得数据库路径，如果不存在，则创建对象对象
     * @param name
     */
    @Override
    public File getDatabasePath(String name) {
        String dbDir = getExternalCacheDir().toString();
        dbDir += "/baolimanagerDataBase";//数据库所在目录
        String dbPath = dbDir + "/" + name;//数据库路径
        //判断目录是否存在，不存在则创建该目录
        File dirFile = new File(dbDir);
        if (!dirFile.exists()) {
            boolean mkdirs = dirFile.mkdirs();
        }
        //数据库文件是否创建成功
        boolean isFileCreateSuccess = false;
        //判断文件是否存在，不存在则创建该文件
        File dbFile = new File(dbPath);
        if (!dbFile.exists()) {
            try {
                isFileCreateSuccess = dbFile.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            isFileCreateSuccess = true;
        }

        //返回数据库文件对象
        if (isFileCreateSuccess) {
            return dbFile;
        } else {
            return null;
        }
    }

    /**
     * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
     * @param name
     * @param mode
     * @param factory
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        if (TextUtils.isEmpty(name)) {
            return null;
        } else {
            File databasePath = getDatabasePath(name);
            if (databasePath.exists()) {
                SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(databasePath, null);
                return result;
            }else {
                return null;
            }
        }
    }

    /**
     * Android 4.0会调用此方法获取数据库。
     * @param name
     * @param mode
     * @param factory
     * @param errorHandler
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        if (TextUtils.isEmpty(name)) {
            return null;
        } else {
            File databasePath = getDatabasePath(name);
            if (databasePath.exists()) {
                SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(databasePath, null);
                return result;
            }else {
                return null;
            }

        }
    }
}
