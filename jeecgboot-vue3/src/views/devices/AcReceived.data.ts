import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '设备id',
    align:"center",
    dataIndex: 'deviceId'
   },
   {
    title: '发送号码',
    align:"center",
    dataIndex: 'senderNumber'
   },
   {
    title: '短信内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备id',
    field: 'deviceId',
    component: 'Input',
  },
  {
    label: '发送号码',
    field: 'senderNumber',
    component: 'Input',
  },
  {
    label: '短信内容',
    field: 'content',
    component: 'InputTextArea',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'InputTextArea',
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
  deviceId: {title: '设备id',order: 0,view: 'text', type: 'string',},
  senderNumber: {title: '发送号码',order: 1,view: 'text', type: 'string',},
  content: {title: '短信内容',order: 2,view: 'textarea', type: 'string',},
  remark: {title: '备注',order: 3,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}