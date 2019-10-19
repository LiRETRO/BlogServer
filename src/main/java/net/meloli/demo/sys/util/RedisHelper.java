package net.meloli.demo.sys.util;

import com.alibaba.fastjson.JSON;
import net.meloli.demo.sys.base.SpringContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作工具类
 * @author LiRETRO
 */
public class RedisHelper {

    private static StringRedisTemplate stringRedisTemplate;

    private RedisHelper() { }

    public static void setApplicationContext(ApplicationContext context) {
        stringRedisTemplate = context.getBean(StringRedisTemplate.class);
    }

    /**
     * 获取Redis Hash对象
     * @param clazz 接收对象Class
     * @param k key
     * @param o key-key
     * @param <T>
     * @return
     */
    public static <T> T getHashObj(Class<T> clazz, String k, String o) {
        Object v = stringRedisTemplate.opsForHash().get(k, o);
        if(Objects.isNull(v)) {
            return null;
        }
        return JSON.parseObject(v.toString(), clazz);
    }


    /**
     * 获取Redis Hash List集合
     * @param clazz class参数
     * @param k key
     * @param <T>
     * @return
     */
    public static <T> List<T> getHashList(Class<T> clazz, String k) {
        Object jsonList = stringRedisTemplate.opsForHash().values(k);
        if(Objects.isNull(jsonList)) {
            return null;
        }
        return JSON.parseArray(jsonList.toString(), clazz);
    }

    /**
     * 获取Redis Hash String字符串
     * @param k key
     * @param o key-key
     * @return
     */
    public static String getHashString(String k, String o) {
        Object v = stringRedisTemplate.opsForHash().get(k, o);
        return Objects.nonNull(v) ? v.toString() : null;
    }

    /**
     * 获取
     * @param k key
     * @return
     */
    public static String getStringsValue(String k) {
        String v = stringRedisTemplate.opsForValue().get(k);
        return v;
    }

    /**
     * 设置Redis Strings对象
     * @param k key
     * @param v value
     */
    public static void setStringsValue(String k, String v) {
        if (!StringUtils.isEmpty(k)) {
            stringRedisTemplate.opsForValue().set(k, v);
        }
    }

    /**
     * 设置Redis Hash对象
     * @param k key
     * @param o key-key
     * @param v value
     */
    public static void setHashObj(String k, String o, Object v) {
        if (!StringUtils.isEmpty(k) && !StringUtils.isEmpty(o) && Objects.nonNull(v)) {
            stringRedisTemplate.opsForHash().put(k, o, (v instanceof String ? v : JSON.toJSONString(v)));
        }
    }

    /**
     * 删除Redis Hash对象
     * @param k key
     * @param o 可传一个或多个Key过来
     */
    public static void delHashObj(String k, String... o) {
        stringRedisTemplate.opsForHash().delete(k, o);
    }

    /**
     * 删除Key
     * @param k 一个或多个
     */
    public static void delKey(String... k) {
        List<String> keys = CollectionUtils.arrayToList(k);
        stringRedisTemplate.delete(keys);
    }

    /**
     * 设置key的失效时间单位分钟
     * @param k
     * @param expire
     */
    public static void setExpire(String k, Long expire){
        stringRedisTemplate.expire(k, expire, TimeUnit.MINUTES);
    }
}
