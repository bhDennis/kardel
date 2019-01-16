package utils;


import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

    public static <T> Constructor<T> accessibleConstructor(Class<T> clazz,Class<?>...parameterTypes) throws NoSuchMethodException {

        Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);

        if(!Modifier.isPublic(constructor.getModifiers())){
            constructor.setAccessible(true);
        }
        if(!Modifier.isPublic(constructor.getDeclaringClass().getModifiers()) && !constructor.isAccessible()){
            constructor.setAccessible(true);
        }
        return constructor;
    }

    public static Calendar getSomeCalendar(Date timePoint, int hour, int minute, int second , int milliSecond) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(timePoint);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND,milliSecond);

        return calendar;
    }

    public static Date getDate(String date){
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date transferDate = sf.parse(date);
            return transferDate;
        } catch (ParseException e) {
            throw new RuntimeException("时间转换失败");
        }
    }
}
