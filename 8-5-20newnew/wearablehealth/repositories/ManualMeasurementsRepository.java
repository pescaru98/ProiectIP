package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.ManualMeasurements;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface ManualMeasurementsRepository {

    @Select("SELECT * from MANUAL_MEASUREMENTS")
    List<ManualMeasurements> getAll();

    @Select("SELECT * from MANUAL_MEASUREMENTS where manual_measurement_id = #{id}")
    Optional<ManualMeasurements> getOne(@Param("id") int id);

    @Delete("DELETE from MANUAL_MEASUREMENTS WHERE manual_measurements_id = #{id}")
    void delete(@Param("id") int id);

    @Insert({"insert into MANUAL_MEASUREMENTS (MANUAL_MEASUREMENT_ID,USERNAME,MEASURE_DATE,TEMPERATURE,WEIGHT) values(" +
            "#{manualMeasurements.manual_measurement_id, jdbcType=INTEGER}," +
            "#{manualMeasurements.username, jdbcType=VARCHAR}," +
            "#{manualMeasurements.measure_date}," +
            "#{manualMeasurements.temperature, jdbcType=DOUBLE}," +
            "#{manualMeasurements.weight, jdbcType=DOUBLE})"})
    @Options(useGeneratedKeys = true,keyProperty = "manual_measurement_id")
    void insert(@Param("manualMeasurements") ManualMeasurements manualMeasurements);

    @Update({"UPDATE MANUAL_MEASUREMENTS SET " +
            "MEASURE_DATE = #{manualMeasurements.measure_date}," +
            "TEMPERATURE = #{manualMeasurements.temperature,jdbcType=DOUBLE}," +
            "WEIGHT = #{manualMeasurements.weight,jdbcType=DOUBLE}" +
            "WHERE MANUAL_MEASUREMENT_ID = #{manualMeasurements.manual_measurement_id, jdbcType=INTEGER}"})
    void update(@Param("manualMeasurements") ManualMeasurements manualMeasurements);

    @Select("SELECT * FROM MANUAL_MEASUREMENTS WHERE username = #{id}")
    List<ManualMeasurements> getAllOf(@Param("id") String id);
}
