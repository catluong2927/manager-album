package album;

import java.util.*;

public class Album {
    static int SIZE = 0;
    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private String typeAlbum;
    private List<Integer> songs;

    public void setName(String name) {
        this.name = name;
    }
    public void setTypeAlbum(String typeAlbum) {
        this.typeAlbum = typeAlbum;
    }

    public void setSongs(int obj) {
        this.songs.add(obj);
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getTypeAlbum() {
        return this.typeAlbum;
    }

    public List<Integer> getSongs() {
        return songs;
    }
    public Album(String name, String typealbum) {
        int id = SIZE++;
        this.id = id;
        this.name = name;
        this.typeAlbum = typealbum;
        this.songs = new LinkedList<>();
    }

}
