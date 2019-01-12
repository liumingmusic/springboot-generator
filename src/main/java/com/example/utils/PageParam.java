package com.example.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author doubleM
 * @ClassName: PageParam
 * @Description: 分页实体信息
 * @date 2018年3月16日 下午4:43:57
 */
@Setter
@Getter
public class PageParam {

    /**
     * 默认页码
     */

    private Integer defaultPage = 1;

    /**
     * 默认每页显示条数
     */
    private Integer defaultPageSize = 10;

    /**
     * 是否启用分页功能
     */
    private Boolean defaultUseFlag = true;

    /**
     * 是否检测当前页码的合法性（大于最大页码或小于最小页码都不合法）
     */
    private Boolean defaultCheckFlag = true;

    /**
     * 当前sql查询的总记录数，回填
     */
    private Integer totle = 1;

    /**
     * 当前sql查询实现分页后的总页数，回填
     */
    private Integer totlePage = 1;


}
