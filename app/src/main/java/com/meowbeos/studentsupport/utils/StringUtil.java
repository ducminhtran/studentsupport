package com.meowbeos.studentsupport.utils;

import android.util.Log;

import com.meowbeos.studentsupport.constants.STConstant;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class StringUtil {

    public static boolean containsIgnoreCase(String[] array, String value) {
        for (String str : array) {
            if (value == null && str == null) return true;
            if (value != null && value.equalsIgnoreCase(str)) return true;
        }
        return false;
    }

    public static String generateAPIKey() {
        String apiKey = STConstant.APY_KEY;

        try {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.MINUTE, 21);
            SimpleDateFormat formatDate = new SimpleDateFormat(STConstant.PATTERT_DATE_HASH);
            String keyHash = formatDate.format(now.getTime()) + "meow";
            //TODO ENCODE
            apiKey = keyHash;

        }catch (Exception ex)
        {
            Log.d(TAG, "generateAPIKey: ERROR", ex);
        }
        return apiKey;
    }
}
