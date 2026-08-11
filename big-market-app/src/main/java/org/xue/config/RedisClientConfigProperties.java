package org.xue.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Redis 客户端配置
 */
@Data
@ConfigurationProperties(prefix = "redis.sdk.config")
public class RedisClientConfigProperties {

    private String host;
    private Integer port;
    private String password;

}
