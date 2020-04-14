package com.example.seersandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class Student implements Parcelable {

    private String userId;
    private String userName;
    private String password;
    private String name;
    private String gender;
    private String SAT_math;
    private String SAT_verbal;
    private String expense_limit;

    public Student(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
        this.password = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.SAT_math = in.readString();
        this.SAT_verbal = in.readString();
        this.expense_limit = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeString(userId);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(SAT_math);
        dest.writeString(SAT_verbal);
        dest.writeString(expense_limit);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSAT_math() {
        return SAT_math;
    }

    public void setSAT_math(String SAT_math) {
        this.SAT_math = SAT_math;
    }

    public String getSAT_verbal() {
        return SAT_verbal;
    }

    public void setSAT_verbal(String SAT_verbal) {
        this.SAT_verbal = SAT_verbal;
    }

    public String getExpense_limit() {
        return expense_limit;
    }

    public void setExpense_limit(String expense_limit) {
        this.expense_limit = expense_limit;
    }


}
