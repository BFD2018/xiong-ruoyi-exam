package com.ruoyi.exam.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 题目收藏对象 exam_collect
 * 
 * @author xiong
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 题目id */
    @Excel(name = "题目id")
    private Long questionId;

    /** 题目内容 */
    @Excel(name = "题目内容")
    private String questionTitle;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;
}
