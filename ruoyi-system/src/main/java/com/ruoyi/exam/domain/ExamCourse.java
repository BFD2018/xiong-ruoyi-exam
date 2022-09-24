package com.ruoyi.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 学院id */
    @Excel(name = "学院id")
    private String instituteId;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String instituteName;

    /** 专业id */
    @Excel(name = "专业id")
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 教师id */
    @Excel(name = "教师id")
    private Long teacherId;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String teacherName;

    /** 配套教材 */
    @Excel(name = "配套教材")
    private String courseBook;

}
