package com.ruoyi.web.controller.exam;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.exam.domain.ExamWrongBook;
import com.ruoyi.exam.service.IExamWrongBookService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 错题本Controller
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/exam/book")
public class ExamWrongBookController extends BaseController
{
    @Autowired
    private IExamWrongBookService examWrongBookService;

    /**
     * 查询错题本列表
     */
    //@PreAuthorize("@ss.hasPermi('exam:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamWrongBook examWrongBook)
    {
        startPage();
        List<ExamWrongBook> list = examWrongBookService.selectExamWrongBookList(examWrongBook);
        return getDataTable(list);
    }

    /**
     * 导出错题本列表
     */
    @PreAuthorize("@ss.hasPermi('exam:book:export')")
    @Log(title = "错题本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamWrongBook examWrongBook)
    {
        List<ExamWrongBook> list = examWrongBookService.selectExamWrongBookList(examWrongBook);
        ExcelUtil<ExamWrongBook> util = new ExcelUtil<ExamWrongBook>(ExamWrongBook.class);
        util.exportExcel(response, list, "错题本数据");
    }

    /**
     * 获取错题本详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(examWrongBookService.selectExamWrongBookById(id));
    }

    /**
     * 新增错题本
     */
    @PreAuthorize("@ss.hasPermi('exam:book:add')")
    @Log(title = "错题本", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamWrongBook examWrongBook)
    {
        return toAjax(examWrongBookService.insertExamWrongBook(examWrongBook));
    }

    /**
     * 修改错题本
     */
    @PreAuthorize("@ss.hasPermi('exam:book:edit')")
    @Log(title = "错题本", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamWrongBook examWrongBook)
    {
        return toAjax(examWrongBookService.updateExamWrongBook(examWrongBook));
    }

    /**
     * 删除错题本
     */
    @PreAuthorize("@ss.hasPermi('exam:book:remove')")
    @Log(title = "错题本", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examWrongBookService.deleteExamWrongBookByIds(ids));
    }
}
