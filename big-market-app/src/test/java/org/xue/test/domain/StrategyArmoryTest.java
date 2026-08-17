package org.xue.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xue.domain.strategy.service.armory.IStrategyArmory;

import javax.annotation.Resource;

/**
 * @author xue
 * @description
 * @create 2026/8/17 11:03
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void test_Strategyarmory() {
        strategyArmory.assembleLotteryStrtegy(10001L);

    }

    @Test
    public void test_getAssembleRandomVal() {
        strategyArmory.assembleLotteryStrtegy(10001L);
        log.info("测试结果：{} - 奖品id值",strategyArmory.getRandomAwardId(10001L));
        log.info("测试结果：{}- 奖品id值",strategyArmory.getRandomAwardId(10001L));
        log.info("测试结果：{}- 奖品id值",strategyArmory.getRandomAwardId(10001L));

    }



}
