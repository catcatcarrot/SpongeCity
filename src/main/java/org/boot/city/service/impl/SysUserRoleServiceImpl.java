package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.SysUserRole;
import org.boot.city.mapper.SysUserRoleMapper;
import org.boot.city.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
