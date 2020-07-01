package com.xdf.bling.qa.framework.entity;

import com.xdf.bling.qa.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class OperationLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="操作序号",name="operId",example="1")
    private Long operId;

    @ApiModelProperty(value="操作模块",name="title",example="在线用户")
    private String title;

    @ApiModelProperty(value="业务类型",name="businessType",example="0",allowableValues = "range[0,9]",reference="0=其它,1=新增,2=删除,3=修改,4=登录,5=退出")
    private Integer actionType;

    @ApiModelProperty(value="请求方法",name="method",example="com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()")
    private String method;

    @ApiModelProperty(value="操作类别",name="operatorType",example="0",allowableValues = "0,1,2",reference="0=其它,1=后台用户,2=手机端用户")
    private Integer operatorType;

    @ApiModelProperty(value="操作人",name="operName",example="admin")
    private String operName;

    @ApiModelProperty(value="部门名称",name="deptName",example="研发部门")
    private String deptName;

    @ApiModelProperty(value="请求URL地址",name="operUrl",example="/monitor/online/forceLogout")
    private String operUrl;

    @ApiModelProperty(value="操作IP地址",name="operIp",example="127.0.0.1")
    private String operIp;

    @ApiModelProperty(value="操作地点",name="operLocation",example="内网IP")
    private String operLocation;

    @ApiModelProperty(value="请求参数",name="operParam")
    private String operParam;

    @ApiModelProperty(value="操作状态",name="status",example="0",allowableValues = "0,1",reference="0=正常,1=异常")
    private Integer status;

    @ApiModelProperty(value="错误消息",name="errorMsg")
    private String errorMsg;

    @ApiModelProperty(value="操作时间",name="operTime",example="2018-12-15 18:03:58",dataType="java.util.Date")
    private Date operTime;
}
