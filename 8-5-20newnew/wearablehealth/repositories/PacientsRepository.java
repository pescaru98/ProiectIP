package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Pacients;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface PacientsRepository {

    @Select("SELECT * from PACIENTS")
    List<Pacients> getAll();

    @Select("SELECT * from PACIENTS where username = #{id}")
    Optional<Pacients> getOne(@Param("id") String id);

    @Delete("DELETE from PACIENTS WHERE username = #{id}")
    void delete(@Param("id") String id);

    @Insert({"insert into PACIENTS (USERNAME,NAME,SURNAME,AGE,CNP,COUNTRY,COUNTY,CITY,STREET,PHONE,EMAIL,JOB) values(" +
            "#{pacients.username, jdbcType=VARCHAR}," +
            "#{pacients.name, jdbcType=VARCHAR}," +
            "#{pacients.surname, jdbcType=VARCHAR}," +
            "#{pacients.age, jdbcType=INTEGER}," +
            "#{pacients.cnp, jdbcType=VARCHAR}," +
            "#{pacients.country, jdbcType=VARCHAR}," +
            "#{pacients.county, jdbcType=VARCHAR}," +
            "#{pacients.city, jdbcType=VARCHAR}," +
            "#{pacients.street, jdbcType=VARCHAR}," +
            "#{pacients.phone, jdbcType=VARCHAR}," +
            "#{pacients.email, jdbcType=VARCHAR}," +
            "#{pacients.job, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "username")
    void insert(@Param("pacients") Pacients pacients);

    @Update({"UPDATE PACIENTS SET " +
            "NAME = #{pacients.name,jdbcType=VARCHAR}," +
            "SURNAME = #{pacients.surname,jdbcType=VARCHAR}," +
            "AGE = #{pacients.age,jdbcType=INTEGER}," +
            "CNP = #{pacients.cnp,jdbcType=VARCHAR}," +
            "COUNTRY = #{pacients.country,jdbcType=VARCHAR}," +
            "COUNTY = #{pacients.county,jdbcType=VARCHAR}," +
            "CITY = #{pacients.city,jdbcType=VARCHAR}," +
            "STREET = #{pacients.street,jdbcType=VARCHAR}," +
            "PHONE = #{pacients.phone,jdbcType=VARCHAR}," +
            "EMAIL = #{pacients.email,jdbcType=VARCHAR}," +
            "PHONE = #{pacients.job,jdbcType=VARCHAR}" +
            "WHERE USERNAME=#{pacients.username, jdbcType=VARCHAR}"})
    void update(@Param("pacients") Pacients pacients);

    @Select("SELECT DOCTOR_ID FROM MAP_PACIENT_TO_DOC WHERE PACIENT_ID = #{id}")
    List<String> getAllDoctorsOf(@Param("id") String id);

}
