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
import com.ruoyi.exam.domain.ExamCollect;
import com.ruoyi.exam.service.IExamCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目收藏Controller
 * 
 * @author xiong
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/exam/collect")
public class ExamCollectController extends BaseController
{
    @Autowired
    private IExamCollectService examCollectService;

    /**
     * 查询题目收藏列表
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamCollect examCollect)
    {
        startPage();
        List<ExamCollect> list = examCollectService.selectExamCollectList(examCollect);
        return getDataTable(list);
    }

    /**
     * 导出题目收藏列表
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:export')")
    @Log(title = "题目收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamCollect examCollect)
    {
        List<ExamCollect> list = examCollectService.selectExamCollectList(examCollect);
        ExcelUtil<ExamCollect> util = new ExcelUtil<ExamCollect>(ExamCollect.class);
        util.exportExcel(response, list, "题目收藏数据");
    }

    /**
     * 获取题目收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(examCollectService.selectExamCollectById(id));
    }

    /**
     * 新增题目收藏
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:add')")
    @Log(title = "题目收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamCollect examCollect)
    {
        return toAjax(examCollectService.insertExamCollect(examCollect));
    }

    /**
     * 修改题目收藏
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:edit')")
    @Log(title = "题目收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamCollect examCollect)
    {
        return toAjax(examCollectService.updateExamCollect(examCollect));
    }

    /**
     * 删除题目收藏
     */
    @PreAuthorize("@ss.hasPermi('exam:collect:remove')")
    @Log(title = "题目收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examCollectService.deleteExamCollectByIds(ids));
    }
}
