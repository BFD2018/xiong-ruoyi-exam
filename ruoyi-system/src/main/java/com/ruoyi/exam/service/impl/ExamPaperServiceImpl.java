package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamPaper;
import com.ruoyi.exam.mapper.ExamPaperMapper;
import com.ruoyi.exam.service.IExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 试卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamPaperServiceImpl implements IExamPaperService 
{
    @Autowired
    private ExamPaperMapper examPaperMapper;

    /**
     * 查询试卷
     * 
     * @param id 试卷主键
     * @return 试卷
     */
    @Override
    public ExamPaper selectExamPaperById(Long id)
    {
        return examPaperMapper.selectExamPaperById(id);
    }

    /**
     * 查询试卷列表
     * 
     * @param examPaper 试卷
     * @return 试卷
     */
    @Override
    public List<ExamPaper> selectExamPaperList(ExamPaper examPaper)
    {
        return examPaperMapper.selectExamPaperList(examPaper);
    }

    /**
     * 新增试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    @Override
    public int insertExamPaper(ExamPaper examPaper)
    {
        examPaper.setCreateTime(DateUtils.getNowDate());
        return examPaperMapper.insertExamPaper(examPaper);
    }

    /**
     * 修改试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    @Override
    public int updateExamPaper(ExamPaper examPaper)
    {
        examPaper.setUpdateTime(DateUtils.getNowDate());
        return examPaperMapper.updateExamPaper(examPaper);
    }

    /**
     * 批量删除试卷
     * 
     * @param ids 需要删除的试卷主键
     * @return 结果
     */
    @Override
    public int deleteExamPaperByIds(Long[] ids)
    {
        return examPaperMapper.deleteExamPaperByIds(ids);
    }

    /**
     * 删除试卷信息
     * 
     * @param id 试卷主键
     * @return 结果
     */
    @Override
    public int deleteExamPaperById(Long id)
    {
        return examPaperMapper.deleteExamPaperById(id);
    }
}
