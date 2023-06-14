package person;

import album.*;
import song.Song;
import song.processSong;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class processPeople {
    processAlbum listAlbum = processAlbum.getInstance();
    int count;
    private static processPeople instance;

    private List<People> listPeople;

    private processPeople() {
        listPeople = new LinkedList<>();
//        listAlbum.add(new Album("trân","japan"));
//        listAlbum.add(new Album("phong","english"));
    }

    public List<People> getListPeople() {
        return listPeople;
    }

    public static processPeople getInstance() {
        if (instance == null) {
            instance = new processPeople();
        }
        return instance;
    }

    Scanner sc = new Scanner(System.in);

    public boolean checkPeople(String obj) {
        boolean checksinger = false;
        if (!listPeople.isEmpty()) {
            for (int i = 0; i < listPeople.size(); i++) {
                if (listPeople.get(i).getName().equals(obj)) {
                    checksinger = true;
                }
            }
        }
        return checksinger;
    }

    public boolean checkSinger(String obj) {
        boolean checksinger = false;
        if (!listPeople.isEmpty()) {
            for (int i = 0; i < listPeople.size(); i++) {
                if (listPeople.get(i).getName().equals(obj)) {
                    checksinger = true;
                }
            }
        }
        return checksinger;
    }

    public boolean checkComposer(String obj) {
        boolean checkcomposer = false;
        if (!listPeople.isEmpty()) {
            for (int i = 0; i < listPeople.size(); i++) {
                if (listPeople.get(i).getName().equals(obj)) {
                    checkcomposer = true;
                }
            }
        }
        return checkcomposer;
    }

    public int countPeople(String name) {
        int count = 0;
        for (People element : listPeople) {
            if (element.getName().equals(name)) count++;
        }
        return count;
    }

    public People searchPeoplebyName(String name) {
        for (People element : listPeople) {
            if (element.getName().equals(name)) return element;
        }
        return null;
    }

    public People searchPeoplebyId(int id) {
        People result = null;
        for (int i = 0; i < listPeople.size(); i++) {
            if (listPeople.get(i).getId() == id) result = listPeople.get(i);
        }
        return result;
    }

    public void addPeople() {
        int size;
        if (listPeople.size() == 0) size = 0;
        else size = listPeople.size();
        System.out.println("nhập số lượng đối tượng muốn tạo:");
        int numAlbum = sc.nextInt();
        sc.nextLine();
        for (int i = size, k = 1; i < numAlbum && k <= numAlbum; i++, k++) {
            System.out.println("nhập tên đối tượng thứ: " + k + ":");
            String name = sc.nextLine();
            System.out.println("nhập tuổi:");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("nhập giới tính:");
            String gender = sc.nextLine();
            System.out.println("nhập vai trò");
            String role = sc.nextLine();
            listPeople.add(new People(name, age, gender, role));
        }
    }

    public void addAlbumToList(String name) {
        People choosePeople = searchPeoplebyName(name);
        int count = countPeople(choosePeople.getName());
        if (count == 1) {
            System.out.println("chọn Album muốn thêm");
            String nameAlbum = sc.nextLine();
            if (listAlbum.checkAlbum(nameAlbum)) {
                Album chooseAlbum = listAlbum.searchAlbumByName(nameAlbum);
                choosePeople.setListPeople(chooseAlbum.getId());
                System.out.println("bạn đã thêm thành công");
            } else System.out.println("Album không tồn tại");
        } else {
            if (count > 1) {
                System.out.println("đối tượng bị trùng tên");
                for (People element : listPeople) {
                    if (checkPeople(element.getName())) displayPeopleInfo(element);
                }
                System.out.println("nhập Id đối tượng muốn thêm");
                int chooseId = sc.nextInt();
                sc.nextLine();
                People objId = searchPeoplebyId(chooseId);
                System.out.println("chọn Album muốn thêm");
                String nameAlbum = sc.nextLine();
                if (listAlbum.checkAlbum(nameAlbum)) {
                    Song chooseSong = processSong.getInstance().searchSongName(nameAlbum);
                    choosePeople.setListPeople(chooseSong.getId());
                    System.out.println("đã thêm thành công");
                } else System.out.println("Album không tồn tại");
            } else System.out.println("không tìm thấy đối tượng để thêm");
        }
    }

    public String displayPeopleInfo(People obj) {
        return "Id: " + obj.getId() + " - Tên: " + obj.getName() + " - vai trò: " + obj.getRole() + "\n"
                + "danh sách Album" + "\n" + showListAlbum(obj);

    }

    public void displayPeople() {
        if (!listPeople.isEmpty()) {
            for (People element : listPeople) {
                System.out.println(displayPeopleInfo(element));
            }
        } else System.out.println("danh sách đang trống");
    }

    public void fixPeople(People obj) {
        int count = countPeople(obj.getName());
        if (count == 1) {
            System.out.println("chọn thông tin bạn muốn sửa (tên - tuổi - giới tính - vai trò - album)");
            String fixInfor = sc.nextLine().toLowerCase();
            switch (fixInfor) {
                case "tên":
                    System.out.println("tên mới là gì?");
                    String name = sc.nextLine();
                    obj.setName(name);
                    break;
                case "tuổi":
                    System.out.println("bao nhiêu tuổi");
                    int age = sc.nextInt();
                    sc.nextLine();
                    obj.setAge(age);
                    break;
                case "giới tính":
                    System.out.println("giới tính là gì?");
                    String gender = sc.nextLine();
                    obj.setGender(gender);
                    break;
                case "vai trò":
                    System.out.println("vai trò là gì?");
                    String role = sc.nextLine();
                    obj.setRole(role);
                    break;
                case "album":
                    MenuAlbum.displayMenu();
                    new MenuAlbum().doMainMenuAlbum();
                    break;
            }
        } else {
            if (count > 1) {
                System.out.println("đối tượng này bị trùng tên:");
                displayPeopleInfo(obj);
                System.out.println("chọn Id Album muốn cập nhât:");
                int chooseId = sc.nextInt();
                sc.nextLine();
                People choosePeople = searchPeoplebyId(chooseId);
                System.out.println("chọn thông tin bạn muốn sửa (tên - dòng nhạc - album)");
                String fixInfor = sc.nextLine().toLowerCase();
                switch (fixInfor) {
                    case "tên":
                        System.out.println("tên mới là gì?");
                        String name = sc.nextLine();
                        choosePeople.setName(name);
                        break;
                    case "tuổi":
                        System.out.println("tuổi đối tượng");
                        int age = sc.nextInt();
                        sc.nextLine();
                        choosePeople.setAge(age);
                        break;
                    case "giới tính":
                        System.out.println("giới tính là gì?");
                        String gender = sc.nextLine();
                        choosePeople.setGender(gender);
                        break;
                    case "vai trò":
                        System.out.println("vai trò là gì?");
                        String role = sc.nextLine();
                        choosePeople.setRole(role);
                        break;
                    case "album":
                        MenuAlbum.displayMenu();
                        new MenuAlbum().doMainMenuAlbum();
                        break;
                }
            } else System.out.println("không tìm thấy đối tượng để sửa");
        }
    }


    public void removePeople() {
        System.out.println("chọn đối tượng muốn xóa");
        String choosePeople = sc.nextLine();
        int count = countPeople(choosePeople);
        if (count == 1) {
            for (People element : listPeople) {
                if (element.getName().equals(choosePeople)) {
                    listPeople.remove(element);
                    System.out.println("bạn đã xóa thành công");
                }
            }
        } else {
            if (count > 1) {
                System.out.println("bài hát này bị trùng tên:");
                System.out.println(displayPeopleInfo(searchPeoplebyName(choosePeople)));
                System.out.println("chọn Id muốn xóa:");
                int chooseId = sc.nextInt();
                sc.nextLine();
                for (People element : listPeople) {
                    if (element.getId() == chooseId) {
                        listPeople.remove(element);
                        System.out.println("bạn đã xóa thành công");
                    }
                }
            } else System.out.println("không tìm thấy đối tượng này để xóa");
        }
    }

    public String showListAlbum(People obj) {
        String text = null;
        Album albums;
        for (int element : obj.getListAlbum()) {
            albums = processAlbum.getInstance().searchAlbumById(element);
            text = processAlbum.getInstance().displayAlbumInfo(albums);
        }
        return text;
    }

    public void removeAlbum(People obj) {
        System.out.println(showListAlbum(obj));
        System.out.println("chọn số lượng Album muốn xóa");
        int num = sc.nextInt();
        sc.nextLine();
        if (showListAlbum(obj) != null) {
            for (int i = 0; i < num; i++) {
                System.out.println("chọn id thứ " + (i + 1) + " muốn xóa");
                int chooseId = sc.nextInt();
                sc.nextLine();
                if (obj.getListAlbum().get(i) == chooseId) obj.getListAlbum().remove(i);
            }
        } else System.out.println("đối tượng đang không có Album nào");
    }

}
