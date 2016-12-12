package com.example.masoud.dbmyself.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.masoud.dbmyself.model.Person;

import java.util.List;
import java.util.StringTokenizer;

public class DataBaseOperation implements PersonDBDAO{
    private SQLiteDatabase db;

    public DataBaseOperation(Context context){
        DataBaseOpenHelper helper = new DataBaseOpenHelper(context);
        db = helper.getWritableDatabase();
    }



    @Override
    public void AddPerson(Person person) {

        ContentValues values = new ContentValues();
        values.put(DataBaseConstants.COLUMN_PERSON_NAME , person.getName());
        values.put(DataBaseConstants.COLUMN_PERSON_FAMILY , person.getFamily());
        values.put(DataBaseConstants.COLUMN_PERSON_PHONEMNUM , person.getPhonenum());
        db.insert(DataBaseConstants.TABLE_NAME , null , values);
    }

    @Override
    public void DeletPerson(Person person) {

        int delete = db.delete(DataBaseConstants.TABLE_NAME , DataBaseConstants.COLUMN_PERSON_ID + " =?" ,
                new String[]{String.valueOf(person.getId())});
    }

    @Override
    public void UpdataPerson(Person person) {

    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }
}
