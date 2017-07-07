package com.xinwis.sqlbrite2rxjava2demo.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.xinwis.sqlbrite2rxjava2demo.db.Db;

import io.reactivex.functions.Function;



@AutoValue
public abstract class Account implements Parcelable {

    public static final String CREATE_TABLE = ""
            + "CREATE TABLE Account(\r\n"
            + "  mOrgId INTEGER,\r\n"
            + "  mGrade INTEGER,\r\n"
            + "  mUserId  INTEGER,\r\n"
            + "  mOrgName TEXT,\r\n"
            + "  mUserName TEXT,\r\n"
            + "  mName TEXT,\r\n"
            + "  mTelphone TEXT,\r\n"
            + "  mDeptId TEXT,\r\n"
            + "  mDeptName TEXT,\r\n"
            + "  mJobId TEXT,\r\n"
            + "  mJobName TEXT,\r\n"
            + "  mSex TEXT,\r\n"
            + "  headImg TEXT\r\n"
            + ")";

    public static final String TABLE_NAME = "Account";

    public static final String ORGID = "mOrgId";
    public static final String GRADE = "mGrade";
    public static final String USERID = "mUserId";
    public static final String ORGNAME = "mOrgName";
    public static final String USERNAME = "mUserName";
    public static final String NAME = "mName";
    public static final String TELEPHONE = "mTelphone";
    public static final String DEPTID = "mDeptId";
    public static final String DEPTNAME = "mDeptName";
    public static final String JOBID = "mJobId";
    public static final String JOBNAME = "mJobName";
    public static final String SEX = "mSex";
    public static final String HEADIMG = "headImg";

    public abstract long mOrgId();

    public abstract long mGrade();

    public abstract long mUserId();

    public abstract String mOrgName();

    public abstract String mUserName();

    public abstract String mName();

    public abstract String mTelphone();

    public abstract String mDeptId();

    public abstract String mDeptName();

    public abstract String mJobId();

    public abstract String mJobName();

    public abstract String mSex();

    public abstract String headImg();

    public static final Function<Cursor, Account> MAPPER = new Function<Cursor, Account>() {
        @Override
        public Account apply(Cursor cursor) {
            long orgId = Db.getLong(cursor, ORGID);
            long grade = Db.getLong(cursor, GRADE);
            long userId = Db.getLong(cursor, USERID);
            String orgName = Db.getString(cursor, ORGNAME);
            String userName = Db.getString(cursor, USERNAME);
            String name = Db.getString(cursor, NAME);
            String telephone = Db.getString(cursor, TELEPHONE);
            String deptId = Db.getString(cursor, DEPTID);
            String deptName = Db.getString(cursor, DEPTNAME);
            String jobName = Db.getString(cursor, JOBNAME);
            String jobId = Db.getString(cursor, JOBID);
            String sex = Db.getString(cursor, SEX);
            String headImg = Db.getString(cursor, HEADIMG);

            return new AutoValue_Account(orgId, grade, userId, orgName, userName, name, telephone, deptId, deptName, jobName, jobId, sex, headImg);
        }
    };

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder orgId(long orgId) {
            values.put(ORGID, orgId);
            return this;
        }

        public Builder grade(long grade) {
            values.put(ORGID, grade);
            return this;
        }

        public Builder userId(long userId) {
            values.put(USERID, userId);
            return this;
        }


        public Builder orgName(String orgName) {
            values.put(ORGNAME, orgName);
            return this;
        }


        public Builder userName(String userName) {
            values.put(USERNAME, userName);
            return this;
        }

        public Builder name(String name) {
            values.put(NAME, name);
            return this;
        }

        public Builder telephone(String telephone) {
            values.put(TELEPHONE, telephone);
            return this;
        }

        public Builder deptId(String deptId) {
            values.put(DEPTID, deptId);
            return this;
        }

        public Builder deptName(String deptName) {
            values.put(DEPTNAME, deptName);
            return this;
        }

        public Builder jobName(String jobName) {
            values.put(JOBNAME, jobName);
            return this;
        }

        public Builder jobId(String jobId) {
            values.put(JOBID, jobId);
            return this;
        }

        public Builder sex(String sex) {
            values.put(SEX, sex);
            return this;
        }

        public Builder headImg(String headImg) {
            values.put(HEADIMG, headImg);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }

}
