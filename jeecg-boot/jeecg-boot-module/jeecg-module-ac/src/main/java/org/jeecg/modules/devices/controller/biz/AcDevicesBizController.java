package org.jeecg.modules.devices.controller.biz;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.devices.entity.AcDevices;
import org.jeecg.modules.devices.service.IAcDevicesService;
import org.jeecg.modules.devices.service.biz.DevicePermissionBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 设备管理表
 * @Author: jeecg-boot
 * @Date: 2025-07-10
 * @Version: V1.0
 */
@Tag(name = "设备管理表")
@RestController
@RequestMapping("/devices/biz/acDevices")
@Slf4j
public class AcDevicesBizController extends JeecgController<AcDevices, IAcDevicesService> {
    @Autowired
    private IAcDevicesService acDevicesService;
    @Autowired
    private DevicePermissionBizService devicePermissionBizService;

    /**
     * 分页列表查询
     *
     * @param acDevices
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "设备管理表-分页列表查询")
    @Operation(summary = "设备管理表-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<AcDevices>> queryPageList(AcDevices acDevices,
                                                  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                  HttpServletRequest req) {

        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String roleCode = sysUser.getRoleCode();


        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcDevices> queryWrapper = QueryGenerator.initQueryWrapper(acDevices, req.getParameterMap(), customeRuleMap);
        // 如果是管理员，查询所有
        if (!StrUtil.equals("admin", roleCode)) {
            List<String> myPermission = devicePermissionBizService.getMyPermission(sysUser.getId());
            queryWrapper.in("id", myPermission);
        }

        Page<AcDevices> page = new Page<AcDevices>(pageNo, pageSize);
        IPage<AcDevices> pageList = acDevicesService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

}
