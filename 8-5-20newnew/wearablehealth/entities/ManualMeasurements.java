package com.wearablehealth.wearablehealth.entities;

import java.util.Date;

public class ManualMeasurements {
    private int manual_measurement_id;
    private String username;
    private Date measure_date;
    private double temperature;
    private double weight;

    public int getManual_measurement_id() {
        return manual_measurement_id;
    }

    public void setManual_measurement_id(int manual_measurement_id) {
        this.manual_measurement_id = manual_measurement_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getMeasure_date() {
        return measure_date;
    }

    public void setMeasure_date(Date measure_date) {
        this.measure_date = measure_date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
