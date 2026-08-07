package org.xue.infrastructure.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * strategy table
 */
@Data
public class StrategyPO {

    private Long id;
    private Long strategyId;
    private String strategyDesc;
    private String ruleModels;
    private Date createTime;
    private Date updateTime;

}
