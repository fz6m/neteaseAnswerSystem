package com.fz6m.answer.fz6m.service;

import com.fz6m.answer.fz6m.entities.*;
import com.fz6m.answer.fz6m.mapper.UserMapper;
import com.fz6m.answer.fz6m.utils.Token;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {


    @Autowired
    Token tokenUtils;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public TokenResponse login(Integer id) {

        TokenResponse tokenResponse = new TokenResponse();
        User user = userMapper.getUser(id);
        if (user == null) {
            tokenResponse.setCode(400);
        }
        else {
            if (user.getEnd() == 1) {
                tokenResponse.setCode(600);
            }
            else {
                    // Do the first time
                    user.setStart(1);
                    Map<String,Object> params = new HashMap<>();
                    params.put("id",user.getId());
                    String token = tokenUtils.creatToken(params);
                    // Save
                    userMapper.setToken(user.getId(), token);
                    // Update user
                    userMapper.setUser(user);
                    tokenResponse.setCode(200);
                    tokenResponse.setToken(token);
                }
        }
        return tokenResponse;
    }

    @Transactional
    public TokenResponse token(String token) {
        TokenResponse tokenResponse = new TokenResponse();
        Object object = tokenUtils.parseToken(token);
        if(object instanceof Claims) {
            Integer userId = (Integer) (((Claims) object).get("id"));
            User user = userMapper.getUser(userId);
            if(user.getCount() == 0) {
                // First answer
                tokenResponse.setCode(200);
            }
            else {
                tokenResponse.setCode(2000);
            }
            tokenResponse.setToken(userId.toString());
        }
        else {
            tokenResponse.setCode(400);
        }
        return tokenResponse;
    }

    @Transactional
    public Subject answer(String token, Integer id, Integer answer) {
        Subject subject = new Subject();
        // Authentication token
        TokenResponse tokenResponse = token(token);
        if(tokenResponse.getCode() == 400) {
            subject.setCode(400);
        }
        else {
            Integer userId = Integer.valueOf(tokenResponse.getToken());
            User user = userMapper.getUser(userId);
            // Determine direct access server behavior
            if(user.getEnd() == 1) {
                subject.setCode(400);
            }
            else {
                if(tokenResponse.getCode() == 200) {
                    subject = new Subject(200, false, userId, 1, user.getMax());
                    this.assembly(subject, 1);
                    // save
                    user.setCount(1);
                    user.setAnsweringId(1);
                    userMapper.setUser(user);
                }
                else {
                    // Not the first time
                    // Verify cheating
                    if(user.getAnsweringId() == id) {
                        // Record answer
                        userMapper.setTopic(id, userId, answer);
                        // Whether done
                        Integer number = user.getCount() + 1;
                        if(number > user.getMax()) {
                            subject = new Subject(200, true, userId, user.getAnsweringId() , user.getMax());
                            // save
                            user.setEnd(1);
                            userMapper.setUser(user);
                        }
                        else {
                            subject = new Subject(200, false, userId, number , user.getMax());
                            this.assembly(subject, number);
                            // save
                            user.setAnsweringId(number);
                            user.setCount(number);
                            userMapper.setUser(user);
                        }
                    }
                    else {
                        subject = new Subject(200, false, userId, user.getAnsweringId() , user.getMax());
                        this.assembly(subject, user.getAnsweringId());
                    }
                }
            }

        }
        return subject;
    }

    @Transactional
    public void assembly(Subject subject, Integer id) {
        Topic topic = userMapper.getTopic(id, subject.getUserId());
        topic.setMax(subject.getMax());
        topic.setNumber(subject.getNumber());
        subject.setInfo(topic);
    }

    @Transactional
    public Map<String, Object> statisticalData(Integer id) {
        List<Wrong> all = userMapper.getAllUserAnswer(id);
        Map<String, Object> map = new HashMap<>();
        Integer correct = 0;
        Integer max = 0;
        List<Wrong> wrongs = new ArrayList<>();
        for(Wrong a : all){
            max++;
            if(a.getAnswer() != null) {
                if (a.getAnswer() == a.getRawAnswer()) {
                    correct++;
                } else {
                    wrongs.add(a);
                }
            }
        }
        map.put("correct", correct);
        map.put("max", max);
        map.put("wrongs", wrongs);
        return map;
    }

    @Transactional
    public List<Integer> getAllLoginUser() {
        List<UserShort> userShorts = userMapper.getAllLoginUser();
        List<Integer> list = new ArrayList<>();
        for(UserShort u : userShorts) {
            list.add(u.getId());
        }
        return list;
    }

    @Transactional
    public StataResponse stata(Integer id) {
        StataResponse stataResponse = new StataResponse();
        if(id == 0) {
            // First request
            stataResponse.setCode(200);
            stataResponse.setUsers(this.getAllLoginUser());
        }
        else {
            stataResponse.setCode(200);
            Map<String, Object> map = this.statisticalData(id);
            stataResponse.setCorrect((Integer) map.get("correct"));
            stataResponse.setMax((Integer) map.get("max"));
            stataResponse.setError((List<Wrong>) map.get("wrongs"));
            stataResponse.setUsers(this.getAllLoginUser());
        }
        return stataResponse;
    }

}


