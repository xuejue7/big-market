package org.xue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xue.infrastructure.dao.IAwardDao;
import org.xue.infrastructure.dao.po.AwardPO;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private IAwardDao awardDao;

    @GetMapping("/api/test")
    public List<AwardPO> test() {
        return awardDao.queryAwardList();
    }

}
