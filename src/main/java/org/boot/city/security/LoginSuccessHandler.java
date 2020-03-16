//package org.boot.city.security;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.boot.city.entity.AdminModel;
//import org.boot.city.entity.SysUser;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		UserDetails details = (UserDetails) auth.getPrincipal();
//		AdminModel model = new AdminModel();
//		SysUser admin = new SysUser();
//		admin.setName(details.getUsername());
//		//admin.setPassword(details.getPassword());  ÄÃ²»µ½°¡£¡£¡£¡
//		model.setCode(0);
//		model.setData(admin);
//		request.getSession().setAttribute("user", model);
//		response.getWriter().write("ok");
//	}
//}
