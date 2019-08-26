package com.userpanel.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    @NotNull
    @Size(max = 15,min = 3,message = "Lütfen en az 3 , en fazla 15 karakter giriniz.")
    private String name;

    @NotNull
    @Size(max = 15,min = 3,message = "Lütfen en az 3 , en fazla 15 karakter giriniz.")
    private String surname;

    @NotNull
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
