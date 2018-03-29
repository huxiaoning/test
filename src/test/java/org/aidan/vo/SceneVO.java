package org.aidan.vo;


/**
 * 应用场景基础信息
 */
public class SceneVO {

    /**
     *
     */
    private String id;

    /**
     * 供应商ID
     */
    private String suppleId;

    /**
     * 应用场景名称
     */
    private String name;

    /**
     * 应用场景编号
     */
    private String code;

    /**
     * 图标
     */
    private String icon;

    /**
     * 行业领域
     */
    private String industry;

    /**
     * 场景描述
     */
    private String description;

    /**
     * 类型  下拉框选择，来自数据字典
     */
    private String type;

    /**
     * 网络 政务网，企业网，互联网
     */
    private String network;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuppleId() {
        return suppleId;
    }

    public void setSuppleId(String suppleId) {
        this.suppleId = suppleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}
