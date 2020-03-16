package org.boot.city.service;

import org.boot.city.entity.SysUser;

public interface SysUserService {

    public SysUser selectById(Integer id);

    public SysUser selectByName(String name);
    
    public String selectPwdByName(String name);
    
    public int updatePwdByName(String name, String newPwd);
}

