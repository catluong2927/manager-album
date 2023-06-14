package song;

import java.util.*;

public class processSong {
    int count;
    private static processSong instance;

    private List<Song> listSong;

    private processSong() {
        listSong = new LinkedList<>();
        listSong.add(new Song("phong","ưefwer","ưefewf","aẻherh","èwefe"));
        listSong.add(new Song("hieu","ưefwer","ưefewf","aẻherh","èwefe"));
        listSong.add(new Song("luong","ưefwer","ưefewf","aẻherh","èwefe"));
        listSong.add(new Song("trân","ưefwer","ưefewf","aẻherh","èwefe"));
        listSong.add(new Song("luong","ưádasd","ưefthj","aẻherh","èwefe"));
    }

    public List<Song> getListSong() {
        return listSong;
    }

    public static processSong getInstance() {
        if (instance == null) {
            instance = new processSong();
        }
        return instance;
    }

    Scanner sc = new Scanner(System.in);

    public boolean checkSong(String word) {
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getName().equals(word)) {
                return true;
            }
        }
        return false;
    }

    public Song searchSongName(String name) {
        Song result = null;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getName().equals(name)) result = listSong.get(i);
        }
        return result;
    }

    public String displaySongInfo(Song obj) {
        return "Id: " + obj.getId() + " - Tên bài hát: " + obj.getName() + " - Thể loại nhạc: " + obj.getTypeMusic() + " - Thời lượng: " + obj.getTime() +
                " - ca sĩ: " + obj.getSinger() + " - nhạc sĩ: " + obj.getComposer() + "\n";

    }

    public void displayListSong() {
        if (!listSong.isEmpty()) {
            for (Song element : listSong) {
                System.out.println(displaySongInfo(element));
            }
        } else System.out.println("danh sách đang trống");
    }

    public void fixSong() {
        int count;
        System.out.println("chọn bài hát bạn muốn sửa:");
        String chooseSong = sc.nextLine();
        count = duplicate(chooseSong);
        if (count == 1) {
            for (int i = 0; i < listSong.size(); i++) {
                if (listSong.get(i).getName().equals(chooseSong)) {
                    Song obj = listSong.get(i);
                    System.out.println("chọn thông tin bạn muốn sửa (tên - dòng nhạc - thời lượng - ca sĩ  - nhạc sĩ)");
                    String fixInfor = sc.nextLine().toLowerCase();
                    switch (fixInfor) {
                        case "tên":
                            System.out.println("tên mới là gì?");
                            String name = sc.nextLine();
                            obj.setName(name);
                            break;
                        case "dòng nhạc":
                            System.out.println("dòng nhạc là gì?");
                            String type = sc.nextLine();
                            obj.setTypeMusic(type);
                            break;
                        case "thời lượng":
                            System.out.println("thời lượng bao lâu?");
                            String time = sc.nextLine();
                            obj.setTime(time);
                            break;
                        case "ca sĩ":
                            System.out.println("ca sĩ thể hiện:");
                            String singer = sc.nextLine();
                            obj.setSinger(singer);
                            break;
                        case "nhạc sĩ":
                            System.out.println("nhạc sĩ sáng tác:");
                            String composer = sc.nextLine();
                            obj.setComposer(composer);
                            break;
                    }
                }
            }
        } else {
            if (count > 1) {
                System.out.println("bài hát này bị trùng tên:");
                for (Song element : listSong) {
                    if (element.getName().equals(chooseSong)) System.out.println(displaySongInfo(element));
                }
                System.out.println("chọn Id muốn cập nhât:");
                int chooseId = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < listSong.size(); i++) {
                    if (listSong.get(i).getId() == chooseId) {
                        Song obj = listSong.get(i);
                        System.out.println("chọn thông tin bạn muốn sửa (tên - dòng nhạc - thời lượng)");
                        String fixInfor = sc.nextLine().toLowerCase();
                        switch (fixInfor) {
                            case "tên":
                                System.out.println("tên mới là gì?");
                                String name = sc.nextLine();
                                obj.setName(name);
                                break;
                            case "dòng nhạc":
                                System.out.println("dòng nhạc là gì?");
                                String type = sc.nextLine();
                                obj.setTypeMusic(type);
                                break;
                            case "thời lượng":
                                System.out.println("thời lượng bao lâu?");
                                String time = sc.nextLine();
                                obj.setTime(time);
                                break;
                            case "ca sĩ":
                                System.out.println("ca sĩ thể hiện:");
                                String singer = sc.nextLine();
                                obj.setSinger(singer);
                                break;
                            case "nhạc sĩ":
                                System.out.println("nhạc sĩ sáng tác:");
                                String composer = sc.nextLine();
                                obj.setComposer(composer);
                                break;
                        }
                    }
                }
            } else System.out.println("không tìm thấy bài hát này để sửa");
        }
    }


    public void addSong() {
        int size;
        if (listSong.size() == 0) size = 0;
        else size = listSong.size();
        System.out.println("nhập số lượng bài hát muốn thêm:");
        int numSong = sc.nextInt();
        sc.nextLine();
        for (int i = size, k = 1; i < numSong && k <= numSong; i++, k++) {
            System.out.println("nhập tên bài hát thứ: " + k + ":");
            String name = sc.nextLine();
            System.out.println("nhập dòng nhạc:");
            String type = sc.nextLine();
            System.out.println("nhập thời lượng");
            String time = sc.nextLine();
            System.out.println("nhập tên ca sĩ thể hiện: ");
            String singer = sc.nextLine();
            System.out.println("nhập tên nhạc sĩ sáng tác: ");
            String composer = sc.nextLine();
            listSong.add(new Song(name, type, time, singer, composer));
        }
    }

    public void removeSong() {
        int count = 0;
        System.out.println("chọn bài hát muốn xóa");
        String chooseSong = sc.nextLine();
        count = duplicate(chooseSong);
        if (count == 1) {
            for (int i = 0; i < listSong.size(); i++) {
                if (listSong.get(i).getName().equals(chooseSong)) listSong.remove(i);
            }
        } else {
            if (count > 1) {
                System.out.println("bài hát này bị trùng tên:");
                for (Song element : listSong) {
                    if (element.getName().equals(chooseSong)) System.out.println(displaySongInfo(element));
                }
                System.out.println("chọn Id muốn xóa:");
                int chooseId = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < listSong.size(); i++) {
                    if (listSong.get(i).getId() == chooseId) listSong.remove(i);
                }
            } else System.out.println("không tìm thấy bài hát này để xóa");
        }
    }

    public boolean searchSinger(String singer) {
        boolean check = false;
        for (Song element : listSong) {
            if (element.getSinger().equals(singer)) check = true;
        }
        return check;
    }

    public boolean searchComposer(String composer) {
        boolean check = false;
        for (Song element : listSong) {
            if (element.getComposer().equals(composer)) check = true;
        }
        return check;
    }

    public int duplicate(String choosong) {
        int count = 0;
        for (Song element : listSong) {
            if (element.getName().equals(choosong)) count++;
        }
        return count;
    }

    public String searchSongSinger() {
        String text = "";
        System.out.println("nhập tên ca sĩ muốn tìm:");
        String singer = sc.nextLine();
        for (Song element : listSong) {
            if (searchSinger(singer)) text += displaySongInfo(element);
        }
        return text;
    }

    public String searchSongComposer() {
        String text = "";
        System.out.println("nhập tên nhạc sĩ muốn tìm:");
        String composer = sc.nextLine();
        for (Song element : listSong) {
            if (searchComposer(composer)) text += displaySongInfo(element);
        }
        return text;
    }

    public Song searchAlbumId(int id) {
        Song song = null;
        for (Song element : listSong) {
            if (element.getId() == id) song = element;
        }
        return song;
    }
    public String displaySong(Song obj){
        return "Id: " + obj.getId() + " - Tên bài hát: " + obj.getName()+
                " - ca sĩ: " + obj.getSinger() + " - nhạc sĩ: " + obj.getComposer() + "\n";
    }
}

