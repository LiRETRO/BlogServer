package net.meloli.demo.sys.util;

public enum RedisKeyHolder {
    TAGS("tags");

    String key;

    RedisKeyHolder(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
