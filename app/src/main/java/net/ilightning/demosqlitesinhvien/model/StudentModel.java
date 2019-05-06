package net.ilightning.demosqlitesinhvien.model;

/**
 * Created by Admin on 10/5/2018.
 */

public class StudentModel {

    private int id;
    private String name;
    private int old;
    private String address;
    private String nameClass;
    private int img;



    public StudentModel(String name, int old, String address, String nameClass) {
        this.name = name;
        this.old = old;
        this.address = address;
        this.nameClass = nameClass;

    }

    public StudentModel(String name, int old, String address, String nameClass, int img) {
        this.name = name;
        this.old = old;
        this.address = address;
        this.nameClass = nameClass;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public StudentModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
