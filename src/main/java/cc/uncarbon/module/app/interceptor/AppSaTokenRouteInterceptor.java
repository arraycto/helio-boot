package cc.uncarbon.module.app.interceptor;

import cc.uncarbon.framework.core.props.HelioProperties;
import cc.uncarbon.module.app.constant.AppConstant;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * 路由拦截器，自定义验证规则
 * http://sa-token.dev33.cn/doc/index.html#/use/route-check
 * @author Uncarbon
 */
public class AppSaTokenRouteInterceptor extends SaRouteInterceptor {

    @Resource
    private HelioProperties helioProperties;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 登录验证
        SaRouter.match(
                Collections.singletonList(AppConstant.APP_MODULE_CONTEXT_PATH + "/**")
                , helioProperties.getSecurity().getExcludeRoutes()
                , StpUtil::checkLogin
        );
    }
}
