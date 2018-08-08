package com.myke.mybatis.mapper;

import com.github.pagehelper.Page;
import com.myke.mybatis.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper//声明成mybatis Dao层的Bean，也可以在配置类上使用@MapperScan("*.mapper")注解声明
public interface PersonMapper {

    /**
     * 获取所有数据
     *
     * @return
     */
    @Select("SELECT * from person")
    List<Person> findAllOne();

    @Select("SELECT * from person")
    List<Person> findAllTwo();

    @Select("select * from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<Map> listTable();

    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<Map> listTableColumn(String tableName);

    Page<Person> findByPage();


    @Select("${value}")
    @ResultType(Map.class)
    List<LinkedHashMap<String, Object>> exeSql(String sql);

}