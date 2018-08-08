package com.myke.mybatis.controller;

import com.myke.mybatis.model.Person;
import com.myke.mybatis.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： zhangjianbin <br/>
 * ===============================
 * Created with IDEA.
 * Date： 2018/8/7
 * Time： 14:00
 * ================================
 */
@RestController
public class TwoController {

    @Resource(name = "PersonServiceAnnotationDSImpl")
    PersonService personService;

    @RequestMapping("/all-two")
    public List<Person> sort() {
        List<Person> people = personService.findAllTwo();
        return people;
    }
}
