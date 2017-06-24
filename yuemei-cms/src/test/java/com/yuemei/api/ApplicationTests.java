package com.yuemei.api;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import com.yuemei.api.admin.entity.BeautifulPictures;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "222");
       
    }

    @Test
    public void testObj() throws Exception {
    	BeautifulPictures user=new BeautifulPictures();
        user.setId(UUID.randomUUID().toString());
        user.setKeywords("edfedewd");
        user.setTitle("额的课的金额");
        ValueOperations operations=redisTemplate.opsForValue();
        operations.set("com.neox", user);
/*//        operations.set("com.neo.f", user,10000);
*/        
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neox");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        Thread.sleep(1000);
        BeautifulPictures ahha=(BeautifulPictures) operations.get("com.neox");
        System.out.println(ahha.getId());
        System.out.println(ahha.getTitle());
       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
    
    @Test
    public void time() throws Exception {
    	System.out.println(TimeUnit.SECONDS);
    }
}
