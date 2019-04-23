package net.meloli.demo.sys.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 基础Context
 *
 * @author RetroLi
 */
public class BaseContext {
    /**
     * 日志记录
     */
    protected Logger logger = LogManager.getLogger(BaseContext.class);

    /**
     * json字符串转list
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> jsonToList(String json, Class<T> clazz) throws Exception {
        String jsonString = JSON.toJSONString(json);
        List<T> list = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            String str = JSON.toJSONString(iterator.next());
            list.add(jsonToObject(str, clazz));
        }
        return list;
    }

    /**
     * 从JSON转对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T jsonToObject(String json, Class<T> clazz) throws Exception {
        if (json instanceof Object) {
            json = json.toString();
        }
        JSONObject jsonObject = JSON.parseObject(json);
        return JSON.toJavaObject(jsonObject, clazz);
    }
}
