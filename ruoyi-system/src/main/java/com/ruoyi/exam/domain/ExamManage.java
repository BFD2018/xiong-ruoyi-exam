package com.ruoyi.exam.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 考试管理对象 exam_manage
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 该次考试介绍 */
    @Excel(name = "该次考试介绍")
    private String description;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String course;

    /** 试卷编号 */
    @Excel(name = "试卷编号")
    private Long paperId;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String paperName;

    /** 考试日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考试日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examDate;

    /** 持续时长 */
    @Excel(name = "持续时长")
    private Long duration;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 学期 */
    @Excel(name = "学期")
    private String term;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 学院 */
    @Excel(name = "学院")
    private String institute;

    /** 总分 */
    @Excel(name = "总分")
    private Long totalScore;

    /** 考试类型;数据结构与算法课程考试 */
    @Excel(name = "考试类型;数据结构与算法课程考试")
    private Long examType;

    /** 考生须知 */
    @Excel(name = "考生须知")
    private String tips;

    /** 组织者（学院-专业编号）;如计算机学院-软件工程专业 10014 */
    @Excel(name = "组织者", readConverterExp = "学=院-专业编号")
    private String organizer;
}
