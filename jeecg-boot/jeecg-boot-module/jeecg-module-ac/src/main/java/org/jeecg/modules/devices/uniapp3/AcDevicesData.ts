import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
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