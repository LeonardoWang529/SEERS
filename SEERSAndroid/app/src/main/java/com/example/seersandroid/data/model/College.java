package com.example.seersandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class College {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String collegeId;

    @SerializedName("name")
    public String collegeName;

    @SerializedName("lon")
    public String lon;

    @SerializedName("lat")
    public String lat;

    @SerializedName("state")
    public String state;

    @SerializedName("control")
    public String control;

    @SerializedName("urbanization")
    public String urbanization;

    @SerializedName("religious_affiliation")
    public String religious_affiliation;

    @SerializedName("offers_associate_degree")
    public String offers_associate_degree;

    @SerializedName("offers_bachelor_degree")
    public String offers_bachelor_degree;

    @SerializedName("offers_master_degree")
    public String offers_master_degree;

    @SerializedName("offers_doctor_degree_research_scholarship")
    public String offers_doctor_degree_research_scholarship;

    @SerializedName("offers_doctor_degree_professional_practice")
    public String offers_doctor_degree_professional_practice;

    @SerializedName("tuition_and_fees")
    public String tuition_and_fees;

    @SerializedName("applicants_total")
    public String applicants_total;

    @SerializedName("admissions_total")
    public String admissions_total;

    @SerializedName("enrolled_total")
    public String enrolled_total;

    @SerializedName("percent_admitted_total")
    public String percent_admitted_total;

    @SerializedName("total_enrollment")
    public String total_enrollment;

    @SerializedName("undergraduate_total_enrollment")
    public String undergraduate_total_enrollment;

    @SerializedName("graduate_total_enrollment")
    public String graduate_total_enrollment;

    @SerializedName("sat_reading_25th_percentile_score")
    public String sat_reading_25th_percentile_score;

    @SerializedName("sat_reading_75th_percentile_score")
    public String sat_reading_75th_percentile_score;

    @SerializedName("sat_math_25th_percentile_score")
    public String sat_math_25th_percentile_score;

    @SerializedName("sat_math_75th_percentile_score")
    public String sat_math_75th_percentile_score;

    @SerializedName("sat_writing_25th_percentile_score")
    public String sat_writing_25th_percentile_score;

    @SerializedName("sat_writing_75th_percentile_score")
    public String sat_writing_75th_percentile_score;
    @SerializedName("act_25th_percentile_score")
    public String act_25th_percentile_score;

    @SerializedName("act_75th_percentile_score")
    public String act_75th_percentile_score;

    @NonNull
    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(@NonNull String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public String getReligious_affiliation() {
        return religious_affiliation;
    }

    public void setReligious_affiliation(String religious_affiliation) {
        this.religious_affiliation = religious_affiliation;
    }

    public String getOffers_associate_degree() {
        return offers_associate_degree;
    }

    public void setOffers_associate_degree(String offers_associate_degree) {
        this.offers_associate_degree = offers_associate_degree;
    }

    public String getOffers_bachelor_degree() {
        return offers_bachelor_degree;
    }

    public void setOffers_bachelor_degree(String offers_bachelor_degree) {
        this.offers_bachelor_degree = offers_bachelor_degree;
    }

    public String getOffers_master_degree() {
        return offers_master_degree;
    }

    public void setOffers_master_degree(String offers_master_degree) {
        this.offers_master_degree = offers_master_degree;
    }

    public String getOffers_doctor_degree_research_scholarship() {
        return offers_doctor_degree_research_scholarship;
    }

    public void setOffers_doctor_degree_research_scholarship(String offers_doctor_degree_research_scholarship) {
        this.offers_doctor_degree_research_scholarship = offers_doctor_degree_research_scholarship;
    }

    public String getOffers_doctor_degree_professional_practice() {
        return offers_doctor_degree_professional_practice;
    }

    public void setOffers_doctor_degree_professional_practice(String offers_doctor_degree_professional_practice) {
        this.offers_doctor_degree_professional_practice = offers_doctor_degree_professional_practice;
    }

    public String getTuition_and_fees() {
        return tuition_and_fees;
    }

    public void setTuition_and_fees(String tuition_and_fees) {
        this.tuition_and_fees = tuition_and_fees;
    }

    public String getApplicants_total() {
        return applicants_total;
    }

    public void setApplicants_total(String applicants_total) {
        this.applicants_total = applicants_total;
    }

    public String getAdmissions_total() {
        return admissions_total;
    }

    public void setAdmissions_total(String admissions_total) {
        this.admissions_total = admissions_total;
    }

    public String getEnrolled_total() {
        return enrolled_total;
    }

    public void setEnrolled_total(String enrolled_total) {
        this.enrolled_total = enrolled_total;
    }

    public String getPercent_admitted_total() {
        return percent_admitted_total;
    }

    public void setPercent_admitted_total(String percent_admitted_total) {
        this.percent_admitted_total = percent_admitted_total;
    }

    public String getTotal_enrollment() {
        return total_enrollment;
    }

    public void setTotal_enrollment(String total_enrollment) {
        this.total_enrollment = total_enrollment;
    }

    public String getUndergraduate_total_enrollment() {
        return undergraduate_total_enrollment;
    }

    public void setUndergraduate_total_enrollment(String undergraduate_total_enrollment) {
        this.undergraduate_total_enrollment = undergraduate_total_enrollment;
    }

    public String getGraduate_total_enrollment() {
        return graduate_total_enrollment;
    }

    public void setGraduate_total_enrollment(String graduate_total_enrollment) {
        this.graduate_total_enrollment = graduate_total_enrollment;
    }

    public String getSat_reading_25th_percentile_score() {
        return sat_reading_25th_percentile_score;
    }

    public void setSat_reading_25th_percentile_score(String sat_reading_25th_percentile_score) {
        this.sat_reading_25th_percentile_score = sat_reading_25th_percentile_score;
    }

    public String getSat_reading_75th_percentile_score() {
        return sat_reading_75th_percentile_score;
    }

    public void setSat_reading_75th_percentile_score(String sat_reading_75th_percentile_score) {
        this.sat_reading_75th_percentile_score = sat_reading_75th_percentile_score;
    }

    public String getSat_math_25th_percentile_score() {
        return sat_math_25th_percentile_score;
    }

    public void setSat_math_25th_percentile_score(String sat_math_25th_percentile_score) {
        this.sat_math_25th_percentile_score = sat_math_25th_percentile_score;
    }

    public String getSat_math_75th_percentile_score() {
        return sat_math_75th_percentile_score;
    }

    public void setSat_math_75th_percentile_score(String sat_math_75th_percentile_score) {
        this.sat_math_75th_percentile_score = sat_math_75th_percentile_score;
    }

    public String getSat_writing_25th_percentile_score() {
        return sat_writing_25th_percentile_score;
    }

    public void setSat_writing_25th_percentile_score(String sat_writing_25th_percentile_score) {
        this.sat_writing_25th_percentile_score = sat_writing_25th_percentile_score;
    }

    public String getSat_writing_75th_percentile_score() {
        return sat_writing_75th_percentile_score;
    }

    public void setSat_writing_75th_percentile_score(String sat_writing_75th_percentile_score) {
        this.sat_writing_75th_percentile_score = sat_writing_75th_percentile_score;
    }

    public String getAct_25th_percentile_score() {
        return act_25th_percentile_score;
    }

    public void setAct_25th_percentile_score(String act_25th_percentile_score) {
        this.act_25th_percentile_score = act_25th_percentile_score;
    }

    public String getAct_75th_percentile_score() {
        return act_75th_percentile_score;
    }

    public void setAct_75th_percentile_score(String act_75th_percentile_score) {
        this.act_75th_percentile_score = act_75th_percentile_score;
    }
}
