package person;

import album.Album;

import java.util.ArrayList;
import java.util.List;


public class People {
    private static int size = 0;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String role;
    private List<Integer> listAlbum;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setListPeople(int album) {
        this.listAlbum.add(album);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRole() {
        return role;
    }

    public List<Integer> getListAlbum() {
        return listAlbum;
    }

    public People(String name, int age, String gender, String role){
        int id = size++;
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.listAlbum = new ArrayList<>();
    }
}
