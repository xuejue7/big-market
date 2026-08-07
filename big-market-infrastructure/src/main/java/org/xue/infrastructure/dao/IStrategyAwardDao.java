package org.xue.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xue.infrastructure.dao.po.StrategyAwardPO;

import java.util.List;

@Mapper
public interface IStrategyAwardDao {

    List<StrategyAwardPO> queryStrategyAwardList(Long strategyId);

    void insertList(List<StrategyAwardPO> list);

}
