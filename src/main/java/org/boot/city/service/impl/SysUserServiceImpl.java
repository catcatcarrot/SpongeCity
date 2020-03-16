package org.boot.city.service.impl;

import org.boot.city.entity.SysUser;
import org.boot.city.mapper.SysUserMapper;
import org.boot.city.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }

	public String selectPwdByName(String name) {
		return userMapper.selectPwdByName(name);
	}

	public int updatePwdByName(String name,String newPwd) {
		return userMapper.updatePwdByName(name, newPwd);
	}
}

