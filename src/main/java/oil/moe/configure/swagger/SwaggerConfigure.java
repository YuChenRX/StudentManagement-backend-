package oil.moe.configure.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfigure {

    @Autowired
    DocumentationPluginsBootstrapper documentationPluginsBootstrapper;
    @Bean
    public Docket docket(){
        System.out.println(documentationPluginsBootstrapper);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("=-=")
                .description("=-=")
                .contact(new Contact("GuXianWN","http:localhost:8081/doc.html","2818958193@qq.com"))
                .version("1.0")
                .build();
    }
}
