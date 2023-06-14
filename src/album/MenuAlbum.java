package album;


import java.util.Scanner;
public class MenuAlbum {
    processAlbum albums = processAlbum.getInstance();
    Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("****************************************");
        System.out.println("*     Mời bạn chọn tính năng:          *");
        System.out.println("*     1. Thêm Album                    *");
        System.out.println("*     2. Sửa thông tin Album           *");
        System.out.println("*     3. tìm kiếm Album                *");
        System.out.println("*     4. Xóa Album                     *");
        System.out.println("*     5. Hiển thị danh sách Album      *");
        System.out.println("*     6. Thêm bài hát vào Album        *");
        System.out.println("*     7. Hiển thị bài hát trong Album  *");
        System.out.println("*     8. Xóa bài hát trong Album       *");
        System.out.println("*     0. Thoát chương trình            *");
        System.out.println("****************************************");
    }

    public void doMainMenuAlbum() {
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    albums.addAlbum();
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("chọn Album để sửa");
                    String chooseAlbum2 = sc.nextLine();
                    if(albums.checkAlbum(chooseAlbum2)){
                        albums.fixAlbum(albums.searchAlbumByName(chooseAlbum2));
                    }else System.out.println("không tồn tại Album này");
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("chọn tên Album muốn tìm kiếm: ");
                    String name = sc.nextLine();
                    while (name.equals("")) {
                        System.out.println("tên Album không được để trống, vui lòng nhập lại");
                        name = sc.nextLine();
                    }
                    if(albums.checkAlbum(name)){
                        System.out.println(albums.displayAlbumInfo(albums.searchAlbumByName(name)));
                    }
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 4:
                    albums.removeAlbum();
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 5:
                    albums.displayAlbum();
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("chọn Album muốn thêm bài hát");
                    String nameAlbum = sc.nextLine();
                    if(albums.checkAlbum(nameAlbum)){
                        albums.addSongToAlbum(nameAlbum);
                    }else System.out.println("không tồn tại Album này");
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("chọn Album:");
                    String albumName = sc.nextLine();
                    if(albums.checkAlbum(albumName)){
                        Album album = albums.searchAlbumByName(albumName);
                        System.out.println(albums.showListSong(album));
                    }else System.out.println("không tồn tại Album này");
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("chọn Album:");
                    String delalbumName = sc.nextLine();
                    if(albums.checkAlbum(delalbumName)){
                        albums.removeSong(albums.searchAlbumByName(delalbumName));
                    }else System.out.println("không tồn tại Album này");
                    MenuAlbum.displayMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
            }
        }
        System.out.println("cám ơn bạn đã sử dụng chương trình");
    }
}
