package pl.coderslab.AppConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;

//import javax.validation.Validator;
;


@Configuration

@ComponentScan(basePackages = "pl.coderslab")

@EnableTransactionManagement

@EnableWebMvc

@EnableJpaRepositories(basePackages = "pl.coderslab")


public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean

    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");

        resolver.setSuffix(".jsp");

        return resolver;

    }



    @Bean

    public LocalEntityManagerFactoryBean entityManagerFactory() {

        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();

        emfb.setPersistenceUnitName("thegamePersistanceUnit");

        return emfb; }



    @Bean

    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

        JpaTransactionManager tm = new JpaTransactionManager(emf);

        return tm;
    }
    @Bean(name="localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl","PL"));
        return localeResolver; }
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }

}