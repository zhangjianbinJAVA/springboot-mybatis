package com.myke.mybatis.service;

import com.github.pagehelper.Page;
import com.myke.mybatis.model.Person;

import java.util.LinkedHashMap;
import java.util.List;

public interface PersonService {

    List<Person> findAllOne();

    List<Person> findAllTwo();

    /**
     * 分页查询
     *
     * @param pageNo   页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<Person> findByPage(int pageNo, int pageSize);

    List<LinkedHashMap<String, Object>> exeSql(String sql);

}