package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        int number = 0;
        List<Inventory> inventoryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===명업앱===");

        while (true) {
            System.out.printf("명령 ) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 :");
                String wiseSaying = scanner.nextLine();
                System.out.print("작가 :");
                String author = scanner.nextLine();
                number++;
                int id = number;
                System.out.printf("%d 번 명언이 등록되었습니다%n", id);
                Inventory inventory = new Inventory(id, wiseSaying, author);
                inventoryList.add(inventory);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                for (int i = inventoryList.size() - 1; i >= 0; i--) {
                    Inventory inventory = inventoryList.get(i);
                    System.out.printf("%d %s %s %n", inventory.id, inventory.wiseSaying, inventory.author);
                }

            } else if (cmd.startsWith("삭제?")) { //삭제?id=2
                String[] cmdBits = cmd.split("\\?", 2); // ["삭제" ] , [" id=2 "] 로 나눈다.
                String action = cmdBits[0]; // ["삭제"] 저장
                String queryString = cmdBits[1]; // ["id=2"] 저장

                String[] queryStringBits = queryString.split("&");

                int id = 0;

                for (int i = 0; i < queryStringBits.length; i++) { //queryStringBits 번 까지 실행
                    String queryParamStr = queryStringBits[i]; // [id=2] 를 queryParamStr 로 저장

                    String[] queryParamStrBits = queryParamStr.split("=", 2); // id =2 를 "id" , "2" 로 나눈다.

                    String paramName = queryParamStrBits[0]; //"id" 저장
                    String paramValue = queryParamStrBits[1]; // "2 " 저장 

                    if (paramName.equals("id")) { //id 가 같을경우 아래 구문 실행
                        id = Integer.parseInt(paramValue);
                    }
                }

                System.out.printf("%d번 명언을 삭제합니다.\n", id);
            }
        }

    }

}



