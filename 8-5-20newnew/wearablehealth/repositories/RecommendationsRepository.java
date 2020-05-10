package com.wearablehealth.wearablehealth.repositories;

import com.wearablehealth.wearablehealth.entities.Recommendations;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface RecommendationsRepository {

    @Select("SELECT * from RECOMMENDATIONS")
    List<Recommendations> getAll();

    @Select("SELECT * from RECOMMENDATIONS where recommendation_id = #{id}")
    Optional<Recommendations> getOne(@Param("id") int id);

    @Delete("DELETE from RECOMMENDATIONS WHERE recommendation_id = #{id}")
    void delete(@Param("id") int id);

    @Insert({"insert into RECOMMENDATIONS (RECOMMENDATION_ID,USERNAME,START_DATE,END_DATE,RECOMMEND_ID,COMMENTS) values(" +
            "#{recommendations.recommendation_id, jdbcType=INTEGER}," +
            "#{recommendations.username, jdbcType=VARCHAR}," +
            "#{recommendations.start_date}," +
            "#{recommendations.end_date}," +
            "#{recommendations.recommend_id, jdbcType=INTEGER}," +
            "#{recommendations.comments, jdbcType=VARCHAR})"})
    @Options(useGeneratedKeys = true,keyProperty = "username")
    void insert(@Param("recommendations") Recommendations recommendations);

    @Update({"UPDATE RECOMMENDATIONS SET " +
            "START_DATE = #{recommendations.start_date}," +
            "END_DATE = #{recommendations.end_date}," +
            "RECOMMEND_ID = #{recommendations.recommend_id,jdbcType=INTEGER}," +
            "COMMENTS = #{recommendations.comments,jdbcType=VARCHAR}" +
            "WHERE RECOMMENDATION_ID=#{recommendations.recommendation_id, jdbcType=INTEGER}"})
    void update(@Param("recommendations") Recommendations recommendations);

    @Select("SELECT * FROM RECOMMENDATIONS WHERE username = #{id}")
    List<Recommendations> getAllOf(@Param("id") String id);

}
