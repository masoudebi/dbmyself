package com.example.masoud.dbmyself.db;


import com.example.masoud.dbmyself.model.Person;

import java.util.List;

public interface PersonDBDAO {

    void AddPerson(Person person);
    void DeletPerson (Person person);
    void UpdataPerson(Person person);

    List<Person> getAllPerson();
}
