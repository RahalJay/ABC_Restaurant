package com.abcrestaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Menu;
import com.abcrestaurant.service.MenuService;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MenuService menuService;

    public void init() throws ServletException {
        menuService = MenuService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> menuList = menuService.getAllMenuItems();
        request.setAttribute("menuList", menuList);
        request.getRequestDispatcher("WEB-INF/view/menu.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String category = request.getParameter("category");
                    menuService.addMenuItem(name, description, price, category);
                    break;
                case "update":
                    int id = Integer.parseInt(request.getParameter("id"));
                    name = request.getParameter("name");
                    description = request.getParameter("description");
                    price = Double.parseDouble(request.getParameter("price"));
                    category = request.getParameter("category");
                    menuService.updateMenuItem(id, name, description, price, category);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    menuService.deleteMenuItem(id);
                    break;
            }
        }
        response.sendRedirect("menu");
    }
}

	
