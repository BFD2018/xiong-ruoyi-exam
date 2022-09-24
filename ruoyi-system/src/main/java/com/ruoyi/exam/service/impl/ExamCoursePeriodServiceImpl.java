package com.ruoyi.exam.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamCoursePeriodMapper;
import com.ruoyi.exam.domain.ExamCoursePeriod;
import com.ruoyi.exam.service.IExamCoursePeriodService;

/**
 * 课程章节Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamCoursePeriodServiceImpl implements IExamCoursePeriodService 
{
    @Autowired
    private ExamCoursePeriodMapper examCoursePeriodMapper;

    /**
     * 查询课程章节
     * 
     * @param id 课程章节主键
     * @return 课程章节
     */
    @Override
    public ExamCoursePeriod selectExamCoursePeriodById(Long id)
    {
        return examCoursePeriodMapper.selectExamCoursePeriodById(id);
    }

    /**
     * 查询课程章节列表
     * 
     * @param examCoursePeriod 课程章节
     * @return 课程章节
     */
    @Override
    public List<ExamCoursePeriod> selectExamCoursePeriodList(ExamCoursePeriod examCoursePeriod)
    {
        return examCoursePeriodMapper.selectExamCoursePeriodList(examCoursePeriod);
    }

    /**
     * 新增课程章节
     * 
     * @param examCoursePeriod 课程章节
     * @return 结果
     */
    @Override
    public int insertExamCoursePeriod(ExamCoursePeriod examCoursePeriod)
    {
        examCoursePeriod.setCreateTime(DateUtils.getNowDate());
        return examCoursePeriodMapper.insertExamCoursePeriod(examCoursePeriod);
    }

    /**
     * 修改课程章节
     * 
     * @param examCoursePeriod 课程章节
     * @return 结果
     */
    @Override
    public int updateExamCoursePeriod(ExamCoursePeriod examCoursePeriod)
    {
        examCoursePeriod.setUpdateTime(DateUtils.getNowDate());
        return examCoursePeriodMapper.updateExamCoursePeriod(examCoursePeriod);
    }

    /**
     * 批量删除课程章节
     * 
     * @param ids 需要删除的课程章节主键
     * @return 结果
     */
    @Override
    public int deleteExamCoursePeriodByIds(Long[] ids)
    {
        return examCoursePeriodMapper.deleteExamCoursePeriodByIds(ids);
    }

    /**
     * 删除课程章节信息
     * 
     * @param id 课程章节主键
     * @return 结果
     */
    @Override
    public int deleteExamCoursePeriodById(Long id)
    {
        return examCoursePeriodMapper.deleteExamCoursePeriodById(id);
    }
}
