package org.boot.city.mapper;

import org.boot.city.entity.SysRole;

public interface SysRoleMapper {
 
    SysRole selectById(Integer id);
    
    SysRole selectByName(String name);
}

