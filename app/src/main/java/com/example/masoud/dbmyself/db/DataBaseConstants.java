package com.example.masoud.dbmyself.db;

public class DataBaseConstants {

    public static final String DATABASE_NAME = "parmas";
    public static final int DATABASE_VARSION = 1;

    public static final String TABLE_NAME = "table_add_person";

    public static final String COLUMN_PERSON_ID = "_id";
    public static final String COLUMN_PERSON_NAME = "person_name";
    public static final String COLUMN_PERSON_FAMILY = "person_family";
    public static final String COLUMN_PERSON_PHONEMNUM = "person_phonnum";
    public static final String COLUMN_PERSON_IMAGE_PATH = "person_image";

    public static final String TABLE_CREATE =
            "create table " + TABLE_NAME +
                    " (" +
                    COLUMN_PERSON_ID + " integer," +
                    COLUMN_PERSON_NAME + " text," +
                    COLUMN_PERSON_FAMILY + " text," +
                    COLUMN_PERSON_PHONEMNUM + " text," +
                    COLUMN_PERSON_IMAGE_PATH + " text" +
                    ");";

}
