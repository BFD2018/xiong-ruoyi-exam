package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamPaper;

import java.util.List;

/**
 * 试卷Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface ExamPaperMapper 
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
     * 删除试卷
     * 
     * @param id 试卷主键
     * @return 结果
     */
    public int deleteExamPaperById(Long id);

    /**
     * 批量删除试卷
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamPaperByIds(Long[] ids);
}
