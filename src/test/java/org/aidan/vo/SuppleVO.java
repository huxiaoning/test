package org.aidan.vo;

import java.util.Date;

/**
 * <p>
 * 供应商基础信息类
 * </p>
 *
 * @author Aidan
 * @since 2017-12-20
 */
public class SuppleVO {

    private String id;

    /**
     * 图标
     */
    private String icon;

    /**
     * 联系人
     */
    private String linker;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 行政区域  区域级别之间用英文"-"连接
     */
    private String area;

    /**
     * 网址
     */
    private String web;

    /**
     * 类型  1 企业  2 个人  其中如果是1企业 以下 企业名称、法人、统一征信代码 必填  如果是2个人 以下 姓名、身份证
     */
    private Integer type;

    /**
     * 企业名称
     */
    private String company;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 统一征信代码
     */
    private String creditCode;

    /**
     * 姓名
     */
    private String personName;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 执照/身份证图片路径
     */
    private String imgUrl;

    /**
     * 审核状态  -1 审核不通过  0  待审核  1 审核通过
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
