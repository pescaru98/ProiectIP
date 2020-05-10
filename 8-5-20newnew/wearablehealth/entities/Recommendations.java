package com.wearablehealth.wearablehealth.entities;

import java.util.Date;

public class Recommendations {
    private int recommendation_id;
    private String username;
    private Date start_date;
    private Date end_date;
    private int recommend_id;
    private String comments;

    public int getRecommendation_id() {
        return recommendation_id;
    }

    public void setRecommendation_id(int recommendation_id) {
        this.recommendation_id = recommendation_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getRecommend_id() {
        return recommend_id;
    }

    public void setRecommend_id(int recommend_id) {
        this.recommend_id = recommend_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
