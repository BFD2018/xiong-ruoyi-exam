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
import com.ruoyi.exam.domain.ExamCoursePeriod;
import com.ruoyi.exam.service.IExamCoursePeriodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程章节Controller
 * 
 * @author ruoyi
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/exam/period")
public class ExamCoursePeriodController extends BaseController
{
    @Autowired
    private IExamCoursePeriodService examCoursePeriodService;

    /**
     * 查询课程章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:period:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamCoursePeriod examCoursePeriod)
    {
        startPage();
        List<ExamCoursePeriod> list = examCoursePeriodService.selectExamCoursePeriodList(examCoursePeriod);
        return getDataTable(list);
    }

    /**
     * 导出课程章节列表
     */
    @PreAuthorize("@ss.hasPermi('system:period:export')")
    @Log(title = "课程章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamCoursePeriod examCoursePeriod)
    {
        List<ExamCoursePeriod> list = examCoursePeriodService.selectExamCoursePeriodList(examCoursePeriod);
        ExcelUtil<ExamCoursePeriod> util = new ExcelUtil<ExamCoursePeriod>(ExamCoursePeriod.class);
        util.exportExcel(response, list, "课程章节数据");
    }

    /**
     * 获取课程章节详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:period:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(examCoursePeriodService.selectExamCoursePeriodById(id));
    }

    /**
     * 新增课程章节
     */
    @PreAuthorize("@ss.hasPermi('system:period:add')")
    @Log(title = "课程章节", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamCoursePeriod examCoursePeriod)
    {
        return toAjax(examCoursePeriodService.insertExamCoursePeriod(examCoursePeriod));
    }

    /**
     * 修改课程章节
     */
    @PreAuthorize("@ss.hasPermi('system:period:edit')")
    @Log(title = "课程章节", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamCoursePeriod examCoursePeriod)
    {
        return toAjax(examCoursePeriodService.updateExamCoursePeriod(examCoursePeriod));
    }

    /**
     * 删除课程章节
     */
    @PreAuthorize("@ss.hasPermi('system:period:remove')")
    @Log(title = "课程章节", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examCoursePeriodService.deleteExamCoursePeriodByIds(ids));
    }
}
