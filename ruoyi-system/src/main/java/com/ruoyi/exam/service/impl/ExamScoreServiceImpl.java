package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamScore;
import com.ruoyi.exam.mapper.ExamScoreMapper;
import com.ruoyi.exam.service.IExamScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分数Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamScoreServiceImpl implements IExamScoreService 
{
    @Autowired
    private ExamScoreMapper examScoreMapper;

    /**
     * 查询分数
     * 
     * @param id 分数主键
     * @return 分数
     */
    @Override
    public ExamScore selectExamScoreById(Long id)
    {
        return examScoreMapper.selectExamScoreById(id);
    }

    /**
     * 查询分数列表
     * 
     * @param examScore 分数
     * @return 分数
     */
    @Override
    public List<ExamScore> selectExamScoreList(ExamScore examScore)
    {
        return examScoreMapper.selectExamScoreList(examScore);
    }

    /**
     * 新增分数
     * 
     * @param examScore 分数
     * @return 结果
     */
    @Override
    public int insertExamScore(ExamScore examScore)
    {
        examScore.setCreateTime(DateUtils.getNowDate());
        return examScoreMapper.insertExamScore(examScore);
    }

    /**
     * 修改分数
     * 
     * @param examScore 分数
     * @return 结果
     */
    @Override
    public int updateExamScore(ExamScore examScore)
    {
        examScore.setUpdateTime(DateUtils.getNowDate());
        return examScoreMapper.updateExamScore(examScore);
    }

    /**
     * 批量删除分数
     * 
     * @param ids 需要删除的分数主键
     * @return 结果
     */
    @Override
    public int deleteExamScoreByIds(Long[] ids)
    {
        return examScoreMapper.deleteExamScoreByIds(ids);
    }

    /**
     * 删除分数信息
     * 
     * @param id 分数主键
     * @return 结果
     */
    @Override
    public int deleteExamScoreById(Long id)
    {
        return examScoreMapper.deleteExamScoreById(id);
    }
}
