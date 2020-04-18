package com.example.seersandroid.data.LocalDB;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class StudentLocal implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    public int userId;

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

    public StudentLocal(){}

    protected StudentLocal(Parcel in) {
        this.userId = in.readInt();
        this.userName = in.readString();
        this.password = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.SAT_math = in.readString();
        this.SAT_verbal = in.readString();
        this.expense_limit = in.readString();
    }

    public static final Creator<StudentLocal> CREATOR = new Creator<StudentLocal>() {
        @Override
        public StudentLocal createFromParcel(Parcel in) {
            return new StudentLocal(in);
        }

        @Override
        public StudentLocal[] newArray(int size) {
            return new StudentLocal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(SAT_math);
        dest.writeString(SAT_verbal);
        dest.writeString(expense_limit);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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