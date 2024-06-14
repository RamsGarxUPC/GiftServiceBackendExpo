package pe.edu.upc.gift_service.util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "https://prueba-despliegue-frontend-expo.netlify.app/")  // Ajusta el origen permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //eliminas los que no uses
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
