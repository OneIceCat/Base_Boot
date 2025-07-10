package org.jeecg.modules.devices.appController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.devices.entity.AcCommand;
import org.jeecg.modules.devices.entity.AcDevices;
import org.jeecg.modules.devices.service.IAcCommandService;
import org.jeecg.modules.devices.service.IAcDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
* @Description: 设备管理表
* @Author: jeecg-boot
* @Date:   2025-06-21
* @Version: V1.0
*/
@Tag(name="设备管理表")
@RestController
@RequestMapping("/devices")
@Slf4j
public class AcDevicesControllerApp extends JeecgController<AcDevices, IAcDevicesService> {
   @Autowired
   private IAcDevicesService acDevicesService;
   @Autowired
   private IAcCommandService acCommandService;
   /**
    *   添加
    *
    * @param message
    * @return
    */
   @AutoLog(value = "设备管理表common-添加")
   @Operation(summary="设备管理表common-添加")
   @IgnoreAuth
   @PostMapping(value = "/upJson")
   public Result<Map<String, Object>> add(@RequestBody Map<String, Object> message) {
       System.out.println(message);
      return Result.ok(message);
//      Object typeObj = message.get("type");
//      if (!(typeObj instanceof String)) {
//         return Result.error("'type' must be a string");
//      }
//      String type = (String) typeObj;
//      switch (type) {
//         case "text":
//            AcDevices acDevices = new AcDevices();
//            acDevices.setDeviceId((String) message.get("device_i  d"));
//            acDevices.setBrand((String) message.get("model"));
//
//            acDevicesService.save(acDevices);
//            System.out.println("11111113");
//            return Result.OK("text");
//         case "iamge":
//            return Result.OK("image");
//         default:
//            // 不支持的 type 类型
//            return Result.error("未指定的类型" );
//      }



   }


   /**
    * 通过命令类型查询命令
    *
    * @param type
    * @return
    */
   //@AutoLog(value = "命令列表-通过命令类型查询命令 ")
   @Operation(summary="命令列表-通过命令类型查询命令 ")
   @GetMapping(value = "/commandQueryByType")
   @IgnoreAuth
   public Result<String> queryById(@RequestParam(name="type",required=true) String type) {
      QueryWrapper<AcCommand> queryWrapper = new QueryWrapper<>();
// 设置查询条件
      queryWrapper.eq("type", type);
      AcCommand acCommand = acCommandService.getOne(queryWrapper);
      if(acCommand==null) {
         return Result.error("未找到对应数据");
      }
      return Result.OK("",acCommand.getShell());
   }

}
