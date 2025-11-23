package com.seohan1010.ch8_4.to;

import java.time.LocalDate;
import java.util.Objects;

public class UserDto {

   private String email;
   private String name;
   private String password;
   private LocalDate birthDate;
   private LocalDate regDate;
   private String sns;


    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", regDate=" + regDate +
                ", sns='" + sns + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(email, userDto.email) && Objects.equals(name, userDto.name) && Objects.equals(password, userDto.password) && Objects.equals(birthDate, userDto.birthDate) && Objects.equals(regDate, userDto.regDate) && Objects.equals(sns, userDto.sns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, birthDate, regDate, sns);
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }
}
