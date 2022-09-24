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
import com.ruoyi.exam.domain.ExamQuestion;
import com.ruoyi.exam.service.IExamQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题库Controller
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/exam/question")
public class ExamQuestionController extends BaseController
{
    @Autowired
    private IExamQuestionService examQuestionService;

    /**
     * 查询题库列表
     */
    @PreAuthorize("@ss.hasPermi('exam:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamQuestion examQuestion)
    {
        startPage();
        List<ExamQuestion> list = examQuestionService.selectExamQuestionList(examQuestion);
        return getDataTable(list);
    }

    /**
     * 导出题库列表
     */
    @PreAuthorize("@ss.hasPermi('exam:question:export')")
    @Log(title = "题库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamQuestion examQuestion)
    {
        List<ExamQuestion> list = examQuestionService.selectExamQuestionList(examQuestion);
        ExcelUtil<ExamQuestion> util = new ExcelUtil<ExamQuestion>(ExamQuestion.class);
        util.exportExcel(response, list, "题库数据");
    }

    /**
     * 获取题库详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:question:query')")
    @GetMapping(value = "/{questionId}")
    public AjaxResult getInfo(@PathVariable("questionId") String questionId)
    {
        return AjaxResult.success(examQuestionService.selectExamQuestionByQuestionId(questionId));
    }

    /**
     * 新增题库
     */
    @PreAuthorize("@ss.hasPermi('exam:question:add')")
    @Log(title = "题库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamQuestion examQuestion)
    {
        return toAjax(examQuestionService.insertExamQuestion(examQuestion));
    }

    /**
     * 修改题库
     */
    @PreAuthorize("@ss.hasPermi('exam:question:edit')")
    @Log(title = "题库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamQuestion examQuestion)
    {
        return toAjax(examQuestionService.updateExamQuestion(examQuestion));
    }

    /**
     * 删除题库
     */
    @PreAuthorize("@ss.hasPermi('exam:question:remove')")
    @Log(title = "题库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{questionIds}")
    public AjaxResult remove(@PathVariable String[] questionIds)
    {
        return toAjax(examQuestionService.deleteExamQuestionByQuestionIds(questionIds));
    }
}
