package com.ruoyi.exam.mapper;

import com.ruoyi.exam.domain.ExamWrongBook;

import java.util.List;

/**
 * 错题本Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
public interface ExamWrongBookMapper 
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
     * 删除错题本
     * 
     * @param id 错题本主键
     * @return 结果
     */
    public int deleteExamWrongBookById(Long id);

    /**
     * 批量删除错题本
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamWrongBookByIds(Long[] ids);
}
