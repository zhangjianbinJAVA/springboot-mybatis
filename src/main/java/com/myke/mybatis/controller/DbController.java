package com.myke.mybatis.controller;

import com.myke.mybatis.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author： zhangjianbin <br/>
 * ===============================
 * Created with IDEA.
 * Date： 2018/8/8
 * Time： 15:59
 * ================================
 */
@RestController
@RequestMapping("/db/")
public class DbController {

    @Resource(name = "PersonServiceImpl")
    private PersonService personService;

    /**
     * 执行前台传来的sql语句
     *
     * @param sql
     * @return
     */
    @PostMapping("/mysql")
    public List<LinkedHashMap<String, Object>> personList(@RequestBody String sql) {
        return personService.exeSql(sql);
    }

}
