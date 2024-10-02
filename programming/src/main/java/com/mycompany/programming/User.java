
package com.mycompany.programming;


import java.io.*;

public class User implements Serializable {
    private String username;
    private String password;
    private int age;
    private String gender;

    public User(String username, String password, int age, String gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    // تابع لحفظ معلومات المستخدمين في ملف
    public static void saveUsersToFile(String fileName, User... users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // تابع لقراءة معلومات المستخدمين من ملف
    public static void readUsersFromFile(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    User user = (User) objectInputStream.readObject();
                    System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword() +
                            ", Age: " + user.getAge() + ", Gender: " + user.getGender());
                } catch (EOFException e) {
                    // يتم رمي EOFException عندما يتم الوصول إلى نهاية الملف
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
