package com.gy.upms.component;

import com.gy.upms.dao.ApplicationMapper;
import com.gy.upms.dao.PermissionMapper;
import com.gy.upms.dao.UserLoginMapper;
import com.gy.upms.dao.UserOrgMapper;
import com.gy.upms.entity.*;
import com.gy.upms.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: guofeng
 * @Date: 2019/6/4 11:52
 * @Description:
 */
@Component
public class VerifyUtils {

    //应用程序 Jcache 缓存
    private static final String CACHE_APPS="apps";
    //用户相关 Jcache 缓存
    private static final String CACHE_USERS="users";
    //用户缓存key前缀
    private static  final String KEYUSER_PREFIX="user_";
    //应用缓存key前缀
    private static  final String KEYAPP_PREFIX="app_auth_";
    //应用缓存key前缀 权限
    private static  final String KEYAPP_PERM_PREFIX="app_perm_";
    //用户权限key前缀
    private static  final String KEYUSER_PERM_PREFIX="user_perm_";
    //用户组织key前缀
    private static  final String KEYUSER_ORG_PREFIX="user_org_";

    //登录过期时间 30D
    private static  Integer LOGINEXPDUR=30;
    @Value("${redis.exp.dur.app}")
    public  void setLOGINEXPDUR(Integer LOGINEXPDUR) {
        if (LOGINEXPDUR!=null && LOGINEXPDUR>0) {
            VerifyUtils.LOGINEXPDUR = LOGINEXPDUR;
        }
    }

    //应用授权过期时间 1D
    private static  Integer APPEXPDUR=1;
    @Value("${redis.exp.dur.user}")
    public  void setAPPEXPDUR(Integer APPEXPDUR) {
        if (APPEXPDUR!=null && APPEXPDUR>0) {
            VerifyUtils.APPEXPDUR = APPEXPDUR;
        }
    }

    private static UserLoginMapper userLoginMapper;
    @Autowired
    public void setUserLoginMapper(UserLoginMapper userLoginMapper) {
        VerifyUtils.userLoginMapper = userLoginMapper;
    }

    private static ApplicationMapper applicationMapper;

    @Autowired
    public  void setApplicationMapper(ApplicationMapper applicationMapper) {
        VerifyUtils.applicationMapper = applicationMapper;
    }

    private static PermissionMapper permissionMapper;

    @Autowired
    public  void setPermissionMapper(PermissionMapper permissionMapper) {
        VerifyUtils.permissionMapper = permissionMapper;
    }

    private  static UserOrgMapper userOrgMapper;

    @Autowired
    public  void setUserOrgMapper(UserOrgMapper userOrgMapper) {
        VerifyUtils.userOrgMapper = userOrgMapper;
    }


    private static CacheManager jCacheCacheManager;
    @Autowired
    public  void setEhcacheManager(CacheManager jCacheCacheManager) {
        VerifyUtils.jCacheCacheManager = jCacheCacheManager;
    }

    /**
     * 保存登录信息 到redis 及数据库
     * @param userAccount 登录的用户账号信息
     * @param loginTime 登录的时间
     * @return 登录的成功后的token
     */
    public  static String setUserLogin(UserAccount userAccount, LocalDateTime loginTime){
        //保存到数据库
        UserLogin userLogin=new UserLogin();
        userLogin.setUserId(userAccount.getId());
        userLogin.setLoginTime(loginTime);
        userLogin.setExpDur(LOGINEXPDUR);
        userLoginMapper.insertOrUpdate(userLogin);
        //保存到缓存 对象为登录返回对象
        String key=KEYUSER_PREFIX+userAccount.getId();
        UserLoginInfo userLoginInfo= new UserLoginInfo(userAccount.getId(),userAccount.getUsername(),userAccount.getNickname(),
                userLogin.getToken(),userAccount.getEmail(),userAccount.getPhone(),userAccount.getUsertype(),userAccount.getComeform(),
                userAccount.getUserlevel(),userAccount.getOrgId(),userAccount.getJobtitleId(),loginTime);

        RedisUtil.set(key,userLoginInfo,LOGINEXPDUR*24*60*60);
        jCacheCacheManager.getCache(CACHE_USERS).put(key,userLoginInfo);

        return userLogin.getToken();
    }

    /**
     * 获取用户登录信息
     * @param userId 用户编号
     * @param nowTime 当前时间
     * @return
     */
    public static  UserLoginInfo getUserLogin(int userId,LocalDateTime nowTime){

        UserLoginInfo userLoginInfo=null;

        String key=KEYUSER_PREFIX+userId;
        userLoginInfo =jCacheCacheManager.getCache(CACHE_APPS).get(key,UserLoginInfo.class);
        if (userLoginInfo!=null){
            return  userLoginInfo;
        }
        Object redisLoginResult =RedisUtil.get(key);
        //首先从缓存获取
        if (redisLoginResult!=null){
            userLoginInfo=  JacksonUtils.obj2pojo(redisLoginResult,UserLoginInfo.class) ;
            jCacheCacheManager.getCache(CACHE_USERS).put(key,userLoginInfo);
        }
        else{
            userLoginInfo= userLoginMapper.selectLogin(userId,nowTime);
            //数据库存在登录信息 同步到redis
            if (userLoginInfo!=null){
                long expDur= Duration.between(nowTime,userLoginInfo.getLoginTime().plusDays(LOGINEXPDUR)).getSeconds();
                RedisUtil.set(key,userLoginInfo,expDur);
                jCacheCacheManager.getCache(CACHE_USERS).put(key,userLoginInfo);
            }
        }
        return  userLoginInfo;
    }

    /**
     * 获取应用程序信息 及 应用程序授权访问的应用
     * @param appToken 应用程序身份令牌
     * @return 授权信息
     */
    public static AppAndAuthInfo getAppAuth(String appToken){
        AppAndAuthInfo appAuthInfo=null;
        if (appToken==null || appToken.isEmpty()){
            return null;
        }
        String key =KEYAPP_PREFIX+appToken;

        appAuthInfo =jCacheCacheManager.getCache(CACHE_APPS).get(key,AppAndAuthInfo.class);
        if (appAuthInfo!=null){
            return appAuthInfo;
        }

        Object redisResult = RedisUtil.get(key);
        //首先从缓存获取
        if (redisResult!=null){
            appAuthInfo=  JacksonUtils.obj2pojo(redisResult,AppAndAuthInfo.class);
            jCacheCacheManager.getCache(CACHE_APPS).put(key,appAuthInfo);
        }
        else{
            appAuthInfo= applicationMapper.selectByToken(appToken);
            //数据库存在登录信息 同步到redis
            if (appAuthInfo!=null){
                long expDur=APPEXPDUR*24*60*60;
                RedisUtil.set(key,appAuthInfo,expDur);
                jCacheCacheManager.getCache(CACHE_APPS).put(key,appAuthInfo);
            }
        }
        return  appAuthInfo;
    }

    /**
     * 获取应用程序权限
     * @param token 应用编号
     * @return 权限列表
     */
    public static List<Permission> getAppPerm(String token){
        List<Permission> permissionList=null;
        if (token==null || token.isEmpty()){
            return  permissionList;
        }
        String key =KEYAPP_PERM_PREFIX+token;
        permissionList= jCacheCacheManager.getCache(CACHE_APPS).get(key, ArrayList.class);
        if (permissionList!=null){
            return  permissionList;
        }
        Object redisResult = RedisUtil.get(key);
        //首先从缓存获取
        if (redisResult!=null){
            permissionList=  JacksonUtils.json2list(redisResult,Permission.class) ;
            jCacheCacheManager.getCache(CACHE_APPS).put(key,permissionList);
        }
        else{
            permissionList= permissionMapper.selectByAppToken(token);
            //去掉重复数据
            Set<Permission>  permissionSet=new HashSet<>(permissionList);
            permissionList.clear();
            permissionList.addAll(permissionSet);

            //数据库存在登录信息 同步到redis
            if (permissionList!=null){
                long expDur=APPEXPDUR*24*60*60;
                RedisUtil.set(key,permissionList,expDur);
                jCacheCacheManager.getCache(CACHE_APPS).put(key,permissionList);
            }
        }
        return  permissionList;
    }
    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    public static List<Permission> getUserPerm(Integer userId){
        List<Permission> permissionList=null;
        if (userId==0){
            return  permissionList;
        }
        String key =KEYUSER_PERM_PREFIX+userId;
        permissionList= jCacheCacheManager.getCache(CACHE_USERS).get(key,ArrayList.class);
        if (permissionList!=null){
            return  permissionList;
        }
        Object redisResult = RedisUtil.get(key);
        //首先从缓存获取
        if (redisResult!=null){
            permissionList=  JacksonUtils.json2list(redisResult,Permission.class);
            jCacheCacheManager.getCache(CACHE_USERS).put(key,permissionList);
        }
        else{
            permissionList= permissionMapper.selectByUserIdAndAppId(userId,null);
            //去掉重复数据
            Set<Permission>  permissionSet=new HashSet<>(permissionList);
            permissionList.clear();
            permissionList.addAll(permissionSet);

            //数据库存在登录信息 同步到redis
            if (permissionList!=null){
                long expDur=LOGINEXPDUR*24*60*60;
                RedisUtil.set(key,permissionList,expDur);
                jCacheCacheManager.getCache(CACHE_USERS).put(key,permissionList);
            }
        }
        return  permissionList;
    }

    /**
     * 根据用户获取 组织 数据权限
     * @param userId 用户编号
     * @return
     */
    public static List<UserOrg> getUserOrg(Integer userId){
        List<UserOrg> userOrgList=null;
        if (userId==null){
            return  userOrgList;
        }
        String key =KEYUSER_ORG_PREFIX+userId;
        userOrgList= jCacheCacheManager.getCache(CACHE_USERS).get(key,ArrayList.class);
        if (userOrgList!=null){
            return  userOrgList;
        }
        Object redisResult = RedisUtil.get(key);
        //首先从缓存获取
        if (redisResult!=null){
            userOrgList=   JacksonUtils.json2list(redisResult,UserOrg.class) ;
            jCacheCacheManager.getCache(CACHE_USERS).put(key,userOrgList);
        }
        else{
            userOrgList= userOrgMapper.selectByUserId(userId);

            //数据库存在登录信息 同步到redis
            if (userOrgList!=null){
                long expDur=LOGINEXPDUR*24*60*60;
                RedisUtil.set(key,userOrgList,expDur);
                jCacheCacheManager.getCache(CACHE_USERS).put(key,userOrgList);
            }
        }
        return  userOrgList;
    }


}
