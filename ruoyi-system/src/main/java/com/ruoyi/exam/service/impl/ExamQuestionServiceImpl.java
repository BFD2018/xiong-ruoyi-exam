package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamQuestion;
import com.ruoyi.exam.mapper.ExamQuestionMapper;
import com.ruoyi.exam.service.IExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题库Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamQuestionServiceImpl implements IExamQuestionService 
{
    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    /**
     * 查询题库
     * 
     * @param questionId 题库主键
     * @return 题库
     */
    @Override
    public ExamQuestion selectExamQuestionByQuestionId(String questionId)
    {
        return examQuestionMapper.selectExamQuestionByQuestionId(questionId);
    }

    /**
     * 查询题库列表
     * 
     * @param examQuestion 题库
     * @return 题库
     */
    @Override
    public List<ExamQuestion> selectExamQuestionList(ExamQuestion examQuestion)
    {
        return examQuestionMapper.selectExamQuestionList(examQuestion);
    }

    /**
     * 新增题库
     * 
     * @param examQuestion 题库
     * @return 结果
     */
    @Override
    public int insertExamQuestion(ExamQuestion examQuestion)
    {
        examQuestion.setCreateTime(DateUtils.getNowDate());
        return examQuestionMapper.insertExamQuestion(examQuestion);
    }

    /**
     * 修改题库
     * 
     * @param examQuestion 题库
     * @return 结果
     */
    @Override
    public int updateExamQuestion(ExamQuestion examQuestion)
    {
        examQuestion.setUpdateTime(DateUtils.getNowDate());
        return examQuestionMapper.updateExamQuestion(examQuestion);
    }

    /**
     * 批量删除题库
     * 
     * @param questionIds 需要删除的题库主键
     * @return 结果
     */
    @Override
    public int deleteExamQuestionByQuestionIds(String[] questionIds)
    {
        return examQuestionMapper.deleteExamQuestionByQuestionIds(questionIds);
    }

    /**
     * 删除题库信息
     * 
     * @param questionId 题库主键
     * @return 结果
     */
    @Override
    public int deleteExamQuestionByQuestionId(String questionId)
    {
        return examQuestionMapper.deleteExamQuestionByQuestionId(questionId);
    }
}
