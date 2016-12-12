package com.example.masoud.dbmyself;


import android.app.Application;

import com.example.masoud.dbmyself.db.DataBaseOperation;
import com.example.masoud.dbmyself.db.PersonDBDAO;

public class myapplication extends Application {

    private static DataBaseOperation operation;

    @Override
    public void onCreate() {

        operation = new DataBaseOperation(this);
        super.onCreate();
    }

    public static PersonDBDAO getPersonDBDAO(){
        return operation;

    }
}
