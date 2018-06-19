package org.zealot.fireflycommon.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {

    public static String getIndexCode() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString();
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());

        stringBuilder.append(uuid.substring(0, 8));
        stringBuilder.append(sdf);
        return stringBuilder.toString();
    }
}
