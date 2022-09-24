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
 * 分数对象 exam_score
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分数编号 */
    private Long id;

    /** 考试编号 */
    @Excel(name = "考试编号")
    private Long examId;

    /** 学号 */
    @Excel(name = "学号")
    private Long studentId;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private String studentName;

    /** 课程id */
    @Excel(name = "课程id")
    private Long subjectId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String subjectName;

    /** 平时成绩 */
    @Excel(name = "平时成绩")
    private Long ptScore;

    /** 期末成绩 */
    @Excel(name = "期末成绩")
    private Long etScore;

    /** 总成绩 */
    @Excel(name = "总成绩")
    private Long totalScore;

    /** 考试日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考试日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examDate;
}
