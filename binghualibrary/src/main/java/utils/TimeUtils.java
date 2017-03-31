package utils;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    /**
     * 时间戳转换为日期格式
     * @param timestamp 时间戳
     * @param formats 日期格式
     * @return
     */
    public static String timeStamp2Date(@NonNull String timestamp, @NonNull String formats) {
        String date = "";
        try {
            date = new SimpleDateFormat(formats)
                    .format(new Date(Long.parseLong(timestamp) * 1000));
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 时间戳转换为日期 "yyyy-MM-dd"
     * @param timestamp 时间戳
     * @return
     */
    public static String timeStamp2Date(@NonNull String timestamp ) {
        return timeStamp2Date(timestamp,"yyyy-MM-dd" );
    }

    /**
     * 时间戳转换为日期 "yyyy-MM-dd HH:mm"
     * @param timestamp
     * @return
     */
    public static String timeStamp2DateMinute(@NonNull String timestamp ) {
        return timeStamp2Date(timestamp,"yyyy-MM-dd HH:mm" );
    }

    /**
     * 日期与当前相比较
     *
     * @param timestamp 时间戳(秒)
     * @return 返回给定格式的时间，或者 7天内的提示
     */
    public static String GetTimeDifference(long timestamp, String formats) {
        try {

            SimpleDateFormat df = new SimpleDateFormat(formats);
            Date now = new Date();
            Date date = new Date(timestamp * 1000);
            String szDate = df.format(date);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

            if (day > 7) {
                return szDate;
            } else if (day > 0) {
                return day + "天前";
            } else if (hour > 0) {
                return hour + "小时前";
            } else if (min > 0) {
                return min + "分钟前";
            } else if (s > 0) {
                return min + "秒前";
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 日期与当前相比较
     *
     * @param timestamp
     * @return "yyyy-MM-dd"的时间或者 7天内的提示
     */
    public static String GetTimeDifference(long timestamp) {
        return GetTimeDifference(timestamp, "yyyy-MM-dd");
    }

    /**
     * 日期与当前相比较
     *
     * @param timestamp
     * @return "yyyy-MM-dd"的时间或者 7天内的提示
     */
    public static String GetTimeDifference(String timestamp) {
        try {
            return GetTimeDifference(Long.parseLong(timestamp));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 得到当前时间
     * @param dateFormat 时间格式
     * @return 转换后的时间格式
     */
    public static String getStringToday(String dateFormat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将字符串型日期转换成日期
     * @param dateStr 字符串型日期
     * @param dateFormat 日期格式
     * @return
     */
    public static Date stringToDate(String dateStr, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期转字符串
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    /**
     * 两个时间点的间隔时长（分钟）
     * @param before 开始时间
     * @param after 结束时间
     * @return 两个时间点的间隔时长（分钟）
     */
    public static long compareMin(Date before, Date after) {
        if (before == null || after == null) {
            return 0l;
        }
        long dif = 0;
        if(after.getTime() >= before.getTime()) {
            dif = after.getTime() - before.getTime();
        }else if(after.getTime() < before.getTime()){
            dif = after.getTime() + 86400000 - before.getTime();
        }
        dif = Math.abs(dif);
        return dif  / 60000;
    }

    /**
     * 获取指定时间间隔分钟后的时间
     * @param date 指定的时间
     * @param min 间隔分钟数
     * @return 间隔分钟数后的时间
     */
    public static Date addMinutes(Date date, int min) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 根据时间返回指定术语，自娱自乐，可自行调整
     * @param hourday 小时
     * @return
     */
    public static String showTimeView(int hourday) {
        if(hourday >= 22 && hourday <= 24){
            return "晚上";
        }else if(hourday >= 0 && hourday <= 6 ){
            return  "凌晨";
        }else if(hourday > 6 && hourday <= 12){
            return "上午";
        }else if(hourday >12 && hourday < 22){
            return "下午";
        }
        return null;
    }

}
