package net.meloli.demo.sys.gson.extend;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * int及Integer类型为""或"null"时设置默认值0
 * @author shuchao
 */
public class IntegerDefault0Adapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {
	@Override
	public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if (json.getAsString().equals("") || json.getAsString().equals("null")) {//定义为int类型,如果后台返回""或者null,则返回0
				return 0;
			}
		} catch (Exception ignore) {
		}
		try {
			return json.getAsInt();
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}
	@Override
	public JsonElement serialize(Integer src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src);
	}
}