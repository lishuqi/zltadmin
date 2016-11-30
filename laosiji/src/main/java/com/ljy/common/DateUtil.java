package com.ljy.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class DateUtil {
	private static Logger log = Logger.getLogger(DateUtil.class);

    private static String _datePattern = "yyyyMMdd";
    private static String datePattern = "yyyy-MM-dd";
    private static String _timePattern = "HHmmss";
    private static String timePattern = "HH:mm:ss";

    private static SimpleDateFormat _dateFormat = new SimpleDateFormat(_datePattern);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
    private static SimpleDateFormat _datetimeFormat = new SimpleDateFormat(_timePattern);
    private static SimpleDateFormat datetimeFormat = new SimpleDateFormat(datePattern + " " + timePattern);

    /**
     * 将日期对象转换为字符串，格式为yyyy-MM-dd.
     * @param date
     *            日期.
     * @return 日期对应的日期字符串.
     */
    public static String toDateString(Date date) {
        if (date == null) {
            return null;
        }
        return dateFormat.format(date);
    }

    public static String _toDateString(Date date) {
        if (date == null) {
            return null;
        }
        return _dateFormat.format(date);
    }

    /**
     * 将字符串转换为日期对象，字符串必须符合yyyy-MM-dd的格式.
     * @param s
     *            要转化的字符串.
     * @return 字符串转换成的日期.如字符串为NULL或空串,返回NULL.
     */
    public static Date toDate(String s) {
        s = StringUtils.trim(s);
        if (s.length() < 1) {
            return null;
        }
        try {
            if (s.length() <= 10) {
                return dateFormat.parse(s);
            }
            return toDate(Timestamp.valueOf(s));
        } catch (Exception e) {
            log.warn("解析字符串成日期对象时出错", e);
            return null;
        }
    }

    /**
     * 将字符串转换为日期对象，字符串必须符合(yyyy-MM-dd HH:mm:ss)的格式.
     * @param s
     * @return
     */
    public static Date toDateTime(String s) {
        s = StringUtils.trim(s);
        if (s.length() < 19) {
            return null;
        }
        try {
            return toDate(Timestamp.valueOf(s));
        } catch (Exception e) {
            log.warn("解析字符串成日期对象时出错", e);
            return null;
        }
    }

    /**
     * 将日期对象转换为字符串，转换后的格式为yyyy-MM-dd HH:mm:ss.
     * @param date
     *            要转换的日期对象.
     * @return 字符串,格式为yyyy-MM-dd HH:mm:ss.
     */
    public static String toDatetimeString(Date date) {
        if (date == null) {
            return null;
        }
        return datetimeFormat.format(date);
    }

    public static String _toDatetimeString(Date date) {
        if (date == null) {
            return null;
        }
        return _datetimeFormat.format(date);
    }

    /**
     * 计算两个日期间相隔的周数
     * @param startDate
     *            开始日期
     * @param endDate
     *            结束日期
     * @return
     */
    public static int computeWeek(Date startDate, Date endDate) {

        int weeks = 0;

        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        while (beginCalendar.before(endCalendar)) {

            // 如果开始日期和结束日期在同年、同月且当前月的同一周时结束循环
            if (beginCalendar.get(Calendar.YEAR) == endCalendar.get(Calendar.YEAR)
                    && beginCalendar.get(Calendar.MONTH) == endCalendar.get(Calendar.MONTH)
                    && beginCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == endCalendar
                            .get(Calendar.DAY_OF_WEEK_IN_MONTH)) {
                break;

            } else {

                beginCalendar.add(Calendar.DAY_OF_YEAR, 7);
                weeks += 1;
            }
        }

        return weeks;
    }

    /**
     * 返回当前系统时间
     * @return
     */
    public static String getCurrDateTime() {
        return toDatetimeString(new Date());

    }

    public static String getCurrTimeNumber() {
        return _toDatetimeString(new Date());
    }

    /**
     * 获取系统当前时间，待后期可扩展到取数据库时间
     * @return 系统当前时间
     */
    public static String getCurrDate() {
        return toDateString(new Date());

    }

    public static String getCurrDateNumber() {
        return _toDateString(new Date());

    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转化为yyyy-MM-dd
     * @param dateTime
     * @return
     */
    public static String getCurrDate(String dateTime) {
        return toDateString(DateUtil.toDateTime(dateTime));
    }

    /**
     * 将Timestamp转换为日期.
     * @param timestamp
     *            时间戳.
     * @return 日期对象.如时间戳为NULL,返回NULL.
     */
    public static Date toDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return new Date(timestamp.getTime());
    }

    /**
     * 将日期转换为Timestamp.
     * @param date
     *            日期.
     * @return 时间戳.如日期为NULL,返回NULL.
     */
    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    /**
     * 将时间戳对象转化成字符串.
     * @param t
     *            时间戳对象.
     * @return 时间戳对应的字符串.如时间戳对象为NULL,返回NULL.
     */
    public static String toDateString(Timestamp t) {
        if (t == null) {
            return null;
        }
        return toDateString(toDate(t));
    }
    /**
     * 获取当前时间
     * 
     * @return
     */
    public static Date getCurrentDate(){
    	return new Date();
    }

}
