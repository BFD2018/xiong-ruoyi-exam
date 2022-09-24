package com.ruoyi.exam.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错题本对象 exam_wrong_book
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamWrongBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 题目id */
    @Excel(name = "题目id")
    private Long questionId;

    /** 题目 */
    @Excel(name = "题目")
    private String questionTitle;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentId;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private String studentName;

    /** 题目所属课程名称 */
    @Excel(name = "题目所属课程名称")
    private String questionCourseName;

    /** 试卷id */
    @Excel(name = "试卷id")
    private Long paperId;
}
