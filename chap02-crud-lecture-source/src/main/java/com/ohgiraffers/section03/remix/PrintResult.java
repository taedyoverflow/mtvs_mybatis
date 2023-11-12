package com.ohgiraffers.section03.remix;

import java.util.List;

public class PrintResult {
    public void printMenus(List<MenuDTO> menus) {

        menus.forEach(System.out::println);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "findAllMenus" :
                errorMessage = "메뉴 목록 조회를 실패하였습니다.";
                break;
            case "findMenuByMenuCode" :
                errorMessage = "메뉴 상세 조회에 실패하였습니다.";
                break;
            case "regist" :
                errorMessage = "신규 메뉴 추가에 실패하셨습니다!";
                break;
            case "modify" :
                errorMessage = "메뉴 정보 수정에 실패하셨습니다!";
                break;
            case "remove" :
                errorMessage = "메뉴 삭제에 실패하셨습니다!";
                break;
            default :
                errorMessage = "알 수 없는 에러 발생!";
        }

        System.out.println(errorMessage);
    }

    public void printMenu(MenuDTO menu) {

        System.out.println("menu = " + menu);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "regist" :
                successMessage = "신규 메뉴 등록에 성공하셨습니다.";
                break;
            case "modify" :
                successMessage = "메뉴 수정에 성공하셨습니다.";
                break;
            case "remove" :
                successMessage = "메뉴 삭제에 성공하셨습니다.";
                break;
        }

        System.out.println(successMessage);
    }
}
