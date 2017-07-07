package com.xinwis.sqlbrite2rxjava2demo;

public class AccountInfo {
    protected long mOrgId;//组织ID Long类型，必填，用户隶属于的组织层次包括集团（用户）、区域／分公司（用户）、社区/项目（用户）

    protected String mOrgName;//这里组织名称是用来判断权限,并且用于显示各个模块'切换那里的默认名称

    protected long mGrade;//用户层级：1集团 2区域公司 3区域子公司(区域分公司) 4项目 5部门6岗位

    protected long mUserId=-1L;//用户ID，Long类型

    protected String mUserName;//用户名(登录名)，string类型

    protected String mName;//显示名,string类型

    protected String mSex;//性别0女1男
    public static final String SEX_MALE = "1"; //男性代号为 1 ，静态
    public static final String SEX_FEMALE = "0"; //女性代号为 0   静态

    protected String mTelphone;//联系方式,手机号

    protected String mDeptId;//部门id，若有多个，以逗号隔开

    protected String mDeptName; // 部门名称，若有多个，以逗号隔开

    protected String mJobId;//职位（岗位）id，若有多个，以逗号隔开

    protected String mJobName;// 职位（岗位）名称，若有多个，以逗号隔开;

    protected String headImg;// 头像


    public AccountInfo(long mOrgId, long mGrade, long mUserId, String mOrgName, String mUserName, String mName, String mTelphone, String mDeptId, String mDeptName, String mJobId, String mJobName, String mSex, String headImg) {

        this.mOrgId = mOrgId;
        this.mOrgName = mOrgName;
        this.mGrade = mGrade;
        this.mUserId = mUserId;
        this.mUserName = mUserName;
        this.mName = mName;
        this.mSex = mSex;
        this.mTelphone = mTelphone;
        this.mDeptId = mDeptId;
        this.mDeptName = mDeptName;
        this.mJobId = mJobId;
        this.mJobName = mJobName;
        this.headImg = headImg;
    }


    public long getmOrgId() {
        return mOrgId;
    }

    public void setmOrgId(long mOrgId) {
        this.mOrgId = mOrgId;
    }

    public String getmOrgName() {
        return mOrgName;
    }

    public void setmOrgName(String mOrgName) {
        this.mOrgName = mOrgName;
    }

    public long getmGrade() {
        return mGrade;
    }

    public void setmGrade(long mGrade) {
        this.mGrade = mGrade;
    }

    public long getmUserId() {
        return mUserId;
    }

    public void setmUserId(long mUserId) {
        this.mUserId = mUserId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmNickName() {
        return mName;
    }

    public void setmNickName(String mName) {
        this.mName = mName;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public static String getSexMale() {
        return SEX_MALE;
    }

    public static String getSexFemale() {
        return SEX_FEMALE;
    }

    public String getmTelphone() {
        return mTelphone;
    }

    public void setmTelphone(String mTelphone) {
        this.mTelphone = mTelphone;
    }

    public String getmDeptId() {
        return mDeptId;
    }

    public void setmDeptId(String mDeptId) {
        this.mDeptId = mDeptId;
    }

    public String getmDeptName() {
        return mDeptName;
    }

    public void setmDeptName(String mDeptName) {
        this.mDeptName = mDeptName;
    }

    public String getmJobId() {
        return mJobId;
    }

    public void setmJobId(String mJobId) {
        this.mJobId = mJobId;
    }

    public String getmJobName() {
        return mJobName;
    }

    public void setmJobName(String mJobName) {
        this.mJobName = mJobName;
    }

    public String getmHeadImg() {
        return headImg;
    }

    public void setmHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "mOrgId=" + mOrgId +
                ", mOrgName='" + mOrgName + '\'' +
                ", mGrade=" + mGrade +
                ", mUserId=" + mUserId +
                ", mUserName='" + mUserName + '\'' +
                ", mName='" + mName + '\'' +
                ", mSex='" + mSex + '\'' +
                ", mTelphone='" + mTelphone + '\'' +
                ", mDeptId='" + mDeptId + '\'' +
                ", mDeptName='" + mDeptName + '\'' +
                ", mJobId='" + mJobId + '\'' +
                ", mJobName='" + mJobName + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }
}
