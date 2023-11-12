package com.ohgiraffers.section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void findAllMenus() {

        List<MenuDTO> menus = menuService.findAllMenus();

        if(menus != null) {
            printResult.printMenus(menus);
        } else {
            printResult.printErrorMessage("findAllMenus");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
    }

    public void registMenu(Map<String, String> parameter) {
    }

    public void modifyMenu(Map<String, String> parameter) {
    }

    public void removeMenu(Map<String, String> parameter) {
    }
}
