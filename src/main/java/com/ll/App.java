package com.ll;

import java.util.*;

public class App {
    public void run() {
        int number = 0;
        List<Inventory> inventoryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===명업앱===");
        Map<String, String> inventoryMap = new HashMap<>();
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
                System.out.println("-".repeat(18));
                for (int i = inventoryList.size() - 1; i >= 0; i--) {
                    Inventory inventory = inventoryList.get(i);
                    System.out.printf("%d %s %s %n", inventory.id, inventory.wiseSaying, inventory.author);

                }

            } else if (cmd.startsWith("삭제")) { //삭제?id=2
                String[] cmdBit = cmd.split("\\?", 2); //"삭제" , "id=2"
                String action = cmdBit[0]; // "삭제" 저장
                String queryString = cmdBit[1]; // "id=2" 저장
                String[] queryStringBit = queryString.split("&");
                int id = 0;
                for (int i = 0; i < queryStringBit.length; i++) {
                    String queryStringStr = queryStringBit[i]; //"id=2"
                    String[] queryStringStrBit = queryStringStr.split("=", 2); //"id" , "2"
                    String paramName = queryStringStrBit[0]; // "id"
                    String paramValue = queryStringStrBit[1]; //"2"
                    inventoryMap.put(paramName, paramValue);
                    if (paramName.equals("id")) {
                        id = Integer.parseInt(paramValue);
                    }

                }
                if (inventoryList.isEmpty()) {
                    System.out.println("현재 목록에 명언이 없습니다");
                }

                for (int i = inventoryList.size() - 1; i >= 0; i--) { // 객체가 저장 되어 있는 리스트에 사이즈만큼 순회한다
                    Inventory inventory = inventoryList.get(i); // 리스트에 저장 되어 있는 값을 꺼내어 클래스의 객체에저장.
                    if (inventory.id == id) { // 현재 목록에 저장 되어 있는 id 와 현재 입력된 id 값이 같다고 한다면
                        inventoryList.remove(i); // 삭제한다.
                        System.out.printf("%d 번 명언이 삭제되었습니다%n", id);
                    }
                    if (inventory.id != id) {
                        System.out.println("현재 목록에 명언이 없습니다");
                        break;
                    }
                }

            } else if (cmd.startsWith("수정?")) {
                String[] cmdBit = cmd.split("\\?", 2); //"삭제" , "id=2"
                String action = cmdBit[0]; // "삭제" 저장
                String queryString = cmdBit[1]; // "id=2" 저장
                String[] queryStringBit = queryString.split("&");
                int id = 0;
                for (int i = 0; i < queryStringBit.length; i++) {
                    String queryStringStr = queryStringBit[i]; //"id=2"
                    String[] queryStringStrBit = queryStringStr.split("=", 2); //"id" , "2"
                    String paramName = queryStringStrBit[0]; // "id"
                    String paramValue = queryStringStrBit[1]; //"2"
                    inventoryMap.put(paramName, paramValue);
                    if (paramName.equals("id")) {
                        id = Integer.parseInt(paramValue);
                    }

                }
                if (inventoryList.isEmpty()) {
                    System.out.println("현재 목록에 명언이 없습니다");
                }
                for (int i = inventoryList.size() - 1; i >= 0; i--) { // 객체가 저장 되어 있는 리스트에 사이즈만큼 순회한다
                    Inventory inventory = inventoryList.get(i); // 리스트에 저장 되어 있는 값을 꺼내어 클래스의 객체에저장.
                    if (inventory.id == id) { // 현재 목록에 저장 되어 있는 id 와 현재 입력된 id 값이 같다고 한다면
                        inventoryList.remove(i); // 삭제한다.
                        System.out.printf("%d 번 명언이 삭제되었습니다%n", id);
                    }
                    if (inventory.id != id) {
                        System.out.println("현재 목록에 명언이 없습니다");
                        break;
                    }

                }

            }

        }

    }
}
