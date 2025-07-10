package org.jeecg.modules.devices.service.impl;

import org.jeecg.modules.devices.entity.AcCommand;
import org.jeecg.modules.devices.mapper.AcCommandMapper;
import org.jeecg.modules.devices.service.IAcCommandService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 命令表
 * @Author: jeecg-boot
 * @Date:   2025-07-10
 * @Version: V1.0
 */
@Service
public class AcCommandServiceImpl extends ServiceImpl<AcCommandMapper, AcCommand> implements IAcCommandService {

}
