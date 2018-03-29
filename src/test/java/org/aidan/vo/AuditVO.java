package org.aidan.vo;

/**
 * 供应商基础信息审核请求VO
 */
public class AuditVO {
    /**
     * 供应商id
     */
    private String suppleId;
    /**
     * 审核结果状态
     */
    private Integer state;
    /**
     * 审核不过原因
     */
    private String reason;

    /**
     * 审核人
     */
    private String checker;

    /**
     * 业务模块
     */
    private String module;

    public String getSuppleId() {
        return suppleId;
    }

    public void setSuppleId(String suppleId) {
        this.suppleId = suppleId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
