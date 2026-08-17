package org.xue.domain.strategy.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.xue.domain.strategy.model.entity.StrategyAwardEntity;
import org.xue.domain.strategy.resository.IStrategyRepository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author xue
 * @description
 * @create 2026/8/13 23:47
 */
@Slf4j
@Service
public class StrategyArmory implements IStrategyArmory {

    @Resource


    private IStrategyRepository repository;

    @Override
    public void assembleLotteryStrtegy(Long strtegyId) {
        //查询策略配置
        List<StrategyAwardEntity>strategyAwardEntity = repository.queryStrtegyAwardList(strtegyId);

        //获取最小概率值
        BigDecimal minAwardRate = strategyAwardEntity
                .stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        //获取概率综合
        BigDecimal totalAwardRate = strategyAwardEntity
                .stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //用1 0.0001 获取概率范围
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.HALF_UP);

        ArrayList<Integer> strtegyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAwardEntity1 : strategyAwardEntity) {
            Integer awardId = strategyAwardEntity1.getAwardId();
            BigDecimal awardRate = strategyAwardEntity1.getAwardRate();

            //计算每个概率需要存放到查找表的数量循环填充
            int awardRateCount = awardRate.divide(minAwardRate, 0, RoundingMode.CEILING).intValue();
            for (int i = 0; i < awardRateCount; i++) {
                strtegyAwardSearchRateTables.add(awardId);
                
            }
        }
        
        //乱序
        Collections.shuffle(strtegyAwardSearchRateTables);

        HashMap<Integer, Integer> shufflestrtegyAwardSearchRateTables = new HashMap<>();
        for (int i =  0; i < strtegyAwardSearchRateTables.size(); i++) {
            shufflestrtegyAwardSearchRateTables.put(i, strtegyAwardSearchRateTables.get(i));

        }

        //存储到redis
        repository.storeStrtegyuAwardSearchRateTables(strtegyId,rateRange,shufflestrtegyAwardSearchRateTables);

    }

    @Override
    public Integer getRandomAwardId(Long strategyId) {
        int ratreRage = repository.getRateRange(strategyId);

        return repository.getStrategyAwardAssemble(strategyId,new SecureRandom().nextInt(ratreRage));
    }
}
