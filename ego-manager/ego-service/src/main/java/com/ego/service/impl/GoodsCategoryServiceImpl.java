package com.ego.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ego.mapper.GoodsCategoryMapper;
import java.util.List;
import com.ego.beans.GoodsCategory;
import com.ego.beans.GoodsCategoryExample;
import com.ego.service.GoodsCategoryService;
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public long countByExample(GoodsCategoryExample example) {
        return goodsCategoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsCategoryExample example) {
        return goodsCategoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsCategory record) {
        return goodsCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsCategory record) {
        return goodsCategoryMapper.insertSelective(record);
    }

    @Override
    public List<GoodsCategory> selectByExample(GoodsCategoryExample example) {
        return goodsCategoryMapper.selectByExample(example);
    }

    @Override
    public GoodsCategory selectByPrimaryKey(Integer id) {
        return goodsCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsCategory record,GoodsCategoryExample example) {
        return goodsCategoryMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsCategory record,GoodsCategoryExample example) {
        return goodsCategoryMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsCategory record) {
        return goodsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsCategory record) {
        return goodsCategoryMapper.updateByPrimaryKey(record);
    }

}
