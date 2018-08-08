package com.myke.mybatis.interceptor;

import com.myke.mybatis.config.DataSourceContextHolder;
import com.myke.mybatis.utils.ContextDbMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author： zhangjianbin <br/>
 * ===============================
 * Created with IDEA.
 * Date： 2018/8/8
 * Time： 15:38
 * ================================
 */
@Slf4j
public class DbInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("---------------------开始进入请求地址拦截----------------------------");


        String header = request.getHeader("X-Sql");
        if (StringUtils.isNotBlank(header)) {
            return true;
        }

        String default_db = DataSourceContextHolder.DEFAULT_DS;

        String db = request.getParameter("db");
        if (StringUtils.isBlank(db)) {
            return false;
        }

        if (ContextDbMap.get(db)) {
            log.info("切换数据源:{}", db);
            DataSourceContextHolder.setDB(db);
        } else {
            log.info("默认数据源:{}", default_db);
            DataSourceContextHolder.setDB(default_db);
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
        DataSourceContextHolder.clearDB();
        super.postHandle(request, response, handler, modelAndView);
    }
}
