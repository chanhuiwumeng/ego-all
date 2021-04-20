package com.ego.service;

import java.util.List;
import com.ego.beans.GoodsCategory;
import com.ego.beans.GoodsCategoryExample;
public interface GoodsCategoryService{


    long countByExample(GoodsCategoryExample example);

    int deleteByExample(GoodsCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(GoodsCategory record,GoodsCategoryExample example);

    int updateByExample(GoodsCategory record,GoodsCategoryExample example);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

}
