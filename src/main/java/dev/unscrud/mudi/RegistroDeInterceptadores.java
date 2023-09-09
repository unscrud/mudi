package dev.unscrud.mudi;

import dev.unscrud.mudi.interceptor.InterceptadorDeAcessos;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class RegistroDeInterceptadores implements WebMvcConfigurer{
    
    @Autowired
    private InterceptadorDeAcessos interceptadorDeAcessos;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptadorDeAcessos);
    }
}
