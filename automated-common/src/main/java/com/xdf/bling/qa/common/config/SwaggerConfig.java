package com.xdf.bling.qa.common.config;

import com.xdf.bling.qa.common.annotation.ApiVersion;
import com.xdf.bling.qa.common.constants.ApiVersionConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    //默认版本的接口api-docs分组
    @Bean
    public Docket vDefault(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gysoft"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }
    //app1.0.0版本对外接口
    @Bean
    public Docket apiV1_0(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .groupName(ApiVersionConstants.V_1_0)
                .select()
                .apis(input -> {
                    ApiVersion apiVersion = input.getHandlerMethod().getMethodAnnotation(ApiVersion.class);
                    return apiVersion != null && Arrays.asList(apiVersion.group()).contains(ApiVersionConstants.V_1_0);
                })//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("接口列表")
                .termsOfServiceUrl("http://127.0.0.1:8080/swagger-ui.html")
                .description("springmvc swagger 接口测试")
                .version("1.0.0")
                .build();
    }

}
