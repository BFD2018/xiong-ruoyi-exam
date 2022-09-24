package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamManage;
import com.ruoyi.exam.mapper.ExamManageMapper;
import com.ruoyi.exam.service.IExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考试管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamManageServiceImpl implements IExamManageService 
{
    @Autowired
    private ExamManageMapper examManageMapper;

    /**
     * 查询考试管理
     * 
     * @param id 考试管理主键
     * @return 考试管理
     */
    @Override
    public ExamManage selectExamManageById(String id)
    {
        return examManageMapper.selectExamManageById(id);
    }

    /**
     * 查询考试管理列表
     * 
     * @param examManage 考试管理
     * @return 考试管理
     */
    @Override
    public List<ExamManage> selectExamManageList(ExamManage examManage)
    {
        return examManageMapper.selectExamManageList(examManage);
    }

    /**
     * 新增考试管理
     * 
     * @param examManage 考试管理
     * @return 结果
     */
    @Override
    public int insertExamManage(ExamManage examManage)
    {
        examManage.setCreateTime(DateUtils.getNowDate());
        return examManageMapper.insertExamManage(examManage);
    }

    /**
     * 修改考试管理
     * 
     * @param examManage 考试管理
     * @return 结果
     */
    @Override
    public int updateExamManage(ExamManage examManage)
    {
        examManage.setUpdateTime(DateUtils.getNowDate());
        return examManageMapper.updateExamManage(examManage);
    }

    /**
     * 批量删除考试管理
     * 
     * @param ids 需要删除的考试管理主键
     * @return 结果
     */
    @Override
    public int deleteExamManageByIds(String[] ids)
    {
        return examManageMapper.deleteExamManageByIds(ids);
    }

    /**
     * 删除考试管理信息
     * 
     * @param id 考试管理主键
     * @return 结果
     */
    @Override
    public int deleteExamManageById(String id)
    {
        return examManageMapper.deleteExamManageById(id);
    }
}
