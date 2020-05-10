package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Admins;
import com.wearablehealth.wearablehealth.entities.Alerts;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface AlertsRepository {

    @Select("SELECT * from ALERTS")
    List<Alerts> getAll();

    @Select("SELECT * from ALERTS where alert_id = #{id}")
    Optional<Alerts> getOne(@Param("id") int id);

    @Delete("DELETE from ALERTS WHERE alert_id = #{id}")
    void delete(@Param("id") int id);

    @Insert({"insert into ALERTS (ALERT_ID,USERNAME,START_DATE,END_DATE,COMMENTS) values(" +
            "#{alerts.alert_id, jdbcType=INTEGER}," +
            "#{alerts.username, jdbcType=VARCHAR}," +
            "#{alerts.start_date}," +
            "#{alerts.end_date}," +
            "#{alerts.comments, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "alert_id")
    void insert(@Param("alerts") Alerts alerts);

    @Update({"UPDATE ALERTS SET " +
            "START_DATE = #{alerts.start_date}," +
            "END_DATE = #{alerts.end_date}," +
            "COMMENTS = #{alerts.comments,jdbcType=VARCHAR}" +
            "WHERE ALERT_ID = #{alerts.alert_id,jdbcType=INTEGER}"})
    void update(@Param("alerts") Alerts alerts);

    @Select("SELECT * FROM ALERTS WHERE username = #{id}")
    List<Alerts> getAllOf(@Param("id") String id);
}
