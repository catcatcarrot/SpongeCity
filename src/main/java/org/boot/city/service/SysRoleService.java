package org.boot.city.service;


import org.boot.city.entity.SysRole;

public interface SysRoleService {

    public SysRole selectById(Integer id);
    
    public SysRole selectByName(String name);
}
