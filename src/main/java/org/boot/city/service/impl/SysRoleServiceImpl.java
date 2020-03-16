package org.boot.city.service.impl;

import org.boot.city.entity.SysRole;
import org.boot.city.mapper.SysRoleMapper;
import org.boot.city.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
    
    public SysRole selectByName(String name){
        return roleMapper.selectByName(name);
    }
}
