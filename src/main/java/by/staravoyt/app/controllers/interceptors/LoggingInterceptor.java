package by.staravoyt.app.controllers.interceptors;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        logUrl(req);
        logHeaders(req);
        logBody(req);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception {
        ContentCachingResponseWrapper respWrapper = (ContentCachingResponseWrapper) resp;
        String body = new String(respWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.debug("Response Body: \n {}", body);
    }


    @SneakyThrows
    private void logBody(final HttpServletRequest req)
    {
        RealCachingRequestWrapper reqWrapper = (RealCachingRequestWrapper) req;
        String body = new String(reqWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.debug("Request Body: \n {}", body);
    }

    private void logUrl(final HttpServletRequest req)
    {
        log.info("{} {}", req.getMethod(), ServletUriComponentsBuilder.fromRequest(req).toUriString());
    }

    private void logHeaders(final HttpServletRequest req)
    {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            log.debug("[{}]: {}", name, req.getHeader(name));
        }
    }
}
