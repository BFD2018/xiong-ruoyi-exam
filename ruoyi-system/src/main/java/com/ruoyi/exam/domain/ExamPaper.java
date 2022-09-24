package com.ruoyi.exam.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 试卷对象 exam_paper
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 试卷编号;202208101430001，格式是：年月日时分+三位数 */
    @Excel(name = "试卷编号;202208101430001，格式是：年月日时分+三位数")
    private Long paperId;

    /** 试卷名称;高等数学A期末测试 */
    @Excel(name = "试卷名称;高等数学A期末测试")
    private String paperName;

    /** 题目编号 */
    @Excel(name = "题目编号")
    private Long questionId;

    /** 题目顺序 */
    @Excel(name = "题目顺序")
    private Long questionOrder;

    /** 学生提交答案 */
    @Excel(name = "学生提交答案")
    private String answer;

    /** 是否已解答;1-已解答，0-未解答 */
    @Excel(name = "是否已解答;1-已解答，0-未解答")
    private Long isSolved;

    /** 是否正确 */
    @Excel(name = "是否正确")
    private Long result;
}
