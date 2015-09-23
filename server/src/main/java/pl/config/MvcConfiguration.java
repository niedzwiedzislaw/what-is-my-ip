package pl.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.server.DataFormat;
import pl.util.provider.GsonExclude;
import pl.util.provider.LongHttpMessageConverter;

import java.util.List;

@Configuration
@ComponentScan({
        "pl.server",
        "pl.util"
})
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(gson());

        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new LongHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(gsonHttpMessageConverter);
    }

    private Gson gson() {
        return new GsonBuilder()
                .setDateFormat(DataFormat.DATE)
                .setPrettyPrinting()
                .setExclusionStrategies(new GsonExclude.ExclusionStrategy())
                .create();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}