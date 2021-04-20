package com.ego.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCategory {
    /**
    * 商品分类id
    */
    private Integer id;

    /**
    * 商品分类名称
    */
    private String name;

    /**
    * 手机端显示的商品分类名
    */
    private String mobileName;

    /**
    * 父id
    */
    private Integer parentId;

    /**
    * 家族图谱
    */
    private String parentIdPath;

    /**
    * 等级
    */
    private Byte level;

    /**
    * 顺序排序
    */
    private Byte sortOrder;

    /**
    * 是否显示
    */
    private Byte isShow;

    /**
    * 分类图片
    */
    private String image;

    /**
    * 是否推荐为热门分类
    */
    private Byte isHot;

    /**
    * 分类分组默认0
    */
    private Byte catGroup;

    /**
    * 分佣比例
    */
    private Byte commissionRate;
}