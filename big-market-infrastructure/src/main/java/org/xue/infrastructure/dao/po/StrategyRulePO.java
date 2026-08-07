package org.xue.infrastructure.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * strategy_rule table
 */
@Data
public class StrategyRulePO {

    private Long id;
    private Integer strategyId;
    private Integer awardId;
    private Integer ruleType;
    private String ruleModel;
    private String ruleValue;
    private String ruleDesc;
    private Date createTime;
    private Date updateTime;

}
