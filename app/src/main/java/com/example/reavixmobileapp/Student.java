package com.example.reavixmobileapp;

import android.provider.BaseColumns;

public class Student {
    private Student() {
    }
    public static final  class  UserDetails implements BaseColumns {
        public static final String TABLE_NAME = "student";
        public static final String COL_ID = "id";
        public static final String COL_NAME_GRUPPA = "name_gruppa";
        public static final String COL_BIOGRAFIA = "biografia";
        public static final String COL_PERSONADATA = "personaldata";
        public static final String COL_XARACTERISTIKA = "xaracteristika";

    }
}
