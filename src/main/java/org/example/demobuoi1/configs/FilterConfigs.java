//package org.example.demobuoi1.configs;
//
//import jakarta.servlet.FilterRegistration;
//import org.example.demobuoi1.security.AuthorFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfigs {
//    @Bean
//    public FilterRegistrationBean<AuthorFilter> authorFilterBean() {
//        FilterRegistrationBean<AuthorFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new AuthorFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//}
