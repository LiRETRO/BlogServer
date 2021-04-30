package net.meloli.demo.sys.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysRole implements Serializable {

    private Integer id;     // 角色ID
    private String roleCode;// 角色编号
    private String roleName;// 角色名称

}
