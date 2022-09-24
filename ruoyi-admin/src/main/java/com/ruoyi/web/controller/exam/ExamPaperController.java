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
import com.ruoyi.exam.domain.ExamPaper;
import com.ruoyi.exam.service.IExamPaperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 试卷Controller
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/exam/paper")
public class ExamPaperController extends BaseController
{
    @Autowired
    private IExamPaperService examPaperService;

    /**
     * 查询试卷列表
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamPaper examPaper)
    {
        startPage();
        List<ExamPaper> list = examPaperService.selectExamPaperList(examPaper);
        return getDataTable(list);
    }

    /**
     * 导出试卷列表
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:export')")
    @Log(title = "试卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamPaper examPaper)
    {
        List<ExamPaper> list = examPaperService.selectExamPaperList(examPaper);
        ExcelUtil<ExamPaper> util = new ExcelUtil<ExamPaper>(ExamPaper.class);
        util.exportExcel(response, list, "试卷数据");
    }

    /**
     * 获取试卷详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(examPaperService.selectExamPaperById(id));
    }

    /**
     * 新增试卷
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:add')")
    @Log(title = "试卷", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamPaper examPaper)
    {
        return toAjax(examPaperService.insertExamPaper(examPaper));
    }

    /**
     * 修改试卷
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:edit')")
    @Log(title = "试卷", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamPaper examPaper)
    {
        return toAjax(examPaperService.updateExamPaper(examPaper));
    }

    /**
     * 删除试卷
     */
    @PreAuthorize("@ss.hasPermi('exam:paper:remove')")
    @Log(title = "试卷", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examPaperService.deleteExamPaperByIds(ids));
    }
}
