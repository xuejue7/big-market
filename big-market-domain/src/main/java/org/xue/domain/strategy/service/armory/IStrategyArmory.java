package org.xue.domain.strategy.service.armory;

/**
 * @author xue
 * @description 策略装配库 负责初始化策略计算
 *
 * @create 2026/8/13 23:45
 */
public interface IStrategyArmory {
    void assembleLotteryStrtegy(Long strtegyId);
    Integer getRandomAwardId(Long strategyId);

}
