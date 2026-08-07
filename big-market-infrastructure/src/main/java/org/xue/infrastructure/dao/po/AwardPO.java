package org.xue.infrastructure.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * award table
 */
@Data
public class AwardPO {

    private Integer id;
    private Integer awardId;
    private String awardKey;
    private String awardConfig;
    private String awardDesc;
    private Date createTime;
    private Date updateTime;

}
