package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamCollect;
import com.ruoyi.exam.mapper.ExamCollectMapper;
import com.ruoyi.exam.service.IExamCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题目收藏Service业务层处理
 * 
 * @author xiong
 * @date 2022-09-24
 */
@Service
public class ExamCollectServiceImpl implements IExamCollectService 
{
    @Autowired
    private ExamCollectMapper examCollectMapper;

    /**
     * 查询题目收藏
     * 
     * @param id 题目收藏主键
     * @return 题目收藏
     */
    @Override
    public ExamCollect selectExamCollectById(Long id)
    {
        return examCollectMapper.selectExamCollectById(id);
    }

    /**
     * 查询题目收藏列表
     * 
     * @param examCollect 题目收藏
     * @return 题目收藏
     */
    @Override
    public List<ExamCollect> selectExamCollectList(ExamCollect examCollect)
    {
        return examCollectMapper.selectExamCollectList(examCollect);
    }

    /**
     * 新增题目收藏
     * 
     * @param examCollect 题目收藏
     * @return 结果
     */
    @Override
    public int insertExamCollect(ExamCollect examCollect)
    {
        examCollect.setCreateTime(DateUtils.getNowDate());
        return examCollectMapper.insertExamCollect(examCollect);
    }

    /**
     * 修改题目收藏
     * 
     * @param examCollect 题目收藏
     * @return 结果
     */
    @Override
    public int updateExamCollect(ExamCollect examCollect)
    {
        examCollect.setUpdateTime(DateUtils.getNowDate());
        return examCollectMapper.updateExamCollect(examCollect);
    }

    /**
     * 批量删除题目收藏
     * 
     * @param ids 需要删除的题目收藏主键
     * @return 结果
     */
    @Override
    public int deleteExamCollectByIds(Long[] ids)
    {
        return examCollectMapper.deleteExamCollectByIds(ids);
    }

    /**
     * 删除题目收藏信息
     * 
     * @param id 题目收藏主键
     * @return 结果
     */
    @Override
    public int deleteExamCollectById(Long id)
    {
        return examCollectMapper.deleteExamCollectById(id);
    }
}
