package com.pp.jd.controller;

import com.github.pagehelper.PageInfo;
import com.pp.jd.entity.TbItem;
import com.pp.jd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/findTbItemById/{id}", produces = "application/json;charset=utf-8")
    public TbItem findTbItemById(@PathVariable("id") Long id) {
        return itemService.findTbItemById(id);
    }

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public HashMap<String, Object> list(@RequestParam("page") int pageNum,@RequestParam("rows") int pageSize) {
        return itemService.findAllByPage(pageNum, pageSize);
    }
}
