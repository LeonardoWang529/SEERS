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
    public String age;

    @ColumnInfo(name = "gpa")
    @SerializedName("gpa")
    public String gpa;

    @ColumnInfo(name = "act")
    @SerializedName("act")
    public String act;

    @ColumnInfo(name = "sat_math")
    @SerializedName("sat_math")
    public String SAT_math;

    @ColumnInfo(name = "sat_reading")
    @SerializedName("sat_reading")
    public String sat_reading;

    @ColumnInfo(name = "expense_limit")
    @SerializedName("expense_limit")
    public String expense_limit;

    @ColumnInfo(name = "sat_writing")
    @SerializedName("sat_writing")
    public String sat_writing;

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

    public String getSAT_math() {
        return SAT_math;
    }

    public void setSAT_math(String SAT_math) {
        this.SAT_math = SAT_math;
    }

    public String getExpense_limit() {
        return expense_limit;
    }

    public void setExpense_limit(String expense_limit) {
        this.expense_limit = expense_limit;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getSat_reading() {
        return sat_reading;
    }

    public void setSat_reading(String sat_reading) {
        this.sat_reading = sat_reading;
    }

    public String getSat_writing() {
        return sat_writing;
    }

    public void setSat_writing(String sat_writing) {
        this.sat_writing = sat_writing;
    }

    public static long getStaleMs() {
        return STALE_MS;
    }

    public String getToken() {
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsIlJvbGVzIjpbIlN0dWRlbnQiXSwiZXhwIjoxNjA2MDg4NDQ1fQ.M9D5Y_7YocCRW9R6orUsOmOhTBPvFzi8oao0N_gHYpi3W9T7ZpWMOHNO4Jj3gEW3lYhNH2puzY5zp4UzRR6LoA";
    }

    public void setToken(String token) {
        this.token = token;
    }
}
