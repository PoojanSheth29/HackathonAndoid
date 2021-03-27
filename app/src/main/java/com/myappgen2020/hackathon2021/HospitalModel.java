package com.myappgen2020.hackathon2021;

public class HospitalModel {

    String email, password, name, area, id;
    Integer nod;
    Integer non;
    Integer beds;
    Integer freeBeds;
    Integer patAdmit;
    Integer actCases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Integer recover;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNod() {
        return nod;
    }

    public void setNod(Integer nod) {
        this.nod = nod;
    }

    public Integer getNon() {
        return non;
    }

    public void setNon(Integer non) {
        this.non = non;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getFreeBeds() {
        return freeBeds;
    }

    public void setFreeBeds(Integer freeBeds) {
        this.freeBeds = freeBeds;
    }

    public Integer getPatAdmit() {
        return patAdmit;
    }

    public void setPatAdmit(Integer patAdmit) {
        this.patAdmit = patAdmit;
    }

    public Integer getActCases() {
        return actCases;
    }

    public void setActCases(Integer actCases) {
        this.actCases = actCases;
    }

    public Integer getRecover() {
        return recover;
    }

    public void setRecover(Integer recover) {
        this.recover = recover;
    }
}
