package org.boot.city.service;

import java.util.List;

import org.boot.city.entity.SysUserRole;


public interface SysUserRoleService {

    public List<SysUserRole> listByUserId(Integer userId);
}
