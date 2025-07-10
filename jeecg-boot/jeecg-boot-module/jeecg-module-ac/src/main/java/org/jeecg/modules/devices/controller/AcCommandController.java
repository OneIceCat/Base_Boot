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
import org.jeecg.modules.devices.entity.AcCommand;
import org.jeecg.modules.devices.service.IAcCommandService;

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
 * @Description: 命令表
 * @Author: jeecg-boot
 * @Date:   2025-07-10
 * @Version: V1.0
 */
@Tag(name="命令表")
@RestController
@RequestMapping("/devices/acCommand")
@Slf4j
public class AcCommandController extends JeecgController<AcCommand, IAcCommandService> {
	@Autowired
	private IAcCommandService acCommandService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acCommand
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "命令表-分页列表查询")
	@Operation(summary="命令表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcCommand>> queryPageList(AcCommand acCommand,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcCommand> queryWrapper = QueryGenerator.initQueryWrapper(acCommand, req.getParameterMap());
		Page<AcCommand> page = new Page<AcCommand>(pageNo, pageSize);
		IPage<AcCommand> pageList = acCommandService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acCommand
	 * @return
	 */
	@AutoLog(value = "命令表-添加")
	@Operation(summary="命令表-添加")
	@RequiresPermissions("devices:ac_command:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcCommand acCommand) {
		acCommandService.save(acCommand);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acCommand
	 * @return
	 */
	@AutoLog(value = "命令表-编辑")
	@Operation(summary="命令表-编辑")
	@RequiresPermissions("devices:ac_command:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcCommand acCommand) {
		acCommandService.updateById(acCommand);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "命令表-通过id删除")
	@Operation(summary="命令表-通过id删除")
	@RequiresPermissions("devices:ac_command:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acCommandService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "命令表-批量删除")
	@Operation(summary="命令表-批量删除")
	@RequiresPermissions("devices:ac_command:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acCommandService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "命令表-通过id查询")
	@Operation(summary="命令表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcCommand> queryById(@RequestParam(name="id",required=true) String id) {
		AcCommand acCommand = acCommandService.getById(id);
		if(acCommand==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acCommand);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acCommand
    */
    @RequiresPermissions("devices:ac_command:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcCommand acCommand) {
        return super.exportXls(request, acCommand, AcCommand.class, "命令表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("devices:ac_command:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcCommand.class);
    }

}
