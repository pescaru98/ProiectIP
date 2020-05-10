package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Admins;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface AdminsRepository {

    @Select("SELECT * from ADMINS")
    List<Admins> getAll();

    @Select("SELECT * from ADMINS where username = #{id}")
    Optional<Admins> getOne(@Param("id") String id);

    @Delete("DELETE from ADMINS WHERE username = #{id}")
    void delete(@Param("id") String id);

    @Insert({"insert into ADMINS (USERNAME,NAME,SURNAME,PHONE,EMAIL) values(" +
            "#{admins.username, jdbcType=VARCHAR}," +
            "#{admins.name, jdbcType=VARCHAR}," +
            "#{admins.surname, jdbcType=VARCHAR}," +
            "#{admins.phone, jdbcType=VARCHAR}," +
            "#{admins.email, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "username")
    void insert(@Param("admins") Admins admins);

    @Update({"UPDATE ADMINS SET " +
            "NAME = #{admins.name,jdbcType=VARCHAR}," +
            "SURNAME = #{admins.surname,jdbcType=VARCHAR}," +
            "PHONE = #{admins.phone,jdbcType=VARCHAR}," +
            "EMAIL = #{admins.email,jdbcType=VARCHAR}" +
            "WHERE USERNAME = #{admins.username,jdbcType=VARCHAR}"})
    void update(@Param("admins") Admins admins);

}
