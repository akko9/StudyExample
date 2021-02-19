package com.example.demo.entity;

public class User {
    private String Id;
    private String nickname;
    private Integer age;

    public User() {
    }

    public User(String Id, String nickname, Integer age) {
        this.Id = Id;
        this.nickname = nickname;
        this.age = age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
