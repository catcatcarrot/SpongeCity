//package org.boot.city.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.boot.city.entity.SysRole;
//import org.boot.city.entity.SysUser;
//import org.boot.city.entity.SysUserRole;
//import org.boot.city.service.SysRoleService;
//import org.boot.city.service.SysUserRoleService;
//import org.boot.city.service.SysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
////注入用户信息和权限
//@Service("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private SysUserService userService;
//
//    @Autowired
//    private SysRoleService roleService;
//
//    @Autowired
//    private SysUserRoleService userRoleService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        // 从数据库中取出用户信息
//        SysUser user = userService.selectByName(username);
//
//        // 判断用户是否存在
//        if(user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        // 添加权限 
//        /*
//         1.找出该用户user_id对应的那个 user_role对应表的所有属性
//         2.根据 user_role表找出该用户对应所有role
//         3.把所有角色名加入authorities中
//        */
//        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
//        for (SysUserRole userRole : userRoles) {
//            SysRole role = roleService.selectById(userRole.getRoleId());
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        // 返回UserDetails实现类
//        System.out.println(user.getName()+":"+user.getPassword()+":"+authorities);
//        return new User(user.getName(), user.getPassword(), authorities);
//    }
//}
