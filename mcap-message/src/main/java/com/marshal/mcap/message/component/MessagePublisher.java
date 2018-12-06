package com.marshal.mcap.message.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @auth: Marshal
 * @date: 2018/12/6
 * @desc: redis消息发布者
 */
@Component
public class MessagePublisher {
    private Logger logger = LoggerFactory.getLogger(MessagePublisher.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public void publish(String channel, Object message) {
        if (message instanceof String || message instanceof Number) {
            redisTemplate.convertAndSend(channel, message.toString());
        } else {
            try {
                redisTemplate.convertAndSend(channel, objectMapper.writeValueAsString(message));
            } catch (JsonProcessingException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("publish message failed.", e);
                }
            }
        }
    }
}
