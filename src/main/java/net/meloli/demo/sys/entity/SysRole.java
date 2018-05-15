package net.meloli.demo.sys.entity;

import java.io.Serializable;

public class SysRole implements Serializable {

    private Integer id;     // 角色ID
    private String roleCode;// 角色编号
    private String roleName;// 角色名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
