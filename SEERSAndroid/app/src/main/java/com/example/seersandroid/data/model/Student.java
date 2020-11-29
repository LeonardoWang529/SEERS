package com.example.seersandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public final class Student {
    @Ignore
    private static final long STALE_MS = 5 * 60 * 1000; // Data is stale after 5 minutes

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("userId")
    @Expose
    private String userId;

    @ColumnInfo(name = "email")
    @SerializedName("email")
    public String userName;

    @ColumnInfo(name = "password")
    @SerializedName("password")
    public String password;

    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    public String firstName;

    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    public String lastName;

    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    public String gender;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    public String status;

    @ColumnInfo(name = "schoolName")
    @SerializedName("schoolName")
    public String schoolName;

    @ColumnInfo(name = "currentId")
    @SerializedName("currentId")
    public String currentId;

    @ColumnInfo(name = "age")
    @SerializedName("age")
    public int age;

    @ColumnInfo(name = "gpa")
    @SerializedName("gpa")
    public double gpa;

    @ColumnInfo(name = "act")
    @SerializedName("act")
    public int act;

    @ColumnInfo(name = "sat_math")
    @SerializedName("sat_math")
    public int SAT_math;

    @ColumnInfo(name = "sat_reading")
    @SerializedName("sat_reading")
    public int sat_reading;

    @ColumnInfo(name = "expense_limit")
    @SerializedName("expense_limit")
    public int expense_limit;

    @ColumnInfo(name = "sat_writing")
    @SerializedName("sat_writing")
    public int sat_writing;

    @ColumnInfo(name = "token")
    @SerializedName("token")
    public String token;

    private Long timeStamp;

    private Long timeStampAdded;

    public Student(){}


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStampAdded < STALE_MS;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getTimeStampAdded() {
        return timeStampAdded;
    }

    public void setTimeStampAdded(Long timeStampAdded) {
        this.timeStampAdded = timeStampAdded;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public static long getStaleMs() {
        return STALE_MS;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public int getSAT_math() {
        return SAT_math;
    }

    public void setSAT_math(int SAT_math) {
        this.SAT_math = SAT_math;
    }

    public int getSat_reading() {
        return sat_reading;
    }

    public void setSat_reading(int sat_reading) {
        this.sat_reading = sat_reading;
    }

    public int getExpense_limit() {
        return expense_limit;
    }

    public void setExpense_limit(int expense_limit) {
        this.expense_limit = expense_limit;
    }

    public int getSat_writing() {
        return sat_writing;
    }

    public void setSat_writing(int sat_writing) {
        this.sat_writing = sat_writing;
    }

    public String getToken() {
        return token;
    }
}
