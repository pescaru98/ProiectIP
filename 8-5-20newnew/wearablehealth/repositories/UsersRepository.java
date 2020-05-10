package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.entities.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface UsersRepository {

    @Select("SELECT * from USERS")
    List<Users> getAllUsers();

    @Select("SELECT * from USERS where username = #{id}")
    Optional<Users> getUserById(@Param("id") String id);

    @Select("SELECT * FROM USERS WHERE username=#{users.username} AND password = #{users.password}")
    Optional<Users> checkCredentials(@Param("users") Users users);

    @Insert({"insert into USERS (USERNAME,PASSWORD,ACTIVE_ID,ROLE_ID) values(" +
            "#{users.username, jdbcType=VARCHAR}," +
            "#{users.password, jdbcType=VARCHAR}," +
            "#{users.active_id, jdbcType=INTEGER}," +
            "#{users.role_id, jdbcType=INTEGER})"})
    @Options(useGeneratedKeys = true,keyProperty = "username")
    void insert(@Param("users") Users users);

    @Update({"UPDATE USERS SET " +
            "PASSWORD = #{users.name,jdbcType=VARCHAR}," +
            "ACTIVE_ID = #{users.surname,jdbcType=INTEGER}," +
            "ROLE_ID = #{users.email,jdbcType=INTEGER}" +
            "WHERE USERNAME=#{users.username, jdbcType=VARCHAR}"})
    void update(@Param("users") Users users);
}
