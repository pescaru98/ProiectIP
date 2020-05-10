package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.SensorMeasurements;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface SensorMeasurementsRepository {

    @Insert({"insert into SENSOR_MEASUREMENTS (USERNAME,MEASURE_DATE,TEMPERATURE,PULSE,HUMIDITY,EKG) values(" +
            "#{sensorMeasurements.username, jdbcType=VARCHAR}," +
            "#{sensorMeasurements.measure_date}," +
            "#{sensorMeasurements.temperature,jdbcType=DOUBLE}," +
            "#{sensorMeasurements.pulse,jdbcType=INTEGER}," +
            "#{sensorMeasurements.humidity,jdbcType=DOUBLE}," +
            "#{sensorMeasurements.ekg,jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "sensor_measurement_id")
    void insert(@Param("sensorMeasurements") SensorMeasurements sensorMeasurements);

    @Select("SELECT * FROM SENSOR_MEASUREMENTS WHERE USERNAME = #{id} ORDER BY MEASURE_DATE DESC LIMIT 1")
    Optional<SensorMeasurements> getLatestOf(@Param("id") String id);

    @Select("SELECT * FROM SENSOR_MEASUREMENTS WHERE USERNAME = #{id}")
    List<SensorMeasurements> getAllOf(@Param("id") String id);
}
