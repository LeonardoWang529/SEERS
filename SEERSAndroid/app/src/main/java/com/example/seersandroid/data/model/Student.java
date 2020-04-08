package com.example.seersandroid.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class Student {

    private String userId;
    private String userName;
    private String password;
    private String name;
    private String gender;
    private String SAT_math;
    private String SAT_verbal;
    private String expense_limit;

    public Student(String userId, String userName, String password, String name,
                   String gender, String SAT_math, String SAT_verbal, String expense_limit) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.SAT_math = SAT_math;
        this.SAT_verbal = SAT_verbal;
        this.expense_limit = expense_limit;
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
