package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamQuestion;

import java.util.List;

/**
 * 题库Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface ExamQuestionMapper 
{
    /**
     * 查询题库
     * 
     * @param questionId 题库主键
     * @return 题库
     */
    public ExamQuestion selectExamQuestionByQuestionId(String questionId);

    /**
     * 查询题库列表
     * 
     * @param examQuestion 题库
     * @return 题库集合
     */
    public List<ExamQuestion> selectExamQuestionList(ExamQuestion examQuestion);

    /**
     * 新增题库
     * 
     * @param examQuestion 题库
     * @return 结果
     */
    public int insertExamQuestion(ExamQuestion examQuestion);

    /**
     * 修改题库
     * 
     * @param examQuestion 题库
     * @return 结果
     */
    public int updateExamQuestion(ExamQuestion examQuestion);

    /**
     * 删除题库
     * 
     * @param questionId 题库主键
     * @return 结果
     */
    public int deleteExamQuestionByQuestionId(String questionId);

    /**
     * 批量删除题库
     * 
     * @param questionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamQuestionByQuestionIds(String[] questionIds);
}
