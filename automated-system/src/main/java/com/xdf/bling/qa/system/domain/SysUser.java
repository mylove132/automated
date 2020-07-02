package com.xdf.bling.qa.system.domain;

import com.xdf.bling.qa.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="用户信息",parent=BaseEntity.class)
public class SysUser extends BaseEntity {

    @ApiModelProperty(value="用户序号",name="userId",example="1")
    private long id;

    @ApiModelProperty(value="用户名",name="username",example="刘占会")
    private String username;

    @ApiModelProperty(value="密码",name="password",example="**********")
    private String password;

    @ApiModelProperty(value="帐号状态",name="status",example="0",allowableValues = "0,1",reference="0=正常,1=停用")
    private String status;

    @ApiModelProperty(value="最后登陆IP",name="loginIp",example="127.0.0.1")
    private String loginIp;

    @ApiModelProperty(value="最后登陆时间",name="loginDate",example="2018-12-15 18:03:58",dataType="java.util.Date")
    private Date loginDate;
}
