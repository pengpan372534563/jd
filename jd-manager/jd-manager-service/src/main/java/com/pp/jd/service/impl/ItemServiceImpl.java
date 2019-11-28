package com.pp.jd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pp.jd.entity.TbItem;
import com.pp.jd.service.ItemService;
import com.pp.jd.mapper.TbItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem findTbItemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    //分页查询
    @Override
    public HashMap<String, Object> findAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbItem>  tbItemList= tbItemMapper.findAllPage();
        PageInfo<TbItem> pageInfo = new PageInfo(tbItemList);

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        //总条数
        hashMap.put("total", pageInfo.getTotal());
        //所以数据
        hashMap.put("rows", pageInfo.getList());
        return hashMap;
    }
}
