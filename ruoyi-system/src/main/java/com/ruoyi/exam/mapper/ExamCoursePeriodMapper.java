package com.ruoyi.exam.mapper;

import java.util.List;
import com.ruoyi.exam.domain.ExamCoursePeriod;

/**
 * 课程章节Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface ExamCoursePeriodMapper 
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
     * 删除课程章节
     * 
     * @param id 课程章节主键
     * @return 结果
     */
    public int deleteExamCoursePeriodById(Long id);

    /**
     * 批量删除课程章节
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamCoursePeriodByIds(Long[] ids);
}
