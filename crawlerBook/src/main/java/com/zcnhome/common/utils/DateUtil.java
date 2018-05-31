/**
 * DateTool.java 2017年7月20日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * <summary>
 * <description>
 * 
 * @author hqsun
 * @since 2017年7月20日
 * @see [Class/Method]
 *
 */
public class DateUtil {

    public static final TimeZone UTC_TZ = TimeZone.getTimeZone("UTC");

    public static final int YEAR = 0;

    public static final int MONTH = 1;

    public static final int WEEK = 2;

    public static final int DAY = 3;

    public static final int HOUR = 4;

    public static final int MINUTE = 5;

    public static final int SECOND = 6;

    public static final int MILLISECOND = 7;

    public static final int MINUTEOFDAY = 8;

    /** 一天的毫秒数 */
    public static final long DAY_LONG = 1 * 24 * 60 * 60 * 1000;

    /** 一小时的毫秒数 */
    public static final long HOUR_LONG = 1 * 1 * 60 * 60 * 1000;

    /** UTC_8 东八时区8小时的毫秒数 */
    public static final long UTC_8_HOUR_LONG = 1 * 8 * 60 * 60 * 1000;

    /** 半小时的毫秒数 */
    public static final long HALF_HOUR_LONG = 1 * 1 * 30 * 60 * 1000;

    /** 一分钟的毫秒数 */
    public static final long MINUTE_LONG = 1 * 1 * 1 * 60 * 1000;

    // add by wangzheng at 20140710 begin

    public static final String DATE_PATTERN_S = "yyyyMMdd";

    /**
     * "yyyy-MM-dd"
     */
    public static final String DATE_PATTERN_S_SHOW = "yyyy-MM-dd";

    /**
     * "yyyy/MM/dd"
     */
    public static final String DATE_PATTERN_SHOW_FOR_WEB = "yyyy/MM/dd";

    /**
     * "yyyy-MM"
     */
    public static final String DATE_PATTERN_Y_SHOW = "yyyy-MM";

    /**
     * "HH:mm"
     */
    public static final String RESEND_DATE_PATTERN_SHOW = "HH:mm";

    /**
     * "yyyyMM"
     */
    public static final String DATE_YEAR_MONTH = "yyyyMM";

    /**
     * "yyyyMMddHHmmss"
     */
    public static final String DATE_PATTERN = "yyyyMMddHHmmss";

    public static final String SHARE_FILE_MENU_ID = "0006";

    public static final String DATE_PATTERN2 = "yyyyMMddHHmm";

    public static final String DATE_LOG_PATTERN = "yyyyMMddHHmmssSSS";

    public static final String LOG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.S";

    public static final String SHOW_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String SHOW_DATE_PATTERN_FOR_WEB = "yyyy/MM/dd HH:mm:ss";

    public static final String SHOW_DATE_MINUTE = "yyyy-MM-dd HH:mm";

    public static final String SHOW_TIME_NO_ZERO_FORMAT = "H:mm:ss";

    public static final String SHOW_TIME_FORMAT = "HH:mm:ss";

    public static final String SHOW_TIME_NO_SEC_ZERO_FORMAT = "H:mm";

    public static final String SHOW_TIME_NO_SEC_FORMAT = "HH:mm";

    public static final String RESEND_DATE_PATTERN = "HHmm";

    public static final String DB_TIME_FORMAT = "HHmmss";

    // add by wangzheng at 20140710 end

    /**
     * 按要求转化时间的显示格式 参数：oldpattern，旧日期格式，如:yyyyMMddhhmmss 格式描述符的含义参见JDK
     * simpleDateFormat类 newpattern，新日期格式
     */
    public static String timeTransform(String time, String oldpattern, String newpattern) {
        // 打印调试信息
        String oldtime;
        if (oldpattern == null) {
            throw new IllegalArgumentException("the old pattern is null");
        }
        if (newpattern == null) {
            throw new IllegalArgumentException("the new pattern is null");
        }
        SimpleDateFormat olddatepattern = new SimpleDateFormat(oldpattern);
        Date now;
        try {
            now = olddatepattern.parse(time);
            // 用原来的pattern解析日期，再和原来的比较，由此来检查时间是否合法
            oldtime = olddatepattern.format(now);
            if (!oldtime.equals(time)) {
                throw new IllegalArgumentException("using Illegal time");
            }
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("using [" + oldpattern + "] parse [" + time + "] failed");
        }
        SimpleDateFormat newdatepattern = new SimpleDateFormat(newpattern);

        return newdatepattern.format(now);
    }

    /**
     * 获取指定格式的当前日期 参数：pattern，日期格式，如:yyyyMMddhhmmss 格式描述符的含义参见JDK
     * simpleDateFormat类
     */
    public static String getCurrentDate(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("input string parameter is null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date now = new Date();
        return sdf.format(now);
    }

    /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now;
        try {
            now = sdf.parse(time);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("using [yyyy-MM-dd] parse [" + time + "] failed");
        }

        String[] weekDays = {
                "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六",

        };
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 将日期长整型转换成字符串 参数：time，long，从格林威治时间：1970年1月1日0点起的毫秒数 pattern, String,
     * 转换的目标格式
     */
    public static String long2TimeStr(long time, String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        Date dt = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(dt);
    }

    /**
     * 将日期型转换成字符串 参数：time，Date pattern, String, 转换的目标格式
     */
    public static String date2TimeStr(Date time, String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        if (time == null) {
            throw new IllegalArgumentException("time parameter can not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(time);
    }

    /**
     * 将日期增加一个增量，目前只能是，年，月，周，日，时、分、秒、毫秒 参数：date, long，原始时间 delta，int，增量的大小 unit,
     * int, 增量的单位，YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLISECOND
     * 返回：long，从格林威治时间：1970年1月1日0点起的毫秒数
     */
    public static long addDate(long date, int delta, int unit) {
        if ((unit < YEAR) || (unit > MILLISECOND)) {
            throw new IllegalArgumentException(
                    "time unit must in [YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND, MILLISECOND], others not support");
        }
        Date dt = new Date(date);
        Calendar calendar = getLocalCalendar(dt);
        // 增加增量
        switch (unit) {
            case YEAR:
                calendar.add(Calendar.YEAR, delta);
                break;
            case MONTH:
                calendar.add(Calendar.MONTH, delta);
                break;
            case WEEK:
                calendar.add(Calendar.DAY_OF_WEEK, delta);
                break;
            case DAY:
                calendar.add(Calendar.DAY_OF_MONTH, delta);
                break;
            case HOUR:
                calendar.add(Calendar.HOUR, delta);
                break;
            case MINUTE:
                calendar.add(Calendar.MINUTE, delta);
                break;
            case SECOND:
                calendar.add(Calendar.SECOND, delta);
                break;
            case MILLISECOND:
                calendar.add(Calendar.MILLISECOND, delta);
        }
        // 获取新的时间，并转换成长整形
        Date ndt = calendar.getTime();
        return ndt.getTime();
    }

    /**
     * 将日期增加一个增量，目前只能是，年，月，周，日，时，分，秒，毫秒 参数：date, long，原始时间 delta，int，增量的大小 unit,
     * int, 增量的单位，YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND, MILLISECOND
     * pattern, String, 转换的目标格式 返回：String，指定格式的日期字符串
     */
    public static String addDate(long date, int delta, int unit, String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        return long2TimeStr(addDate(date, delta, unit), pattern);
    }

    /**
     * 将字符串转换成日期长整形 参数：time，String，日期字符串 pattern, String, 解析的格式 返回：long，日期长整形
     */
    public static long timeStr2Long(String time, String pattern) {
        return timeStr2Date(time, pattern).getTime();
    }

    /**
     * 将字符串转换成日期形 参数：time，String，日期字符串 pattern, String, 解析的格式 返回：Date，日期形
     */
    public static Date timeStr2Date(String time, String pattern) {
        if (time == null) {
            throw new IllegalArgumentException("time parameter can not be null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(time);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("using [" + pattern + "] parse [" + time + "] failed");
        }
    }

    public static String getShotDateString(String date) {
        date = date.trim();
        if (date.length() > 10) {
            date = date.substring(0, 10);
        }
        String str[] = date.split("[-]");
        if (str[1].length() == 1) {
            str[1] = "0".concat(str[1]);
        }
        if (str[2].length() == 1) {
            str[2] = "0".concat(str[2]);
        }
        date = str[0] + "-" + str[1] + "-" + str[2];

        return date;
    }

    /**
     * 获取日期字符串的某一部分 参数：date，有效的日期字符串 pattern，日期格式字符串
     * part，时间部分的指示符，只能是：YEAR,MONTH,WEEK,DAY,HOUR,MINUTE,SECOND，MILLISECOND
     */
    public static int getDatePart(String date, String pattern, int part) {
        if (date == null) {
            throw new IllegalArgumentException("date parameter is null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter is null");
        }
        if ((part < YEAR) || (part > MINUTEOFDAY)) {
            throw new IllegalArgumentException("the part parameter must be in [YEAR,MONTH, DAY, HOUR, MINUTE, SECOND]");
        }
        Date dt = timeStr2Date(date, pattern);
        return getDatePart(dt, part);
    }

    /**
     * 获取日期的某一部分 参数：date，有效的日期类型
     * part，时间部分的指示符，只能是：YEAR,MONTH,WEEK,DAY,HOUR,MINUTE,SECOND，MILLISECOND
     */
    public static int getDatePart(Date date, int part) {
        if (date == null) {
            throw new IllegalArgumentException("date parameter is null");
        }
        if ((part < YEAR) || (part > MINUTEOFDAY)) {
            throw new IllegalArgumentException("the part parameter must be in [YEAR,MONTH, DAY, HOUR, MINUTE, SECOND]");
        }
        Calendar calendar = getLocalCalendar(date);
        int result = 0;
        switch (part) {
            case YEAR:
                result = calendar.get(Calendar.YEAR);
                break;
            case MONTH:
                result = calendar.get(Calendar.MONTH);
                break;
            case WEEK:
                result = calendar.get(Calendar.DAY_OF_WEEK);
                break;
            case DAY:
                result = calendar.get(Calendar.DAY_OF_MONTH);
                break;
            case HOUR:
                result = calendar.get(Calendar.HOUR_OF_DAY);
                break;
            case MINUTE:
                result = calendar.get(Calendar.MINUTE);
                break;
            case SECOND:
                result = calendar.get(Calendar.SECOND);
                break;
            case MILLISECOND:
                result = calendar.get(Calendar.MILLISECOND);
                break;
            case MINUTEOFDAY:
                result = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
        }
        return result;
    }

    /**
     * 获取下一个周期的开始时间 参数：date，String类型，有效的时间 pattern，String类型，时间格式字符串
     * part，int类型，周期类型，可以是年、月、日、周
     */
    public static String getNextPeriodTime(Date galeday, String pattern, int part) {

        if (galeday == null) {
            throw new IllegalArgumentException("date parameter is null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter is null");
        }
        if ((part < YEAR) || (part > DAY)) {
            throw new IllegalArgumentException("the part parameter must be in [YEAR,MONTH, WEEK, DAY]");
        }
        String result;
        Calendar caldeduct = getLocalCalendar(galeday);
        Calendar calnow = getLocalCalendar(new Date());
        switch (part) {
            case DAY: // 扣费周期为每天
                return recursiveGet(caldeduct, calnow, pattern, Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.HOUR);
            case WEEK: // 周期为每周
                return recursiveGetWeek(caldeduct, calnow, pattern, Calendar.DAY_OF_WEEK, Calendar.DAY_OF_MONTH, 0,
                        Calendar.DAY_OF_WEEK);
            case YEAR: // 周期为每年
                return recursiveGet(caldeduct, calnow, pattern, Calendar.YEAR, Calendar.MONTH, Calendar.MONTH);
            case MONTH: // 周期为每月
                return recursiveGet(caldeduct, calnow, pattern, Calendar.MONTH, Calendar.DAY_OF_MONTH,
                        Calendar.DAY_OF_MONTH);
            default:
                result = "unsupport period : " + String.valueOf(part);
        }
        return result;
    }

    private static String recursiveGetWeek(Calendar caldeduct, Calendar calnow, String pattern, int largepart,
            int part, int gap, int step) {
        int deduct = caldeduct.get(step);
        int now = calnow.get(step);
        if (step == Calendar.DAY_OF_WEEK) {
            gap = deduct - now;
        }
        if (deduct > now) {
            calnow.add(step, gap);
            return DateUtil.date2TimeStr(calnow.getTime(), pattern);
        }
        else if (deduct < now) {
            calnow.add(step, 7 + gap);
            return DateUtil.date2TimeStr(calnow.getTime(), pattern);
        }
        else {
            switch (step) {
                case Calendar.DAY_OF_WEEK:
                    step = Calendar.HOUR;
                    break;
                case Calendar.HOUR:
                    step = Calendar.MINUTE;
                    break;
                case Calendar.MINUTE:
                    step = Calendar.SECOND;
                    break;
                case Calendar.SECOND:
                    step = Calendar.MILLISECOND;
                    break;
                case Calendar.MILLISECOND:
                    return date2TimeStr(calnow.getTime(), pattern);
            }
            return recursiveGetWeek(caldeduct, calnow, pattern, largepart, part, gap, step);
        }
    }

    private static String recursiveGet(Calendar caldeduct, Calendar calnow, String pattern, int largepart, int part,
            int step) {

        int deduct = caldeduct.get(step);
        int now = calnow.get(step);
        if (deduct > now) {
            calnow.set(part, caldeduct.get(part));
            if (largepart == Calendar.YEAR) {
                calnow.set(Calendar.DAY_OF_MONTH, caldeduct.get(Calendar.DAY_OF_MONTH));
            }
            return DateUtil.date2TimeStr(calnow.getTime(), pattern);
        }
        else if (deduct < now) {
            calnow.add(largepart, 1);
            calnow.set(part, caldeduct.get(part));
            if (largepart == Calendar.YEAR) {
                calnow.set(Calendar.DAY_OF_MONTH, caldeduct.get(Calendar.DAY_OF_MONTH));
            }
            return DateUtil.date2TimeStr(calnow.getTime(), pattern);
        }
        else {
            switch (step) {
                case Calendar.YEAR:
                    step = Calendar.MONTH;
                    break;
                case Calendar.MONTH:
                    step = Calendar.DATE;
                    break;
                case Calendar.DAY_OF_MONTH:
                    step = Calendar.HOUR;
                    break;
                case Calendar.HOUR:
                    step = Calendar.MINUTE;
                    break;
                case Calendar.MINUTE:
                    step = Calendar.SECOND;
                    break;
                case Calendar.SECOND:
                    step = Calendar.MILLISECOND;
                    break;
                case Calendar.MILLISECOND:
                    return date2TimeStr(calnow.getTime(), pattern);
            }
            return recursiveGet(caldeduct, calnow, pattern, largepart, part, step);
        }
    }

    /**
     * 获得东八时区的日历，并设置日历的当前日期 参数：date，Date，日期型
     * 
     * @param date
     *            Date
     * @return Calendar
     */
    public static Calendar getLocalCalendar(Date date) {
        // 设置为GMT+08:00时区
        String[] ids = TimeZone.getAvailableIDs(8 * 60 * 60 * 1000);
        if (ids.length == 0) {
            throw new IllegalArgumentException("get id of GMT+08:00 time zone failed");
        }
        // SimpleTimeZone stz = new SimpleTimeZone(8 * 60 * 60 * 1000, ids[0]);
        // 创建Calendar对象，并设置为指定时间
        // Calendar calendar = new GregorianCalendar(stz);
        Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
        // 设置成宽容方式
        if (!calendar.isLenient()) {
            calendar.setLenient(true);
        }
        // 设置SUNDAY为每周的第一天
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        // 设置日历的当前时间
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 根据日期格式获得对应的日期字符串
     * 
     * @param time
     *            日期格式字符串 该参数必须满足"yyyyMMddHHmmss"格式
     * @param pattern
     *            要获得对应的日期字符串格式
     * @return 返回日期字符串
     */
    public static String getDateByPattern(String time, String pattern) {
        if (time == null) {
            throw new IllegalArgumentException("time parameter can not be null");
        }

        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }

        Date date = timeStr2Date(time, "yyyyMMddHHmmss");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String resultTime = sdf.format(date);

        return resultTime;
    }

    /**
     * 根据日期增加或减少一天
     * 
     * @param time
     *            日期字符串
     * @param pattern
     *            解析的格式和返回的格式一致
     * @param falg
     *            true 增加一天; false 减少一天
     * @return String 返回日期字符串
     */
    public static String addOrDescOneDay(String time, String pattern, boolean falg) {
        if (time == null) {
            throw new IllegalArgumentException("time parameter can not be null");
        }

        if (pattern == null) {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        long newDate;
        if (falg) {
            newDate = timeStr2Long(time, pattern) + DAY_LONG;
        }
        else {
            newDate = timeStr2Long(time, pattern) - DAY_LONG;
        }

        Date date = new Date(newDate);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String resultTime = sdf.format(date);

        return resultTime;
    }

    /**
     * 根据年、月获取其对应月份的最后一天日期
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return
     * @author hqsun
     * @see [类、类#方法、类#成员]
     */
    public static Date getLastDayFromYYMM(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获得指定年月对应第一天
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return
     * @author hqsun
     * @see [类、类#方法、类#成员]
     */
    public static Date getFirstDayFromYYMM(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 将本地时间转化成UTC时间
     * 
     * @param format
     *            时间格式
     * @param dateStr
     *            本地时间
     * @param timeZone
     *            本地时区
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static final String getUtcTime(String format, String dateStr, TimeZone timeZone) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        formater.setTimeZone(timeZone);

        try {
            Date date = formater.parse(dateStr);

            // 转换UTC时间
            formater.setTimeZone(UTC_TZ);
            return formater.format(date);
        }
        catch (ParseException e) {
            return dateStr;
        }
    }

    /**
     * 获取转换后的时区时间
     * 
     * @param utcDate
     *            UTC时间
     * @param tz
     *            时区
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static final Date getZoneTime(Date utcDate, TimeZone tz) {
        if (utcDate == null) {
            return null;
        }

        int offset = tz.getOffset(utcDate.getTime());
        if (offset == 0) {
            return utcDate;
        }

        // 转化时区时间
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(UTC_TZ);
        cal.setTime(utcDate);
        cal.add(Calendar.MILLISECOND, offset);
        return cal.getTime();

    }

    /**
     * 根据日期字符串判断当年第几周
     * <功能详细描述>
     * 
     * @param time_str
     *            日期
     * @param pattern
     *            "yyyy-MM-dd"
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Integer getWeekOfYear(String time_str, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sdf.parse(time_str);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("using [" + pattern + "] parse [" + time_str + "] failed");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int mouth = calendar.get(Calendar.MONTH);
        // JDK think 2015-12-31 as 2016 1th week  
        //如果月份是12月，且求出来的周数是第一周，说明该日期实质上是这一年的第53周，也是下一年的第一周  
        if (mouth >= 11 && week <= 1) {
            week += 52;
        }
        return week;
    }

    /**
     * <一句话功能简述> <功能详细描述>
     * 
     * @param startMs
     * @param defaultEndMs
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static double calTimeDifference(long startMs, long defaultEndMs) {
        double returnValue = 0;
        double doubleValue = new BigDecimal((defaultEndMs - startMs)).divide(new BigDecimal((1000 * 3600)), 1,
                BigDecimal.ROUND_DOWN).doubleValue();
        if (0 < doubleValue) {
            returnValue = doubleValue;
        }
        return returnValue;
    }

    /**
     * 计算时间差
     * <功能详细描述>
     * 
     * @param startTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @param pattern
     *            时间格式
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String calTime(String startTime, String endTime, String pattern) {
        String returnValue = "";
        try {
            DateUtil.timeTransform(startTime, pattern, SHOW_DATE_PATTERN);
            DateUtil.timeTransform(endTime, pattern, SHOW_DATE_PATTERN);
            //如果起始时间和终止时间不为空，计算时间差并按规定格式显示
            if (StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime)) {
                long startTimeLong = DateUtil.timeStr2Long(startTime, pattern);
                long endTimeLong = DateUtil.timeStr2Long(endTime, pattern);
                long work_hour_long = endTimeLong - startTimeLong - DateUtil.UTC_8_HOUR_LONG;
                returnValue = DateUtil.long2TimeStr(work_hour_long, pattern);
            }
            return returnValue;
        }
        catch (IllegalArgumentException e) {
            return returnValue;
        }
    }

    public static void main(String[] args) {

    }
}
