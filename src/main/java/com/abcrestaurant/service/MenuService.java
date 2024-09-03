package com.abcrestaurant.service;

import java.util.List;

import com.abcrestaurant.dao.MenuDAO;
import com.abcrestaurant.model.Menu;

public class MenuService {

    private static MenuService instance;
    private MenuDAO menuDAO;

    private MenuService() {
        this.menuDAO = new MenuDAO();
    }

    public static MenuService getInstance() {
        if (instance == null) {
            synchronized (MenuService.class) {
                if (instance == null) {
                    instance = new MenuService();
                }
            }
        }
        return instance;
    }

    public void addMenuItem(String name, String description, double price, String category) {
        Menu menu = new Menu(0, name, description, price, category);
        menuDAO.addMenuItem(menu);
    }

    public List<Menu> getAllMenuItems() {
        return menuDAO.getAllMenuItems();
    }

    public Menu getMenuItemById(int id) {
        return menuDAO.getMenuItemById(id);
    }

    public void updateMenuItem(int id, String name, String description, double price, String category) {
        Menu menu = new Menu(id, name, description, price, category);
        menuDAO.updateMenuItem(menu);
    }

    public void deleteMenuItem(int id) {
        menuDAO.deleteMenuItem(id);
    }
	
}
