package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamCollect;

import java.util.List;

/**
 * 题目收藏Mapper接口
 * 
 * @author xiong
 * @date 2022-09-24
 */
public interface ExamCollectMapper 
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
     * 删除题目收藏
     * 
     * @param id 题目收藏主键
     * @return 结果
     */
    public int deleteExamCollectById(Long id);

    /**
     * 批量删除题目收藏
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamCollectByIds(Long[] ids);
}
