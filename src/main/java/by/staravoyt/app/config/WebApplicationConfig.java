package by.staravoyt.app.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import by.staravoyt.app.filters.ContentCachingFilter;
import by.staravoyt.app.filters.EncodingFilter;


public class WebApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[] { ApplicationConfig.class };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters()
    {
        return new Filter[] {
                new EncodingFilter(),
                new ContentCachingFilter()
        };
    }
}
