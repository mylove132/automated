package com.xdf.bling.qa.system.domain;

import com.xdf.bling.qa.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表 sys_role
 *
 * @author ruoyi
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description="角色信息",parent= BaseEntity.class)
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色序号",name="id",example="1")
    private Long id;

    @ApiModelProperty(value="角色名称",name="roleName",example="管理员")
    private String roleName;

    @ApiModelProperty(value="角色权限",name="roleKey",example="admin")
    private String roleKey;

    @ApiModelProperty(value="角色排序",name="roleSort",example="1")
    private String roleSort;

    @ApiModelProperty(value="角色状态",name="status",example="0",allowableValues = "0,1",reference="0=正常,1=停用")
    private String status;

    @ApiModelProperty(value="用户是否存在此角色标识",name="flag",example="0")
    private boolean flag = false;

    @ApiModelProperty(value="菜单组",name="menuIds",hidden = true)
    private Long[] menuIds;

}
