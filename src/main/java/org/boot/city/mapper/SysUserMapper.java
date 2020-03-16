package org.boot.city.mapper;

import org.apache.ibatis.annotations.Param;
import org.boot.city.entity.SysUser;

public interface SysUserMapper {

    SysUser selectById(Integer id);

    SysUser selectByName(String name);
    
    String selectPwdByName(String name);
    
    int updatePwdByName(@Param("name") String name, @Param("pwd") String newPwd);
    
}
