package com.pp.jd.service;

import com.github.pagehelper.PageInfo;
import com.pp.jd.entity.TbItem;

import java.util.HashMap;

/**
 * 商品服务
 * @author pengpan
 */
public interface ItemService {
    /**
     * 根据id查询商品信息
     * @param id
     * @return 商品对象
     */
    TbItem findTbItemById(Long id);

    /**
     *  分页查询
     * @param pageNum   当前页
     * @param pageSize  每页条数
     * @return          所有的分页信息
     */
    HashMap<String, Object> findAllByPage(int pageNum, int pageSize);
}
