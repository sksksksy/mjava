package zhp.win.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisOperation {
    @Autowired
    RedisTemplate redisTemplate;
    public void  loginSet(String k,String v){
        redisTemplate.opsForValue().set(k,v);
        redisTemplate.expire(k,30L, TimeUnit.SECONDS);
        System.out.println(k+' '+"存入成功");
    }
    public String loginGet(String k){
        return (String)redisTemplate.opsForValue().get(k);
    }


}
