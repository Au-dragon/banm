package com.example.banmi.base;

import android.os.Environment;

import java.io.File;

/**
 * Created by asus on 2019/3/5.
 */

public interface Constants {
    boolean isDebug = true;


    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
    String DATA = "data";
    //夜间模式
    String MODE = "mode";
    String NIGHT_CURRENT_FRAG_POS = "fragment_pos";
    String DATE="date";

    String TOKEN = "token";
    String DESC = "description";
    String USERNAME = "userName";
    String GENDER = "gender";
    String EMAIL = "email";
    String PHOTO = "photo";
    String PHONE = "phone";
    String AVATAR_HD = "avatar_hd";
    String TYPE = "type";
    String USER_NAME = "user_name";
    String VERIFY_CODE = "verify_code";
    String PERSONALIZED_SIGNATURE = "personalized_signature";
    String CONTENT = "contnet";
    String INTRODUCTION = "introduction";
    String ID = "id";
    String BALANCE = "balance";

    String URL = "url";
    String TITLE = "title";
    String CITY = "city";
    String CITY_ID = "city_id";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String SPOT_ID = "spotId";
}
