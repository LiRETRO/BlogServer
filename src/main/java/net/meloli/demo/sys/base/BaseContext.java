package net.meloli.demo.sys.base;

import com.google.gson.*;
import net.meloli.demo.sys.gson.extend.DoubleDefault0Adapter;
import net.meloli.demo.sys.gson.extend.IntegerDefault0Adapter;
import net.meloli.demo.sys.gson.extend.LongDefault0Adapter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础Context
 * @author RetroLi
 */
public class BaseContext {
    /**
     * 日志记录
     */
    protected Logger logger = LogManager.getLogger(BaseContext.class);

    /**
     * Gson转换
     */
    protected Gson gson = new GsonBuilder()
            .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
            .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
            .registerTypeAdapter(Double.class, new DoubleDefault0Adapter())
            .registerTypeAdapter(double.class, new DoubleDefault0Adapter())
            .registerTypeAdapter(Long.class, new LongDefault0Adapter())
            .registerTypeAdapter(long.class, new LongDefault0Adapter())
            .serializeNulls().setDateFormat("yyyy-MM-dd hh:mm:ss")
            .create();

    /**
     * json字符串转list
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> gsonToList(String json, Class<T> clazz){
        List<T> list = new ArrayList<T>();
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : jsonArray) {
            list.add(gson.fromJson(elem, clazz));
        }
        return list;
    }

    /**
     * 从JSON转对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T gsonToObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
