package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.ExamCollect;

import java.util.List;

/**
 * 题目收藏Service接口
 * 
 * @author xiong
 * @date 2022-09-24
 */
public interface IExamCollectService 
{
    /**
     * 查询题目收藏
     * 
     * @param id 题目收藏主键
     * @return 题目收藏
     */
    public ExamCollect selectExamCollectById(Long id);

    /**
     * 查询题目收藏列表
     * 
     * @param examCollect 题目收藏
     * @return 题目收藏集合
     */
    public List<ExamCollect> selectExamCollectList(ExamCollect examCollect);

    /**
     * 新增题目收藏
     * 
     * @param examCollect 题目收藏
     * @return 结果
     */
    public int insertExamCollect(ExamCollect examCollect);

    /**
     * 修改题目收藏
     * 
     * @param examCollect 题目收藏
     * @return 结果
     */
    public int updateExamCollect(ExamCollect examCollect);

    /**
     * 批量删除题目收藏
     * 
     * @param ids 需要删除的题目收藏主键集合
     * @return 结果
     */
    public int deleteExamCollectByIds(Long[] ids);

    /**
     * 删除题目收藏信息
     * 
     * @param id 题目收藏主键
     * @return 结果
     */
    public int deleteExamCollectById(Long id);
}
