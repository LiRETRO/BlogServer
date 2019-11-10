package net.meloli.demo.sys.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

/**
 * 文件工具类
 * @author shuchao
 */
public class FileTools {
	/** 附件上传位置   **/
	private static String sysMvcPath = getRootRealPath() + "uploadFiles/";
	/**  资源路径  **/
    public static String resourcePath;

	/**
     * 判断文件夹是否存在，如不存在则创建,并返回路径(带UPLOAD_PATH)
     */
    public static String createFolder(String folderName){
    	String filePath = sysMvcPath + folderName;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        return filePath;
    }
    
    /**
     * 获取文件名列表
     * @param path
     * @return
     */
    public static List<String> getFileNamesByPath(String path){
    	File file = new File(path);
    	if(file.exists()){
    		String[] files = file.list();
    		return Arrays.asList(files);
    	}
    	return null;
    }

    /**
     * 获取资源根路径
     * @param
     * @return
     */
    public static String getRootRealPath(){
        // 到项目根目录
        String path = System.getProperty("user.dir") + "/";
        try {
            path = URLDecoder.decode(path,"utf-8");
        } catch (UnsupportedEncodingException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }
}
