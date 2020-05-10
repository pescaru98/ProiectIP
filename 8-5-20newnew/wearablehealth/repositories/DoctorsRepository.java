package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Doctors;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface DoctorsRepository {
    @Select("SELECT * from DOCTORS")
    List<Doctors> getAll();

    @Select("SELECT * from DOCTORS where username = #{id}")
    Optional<Doctors> getOne(@Param("id") String id);

    @Delete("DELETE from DOCTORS WHERE username = #{id}")
    void delete(@Param("id") String id);

    @Insert({"insert into DOCTORS (USERNAME,NAME,SURNAME,PHONE,ADDRESS,EMAIL) values(" +
            "#{doctors.username, jdbcType=VARCHAR}," +
            "#{doctors.name, jdbcType=VARCHAR}," +
            "#{doctors.surname, jdbcType=VARCHAR}," +
            "#{doctors.phone, jdbcType=VARCHAR}," +
            "#{doctors.address, jdbcType=VARCHAR}," +
            "#{doctors.email, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "username")
    void insert(@Param("doctors") Doctors doctors);

    @Update({"UPDATE DOCTORS SET " +
            "NAME = #{doctors.name,jdbcType=VARCHAR}," +
            "SURNAME = #{doctors.surname,jdbcType=VARCHAR}," +
            "PHONE = #{doctors.phone,jdbcType=VARCHAR}," +
            "ADDRESS = #{doctors.address,jdbcType=VARCHAR}," +
            "EMAIL = #{doctors.email,jdbcType=VARCHAR}" +
            "WHERE USERNAME = #{doctors.username, jdbcType=VARCHAR}"})
    void update(@Param("doctors") Doctors doctors);

    @Select("SELECT PACIENT_ID FROM MAP_PACIENT_TO_DOC WHERE DOCTOR_ID = #{id}")
    List<String> getAllPacientsOf(@Param("id") String id);
}
