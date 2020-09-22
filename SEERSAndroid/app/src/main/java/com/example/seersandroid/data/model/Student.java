package com.example.seersandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("code")
    @Expose
    private String userId;

    @ColumnInfo(name = "userName")
    public String userName;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "gender")
    public String gender;

    @ColumnInfo(name = "SAT_math")
    public String SAT_math;

    @ColumnInfo(name = "SAT_verbal")
    public String SAT_verbal;

    @ColumnInfo(name = "expense_limit")
    public String expense_limit;

    @SerializedName("time")
    @ColumnInfo(name = "time")
    @Expose
    private Long timeStamp;

    @ColumnInfo(name = "timeAdded")
    @Expose
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
}
