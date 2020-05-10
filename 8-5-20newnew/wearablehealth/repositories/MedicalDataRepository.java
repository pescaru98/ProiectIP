package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.MedicalData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface MedicalDataRepository {

    @Select("SELECT * from MEDICAL_DATA")
    List<MedicalData> getAll();

    @Select("SELECT * from MEDICAL_DATA where medical_data_id = #{id}")
    Optional<MedicalData> getOne(@Param("id") int id);

    @Delete("DELETE from MEDICAL_DATA WHERE medical_data_id = #{id}")
    void delete(@Param("id") int id);

    @Insert({"insert into MEDICAL_DATA (MEDICAL_DATA_ID,USERNAME,MEDICAL_HISTORY,ALLERGY,CARDIO_CONSULTATION) values(" +
            "#{medicalData.medical_data_id, jdbcType=INTEGER}," +
            "#{medicalData.username, jdbcType=VARCHAR}," +
            "#{medicalData.medical_history, jdbcType=VARCHAR}," +
            "#{medicalData.allergy, jdbcType=VARCHAR}," +
            "#{medicalData.cardio_consultation, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "medical_data_id")
    void insert(@Param("medicalData") MedicalData medicalData);

    @Update({"UPDATE MEDICAL_DATA SET " +
            "MEDICAL_HISTORY = #{medicalData.medical_history,jdbcType=VARCHAR}," +
            "ALLERGY = #{medicalData.allergy,jdbcType=VARCHAR}," +
            "CARDIO_CONSULTATION = #{medicalData.cardio_consultation,jdbcType=VARCHAR}" +
            "WHERE MEDICAL_DATA_ID=#{medicalData.medical_data_id, jdbcType=INTEGER}"})
    void update(@Param("medicalData") MedicalData medicalData);

    @Select("SELECT * FROM MEDICAL_DATA WHERE username = #{id}")
    List<MedicalData> getAllOf(@Param("id") String id);
}
