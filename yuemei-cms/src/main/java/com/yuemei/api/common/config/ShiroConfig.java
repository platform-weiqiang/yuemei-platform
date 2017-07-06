//package com.yuemei.api.common.config;
//
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.ShiroHttpSession;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.crazycake.shiro.RedisCacheManager;
//import org.crazycake.shiro.RedisManager;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.apache.shiro.codec.Base64;
//import com.yuemei.api.admin.service.SysPermissionInitService;
//import com.yuemei.api.common.config.service.MShiroFilterFactoryBean;
//import com.yuemei.api.common.config.service.MyShiroRealm;
//import org.apache.shiro.web.servlet.Cookie;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.shiro.mgt.SecurityManager;
//
//@Configuration
//public class ShiroConfig {
//
//	@Autowired(required = false)
//	SysPermissionInitService sysPermissionInitService;
//	
//	@Value("${spring.redis.host}")
//	private String host;
//	@Value("${spring.redis.port}")
//	private int port;
//	@Value("${spring.redis.password}")
//	private String password;
//	@Value("${spring.redis.timeout}")
//    private int timeout;
//	
//	/**
//	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
//	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
//	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
//	 *
//	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
//	 * 3、部分过滤器可指定参数，如perms，roles
//	 *
//	 */
//	@Bean
//	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//		ShiroFilterFactoryBean shiroFilterFactoryBean=new MShiroFilterFactoryBean();
//		// 必须设置 SecurityManager
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		// 登录成功后要跳转的链接
//		shiroFilterFactoryBean.setSuccessUrl("/pic2");
//		// 未授权界面;
//		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//		Map<String, String> hashMap = new HashMap<>();
//	    hashMap.put("/static/**", "anon");
//	    hashMap.put("/login", "anon");
//	    hashMap.put("/getGifCode", "anon");
//	    hashMap.put("/ajaxLogin", "anon");
//	    hashMap.put("/**", "user");
//	    shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);
//		return shiroFilterFactoryBean;
//	}
//	
//	@Bean
//	public DefaultWebSecurityManager securityManager() {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		// 设置realm.
//		securityManager.setRealm(myShiroRealm());
//		// 自定义缓存实现 使用redis
//		securityManager.setCacheManager(cacheManager());
//		// 自定义session管理 使用redis
//		securityManager.setSessionManager(sessionManager());
//		//注入记住我管理器;
//	    securityManager.setRememberMeManager(rememberMeManager());
//		return securityManager;
//	}
//	
//	/**
//	 * 配置shiro redisManager
//	 * 使用的是shiro-redis开源插件
//	 * @return
//	 */
//	public RedisManager redisManager() {
//		RedisManager redisManager = new RedisManager();
//		redisManager.setHost(host);
//		redisManager.setPort(port);
//		redisManager.setExpire(1800);// 配置缓存过期时间
//		redisManager.setTimeout(timeout);
//		redisManager.setPassword(password);
//		return redisManager;
//	}
//	/**
//	 * cacheManager 缓存 redis实现
//	 * 使用的是shiro-redis开源插件
//	 * @return
//	 */
//	public RedisCacheManager cacheManager() {
//		RedisCacheManager redisCacheManager = new RedisCacheManager();
//		redisCacheManager.setRedisManager(redisManager());
//		return redisCacheManager;
//	}
//	
//	/**
//	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
//	 * 使用的是shiro-redis开源插件
//	 */
//	@Bean
//	public RedisSessionDAO redisSessionDAO() {
//		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//		redisSessionDAO.setRedisManager(redisManager());
//		return redisSessionDAO;
//	}
//	
//	/**
//	 * Session Manager
//	 * 使用的是shiro-redis开源插件
//	 */
//	@Bean
//	public DefaultWebSessionManager sessionManager() {
//		YueMeiProperties yueMeiProperties=new YueMeiProperties();
//		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		sessionManager.setSessionDAO(redisSessionDAO());
//		sessionManager.setCacheManager(cacheManager());
//		sessionManager.setSessionValidationInterval(yueMeiProperties.getSessionValidationInterval() * 1000);
//        sessionManager.setGlobalSessionTimeout(yueMeiProperties.getSessionInvalidateTime() * 1000);
//        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
//        cookie.setName("shiroCookie");
//        cookie.setHttpOnly(true);
//        sessionManager.setSessionIdCookie(cookie);
//		return sessionManager;
//	}
//	
//	/**
//	 * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
//	 * 
//	 * @return
//	 */
//	@Bean
//	public MyShiroRealm myShiroRealm() {
//		MyShiroRealm myShiroRealm = new MyShiroRealm();
//		return myShiroRealm;
//	}
//	
//	/**
//     * cookie对象;
//     * @return
//     */
//    public SimpleCookie rememberMeCookie(){
//       //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//       SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//       simpleCookie.setHttpOnly(true);
//       //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//       simpleCookie.setMaxAge(7 * 24 * 60 * 60);//7天
//       return simpleCookie;
//    }
//    
//    /**
//     * cookie管理对象;记住我功能
//     * @return
//     */
//    public CookieRememberMeManager rememberMeManager(){
//       CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//       cookieRememberMeManager.setCookie(rememberMeCookie());
//       //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//       cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
//       return cookieRememberMeManager;
//    }
//    
//    /**
//     * 在方法中 注入 securityManager,进行代理控制
//     */
//    /*@Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultWebSecurityManager securityManager) {
//        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
//        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        bean.setArguments(new Object[]{securityManager});
//        return bean;
//    }*/
//    
//    /**
//     * 保证实现了Shiro内部lifecycle函数的bean执行
//     */
//   /* @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//    
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
//                new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }*/
//    
//    /**
//     * 启用shrio授权注解拦截方式，AOP式方法级权限检查
//     */
//   /* @Bean
//    @DependsOn(value = "lifecycleBeanPostProcessor") //依赖其他bean的初始化
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        return new DefaultAdvisorAutoProxyCreator();
//    }*/
//
//  
//    /**
//     * 限制同一账号登录同时登录人数控制
//     * @return
//     */
//  /*  public KickoutSessionControlFilter kickoutSessionControlFilter(){
//    	KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
//    	//使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
//    	//这里我们还是用之前shiro使用的redisManager()实现的cacheManager()缓存管理
//    	//也可以重新另写一个，重新配置缓存时间之类的自定义缓存属性
//    	kickoutSessionControlFilter.setCacheManager(cacheManager());
//    	//用于根据会话ID，获取会话进行踢出操作的；
//    	kickoutSessionControlFilter.setSessionManager(sessionManager());
//    	//是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；踢出顺序。
//    	kickoutSessionControlFilter.setKickoutAfter(false);
//    	//同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
//    	kickoutSessionControlFilter.setMaxSession(1);
//    	//被踢出后重定向到的地址；
//    	kickoutSessionControlFilter.setKickoutUrl("/kickout");
//        return kickoutSessionControlFilter;
//     }*/
//}
