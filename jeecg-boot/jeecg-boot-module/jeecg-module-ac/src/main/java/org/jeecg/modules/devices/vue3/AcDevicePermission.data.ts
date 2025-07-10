import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '用户ID',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '设备ID',
    align:"center",
    dataIndex: 'deviceId'
   },
   {
    title: '可用状态',
    align:"center",
    dataIndex: 'useStatus'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '用户ID',
    field: 'userId',
    component: 'Input',
  },
  {
    label: '设备ID',
    field: 'deviceId',
    component: 'Input',
  },
  {
    label: '可用状态',
    field: 'useStatus',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  userId: {title: '用户ID',order: 0,view: 'text', type: 'string',},
  deviceId: {title: '设备ID',order: 1,view: 'text', type: 'string',},
  useStatus: {title: '可用状态',order: 2,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}