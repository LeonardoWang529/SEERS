package com.example.seersandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class College implements Parcelable {
    String name;
    String state;
    String control;
    String location;
    String percent_admittance;
    String no_applicats;
    String sat_vabal;
    String sat_math;
    String expresses;
    String percent_financial_aid;
    String male_female_ratio;
    String academics_scale;
    String social_scale;
    String quality_of_life_scale;


    protected College(Parcel in) {
        name = in.readString();
        state = in.readString();
        control = in.readString();
        location = in.readString();
        percent_admittance = in.readString();
        no_applicats = in.readString();
        sat_vabal = in.readString();
        sat_math = in.readString();
        expresses = in.readString();
        percent_financial_aid = in.readString();
        male_female_ratio = in.readString();
        academics_scale = in.readString();
        social_scale = in.readString();
        quality_of_life_scale = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(control);
        dest.writeString(location);
        dest.writeString(percent_admittance);
        dest.writeString(no_applicats);
        dest.writeString(sat_vabal);
        dest.writeString(sat_math);
        dest.writeString(expresses);
        dest.writeString(percent_financial_aid);
        dest.writeString(male_female_ratio);
        dest.writeString(academics_scale);
        dest.writeString(social_scale);
        dest.writeString(quality_of_life_scale);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<College> CREATOR = new Creator<College>() {
        @Override
        public College createFromParcel(Parcel in) {
            return new College(in);
        }

        @Override
        public College[] newArray(int size) {
            return new College[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPercent_admittance() {
        return percent_admittance;
    }

    public void setPercent_admittance(String percent_admittance) {
        this.percent_admittance = percent_admittance;
    }

    public String getNo_applicats() {
        return no_applicats;
    }

    public void setNo_applicats(String no_applicats) {
        this.no_applicats = no_applicats;
    }

    public String getSat_vabal() {
        return sat_vabal;
    }

    public void setSat_vabal(String sat_vabal) {
        this.sat_vabal = sat_vabal;
    }

    public String getSat_math() {
        return sat_math;
    }

    public void setSat_math(String sat_math) {
        this.sat_math = sat_math;
    }

    public String getExpresses() {
        return expresses;
    }

    public void setExpresses(String expresses) {
        this.expresses = expresses;
    }

    public String getPercent_financial_aid() {
        return percent_financial_aid;
    }

    public void setPercent_financial_aid(String percent_financial_aid) {
        this.percent_financial_aid = percent_financial_aid;
    }

    public String getMale_female_ratio() {
        return male_female_ratio;
    }

    public void setMale_female_ratio(String male_female_ratio) {
        this.male_female_ratio = male_female_ratio;
    }

    public String getAcademics_scale() {
        return academics_scale;
    }

    public void setAcademics_scale(String academics_scale) {
        this.academics_scale = academics_scale;
    }

    public String getSocial_scale() {
        return social_scale;
    }

    public void setSocial_scale(String social_scale) {
        this.social_scale = social_scale;
    }

    public String getQuality_of_life_scale() {
        return quality_of_life_scale;
    }

    public void setQuality_of_life_scale(String quality_of_life_scale) {
        this.quality_of_life_scale = quality_of_life_scale;
    }
}
