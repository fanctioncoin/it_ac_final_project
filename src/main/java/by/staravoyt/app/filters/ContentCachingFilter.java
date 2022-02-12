package by.staravoyt.app.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingResponseWrapper;

import by.staravoyt.app.controllers.interceptors.RealCachingRequestWrapper;



public class ContentCachingFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        RealCachingRequestWrapper reqWrapper = new RealCachingRequestWrapper((HttpServletRequest) req);
        ContentCachingResponseWrapper respWrapper = new ContentCachingResponseWrapper((HttpServletResponse) resp);
        reqWrapper.getParameterMap();
        chain.doFilter(reqWrapper, respWrapper);
        respWrapper.copyBodyToResponse();
    }
}
