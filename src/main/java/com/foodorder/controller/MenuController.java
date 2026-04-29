package com.foodorder.controller;

import com.foodorder.entity.MenuItem;
import com.foodorder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return menuService.getAllMenuItems();
    }
}
