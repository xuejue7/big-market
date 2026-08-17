package org.xue.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.xue.domain.strategy.model.entity.StrategyAwardEntity;
import org.xue.domain.strategy.resository.IStrategyRepository;
import org.xue.infrastructure.dao.IStrategyAwardDao;
import org.xue.infrastructure.dao.po.StrategyAwardPO;
import org.xue.infrastructure.redis.IRedisService;
import org.xue.types.common.Constants;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xue
 * @description策略仓库实现
 * @create 2026/8/13 23:55
 */
@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyAwardDao strategyAwardDao;
    @Resource
    private IRedisService redisService;
    @Override
    public List<StrategyAwardEntity> queryStrtegyAwardList(Long strtegyId) {
        String cachekey = Constants.RedisKey.STRATEGY_AWARD_KEY + strtegyId;
        List<StrategyAwardEntity> strategyAwardEntities = redisService.getValue(cachekey);
        if (strategyAwardEntities != null && !strategyAwardEntities.isEmpty()) {
            return strategyAwardEntities;
        }

        //从库读数据
        List<StrategyAwardPO> strategyAwards = strategyAwardDao.queryStrategyAwardListByStategyId(strtegyId);
        strategyAwardEntities = new ArrayList<>((strategyAwards.size()));
        for (StrategyAwardPO strategyAwardPO : strategyAwards) {
            StrategyAwardEntity strategyAwardEntity = StrategyAwardEntity.builder()
                    .strategyId(strategyAwardPO.getStrategyId())
                    .awardId(strategyAwardPO.getAwardId())
                    .awardCount(strategyAwardPO.getAwardCount())
                    .awardCountSurplus(strategyAwardPO.getAwardCountSurplus())
                    .awardRate(strategyAwardPO.getAwardRate())
                    .build();
            strategyAwardEntities.add(strategyAwardEntity);
        }
        redisService.setValue(cachekey, strategyAwardEntities);
        return strategyAwardEntities;



    }

    @Override
    public void storeStrtegyuAwardSearchRateTables(Long strtegyId, BigDecimal rateRange, HashMap<Integer, Integer> shufflestrtegyAwardSearchRateTables) {
        // 1. 存储抽奖策略范围值，如10000，用于生成1000以内的随机数
        redisService.setValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + strtegyId, rateRange.intValue());
        // 2. 存储概率查找表
        Map<Integer, Integer> cacheRateTable = redisService.getMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + strtegyId);
        cacheRateTable.putAll(shufflestrtegyAwardSearchRateTables);

    }

    @Override
    public int getRateRange(Long strategyId) {
        return redisService.getValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + strategyId);

    }

    @Override
    public Integer getStrategyAwardAssemble(Long strategyId, int rateKey) {
        return redisService.getFromMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY+strategyId,rateKey);
    }


}
