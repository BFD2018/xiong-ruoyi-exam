package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamScore;

import java.util.List;

/**
 * 分数Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface ExamScoreMapper 
{
    /**
     * 查询分数
     * 
     * @param id 分数主键
     * @return 分数
     */
    public ExamScore selectExamScoreById(Long id);

    /**
     * 查询分数列表
     * 
     * @param examScore 分数
     * @return 分数集合
     */
    public List<ExamScore> selectExamScoreList(ExamScore examScore);

    /**
     * 新增分数
     * 
     * @param examScore 分数
     * @return 结果
     */
    public int insertExamScore(ExamScore examScore);

    /**
     * 修改分数
     * 
     * @param examScore 分数
     * @return 结果
     */
    public int updateExamScore(ExamScore examScore);

    /**
     * 删除分数
     * 
     * @param id 分数主键
     * @return 结果
     */
    public int deleteExamScoreById(Long id);

    /**
     * 批量删除分数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamScoreByIds(Long[] ids);
}
