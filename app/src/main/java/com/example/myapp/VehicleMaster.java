package com.example.myapp;

import android.provider.BaseColumns;

public final class VehicleMaster {

    private VehicleMaster(){}

    protected static class Vehicles implements BaseColumns{

        public static final String TABLE_NAME="vehicles2";
        public static final String COLUMN_NAME_VID="vid";
        public static final String COLUMN_NAME_PHONE="phone";
        public static final String COLUMN_NAME_PRICE="price";
        public static final String COLUMN_NAME_BRAND="brand";
        public static final String COLUMN_NAME_MODEL="model";
        public static final String COLUMN_NAME_EDITION="edition";
        public static final String COLUMN_NAME_CONDITION="condition";
        public static final String COLUMN_NAME_TRANSMISSION="transmission";
        public static final String COLUMN_NAME_FUEL="fuel";
        public static final String COLUMN_NAME_ENGINE="engine";

        public static final String TABLE_NAME2="jeepTable";
        public static final String COLUMN_NAME_VID2="vid";
        public static final String COLUMN_NAME_PHONE2="phone";
        public static final String COLUMN_NAME_PRICE2="price";
        public static final String COLUMN_NAME_BRAND2="brand";
        public static final String COLUMN_NAME_MODEL2="model";
        public static final String COLUMN_NAME_EDITION2="edition";
        public static final String COLUMN_NAME_CONDITION2="condition";
        public static final String COLUMN_NAME_TRANSMISSION2="transmission";
        public static final String COLUMN_NAME_FUEL2="fuel";
        public static final String COLUMN_NAME_ENGINE2="engine";

        public static final String TABLE_NAME3="bikeTable";
        public static final String COLUMN_NAME_VID3="vid";
        public static final String COLUMN_NAME_PHONE3="phone";
        public static final String COLUMN_NAME_PRICE3="price";
        public static final String COLUMN_NAME_BRAND3="brand";
        public static final String COLUMN_NAME_MODEL3="model";
        public static final String COLUMN_NAME_EDITION3="edition";
        public static final String COLUMN_NAME_CONDITION3="condition";
        public static final String COLUMN_NAME_TRANSMISSION3="transmission";
        public static final String COLUMN_NAME_FUEL3="fuel";
        public static final String COLUMN_NAME_ENGINE3="engine";



    }

}
