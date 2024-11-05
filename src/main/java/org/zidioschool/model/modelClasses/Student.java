// Student.java
package org.zidioschool.model.modelClasses;

import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String phone1;
    private String phone2;
    private String email;
    private String guardianPhone1;
    private String guardianPhone2;
    private String guardianEmail;
    private int classId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuardianPhone1() {
        return guardianPhone1;
    }

    public void setGuardianPhone1(String guardianPhone1) {
        this.guardianPhone1 = guardianPhone1;
    }

    public String getGuardianPhone2() {
        return guardianPhone2;
    }

    public void setGuardianPhone2(String guardianPhone2) {
        this.guardianPhone2 = guardianPhone2;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public String getClassName(List<Clss> classes) {
        for (Clss c : classes) {
            if (c.getId() == classId) {
                return c.getClassName();
            }
        }
        return null;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}