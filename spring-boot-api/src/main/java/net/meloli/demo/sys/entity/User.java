package net.meloli.demo.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {

    private Integer id;         // 用户ID
    private String userName;    // 用户名
    private String userEmail;   // 用户邮箱
    private String userPassword;// 用户密码
    private String userNickName;// 用户昵称
    private String userHeadPic; // 用户头像
    private Boolean userSex;    // 用户性别
    private String userPhone;   // 用户手机号
    private Date createDate;    // 用户创建时间
    private Date lastLoginDate; // 用户最后登陆时间
}
