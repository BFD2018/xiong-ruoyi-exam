package com.ruoyi.exam.service;

import com.ruoyi.exam.domain.ExamWrongBook;

import java.util.List;

/**
 * 错题本Service接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface IExamWrongBookService 
{
    /**
     * 查询错题本
     * 
     * @param id 错题本主键
     * @return 错题本
     */
    public ExamWrongBook selectExamWrongBookById(Long id);

    /**
     * 查询错题本列表
     * 
     * @param examWrongBook 错题本
     * @return 错题本集合
     */
    public List<ExamWrongBook> selectExamWrongBookList(ExamWrongBook examWrongBook);

    /**
     * 新增错题本
     * 
     * @param examWrongBook 错题本
     * @return 结果
     */
    public int insertExamWrongBook(ExamWrongBook examWrongBook);

    /**
     * 修改错题本
     * 
     * @param examWrongBook 错题本
     * @return 结果
     */
    public int updateExamWrongBook(ExamWrongBook examWrongBook);

    /**
     * 批量删除错题本
     * 
     * @param ids 需要删除的错题本主键集合
     * @return 结果
     */
    public int deleteExamWrongBookByIds(Long[] ids);

    /**
     * 删除错题本信息
     * 
     * @param id 错题本主键
     * @return 结果
     */
    public int deleteExamWrongBookById(Long id);
}
