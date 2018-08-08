package com.myke.mybatis.controller;

import com.github.pagehelper.Page;
import com.myke.mybatis.model.Person;
import com.myke.mybatis.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
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
public class OneController {

    @Resource(name = "PersonServiceAnnotationDSImpl")
    PersonService personService;


    @RequestMapping("/all-one")
    public List<Person> sort() {
        List<Person> people = personService.findAllOne();
        return people;
    }

    @GetMapping("/findByPage")
    public Page<Person> findByPage() {
        return personService.findByPage(1, 10);
    }


}
