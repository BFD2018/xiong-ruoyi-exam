package com.ruoyi.exam.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ExamCoursePeriod extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 课程id */
    @Excel(name = "课程id")
    private String courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课时名称;微型计算机概述 */
    @Excel(name = "课时名称;微型计算机概述")
    private String name;

    /** 课时时长;45分钟 */
    @Excel(name = "课时时长;45分钟")
    private String duration;

    /** 时间安排;2022-9-1 9:00:00 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间安排;2022-9-1 9:00:00", width = 30, dateFormat = "yyyy-MM-dd")
    private Date schedule;

    /** 课时顺序;1 */
    @Excel(name = "课时顺序;1")
    private Long order;

    /** 课时重要等级;课时重要程度1-5（1,2级可以省略讲，4,5级需要仔细讲） */
    @Excel(name = "课时重要等级;课时重要程度1-5", readConverterExp = "1=,2级可以省略讲，4,5级需要仔细讲")
    private Long level;

}
