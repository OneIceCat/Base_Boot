package org.jeecg.modules.devices.service.biz;

import cn.hutool.core.collection.CollectionUtil;
import org.jeecg.common.constant.enums.MessageTypeEnum;
import org.jeecg.modules.devices.entity.AcDevicePermission;
import org.jeecg.modules.devices.entity.AcDevices;
import org.jeecg.modules.devices.service.IAcDevicePermissionService;
import org.jeecg.modules.devices.service.IAcDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.jeecg.common.constant.enums.ConstTypeEnum.Y;

@Service
public class DevicePermissionBizService {

    @Autowired
    IAcDevicePermissionService acDevicePermissionService;

    @Autowired
    IAcDevicesService iAcDevicesService;

    /**
     * 获取我所有的能查看的设备Id
     * @param uid
     * @return
     */
    public List<String> getMyPermission(String uid) {
        // 获取我所有的能查看的设备
        List<AcDevicePermission> list = acDevicePermissionService.lambdaQuery().eq(AcDevicePermission::getUserId, uid)
                .eq(AcDevicePermission::getUseStatus, Y.getType()).list();
        // 抽取我能查看的数据的id
        return list.stream().map(AcDevicePermission::getDeviceId).toList();
    }

    /**
     * 获取我所有的能查看的设备
     * @param uid
     * @return
     */
    public List<AcDevices> getMyPermissionDevices(String uid) {
        List<String> myPermission = getMyPermission(uid);
        if(CollectionUtil.isEmpty(myPermission)){
            return new ArrayList<>();
        }
        // 获取我所有的能查看的设备
        return iAcDevicesService.lambdaQuery().in(AcDevices::getId,myPermission).list();
    }

}
