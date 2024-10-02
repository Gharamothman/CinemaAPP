package theend;

import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {

    private String username;
    private String password;
    private String age;
    private String gender;
///// this is about constructer:

    public User(String username, String password, String age, String gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    ////// this is about store the inf user in objectfile :
    public static void saveUsersToFile(String fileName, ArrayList users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Object user : users) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println("something happen when we write in file user ");
        }
    }
    ///// this is about read info from objectfile:

    public static ArrayList readUsersFromFile(String fileName) {
        ArrayList newuser= new ArrayList();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            
            while (true) {
                try {
                    User user = (User) objectInputStream.readObject();
                    
                    newuser.add(user);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newuser;
    }
    //// this ios about getter and setter:

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
