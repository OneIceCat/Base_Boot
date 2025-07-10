import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '用户ID',
    align: "center",
    dataIndex: 'userId_dictText'
  },
  {
    title: '冗余用户名',
    align: "center",
    dataIndex: 'username'
  },
  {
    title: '设备ID',
    align: "center",
    dataIndex: 'deviceId_dictText'
  },
  {
    title: '可用状态',
    align: "center",
    dataIndex: 'useStatus_dictText'
  },
];

// 高级查询数据
export const superQuerySchema = {
  userId: {title: '用户ID',order: 0,view: 'sel_search', type: 'string',dictTable: "sys_user", dictCode: 'id', dictText: 'username',},
  username: {title: '冗余用户名',order: 1,view: 'text', type: 'string',},
  deviceId: {title: '设备ID',order: 2,view: 'sel_search', type: 'string',dictTable: "ac_devices", dictCode: 'id', dictText: 'brand',},
  useStatus: {title: '可用状态',order: 3,view: 'list', type: 'string',dictCode: 'y_or_n',},
};
