package pl.coderslab.mvc.init;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.coderslab.AppConfig.AppConfig;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    @Override

    protected Class<?>[] getRootConfigClasses() {

        return null;

    }



    @Override

    protected Class<?>[] getServletConfigClasses() {

        return new Class[] {AppConfig.class};

    }



    @Override

    protected String[] getServletMappings() {

        return new String[] {"/"};

    }

}
