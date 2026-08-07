package org.xue.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xue.infrastructure.dao.po.StrategyRulePO;

import java.util.List;

@Mapper
public interface IStrategyRuleDao {

    List<StrategyRulePO> queryStrategyRuleList(Long strategyId);

}
