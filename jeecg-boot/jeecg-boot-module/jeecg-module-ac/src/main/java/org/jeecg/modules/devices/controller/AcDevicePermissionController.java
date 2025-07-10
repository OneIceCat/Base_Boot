package org.jeecg.modules.devices.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.devices.entity.AcDevicePermission;
import org.jeecg.modules.devices.service.IAcDevicePermissionService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 设备数据权限信息
 * @Author: jeecg-boot
 * @Date:   2025-07-10
 * @Version: V1.0
 */
@Tag(name="设备数据权限信息")
@RestController
@RequestMapping("/devices/acDevicePermission")
@Slf4j
public class AcDevicePermissionController extends JeecgController<AcDevicePermission, IAcDevicePermissionService> {
	@Autowired
	private IAcDevicePermissionService acDevicePermissionService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acDevicePermission
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "设备数据权限信息-分页列表查询")
	@Operation(summary="设备数据权限信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcDevicePermission>> queryPageList(AcDevicePermission acDevicePermission,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcDevicePermission> queryWrapper = QueryGenerator.initQueryWrapper(acDevicePermission, req.getParameterMap());
		Page<AcDevicePermission> page = new Page<AcDevicePermission>(pageNo, pageSize);
		IPage<AcDevicePermission> pageList = acDevicePermissionService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acDevicePermission
	 * @return
	 */
	@AutoLog(value = "设备数据权限信息-添加")
	@Operation(summary="设备数据权限信息-添加")
	@RequiresPermissions("devices:ac_device_permission:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcDevicePermission acDevicePermission) {
		acDevicePermissionService.save(acDevicePermission);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acDevicePermission
	 * @return
	 */
	@AutoLog(value = "设备数据权限信息-编辑")
	@Operation(summary="设备数据权限信息-编辑")
	@RequiresPermissions("devices:ac_device_permission:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcDevicePermission acDevicePermission) {
		acDevicePermissionService.updateById(acDevicePermission);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "设备数据权限信息-通过id删除")
	@Operation(summary="设备数据权限信息-通过id删除")
	@RequiresPermissions("devices:ac_device_permission:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acDevicePermissionService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "设备数据权限信息-批量删除")
	@Operation(summary="设备数据权限信息-批量删除")
	@RequiresPermissions("devices:ac_device_permission:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acDevicePermissionService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "设备数据权限信息-通过id查询")
	@Operation(summary="设备数据权限信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcDevicePermission> queryById(@RequestParam(name="id",required=true) String id) {
		AcDevicePermission acDevicePermission = acDevicePermissionService.getById(id);
		if(acDevicePermission==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acDevicePermission);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acDevicePermission
    */
    @RequiresPermissions("devices:ac_device_permission:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcDevicePermission acDevicePermission) {
        return super.exportXls(request, acDevicePermission, AcDevicePermission.class, "设备数据权限信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("devices:ac_device_permission:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcDevicePermission.class);
    }

}
