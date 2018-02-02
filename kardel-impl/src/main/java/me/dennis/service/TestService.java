package me.dennis.service;

import org.springframework.stereotype.Service;

/**
 * Created by Dennis on 2018/2/2.
 */
@Service
public class TestService implements ITestService{

    @Override
    public String getById(Integer id) {

        return "hzx";
    }
}
