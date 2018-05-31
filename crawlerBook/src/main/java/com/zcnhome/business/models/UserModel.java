package com.zcnhome.business.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zcnhome.common.models.BasicModel;

/**
 * Model class of t_user
 * 基本用户
 * 
 * @author hqsun
 * @since 2017-8-1
 */
public class UserModel extends BasicModel implements Serializable {
    /**
     * UUID
     */
    private static final long serialVersionUID = 8439873683799631997L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户登录帐号，系统全局唯一
     */
    private String account;

    /**
     * 密码
     */
    private transient String password;

    /**
     * 1,正常；2,删除；3,待审核；4,审核失败；5,锁定
     */
    private Integer status;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 办公电话
     */
    private String telephone;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 1,男；2,女
     */
    private Integer sex;

    /**
     * 微信用户唯一标识
     */
    private String unionId;

    /**
     * 出生年月
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * QQ号
     */
    private Integer qq;

    /**
     * 快递地址
     */
    private String deliveryAddress;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 1,邮箱已认证；2,邮箱未认证
     */
    private Integer emailPassable;

    /**
     * 头像图片
     */
    private String image;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 创建人id
     */
    private Long creator;

    /**
     * 修改人id
     */
    private Long modifier;

    /**
     * 创建时间：Y-m-d H:i:S
     */
    private Date createTime;

    /**
     * 修改时间：Y-m-d H:i:S
     */
    private Date modifyTime;

    /**
     * Get the confirmPwd
     * 
     * @return confirmPwd
     *         新密码
     */
    private String newPassword;

    /**
     * Get the newPassword
     * 
     * @return newPassword
     * @see UserModel#newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Set the newPassword
     * 
     * @param newPassword
     * @see UserModel#newPassword
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Get the id
     * 
     * @return id
     *         用户id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Set the id
     * 
     * @param id
     *            用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the account
     * 
     * @return account
     *         用户登录帐号，系统全局唯一
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * Set the account
     * 
     * @param account
     *            用户登录帐号，系统全局唯一
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Get the password
     * 
     * @return password
     *         密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set the password
     * 
     * @param password
     *            密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the status
     * 
     * @return status
     *         1,正常；2,删除；3,待审核；4,审核失败；5,锁定
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Set the status
     * 
     * @param status
     *            1,正常；2,删除；3,待审核；4,审核失败；5,锁定
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * @param unionId
     *            the unionId to set
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * Get the name
     * 
     * @return name
     *         真实姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name
     * 
     * @param name
     *            真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     *            the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Get the telephone
     * 
     * @return telephone
     *         办公电话
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Set the telephone
     * 
     * @param telephone
     *            办公电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get the mobile
     * 
     * @return mobile
     *         移动电话
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Set the mobile
     * 
     * @param mobile
     *            移动电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get the sex
     * 
     * @return sex
     *         1,男；2,女
     */
    public Integer getSex() {
        return this.sex;
    }

    /**
     * Set the sex
     * 
     * @param sex
     *            1,男；2,女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Get the birthday
     * 
     * @return birthday
     *         出生年月
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Set the birthday
     * 
     * @param birthday
     *            出生年月
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Get the qq
     * 
     * @return qq
     *         QQ号
     */
    public Integer getQq() {
        return this.qq;
    }

    /**
     * Set the qq
     * 
     * @param qq
     *            QQ号
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * Get the deliveryAddress
     * 
     * @return deliveryAddress
     *         快递地址
     */
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    /**
     * Set the deliveryAddress
     * 
     * @param deliveryAddress
     *            快递地址
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Get the email
     * 
     * @return email
     *         电子邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the email
     * 
     * @param email
     *            电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the emailPassable
     * 
     * @return emailPassable
     *         1,邮箱已认证；2,邮箱未认证
     */
    public Integer getEmailPassable() {
        return this.emailPassable;
    }

    /**
     * Set the emailPassable
     * 
     * @param emailPassable
     *            1,邮箱已认证；2,邮箱未认证
     */
    public void setEmailPassable(Integer emailPassable) {
        this.emailPassable = emailPassable;
    }

    /**
     * Get the image
     * 
     * @return image
     *         头像图片
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Set the image
     * 
     * @param image
     *            头像图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get the roleId
     * 
     * @return roleId
     *         角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Set the roleId
     * 
     * @param roleId
     *            角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Get the creator
     * 
     * @return creator
     *         创建人id
     */
    public Long getCreator() {
        return this.creator;
    }

    /**
     * Set the creator
     * 
     * @param creator
     *            创建人id
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * Get the modifier
     * 
     * @return modifier
     *         修改人id
     */
    public Long getModifier() {
        return this.modifier;
    }

    /**
     * Set the modifier
     * 
     * @param modifier
     *            修改人id
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * Get the createTime
     * 
     * @return createTime
     *         创建时间：Y-m-d H:i:S
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Set the createTime
     * 
     * @param createTime
     *            创建时间：Y-m-d H:i:S
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Get the modifyTime
     * 
     * @return modifyTime
     *         修改时间：Y-m-d H:i:S
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * Set the modifyTime
     * 
     * @param modifyTime
     *            修改时间：Y-m-d H:i:S
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
