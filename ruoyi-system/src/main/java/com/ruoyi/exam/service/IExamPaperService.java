package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.ExamPaper;

import java.util.List;

/**
 * 试卷Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamPaperService 
{
    /**
     * 查询试卷
     * 
     * @param id 试卷主键
     * @return 试卷
     */
    public ExamPaper selectExamPaperById(Long id);

    /**
     * 查询试卷列表
     * 
     * @param examPaper 试卷
     * @return 试卷集合
     */
    public List<ExamPaper> selectExamPaperList(ExamPaper examPaper);

    /**
     * 新增试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    public int insertExamPaper(ExamPaper examPaper);

    /**
     * 修改试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    public int updateExamPaper(ExamPaper examPaper);

    /**
     * 批量删除试卷
     * 
     * @param ids 需要删除的试卷主键集合
     * @return 结果
     */
    public int deleteExamPaperByIds(Long[] ids);

    /**
     * 删除试卷信息
     * 
     * @param id 试卷主键
     * @return 结果
     */
    public int deleteExamPaperById(Long id);
}
