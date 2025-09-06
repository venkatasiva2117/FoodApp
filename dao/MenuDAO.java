package com.dao;

import java.util.List;
import com.dao.model.Menu;

public interface MenuDAO {
	
    void addMenu(Menu m);
    Menu getMenu(int menu_id);
    void updateMenu(Menu m);
    int deleteMenu(int menu_id);
    List<Menu> getAllMenu();
}
