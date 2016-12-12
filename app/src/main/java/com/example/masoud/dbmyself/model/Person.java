package com.example.masoud.dbmyself.model;


import android.graphics.Bitmap;

public class Person {

    String name, family, phonenum, image_path;
    int id;
    Bitmap avatar;

    public Person(String name, String family, String phonenum, String image_path, int id, Bitmap avatar) {
        this.name = name;
        this.family = family;
        this.phonenum = phonenum;
        this.image_path = image_path;
        this.id = id;
        this.avatar = avatar;
    }

    public Person(String name, String family, String phonenum, String image_path, Bitmap avatar) {
        this.name = name;
        this.family = family;
        this.phonenum = phonenum;
        this.image_path = image_path;
        this.avatar = avatar;
    }

    public Person() {
    }

    public Person(String name, String family, String phonenum) {

    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public Person setPhonenum(String phonenum) {
        this.phonenum = phonenum;
        return this;
    }

    public String getImage_path() {
        return image_path;
    }

    public Person setImage_path(String image_path) {
        this.image_path = image_path;
        return this;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        id = id;
        return this;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public Person setAvatar(Bitmap avatar) {
        this.avatar = avatar;
        return this;
    }
}
