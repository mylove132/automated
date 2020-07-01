package com.xdf.bling.qa.controller;

import com.xdf.bling.qa.common.annotation.ApiVersion;
import com.xdf.bling.qa.common.constants.ApiVersionConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Api(value = "资料文档或者CAD图纸", description = "资料文档或者CAD图纸")
public class HelloController {

    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页数", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "stageNum", value = "阶段编号", dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "type", value = "0资料(文档);1cad图纸", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "searchkey", value = "搜索关键字", dataType = "string", paramType = "query")})
    @ApiOperation("分页获取资料文档(CAD图纸)列表数据")
    @GetMapping("/pageQueryAppDocumentInfo/{page}/{pageSize}/{projectId}/{stageNum}/{type}")
    @ApiVersion(group = ApiVersionConstants.V_1_0)
    public String pageQueryAppDocumentInfo(@PathVariable Integer page, @PathVariable Integer pageSize,
                                           @PathVariable String projectId, @PathVariable String stageNum, @PathVariable Integer type, @RequestParam String searchkey) {
        return "测试";
    }

}
