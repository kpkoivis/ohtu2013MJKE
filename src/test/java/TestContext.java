/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import wad.spring.service.ViiteService;
import wad.spring.service.ViiteServiceImpl;

@Configuration
public class TestContext {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }
    @Bean
    public ViiteService viiteService() {
        return Mockito.mock(ViiteService.class);
    }
    
}