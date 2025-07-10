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
 * @Description: 设备数据权限信息
 * @Author: jeecg-boot
 * @Date:   2025-07-10
 * @Version: V1.0
 */
@Data
@TableName("ac_device_permission")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="设备数据权限信息")
public class AcDevicePermission implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private String id;
	/**用户ID*/
	@Excel(name = "用户ID", width = 15, dictTable = "sys_user", dicText = "username", dicCode = "id")
	@Dict(dictTable = "sys_user", dicText = "username", dicCode = "id")
    @Schema(description = "用户ID")
    private String userId;
	/**冗余用户名*/
	@Excel(name = "冗余用户名", width = 15)
    @Schema(description = "冗余用户名")
    private String username;
	/**设备ID*/
	@Excel(name = "设备ID", width = 15, dictTable = "ac_devices", dicText = "brand", dicCode = "id")
	@Dict(dictTable = "ac_devices", dicText = "brand", dicCode = "id")
    @Schema(description = "设备ID")
    private String deviceId;
	/**可用状态*/
	@Excel(name = "可用状态", width = 15, dicCode = "y_or_n")
	@Dict(dicCode = "y_or_n")
    @Schema(description = "可用状态")
    private String useStatus;
	/**创建人*/
    @Schema(description = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private String sysOrgCode;
}
