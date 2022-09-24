package com.ruoyi.exam.service;

import java.util.List;
import com.ruoyi.exam.domain.ExamCoursePeriod;

/**
 * 课程章节Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamCoursePeriodService 
{
    /**
     * 查询课程章节
     * 
     * @param id 课程章节主键
     * @return 课程章节
     */
    public ExamCoursePeriod selectExamCoursePeriodById(Long id);

    /**
     * 查询课程章节列表
     * 
     * @param examCoursePeriod 课程章节
     * @return 课程章节集合
     */
    public List<ExamCoursePeriod> selectExamCoursePeriodList(ExamCoursePeriod examCoursePeriod);

    /**
     * 新增课程章节
     * 
     * @param examCoursePeriod 课程章节
     * @return 结果
     */
    public int insertExamCoursePeriod(ExamCoursePeriod examCoursePeriod);

    /**
     * 修改课程章节
     * 
     * @param examCoursePeriod 课程章节
     * @return 结果
     */
    public int updateExamCoursePeriod(ExamCoursePeriod examCoursePeriod);

    /**
     * 批量删除课程章节
     * 
     * @param ids 需要删除的课程章节主键集合
     * @return 结果
     */
    public int deleteExamCoursePeriodByIds(Long[] ids);

    /**
     * 删除课程章节信息
     * 
     * @param id 课程章节主键
     * @return 结果
     */
    public int deleteExamCoursePeriodById(Long id);
}
