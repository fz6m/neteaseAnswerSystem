package com.fz6m.answer.fz6m.mapper;

import com.fz6m.answer.fz6m.entities.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User getUser(Integer id);

    @Insert("insert into token VALUES(#{id},#{token})")
    int setToken(Integer id, String token);

    @Update("update user set count=#{count} ,answering_id=#{answeringId}," +
            " max=#{max} ,start=#{start} ,end=#{end}, individual_topics=#{individualTopics} " +
            " where id=#{id}")
    int setUser(User user);

    @Select("select * from answer where id=#{id} and user_id=#{userId}")
    Topic getTopic(Integer id, Integer userId);

    @Update("update answer set answer=#{answer} where id=#{id} and user_id=#{userId}")
    int setTopic(Integer id, Integer userId, Integer answer);

    @Select("select * from answer where user_id=#{userId}")
    List<Wrong> getAllUserAnswer(Integer userId);

    @Select("select * from token where 1=1")
    List<UserShort> getAllLoginUser();

}
