package album;

import song.MenuSong;
import song.Song;
import song.processSong;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class processAlbum {
    processSong listSong = processSong.getInstance();
    int count;
    private static processAlbum instance;

    private List<Album> listAlbum;

    private processAlbum() {
        listAlbum = new LinkedList<>();
        listAlbum.add(new Album("trân", "japan"));
        listAlbum.add(new Album("phong", "english"));
    }

    public List<Album> getListAlbum() {
        return listAlbum;
    }

    public static processAlbum getInstance() {
        if (instance == null) {
            instance = new processAlbum();
        }
        return instance;
    }

    Scanner sc = new Scanner(System.in);

    public boolean checkAlbum(String obj) {
        boolean check = false;
        if (!listAlbum.isEmpty()) {
            for (int i = 0; i < listAlbum.size(); i++) {
                if (listAlbum.get(i).getName().equals(obj)) {
                    check = true;
                }
            }
        }
        return check;
    }

    public int countAlbum(String name) {
        int count = 0;
        for (Album element : listAlbum) {
            if (element.getName().equals(name)) count++;
        }
        return count;
    }

    public Album searchAlbumByName(String name) {
        for (Album element : listAlbum) {
            if (element.getName().equals(name)) return element;
        }
        return null;
    }

    public Album searchAlbumById(int id) {
        Album result = null;
        for (int i = 0; i < listAlbum.size(); i++) {
            if (listAlbum.get(i).getId() == id) result = listAlbum.get(i);
        }
        return result;
    }

    public void addAlbum() {
        int size;
        if (listAlbum.size() == 0) size = 0;
        else size = listAlbum.size();
        System.out.println("nhập số lượng Album muốn tạo:");
        int numAlbum = sc.nextInt();
        sc.nextLine();
        for (int i = size, k = 1; (i-size) < numAlbum && k <= numAlbum; i++, k++) {
            System.out.println("nhập tên Album thứ: " + k + ":");
            String name = sc.nextLine();
            System.out.println("dòng nhạc cho bộ sưu tập:");
            String type = sc.nextLine();
            listAlbum.add(new Album(name, type));
        }
    }

    public void addSongToAlbum(String name) {
        Album chooseAlbum = searchAlbumByName(name);
        int count = countAlbum(chooseAlbum.getName());
        if (count == 1) {
            System.out.println("chọn bài hát muốn thêm");
            String nameSong = sc.nextLine();
            if (listSong.checkSong(nameSong)) {
                Song chooseSong = listSong.searchSongName(nameSong);
                chooseAlbum.setSongs(chooseSong.getId());
                System.out.println("đã thêm thành công");
            } else System.out.println("thêm thất bại, vì bài hát không tồn tại");
        } else {
            if (count > 1) {
                System.out.println("Album bị trùng tên");
                for (Album element : listAlbum) {
                    if (checkAlbum(element.getName())) displayAlbumInfo(element);
                }
                System.out.println("nhập Id Album muốn thêm");
                int chooseId = sc.nextInt();
                sc.nextLine();
                Album objId = searchAlbumById(chooseId);
                System.out.println("chọn bài hát muốn thêm");
                String nameSong = sc.nextLine();
                if (listSong.checkSong(nameSong)) {
                    Song chooseSong = processSong.getInstance().searchSongName(nameSong);
                    chooseAlbum.setSongs(chooseSong.getId());
                    System.out.println("đã thêm thành công");
                } else System.out.println("thêm thất bại, vì bài hát không tồn tại");
            } else System.out.println("không tìm thấy Album này để thêm");
        }
    }

    public String displayAlbumInfo(Album obj) {
        return "Id: " + obj.getId() + " - Tên Album: " + obj.getName() + " - Thể loại: " + obj.getTypeAlbum() + "\n"
                + "danh sách bài hát" + "\n" + showListSong(obj);

    }

    public void displayAlbum() {
        if (!listAlbum.isEmpty()) {
            for (Album element : listAlbum) {
                System.out.println(displayAlbumInfo(element));
            }
        } else System.out.println("danh sách đang trống");
    }

    public void fixAlbum(Album obj) {
        int count = countAlbum(obj.getName());
        if (count == 1) {
            if(!obj.getSongs().isEmpty()){
                System.out.println("chọn thông tin bạn muốn sửa (tên - dòng nhạc - bài hát)");
                String fixInfor = sc.nextLine().toLowerCase();
                switch (fixInfor) {
                    case "tên":
                        System.out.println("tên mới là gì?");
                        String name = sc.nextLine();
                        obj.setName(name);
                        break;
                    case "dòng nhạc":
                        System.out.println("bộ sưu tập về chủ đề gì?");
                        String type = sc.nextLine();
                        obj.setTypeAlbum(type);
                        break;
                    case "bài hát":
                        MenuSong.displayMenu();
                        new MenuSong().doMainMenuSong();
                        break;
                }
            }else System.out.println("bạn chưa có Album này, bạn cần tạo nó");
        } else {
            if (count > 1) {
                if(!obj.getSongs().isEmpty()){
                    System.out.println("Album này bị trùng tên:");
                    displayAlbumInfo(obj);
                    System.out.println("chọn Id Album muốn cập nhât:");
                    int chooseId = sc.nextInt();
                    sc.nextLine();
                    Album chooseAlbum = searchAlbumById(chooseId);
                    System.out.println("chọn thông tin bạn muốn sửa (tên - dòng nhạc - sửa danh mục bài hát)");
                    String fixInfor = sc.nextLine().toLowerCase();
                    switch (fixInfor) {
                        case "tên":
                            System.out.println("tên mới là gì?");
                            String name = sc.nextLine();
                            chooseAlbum.setName(name);
                            break;
                        case "dòng nhạc":
                            System.out.println("bộ sưu tập về chủ đề gì?");
                            String type = sc.nextLine();
                            chooseAlbum.setTypeAlbum(type);
                            break;
                        case "bài hát":
                            MenuSong.displayMenu();
                            new MenuSong().doMainMenuSong();
                            break;
                    }
                }else System.out.println("bạn chưa có Album này, bạn cần tạo nó");
            } else System.out.println("không tìm thấy Album này để sửa");
        }
    }


    public void removeAlbum() {
        System.out.println("chọn Album muốn xóa");
        String chooseAlbum = sc.nextLine();
        int count = countAlbum(chooseAlbum);
        if (count == 1) {
            for (Album element : listAlbum) {
                if (element.getName().equals(chooseAlbum)) {
                    listAlbum.remove(element);
                    System.out.println("bạn đã xóa thành công");
                }

            }
        } else {
            if (count > 1) {
                System.out.println("bài hát này bị trùng tên:");
                System.out.println(displayAlbumInfo(searchAlbumByName(chooseAlbum)));
                System.out.println("chọn Id muốn xóa:");
                int chooseId = sc.nextInt();
                sc.nextLine();
                for (Album element : listAlbum) {
                    if (element.getId() == chooseId) {
                        listAlbum.remove(element);
                        System.out.println("bạn đã xóa thành công");
                    }
                }
            } else System.out.println("không tìm thấy Album này để xóa");
        }
    }

    public String showListSong(Album obj) {
        String text = null;
        Song song;
        for (int element : obj.getSongs()) {
            song = processSong.getInstance().searchAlbumId(element);
            text = processSong.getInstance().displaySong(song);
        }
        return text;
    }

    public void removeSong(Album obj) {
        System.out.println(showListSong(obj));
        System.out.println("chọn số lượng bài hát muốn xóa");
        int num = sc.nextInt();
        sc.nextLine();
        if (showListSong(obj) != null) {
            for (int i = 0; i < num; i++) {
                System.out.println("chọn id thứ " + (i + 1) + " muốn xóa");
                int chooseId = sc.nextInt();
                sc.nextLine();
                if (obj.getSongs().get(i) == chooseId) obj.getSongs().remove(i);
            }
        } else System.out.println("album này đang rỗng");
    }

}
