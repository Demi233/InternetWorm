package com.zcnhome.business.commons.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcnhome.business.commons.Constants;


/**
 * Servlet Filter implementation class UserAuthentication
 */
@WebFilter({"/m/*"})
public class MngAuthFilter implements Filter {
    
    private static final Set<String> WHITE_URL_SET = new HashSet<String>()
    {
        /**
         * 白名单
         */
        private static final long serialVersionUID = -8700909693733057360L;

        {
            add("/favicon.ico");
            add("/m/index");
            add("/m/logout");
            add("/m/login");
        }
    };

    /**
     * Default constructor.
     */
    public MngAuthFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain fchain)
            throws IOException, ServletException {
        if (srequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) srequest;
            HttpServletResponse response = (HttpServletResponse)sresponse;
            HttpSession session = request.getSession();
            String path = request.getServletPath();
            Object object = session.getAttribute(Constants.Commons.SESSION_STORE_USER);
            if (WHITE_URL_SET.contains(path)) {
                //跳转到下一个filter
                fchain.doFilter(request, response);
                return;
            }
            if (null != object) {
                fchain.doFilter(request, response);
                return;
            }else {
                response.sendRedirect(request.getContextPath() + "/m/logout?flag=1&redirect="
                        + request.getContextPath() + path);
                return;
            }
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
