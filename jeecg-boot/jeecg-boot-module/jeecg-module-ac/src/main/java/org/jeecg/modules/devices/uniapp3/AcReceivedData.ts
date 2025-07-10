import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
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