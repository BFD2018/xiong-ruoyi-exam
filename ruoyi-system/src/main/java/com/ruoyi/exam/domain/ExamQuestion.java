package com.ruoyi.exam.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 题库对象 exam_question
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamQuestion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 试题编号 */
    private String questionId;

    /** 所属课程id */
    @Excel(name = "所属课程id")
    private Long courseId;

    /** 所属课程名称 */
    @Excel(name = "所属课程名称")
    private String courseName;

    /** 题目问题;以换行符分隔 */
    @Excel(name = "题目问题;以换行符分隔")
    private String title;

    /** 正确答案 */
    @Excel(name = "正确答案")
    private String rightAnswer;

    /** 题目解析 */
    @Excel(name = "题目解析")
    private String analysis;

    /** 题目分数 */
    @Excel(name = "题目分数")
    private Long score;

    /** 难度等级 */
    @Excel(name = "难度等级")
    private Long level;

    /** 题目被引用次数 */
    @Excel(name = "题目被引用次数")
    private Long count;
}
