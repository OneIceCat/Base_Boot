package org.jeecg.modules.devices.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 设备管理表
 * @Author: jeecg-boot
 * @Date:   2025-07-10
 * @Version: V1.0
 */
@Data
@TableName("ac_devices")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="设备管理表")
public class AcDevices implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**创建人*/
    @Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
	/**设备id*/
	@Excel(name = "设备id", width = 15)
    @Schema(description = "设备id")
    private java.lang.String deviceId;
	/**品牌*/
	@Excel(name = "品牌", width = 15)
    @Schema(description = "品牌")
    private java.lang.String brand;
	/**型号*/
	@Excel(name = "型号", width = 15)
    @Schema(description = "型号")
    private java.lang.String model;
	/**在线状态*/
	@Excel(name = "在线状态", width = 15, dicCode = "onlineStatus")
	@Dict(dicCode = "onlineStatus")
    @Schema(description = "在线状态")
    private java.lang.String status;
	/**用户*/
	@Excel(name = "用户", width = 15)
    @Schema(description = "用户")
    private java.lang.String assignedTo;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @Schema(description = "备注")
    private java.lang.String remark;
}
