package org.xue.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xue.infrastructure.dao.po.StrategyPO;

@Mapper
public interface IStrategyDao {

    StrategyPO queryStrategyByStrategyId(Long strategyId);

}
