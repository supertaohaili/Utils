package www.thl.com.utils;

import android.app.Activity;
import android.text.format.DateUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间格式化
 */
public class DateTimeUtils {

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     **/
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm
     **/
    public static final String DF_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式：yyyy-MM-dd
     **/
    public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式：HH:mm:ss
     **/
    public static final String DF_HH_MM_SS = "HH:mm:ss";

    /**
     * 日期格式：HH:mm
     **/
    public static final String DF_HH_MM = "HH:mm";

    public static final String MM_DD_HH_MM = "MM-dd HH:mm";

    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年

    /**
     * Log输出标识
     **/
    private static final String TAG = DateTimeUtils.class.getSimpleName();

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、刚刚
     *
     * @param date
     * @return
     */
    public static String formatFriendly(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param dateL 日期
     * @return
     */
    public static String formatDateTime(long dateL) {
        SimpleDateFormat sdf = new SimpleDateFormat(DF_YYYY_MM_DD);
        Date date = new Date(dateL);
        return sdf.format(date);
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param dateL 日期
     * @return
     */
    public static String formatDateTime(long dateL, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(new Date(dateL));
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     * 日期
     *
     * @return
     */
    public static String formatDateTime(Date date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(date);
    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    public static Date parseDate(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM_SS);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {
            Log.v(TAG, "parseDate failed !");

        }
        return returnDate;

    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    public static Date parseDate3(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月份");
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {
            Log.v(TAG, "parseDate failed !");

        }
        return returnDate;

    }

    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static Date gainCurrentDate() {
        return new Date();
    }

    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static String gainCurrentDate(String formater) {
        return formatDateTime(new Date(), formater);
    }

    /**
     * 验证日期是否比当前日期早
     *
     * @param target1 比较时间1
     * @param target2 比较时间2
     * @return true 则代表target1比target2晚或等于target2，否则比target2早
     */
    public static boolean compareDate(Date target1, Date target2) {
        boolean flag = false;
        try {
            String target1DateTime = DateTimeUtils.formatDateTime(target1,
                    DF_YYYY_MM_DD_HH_MM_SS);
            String target2DateTime = DateTimeUtils.formatDateTime(target2,
                    DF_YYYY_MM_DD_HH_MM_SS);
            if (target1DateTime.compareTo(target2DateTime) <= 0) {
                flag = true;
            }
        } catch (Exception e1) {
            System.out.println("比较失败，原因：" + e1.getMessage());
        }
        return flag;
    }

    /**
     * 对日期进行增加操作
     *
     * @param target 需要进行运算的日期
     * @param hour   小时
     * @return
     */
    public static Date addDateTime(Date target, double hour) {
        if (null == target || hour < 0) {
            return target;
        }

        return new Date(target.getTime() + (long) (hour * 60 * 60 * 1000));
    }

    /**
     * 对日期进行相减操作
     *
     * @param target 需要进行运算的日期
     * @param hour   小时
     * @return
     */
    public static Date subDateTime(Date target, double hour) {
        if (null == target || hour < 0) {
            return target;
        }

        return new Date(target.getTime() - (long) (hour * 60 * 60 * 1000));
    }


    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    public static Date parseDate2(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(DF_YYYY_MM_DD);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {
            Log.v(TAG, "parseDate failed !");

        }
        return returnDate;
    }

    /**
     * 将日期字符串转成日期
     *
     * @param strDate 字符串日期
     * @return java.util.date日期类型
     */
    public static Date parseDate6(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM_SS);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate+" 23:59:59");
        } catch (ParseException e) {
            Log.v(TAG, "parseDate failed !");

        }
        return returnDate;

    }

    /**
     * 某一个月第一天和最后一天
     * @param date
     * @return
     */
    public static Map<String, String> getFirstday_Lastday_Month(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -0);
        Date theDate = calendar.getTime();

        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);

        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        day_first = str.toString();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last);
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    public static String getLabelStr(Activity mActivity){
        String label = DateUtils.formatDateTime(mActivity.getApplicationContext(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
        return label;
    }
}
