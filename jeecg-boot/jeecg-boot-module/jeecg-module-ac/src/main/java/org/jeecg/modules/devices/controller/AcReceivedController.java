package org.jeecg.modules.devices.controller;

import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.devices.entity.AcReceived;
import org.jeecg.modules.devices.service.IAcReceivedService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 短信列表
 * @Author: jeecg-boot
 * @Date:   2025-06-21
 * @Version: V1.0
 */
@Tag(name="短信列表")
@RestController
@RequestMapping("/devices/acReceived")
@Slf4j
public class AcReceivedController extends JeecgController<AcReceived, IAcReceivedService> {
	@Autowired
	private IAcReceivedService acReceivedService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acReceived
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "短信列表-分页列表查询")
	@Operation(summary="短信列表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcReceived>> queryPageList(AcReceived acReceived,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcReceived> queryWrapper = QueryGenerator.initQueryWrapper(acReceived, req.getParameterMap());
		Page<AcReceived> page = new Page<AcReceived>(pageNo, pageSize);
		IPage<AcReceived> pageList = acReceivedService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acReceived
	 * @return
	 */
	@AutoLog(value = "短信列表-添加")
	@Operation(summary="短信列表-添加")
	@RequiresPermissions("devices:ac_received:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcReceived acReceived) {
		acReceivedService.save(acReceived);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acReceived
	 * @return
	 */
	@AutoLog(value = "短信列表-编辑")
	@Operation(summary="短信列表-编辑")
	@RequiresPermissions("devices:ac_received:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcReceived acReceived) {
		acReceivedService.updateById(acReceived);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "短信列表-通过id删除")
	@Operation(summary="短信列表-通过id删除")
	@RequiresPermissions("devices:ac_received:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acReceivedService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "短信列表-批量删除")
	@Operation(summary="短信列表-批量删除")
	@RequiresPermissions("devices:ac_received:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acReceivedService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "短信列表-通过id查询")
	@Operation(summary="短信列表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcReceived> queryById(@RequestParam(name="id",required=true) String id) {
		AcReceived acReceived = acReceivedService.getById(id);
		if(acReceived==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acReceived);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acReceived
    */
    @RequiresPermissions("devices:ac_received:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcReceived acReceived) {
        return super.exportXls(request, acReceived, AcReceived.class, "短信列表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("devices:ac_received:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcReceived.class);
    }

}
