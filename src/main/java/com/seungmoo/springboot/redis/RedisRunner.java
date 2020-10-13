package com.seungmoo.springboot.redis;

import com.seungmoo.springboot.redis.account.Account;
import com.seungmoo.springboot.redis.account.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    Logger log = LoggerFactory.getLogger(RedisRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("seungmoo", "sam");
        values.set("springboot", "2.3");
        values.set("hello", "world");

        Account account = new Account();
        account.setEmail("dltmdan92@gmail.com");
        account.setUsername("seungmoo");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        log.info(byId.get().getUsername());
        log.info(byId.get().getEmail());
    }
}
