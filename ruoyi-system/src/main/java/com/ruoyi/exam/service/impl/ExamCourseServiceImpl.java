package com.ruoyi.exam.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamCourseMapper;
import com.ruoyi.exam.domain.ExamCourse;
import com.ruoyi.exam.service.IExamCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamCourseServiceImpl implements IExamCourseService 
{
    @Autowired
    private ExamCourseMapper examCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public ExamCourse selectExamCourseById(Long id)
    {
        return examCourseMapper.selectExamCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param examCourse 课程
     * @return 课程
     */
    @Override
    public List<ExamCourse> selectExamCourseList(ExamCourse examCourse)
    {
        return examCourseMapper.selectExamCourseList(examCourse);
    }

    /**
     * 新增课程
     * 
     * @param examCourse 课程
     * @return 结果
     */
    @Override
    public int insertExamCourse(ExamCourse examCourse)
    {
        examCourse.setCreateTime(DateUtils.getNowDate());
        return examCourseMapper.insertExamCourse(examCourse);
    }

    /**
     * 修改课程
     * 
     * @param examCourse 课程
     * @return 结果
     */
    @Override
    public int updateExamCourse(ExamCourse examCourse)
    {
        examCourse.setUpdateTime(DateUtils.getNowDate());
        return examCourseMapper.updateExamCourse(examCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteExamCourseByIds(Long[] ids)
    {
        return examCourseMapper.deleteExamCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteExamCourseById(Long id)
    {
        return examCourseMapper.deleteExamCourseById(id);
    }
}
