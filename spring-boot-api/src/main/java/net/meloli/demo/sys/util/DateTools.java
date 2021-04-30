package net.meloli.demo.sys.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author shuchao
 */
public class DateTools {
	
	/**
	 * 时间添加多少年
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date addYear(Date date,int year){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * 时间添加多少月
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONDAY, month);
		return calendar.getTime();
	}
	
	/**
	 * 时间添加多少天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * 时间添加多少小时
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date,int hour){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}
	/**
	 * 时间添加多少分钟
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinute(Date date,int minute){
		Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date);
	    calendar.add(Calendar.MINUTE, minute);    
	    return calendar.getTime(); 
	}
	/**
	 * 时间添加多少秒
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date,int second){
		Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date);    
	    calendar.add(Calendar.SECOND, second);    
	    return calendar.getTime(); 
	}
	
	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getCurrentYear(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 获取当前月份
	 * @return
	 */
	public static int getCurrentMonth(){
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}
	
	/**
	 * 获取当前日期 如:23
	 * @return
	 */
	public static int getCurrentDay(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 获取当前时
	 * @return
	 */
	public static int getCurrentHour(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	/**
	 * 获取当前分钟
	 * @return
	 */
	public static int getCurrentMinute(){
		Calendar cal = Calendar.getInstance();
		int minute = cal.get(Calendar.MINUTE);
		return minute;
	}
	
	/**
	 * 获取当前秒
	 * @return
	 */
	public static int getCurrentSecond(){
		Calendar cal = Calendar.getInstance();
		int second = cal.get(Calendar.SECOND);
		return second;
	}
	
	/**
	 * 获取日期的年
	 * @param date
	 * @return
	 */
	public static int getYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR); 
		return year;		
	}
	
	/**
	 * 获取日期的月份
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1; 
		return month;		
	}
	
	/**
	 * 获取日期的日
	 * @param date
	 * @return
	 */
	public static int getDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		return day;
	}
	
	/**
	 * 获取日期的小时
	 * @param date
	 * @return
	 */
	public static int getHour(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY); 
		return hour;
	}
	
	/**
	 * 获取日期的分钟
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int minute = cal.get(Calendar.MINUTE); 
		return minute;
	}
	
	/**
	 * 获取日期的秒
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int second = cal.get(Calendar.MINUTE); 
		return second;
	}
	
	/**
	 * 时间的比较(当前时间与第一个日期比较) 如果当前日期>第一个日期返回1;如果当前日期<第一个日期返回-1;相等返回0
	 * @param first 第一个日期
	 * @return
	 */
	public static int getCompareDateTime(Date first) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(Calendar.getInstance().getTime());
		Date dt1 = null;
		try {
			dt1 = sdf.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String setTime = sdf.format(first);
		Date dt2 = null;
		try {
			dt2 = sdf.parse(setTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dt1.getTime() > dt2.getTime()) {
			return 1;
		} else if (dt1.getTime() < dt2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 比较2个日期 如果第一个日期在第二个日期后返回 1;如果第一个日期在第二个日期前返回-1;相等返回0
	 * @param dt1 第一个日期
	 * @param dt2 第二个日期
	 * @return
	 */
	public static int compareDate(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {
            //System.out.println("dt1在dt2后");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            //System.out.println("dt1 在dt2前");
            return -1;
        } else {//相等
            return 0;
        }
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate)   
    {    
    	try
    	{
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        smdate=sdf.parse(sdf.format(smdate));  
	        bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	        return Integer.parseInt(String.valueOf(between_days));           
    	}catch(ParseException e){
    		e.printStackTrace();
    	}
    	return 0;
    }   
	
	/**
	 * 字符串转为时间类型
	 * @param str 日期字符串
	 * @param format 转换格式  如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date strToDate(String str, String format){
		
         try {
			 SimpleDateFormat formate= new SimpleDateFormat(format); 
			 Date date = formate.parse(str);
			 return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 时间转为字符串
	 * @param date 日期
	 * @param format 转换格式  如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateToStr(Date date,String format){
		try{
			SimpleDateFormat formate= new SimpleDateFormat(format); 
			String str = formate.format(date);
			return str;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * java 判断一个时间在另一个时间段内（时分秒判断）
	 * @param myDate 日期
	 * @param dateBegin 开始日期
	 * @param dateEnd  结果日期
	 * @return
	 */
	public static boolean isInDates(Date myDate,Date dateBegin,Date dateEnd){   
		Calendar myCal = Calendar.getInstance();    
		myCal.setTime(myDate);
		Calendar begin = Calendar.getInstance(); 
		begin.setTime(dateBegin);
     	Calendar end = Calendar.getInstance(); 
     	end.setTime(dateEnd);
     	if(myCal.before(end) && myCal.after(begin)){  
            return true;  
        }  
        return false; 
    }
	
	/**
	 * 获取本周的开始时间
	 * @param dateStr
	 * @return
	 */
	public static Date getBeginDayOfWeek(String dateStr) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(dateStr));
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 1);
		return getDayStartTime(cal.getTime());
	}
	/**
	 * 获取本周的结束时间
	 * @param dateStr
	 * @return
	 */
	public static Date getEndDayOfWeek(String dateStr) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek(dateStr));  
		cal.add(Calendar.DAY_OF_WEEK, 6); 
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
	/**
	 * 获取本月的开始时间
	 * @param dateStr
	 * @return
	 */
	public static Date getBeginDayOfMonth(String dateStr) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(dateStr));
		cal.set(getYear(cal.getTime()), getMonth(cal.getTime()) - 1, 1);
		return getDayStartTime(cal.getTime());
	}
	/**
	 * 获取本月的结束时间
	 * @param dateStr
	 * @return
	 */
	public static Date getEndDayOfMonth(String dateStr) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(dateStr));
		int day = calendar.getActualMaximum(5);
		calendar.set(getYear(calendar.getTime()), getMonth(calendar.getTime()) - 1, day);
		return getDayEndTime(calendar.getTime());
	}
	
	
	/**
	 * 获取某个日期的开始时间
	 * @param d
	 * @return
	 */
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if(null != d) calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}
	/**
	 * 获取某个日期的结束时间
	 * @param d
	 * @return
	 */
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if(null != d) calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}
}
