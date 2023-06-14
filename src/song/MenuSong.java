package song;

import java.util.Scanner;

public class MenuSong {
    processSong songs = processSong.getInstance();
    Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("*****************************************");
        System.out.println("*     Mời bạn chọn tính năng:           *");
        System.out.println("*     1. Thêm bài hát:                  *");
        System.out.println("*     2. Sửa thông tin bài hát          *");
        System.out.println("*     3. tìm kiếm bài hát theo tên      *");
        System.out.println("*     4. Xóa bài hát                    *");
        System.out.println("*     5. Hiển thị danh sách bài hát     *");
        System.out.println("*     6. Tìm kiếm bài hát theo ca sĩ    *");
        System.out.println("*     5. Tìm kiếm bài hát theo nhạc sĩ  *");
        System.out.println("*     0. Thoát chương trình             *");
        System.out.println("*****************************************");
    }

    public void doMainMenuSong() {
        int choice = sc.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    songs.addSong();
                    MenuSong.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 2:
                    songs.fixSong();
                    MenuSong.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 3:
                    System.out.println("chọn tên bài hát muốn tìm kiếm: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    while (name.equals("")) {
                        System.out.println("tên bài hát không được để trống, vui lòng nhập lại");
                        name = sc.nextLine();
                    }
                    System.out.println(songs.searchSongName(name));
                    MenuSong.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 4:
                    songs.removeSong();
                    MenuSong.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 5:
                    songs.displayListSong();
                    MenuSong.displayMenu();
                    choice = sc.nextInt();
                    break;
                case 6:
                    songs.searchSongSinger();
                    choice = sc.nextInt();
                    break;
                case 7:
                    songs.searchSongComposer();
                    choice = sc.nextInt();
                    break;
                default:
                    System.out.println("vui lòng nhập đúng chức năng");
                    choice = sc.nextInt();
                    break;
            }
        }
        System.out.println("cám ơn bạn đã sử dụng chương trình");
    }
}
