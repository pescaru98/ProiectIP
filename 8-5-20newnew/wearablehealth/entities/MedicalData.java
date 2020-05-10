package com.wearablehealth.wearablehealth.entities;

public class MedicalData {
    private int medical_data_id;
    private String username;
    private String medical_history;
    private String allergy;
    private String cardio_consultation;

    public int getMedical_data_id() {
        return medical_data_id;
    }

    public void setMedical_data_id(int medical_data_id) {
        this.medical_data_id = medical_data_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getCardio_consultation() {
        return cardio_consultation;
    }

    public void setCardio_consultation(String cardio_consultation) {
        this.cardio_consultation = cardio_consultation;
    }
}
