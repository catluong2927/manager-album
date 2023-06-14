package person;

import java.util.Scanner;

public class MenuPeople {
   processPeople peoples = processPeople.getInstance();
   Scanner sc = new Scanner(System.in);
    public static void displayMenuPeople() {
        System.out.println("********************************************************");
        System.out.println("*    Mời bạn chọn tính năng:                           *");
        System.out.println("*    1. Thêm đối tượng                                 *");
        System.out.println("*    2. Sửa thông tin đối tượng                        *");
        System.out.println("*    3. tìm kiếm đối tượng                             *");
        System.out.println("*    4. Xóa đối tượng                                  *");
        System.out.println("*    5. Hiển thị danh sách đối tượng                   *");
        System.out.println("*    6. Thêm Album vào danh sách Album của đối tượng   *");
        System.out.println("*    7. Hiển thị các Album đối tượng                   *");
        System.out.println("*    8. Xóa Album trong danh sách Album của đối tươợng *");
        System.out.println("*    0. Thoát chương trình                             *");
        System.out.println("********************************************************");
    }
    public void doMainMenuPeople() {
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    peoples.addPeople();
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("chọn đối tượng để sửa");
                    String choosePeople2 = sc.nextLine();
                    if(peoples.checkPeople(choosePeople2)){
                        peoples.fixPeople(peoples.searchPeoplebyName(choosePeople2));
                    }else System.out.println("không tồn tại đối tượng để sửa");
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("chọn tên đối tượng muốn tìm kiếm: ");
                    String name = sc.nextLine();
                    while (name.equals("")) {
                        System.out.println("tên đối tượng không được để trống, vui lòng nhập lại");
                        name = sc.nextLine();
                    }
                    if(peoples.checkPeople(name)){
                        System.out.println(peoples.displayPeopleInfo(peoples.searchPeoplebyName(name)));
                    }else System.out.println("không tìm thấy đối tượng");
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    break;
                case 4:
                    peoples.removePeople();
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 5:
                    peoples.displayPeople();
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("chọn đối tượng muốn thêm Album");
                    String namePeople = sc.nextLine();
                    if(peoples.checkPeople(namePeople)){
                        peoples.addAlbumToList(namePeople);
                    }
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("chọn đối tượng:");
                    String peopleName = sc.nextLine();
                    if(peoples.checkPeople(peopleName)){
                        People people2 = peoples.searchPeoplebyName(peopleName);
                        System.out.println(peoples.showListAlbum(people2));
                    }else System.out.println("không tồn tại đối tượng");
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("chọn đối tượng:");
                    String delPeopleName = sc.nextLine();
                    if(peoples.checkPeople(delPeopleName)){
                        peoples.removeAlbum(peoples.searchPeoplebyName(delPeopleName));
                    }else System.out.println("không tồn tại đối tượng");
                    MenuPeople.displayMenuPeople();
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
            }
        }
        System.out.println("cám ơn bạn đã sử dụng chương trình");
    }
}
