package org.aidan.vo;


public class SolutionVO {

    /**
     *
     */
    private String id;

    /**
     * 所属供应商ID
     */
    private String suppleId;

    /**
     * 解决方案名称
     */
    private String name;

    /**
     * 解决方案代码
     */
    private String code;

    /**
     * 展示图标
     */
    private String icon;

    /**
     * 整体框架图
     */
    private String frameImg;

    /**
     * 内容描述
     */
    private String contentDescribe;

    /**
     * 行业领域
     */
    private String industry;

    /**
     * 行政区域
     */
    private String area;

    /**
     * 类型  下拉框选择，来自数据字典
     */
    private String type;

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

    public String getFrameImg() {
        return frameImg;
    }

    public void setFrameImg(String frameImg) {
        this.frameImg = frameImg;
    }

    public String getContentDescribe() {
        return contentDescribe;
    }

    public void setContentDescribe(String contentDescribe) {
        this.contentDescribe = contentDescribe;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
