package com.ruoyi.exam.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.exam.domain.ExamWrongBook;
import com.ruoyi.exam.mapper.ExamWrongBookMapper;
import com.ruoyi.exam.service.IExamWrongBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 错题本Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@Service
public class ExamWrongBookServiceImpl implements IExamWrongBookService 
{
    @Autowired
    private ExamWrongBookMapper examWrongBookMapper;

    /**
     * 查询错题本
     * 
     * @param id 错题本主键
     * @return 错题本
     */
    @Override
    public ExamWrongBook selectExamWrongBookById(Long id)
    {
        return examWrongBookMapper.selectExamWrongBookById(id);
    }

    /**
     * 查询错题本列表
     * 
     * @param examWrongBook 错题本
     * @return 错题本
     */
    @Override
    public List<ExamWrongBook> selectExamWrongBookList(ExamWrongBook examWrongBook)
    {
        return examWrongBookMapper.selectExamWrongBookList(examWrongBook);
    }

    /**
     * 新增错题本
     * 
     * @param examWrongBook 错题本
     * @return 结果
     */
    @Override
    public int insertExamWrongBook(ExamWrongBook examWrongBook)
    {
        examWrongBook.setCreateTime(DateUtils.getNowDate());
        return examWrongBookMapper.insertExamWrongBook(examWrongBook);
    }

    /**
     * 修改错题本
     * 
     * @param examWrongBook 错题本
     * @return 结果
     */
    @Override
    public int updateExamWrongBook(ExamWrongBook examWrongBook)
    {
        examWrongBook.setUpdateTime(DateUtils.getNowDate());
        return examWrongBookMapper.updateExamWrongBook(examWrongBook);
    }

    /**
     * 批量删除错题本
     * 
     * @param ids 需要删除的错题本主键
     * @return 结果
     */
    @Override
    public int deleteExamWrongBookByIds(Long[] ids)
    {
        return examWrongBookMapper.deleteExamWrongBookByIds(ids);
    }

    /**
     * 删除错题本信息
     * 
     * @param id 错题本主键
     * @return 结果
     */
    @Override
    public int deleteExamWrongBookById(Long id)
    {
        return examWrongBookMapper.deleteExamWrongBookById(id);
    }
}
