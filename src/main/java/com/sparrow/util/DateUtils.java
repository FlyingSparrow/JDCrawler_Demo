package com.sparrow.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * <p>Title: DateUtils</p>
 * <p>Description: 日期工具类</p>
 * @author wjc
 * @date 2016年12月30日
 */
public class DateUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	
	private DateUtils(){}
	
	/**
	 * 
	 * <p>Description: 解析yyyy-MM-dd HH:mm:ss格式的日期字符串，返回日期对象</p>
	 * @param date
	 * @return
	 * @author wjc
	 * @date 2016年12月30日
	 */
	public static Date parseDate(String date){
		Date result = null;
		if(StringUtils.isNotEmpty(date)){
			DateTimeFormatter format = DateTimeFormat.forPattern(DATE_SECOND_FORMAT);
			DateTime dateTime = DateTime.parse(date, format);
			result = dateTime.toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 使用指定的日期格式解析日期字符串，返回日期对象</p>
	 * @param date
	 * @param dateFormat
	 * @return
	 * @author wjc
	 * @date 2016年12月30日
	 */
	public static Date parseDate(String date,String dateFormat){
		Date result = null;
		if(StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(dateFormat)){
			DateTimeFormatter format = DateTimeFormat.forPattern(dateFormat);
			DateTime dateTime = DateTime.parse(date, format);
			result = dateTime.toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 使用指定的格式格式化日期对象，返回格式化后的日期字符串</p>
	 * @param date
	 * @param dateFormat
	 * @return
	 * @author wjc
	 * @date 2016年12月30日
	 */
	public static String formatDate(Date date,String dateFormat){
		String result = null;
		if(date != null && StringUtils.isNotEmpty(dateFormat)){
			DateTimeFormatter format = DateTimeFormat.forPattern(dateFormat);
			DateTime dateTime = new DateTime(date.getTime());
			result = dateTime.toString(format);
		}
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 将yyyy-MM-dd格式的日期字符串转换为这一天的开始时间的日期对象
	 * 例如：将2017-01-01的日期字符串转换为表示2017-01-01 00:00:00的日期对象
	 * </p>
	 * @param date yyyy-MM-dd的日期格式的字符串
	 * @return
	 * @author wjc
	 * @date 2017年1月5日
	 */
	public static Date getStartDateTimeOfDay(String date){
		Date result = null;
		if(StringUtils.isNotEmpty(date)){
			DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
			DateTime dateTime = format.parseDateTime(date);
			result = dateTime.withTimeAtStartOfDay().toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 将yyyy-MM-dd格式的日期字符串转换为这一天的结束时间的日期对象
	 * 例如：将2017-01-01的日期字符串转换为表示2017-01-01 23:59:59的日期对象
	 * </p>
	 * @param date yyyy-MM-dd的日期格式的字符串
	 * @return
	 * @author wjc
	 * @date 2017年1月5日
	 */
	public static Date getEndDateTimeOfDay(String date){
		Date result = null;
		if(StringUtils.isNotEmpty(date)){
			DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
			DateTime dateTime = format.parseDateTime(date);
			result = dateTime.millisOfDay().withMaximumValue().toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 将不包含时间信息的日期对象转换为这一天的开始时间的日期对象
	 * 例如：将2017-01-01的日期对象转换为表示2017-01-01 00:00:00的日期对象
	 * </p>
	 * @param date
	 * @return
	 * @author wjc
	 * @date 2017年1月5日
	 */
	public static Date getStartDateTimeOfDay(Date date){
		Date result = null;
		if(date != null){
			DateTime dateTime = new DateTime(date);
			result = dateTime.withTimeAtStartOfDay().toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 将不包含时间信息的日期对象转换为这一天的结束时间的日期对象
	 * 例如：将2017-01-01的日期对象转换为表示2017-01-01 23:59:59的日期对象
	 * </p>
	 * @param date
	 * @return
	 * @author wjc
	 * @date 2017年1月5日
	 */
	public static Date getEndDateTimeOfDay(Date date){
		Date result = null;
		if(date != null){
			DateTime dateTime = new DateTime(date);
			result = dateTime.millisOfDay().withMaximumValue().toDate();
		}
		
		return result;
	}
	
	/**
	 * 
	 * <p>Description: 获取当前时间的日期对象</p>
	 * @return
	 * @author wjc
	 * @date 2017年1月10日
	 */
	public static Date currentDate(){
		DateTime now = new DateTime();
		return now.toDate();
	}
	
	/**
	 * 
	 * <p>Description: 根据出生日期计算年龄</p>
	 * @param birth
	 * @return
	 * @author wjc
	 * @date 2017年2月16日
	 */
	public static String getAgeFromBirth(String birth) {
		if (birth == null || "".equals(birth)) {
			return "";
		}
		DateTimeFormatter format = DateTimeFormat.forPattern(DATE_FORMAT);
		// 时间解析
		LocalDate birthday = DateTime.parse(birth, format).toLocalDate();
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthday, now);
		
		return age.getYears() + "";
	}

}
