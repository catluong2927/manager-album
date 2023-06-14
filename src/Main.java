import album.MenuAlbum;
import song.*;
import album.*;
import person.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuSong a = new MenuSong();
        MenuAlbum b = new MenuAlbum();
        MenuPeople c = new MenuPeople();
        c.displayMenuPeople();
        c.doMainMenuPeople();

    }
}
