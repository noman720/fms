package com.csbl.fms.spring.bean;


public class UserBean extends AbstractBean {

    private String oid;
    private String userId;
    private String userFullName;
    private String userPassword;
    private boolean enabled;
    private String emailId;
    private String roleName;

    public UserBean() {
    }

    public UserBean(String userId, String userFullName, String userPassword, boolean enabled, String emailId, String roleName) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userPassword = userPassword;
        this.enabled = enabled;
        this.emailId = emailId;
        this.roleName = roleName;
    }

    

    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    
    

    
        
}
