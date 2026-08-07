package org.xue.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xue.infrastructure.dao.po.AwardPO;

import java.util.List;

@Mapper
public interface IAwardDao {

    List<AwardPO> queryAwardList();

}
