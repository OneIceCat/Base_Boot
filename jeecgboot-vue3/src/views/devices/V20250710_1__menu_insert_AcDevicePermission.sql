-- 注意：该页面对应的前台目录为views/devices文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025071011213000140', NULL, '设备数据权限信息', '/devices/acDevicePermissionList', 'devices/AcDevicePermissionList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010141', '2025071011213000140', '添加设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010142', '2025071011213000140', '编辑设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010143', '2025071011213000140', '删除设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010144', '2025071011213000140', '批量删除设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010145', '2025071011213000140', '导出excel_设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071011213010146', '2025071011213000140', '导入excel_设备数据权限信息', NULL, NULL, 0, NULL, NULL, 2, 'devices:ac_device_permission:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-10 23:21:14', NULL, NULL, 0, 0, '1', 0);