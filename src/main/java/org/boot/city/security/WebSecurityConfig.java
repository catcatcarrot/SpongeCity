//package org.boot.city.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    
//	@Autowired
//    private CustomUserDetailsService userDetailsService;
//	
//	@Autowired
//	private LoginSuccessHandler loginSuccessHandler;
//	
//	@Autowired
//	private LoginFailHandler loginFailHandler;
//
//	
//	/**
//     * 用户认证配置
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return s.equals(charSequence.toString());
//            }
//        });
//    	
//        /**
//         * 指定用户认证时，默认从哪里获取认证用户信息
//         */
//    	/*auth.userDetailsService(userDetailsService)
//    	       .passwordEncoder(new BCryptPasswordEncoder());*/
//
//    }
//
//    /**
//     * Http安全配置
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	//通过调用authorizeRequests()和 anyRequest().authenticated()就会要求所有进入应用的 HTTP请求都要进行认证
//       http.authorizeRequests()
//        		.antMatchers("/getVerifyCode","/admin/code").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                // 设置登陆页  默认：username password remember-me
//                .formLogin()
//                .usernameParameter("admin_name")//设置登录页的name名
//                .passwordParameter("admin_pwd")
//                .loginPage("/login").permitAll()   //进入自定义登录页面 
//                // 设置登陆成功页
//                .successHandler(loginSuccessHandler).permitAll()
//                .failureHandler(loginFailHandler).permitAll()
//                //.successForwardUrl("/").permitAll()
//               // .defaultSuccessUrl("/").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll();//logout  默认请求  /logout 可以配置退出登录渠道的页面
//
//        //关闭CSRF跨域
//        //因为spring security登录后会对所有post请求验证csrf_token， 验证失败无法访问，静态页面处理起来比较复杂,所以关闭
//        http.csrf().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //设置拦截忽略文件夹，可以对静态资源放行
//    	web.ignoring().antMatchers("/**/*.css", "/**/*.js", "/**/font/**");
//    }
//
//
//}
