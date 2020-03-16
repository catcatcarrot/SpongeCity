package org.boot.city.mapper;

import java.util.List;

import org.boot.city.entity.SysUserRole;

public interface SysUserRoleMapper {

	 List<SysUserRole> listByUserId(Integer userId);
}

