package com.ruoyi.exam.service;

import java.util.List;
import com.ruoyi.exam.domain.ExamCourse;

/**
 * 课程Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamCourseService 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public ExamCourse selectExamCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param examCourse 课程
     * @return 课程集合
     */
    public List<ExamCourse> selectExamCourseList(ExamCourse examCourse);

    /**
     * 新增课程
     * 
     * @param examCourse 课程
     * @return 结果
     */
    public int insertExamCourse(ExamCourse examCourse);

    /**
     * 修改课程
     * 
     * @param examCourse 课程
     * @return 结果
     */
    public int updateExamCourse(ExamCourse examCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteExamCourseByIds(Long[] ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteExamCourseById(Long id);
}
