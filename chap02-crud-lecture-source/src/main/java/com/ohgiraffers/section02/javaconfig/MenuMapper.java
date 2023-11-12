package com.ohgiraffers.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {

    @Results(id="menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS"),
    })
    @Select("SELECT MENU_CODE\n" +
            "     , MENU_NAME\n" +
            "     , MENU_PRICE\n" +
            "     , CATEGORY_CODE\n" +
            "     , ORDERABLE_STATUS\n" +
            "  FROM TBL_MENU\n" +
            " WHERE ORDERABLE_STATUS = 'Y'\n" +
            " ORDER BY MENU_CODE")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE\n" +
            "     , MENU_NAME\n" +
            "     , MENU_PRICE\n" +
            "     , CATEGORY_CODE\n" +
            "     , ORDERABLE_STATUS\n" +
            "  FROM TBL_MENU\n" +
            " WHERE ORDERABLE_STATUS = 'Y'\n" +
            "   AND MENU_CODE = #{ code }")
    @ResultMap("menuResultMap")			//위에 사용한 resultMap을 재사용할 수 있다.
    MenuDTO selectMenuByCode(int code);

    @Insert("INSERT INTO TBL_MENU (\n" +
            "                       MENU_NAME\n" +
            "                       , MENU_PRICE\n" +
            "                       , CATEGORY_CODE\n" +
            "                       , ORDERABLE_STATUS\n" +
            "                     )\n" +
            "VALUES (\n" +
            "         #{ name }\n" +
        "           , #{ price }\n" +
            "       , #{ categoryCode }\n" +
            "       , 'Y'\n" +
            "       )")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE TBL_MENU\n" +
            "   SET MENU_NAME = #{ name }\n" +
            "     , MENU_PRICE = #{ price }\n" +
            "     , CATEGORY_CODE = #{ categoryCode }\n" +
            " WHERE MENU_CODE = #{ code }")
    int updateMenu(MenuDTO menu);

    @Delete("DELETE\n" +
            "  FROM TBL_MENU\n" +
            " WHERE MENU_CODE = #{ code }")
    int deleteMenu(int code);

}
