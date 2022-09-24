package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.ExamQuestion;

import java.util.List;

/**
 * 题库Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamQuestionService 
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
     * 批量删除题库
     * 
     * @param questionIds 需要删除的题库主键集合
     * @return 结果
     */
    public int deleteExamQuestionByQuestionIds(String[] questionIds);

    /**
     * 删除题库信息
     * 
     * @param questionId 题库主键
     * @return 结果
     */
    public int deleteExamQuestionByQuestionId(String questionId);
}
