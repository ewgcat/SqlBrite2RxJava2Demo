package com.xinwis.sqlbrite2rxjava2demo.db;

import android.content.Context;
import android.database.Cursor;

import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;
import com.xinwis.sqlbrite2rxjava2demo.AccountInfo;
import com.xinwis.sqlbrite2rxjava2demo.db.table.Account;

import io.reactivex.schedulers.Schedulers;



public class DBUtil {
    protected static final String TAG = DBUtil.class.getSimpleName();
    private static DBUtil mDbUtil;

    private BriteDatabase mDB;

    private DbOpenHelper mDbOpenHelper;

    private SqlBrite mSqlBrite;


    private DBUtil(Context context) {
        DatabaseContext databaseContext = new DatabaseContext(context);
        mDbOpenHelper = new DbOpenHelper(databaseContext);
        SqlBrite mSqlBrite = new SqlBrite.Builder().build();
        mDB = mSqlBrite.wrapDatabaseHelper(mDbOpenHelper, Schedulers.io());
    }

    public static DBUtil getInstance(Context context) {
        if (mDbUtil == null) {
            mDbUtil = new DBUtil(context);
        }
        return mDbUtil;
    }


    public BriteDatabase getDB() {
        if (mDB == null) {
            mDB = mSqlBrite.wrapDatabaseHelper(mDbOpenHelper, Schedulers.io());
        }
        return mDB;
    }

    public void insertAccountInfo(AccountInfo accountInfo) {
        mDB = getDB();
        mDB.execute("delete from " + Account.TABLE_NAME + " where 1=1");
        mDB.insert(Account.TABLE_NAME, new Account.Builder()
                .orgId(accountInfo.getmOrgId())
                .grade(accountInfo.getmGrade())
                .userId(accountInfo.getmUserId())
                .orgName(accountInfo.getmOrgName())
                .userName(accountInfo.getmUserName())
                .name(accountInfo.getmNickName())
                .telephone(accountInfo.getmTelphone())
                .deptId(accountInfo.getmDeptId())
                .deptName(accountInfo.getmDeptName())
                .jobId(accountInfo.getmJobId())
                .jobName(accountInfo.getmJobName())
                .sex(accountInfo.getmSex())
                .headImg(accountInfo.getmHeadImg())
                .build());

        mDB.close();
    }

    public AccountInfo queryAccountInfo() {
        mDB = getDB();
        AccountInfo accountInfo = null;
        Cursor cursor = mDB.query("select * from " + Account.TABLE_NAME);
        if (cursor != null && cursor.moveToNext()) {
            Account account = null;
            try {
                account = Account.MAPPER.apply(cursor);
                long mOrgId = account.mOrgId();
                long mGrade = account.mGrade();
                long mUserId = account.mUserId();
                String mOrgName = account.mOrgName();
                String mUserName = account.mUserName();
                String mName = account.mName();
                String mTelphone = account.mTelphone();
                String mDeptId = account.mDeptId();
                String mDeptName = account.mDeptName();
                String mJobId = account.mJobId();
                String mJobName = account.mJobName();
                String mSex = account.mSex();
                String headImg = account.headImg();
                accountInfo = new AccountInfo(mOrgId, mGrade, mUserId, mOrgName, mUserName, mName, mTelphone, mDeptId, mDeptName, mJobId, mJobName, mSex, headImg);
                cursor.close();
                mDB.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return accountInfo;
    }




}