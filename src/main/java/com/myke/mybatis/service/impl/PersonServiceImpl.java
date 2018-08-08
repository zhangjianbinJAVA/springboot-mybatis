package com.myke.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myke.mybatis.mapper.PersonMapper;
import com.myke.mybatis.model.Person;
import com.myke.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service("PersonServiceImpl")
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> findAllOne() {
        return personMapper.findAllOne();
    }

    @Override
    public List<Person> findAllTwo() {
        return personMapper.findAllTwo();
    }


    @Override
    public Page<Person> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return personMapper.findByPage();
    }

    @Override
    public List<LinkedHashMap<String, Object>> exeSql(String sql) {
        return personMapper.exeSql(sql);
    }
}