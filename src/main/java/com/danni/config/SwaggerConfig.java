package com.danni.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration                       //注解表示这个是一个配置文件，让spring来加载该类配置
//@EnableSwagger2                      //注解表示启用Swagger2
public class SwaggerConfig {
//    @Bean                            //注解表示交由bean容器去管理
//    public Docket newsApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        docket.enable(true);
//        //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
//        //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
//        docket.apiInfo(apiInfo())
//              .select()
//              .apis(RequestHandlerSelectors.basePackage("com.danni.web.controller"))   
//              .paths(PathSelectors.any()).build();
//        return docket;
//    }
////
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("dali的项目").description("在这里你可以浏览项目所有接口，并提供相关测试工具")
//                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
//                .license("China Red Star Licence Version 1.0").licenseUrl("#").version("1.0").build();
//    }

//	  @Bean
	  public GroupedOpenApi newsApi() {
	      return GroupedOpenApi.builder()
	              .group("springboot-mybatis-swagger")
	              .pathsToMatch("/controller/**").addOpenApiMethodFilter(null)
	              .build();
	  }
	 @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("BKAV API")
	              .description("Mẫu API của BKAV")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("BKAV Documentation")
	              .url("https://springshop.wiki.github.org/docs"));
	  }

}