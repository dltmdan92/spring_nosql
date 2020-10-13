package com.seungmoo.springboot.redis.account;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("accounts")
public class Account {
    @Id
    private String id;

    private String username;

    private String email;
}
