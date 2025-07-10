import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '命令类型',
    align:"center",
    dataIndex: 'type'
   },
   {
    title: '命令内容',
    align:"center",
    dataIndex: 'shell'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
];