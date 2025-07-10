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
    title: '品牌',
    align:"center",
    dataIndex: 'brand'
   },
   {
    title: '型号',
    align:"center",
    dataIndex: 'model'
   },
   {
    title: '在线状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '用户',
    align:"center",
    dataIndex: 'assignedTo'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "在线状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"onlineStatus"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备id',
    field: 'deviceId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备id!'},
          ];
     },
  },
  {
    label: '品牌',
    field: 'brand',
    component: 'Input',
  },
  {
    label: '型号',
    field: 'model',
    component: 'Input',
  },
  {
    label: '在线状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"onlineStatus"
     },
  },
  {
    label: '用户',
    field: 'assignedTo',
    component: 'Input',
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
  brand: {title: '品牌',order: 1,view: 'text', type: 'string',},
  model: {title: '型号',order: 2,view: 'text', type: 'string',},
  status: {title: '在线状态',order: 3,view: 'list', type: 'string',dictCode: 'onlineStatus',},
  assignedTo: {title: '用户',order: 4,view: 'text', type: 'string',},
  remark: {title: '备注',order: 5,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}