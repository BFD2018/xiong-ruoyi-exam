package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.ExamManage;

import java.util.List;

/**
 * 考试管理Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamManageService 
{
    /**
     * 查询考试管理
     * 
     * @param id 考试管理主键
     * @return 考试管理
     */
    public ExamManage selectExamManageById(String id);

    /**
     * 查询考试管理列表
     * 
     * @param examManage 考试管理
     * @return 考试管理集合
     */
    public List<ExamManage> selectExamManageList(ExamManage examManage);

    /**
     * 新增考试管理
     * 
     * @param examManage 考试管理
     * @return 结果
     */
    public int insertExamManage(ExamManage examManage);

    /**
     * 修改考试管理
     * 
     * @param examManage 考试管理
     * @return 结果
     */
    public int updateExamManage(ExamManage examManage);

    /**
     * 批量删除考试管理
     * 
     * @param ids 需要删除的考试管理主键集合
     * @return 结果
     */
    public int deleteExamManageByIds(String[] ids);

    /**
     * 删除考试管理信息
     * 
     * @param id 考试管理主键
     * @return 结果
     */
    public int deleteExamManageById(String id);
}
