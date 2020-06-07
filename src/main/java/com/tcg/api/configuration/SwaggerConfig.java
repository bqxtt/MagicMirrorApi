package com.tcg.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 14861
 * @date 2020/5/22
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.tcg.api.controller")).paths(PathSelectors.any()).build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("魔镜 API文档").description(
            "数据约定，所有请求返回JSON格式数据，具体属性如下：\n{\n\t\"code\":0\n\t\"message\":\"returnMessage\"\n\t\"data\":\"returnData\"\n}\ncode属性值:0为成功,非0为失败\nmessage属性值:操作信息\ndata属性值:请求的数据，图片数据放在此属性值中，若无数据则无该属性\n返回的图片文件使用base64编码,获得数据后使用base64解码成byte[]即可恢复出图片文件\n\n或直接使用fastjson中JSONObject的getBytes方法\nJSONObject jsonObject = JSON.parseObject(result);\nbyte[] fileBytes = jsonObject.getBytes(\"data\");")
            .version("1.0").build();
    }

}
