package org.afc.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.afc.entities.Test;
import org.afc.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2022-07-25
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test/{msg}")
    public List<Test> testApi(@PathVariable String msg) {
        //查询全部记录
        List<Test> testList = testMapper.selectList(Wrappers.<Test>lambdaQuery().select(Test::getId, Test::getMsg, Test::getTbTest));
        return testList;
    }

}

