package org.xue.domain.strategy.resository;

import org.xue.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author xue
 * @description 策略创库接口
 * @create 2026/8/13 23:52
 */
public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrtegyAwardList(Long strtegyId);

    void storeStrtegyuAwardSearchRateTables(Long strtegyId, BigDecimal rateRange, HashMap<Integer, Integer> shufflestrtegyAwardSearchRateTables);

    int getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, int rateKey);

}
