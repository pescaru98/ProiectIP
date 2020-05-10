package com.wearablehealth.wearablehealth.entities;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SensorMeasurements {
    private int sensor_measurement_id;
    private String username;
    private Date measure_date;
    private double temperature;
    private int pulse;
    private double humidity;
    private String ekg;

    public int getSensor_measurement_id() {
        return sensor_measurement_id;
    }

    public void setSensor_measurement_id(int sensor_measurement_id) {
        this.sensor_measurement_id = sensor_measurement_id;
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

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getEkg() {
        return ekg;
    }

    public void setEkg(String ekg) {
        this.ekg = ekg;
    }


}
