package com.ego.controller;

import com.ego.beans.GoodsCategory;
import com.ego.beans.GoodsCategoryExample;
import com.ego.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName GoodsCategoryController
 * Description:商品列表
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-14-15:06
 */
@Controller
@RequestMapping("/category")
public class GoodsCategoryController {
    @Autowired
    GoodsCategoryService goodsCategoryService;
   /**
    * 商品列表
    * */
    @RequestMapping("/toCategoryList")
    public String toCategoryList(){
        return "category/category-list";
    }

   /**
    * 商品添加
    * */
    @RequestMapping("/toCategoryAdd")
    public String toCategoryAdd(Model model){
        GoodsCategoryExample  example = new GoodsCategoryExample();
            example.createCriteria()
                    .andParentIdEqualTo(0)
                    .andLevelEqualTo((byte)1);
            //查询顶级分类数据
        List<GoodsCategory> goodsCategories = goodsCategoryService.selectByExample(example);
         model.addAttribute("gclist",goodsCategories);
        return "category/category-add";
    }

    @RequestMapping("/getCategorySecondList")
    @ResponseBody
    public Object getCategorySecondList(Integer parentId, byte level){
        GoodsCategoryExample  example = new GoodsCategoryExample();
        example.createCriteria()
                .andParentIdEqualTo(parentId)
                .andLevelEqualTo(level);
        //查询顶级分类数据
        List<GoodsCategory> goodsCategories = goodsCategoryService.selectByExample(example);
        return goodsCategories;
    }
}
