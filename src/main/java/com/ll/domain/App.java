package com.ll.domain;

import java.util.*;

public class App {
    List<Inventory> inventoryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

     int number = 0;

    public void run() {
        System.out.println("===명업앱===");
        while (true) {

            System.out.printf("명령 : ");
            String cmd = scanner.nextLine();

            Rq rq  = new Rq (cmd);

           switch (rq.getCmdAction()){

               case "종료":

                   return;

               case "등록":

                   register();

                   break;

               case "목록":

                   list();

                   break;
               case "삭제":

                   listRemove(rq);

                   break;

               case "수정":

                   listModify(rq);

                   break;

               default:

                   System.out.println("다시입력해주세요");
           }
        }
    }

    private void register() {
        System.out.print("명언 :");
        String wiseSaying = scanner.nextLine();
        System.out.print("작가 :");
        String author = scanner.nextLine();
        number++;
        int id = number;
        System.out.printf("%d 번 명언이 등록되었습니다%n", id);
        Inventory inventory = new Inventory(id, wiseSaying, author);
        inventoryList.add(inventory);
    }

    private void list() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("-".repeat(18));
        for (int i = inventoryList.size() - 1; i >= 0; i--) {
            Inventory inventory = inventoryList.get(i);
            System.out.printf("%d %s %s %n", inventory.getId(), inventory.getWiseSaying(), inventory.getAuthor());
        }
    }

    private void listRemove(Rq rq) {

        int id = rq.getParamAsInt("id", 0);

        if (id ==0) {
            System.out.println("삭제할수있는 명언이 없습니다.");
            return;
        }
        int index = getIndexSearchId(id);

        if(index == -1) {
            System.out.println("명언을 찾을수없습니다.");
            return;
        }
        inventoryList.remove(index);
        System.out.printf("%d번 명언이 삭제되었습니다%n",id);
    }

    private int getIndexSearchId (int id) {
        for (int i=0; i < inventoryList.size(); i++){
            Inventory inventory = inventoryList.get(i);
            if (inventory.getId() ==id) {
                return i;
            }
        }
        return -1;
    }
    private  void listModify(Rq rq) {

        int id = rq.getParamAsInt("id", 0);

        if (id ==0) {
            System.out.println("삭제할수있는 명언이 없습니다.");
            return;
        }
        int index = getIndexSearchId(id);

        if(index == -1) {
            System.out.println("명언을 찾을수없습니다.");
            return;
        }
        Inventory inventory = inventoryList.get(index);
        System.out.print("기존 명언 :");
        System.out.println(inventory.getWiseSaying());

        System.out.print("수정할 명언 :");
        String wiseSaying = scanner.nextLine();

        System.out.print("기존 작가 :");
        System.out.println(inventory.getAuthor());

        System.out.print("수정할 작가명 :");
        String author = scanner.nextLine();

        inventory.setWiseSaying(wiseSaying);
        inventory.setAuthor(author);

    }

}
