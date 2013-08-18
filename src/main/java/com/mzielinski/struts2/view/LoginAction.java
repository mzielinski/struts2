package com.mzielinski.struts2.view;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author mzielinski, Rule Financial
 */
public class LoginAction extends ActionSupport {

    private static final String VIEW_SUCCESS = "success";
    private static final String VIEW_ERROR = "error";

    private String username;
    private String password;

    public String authenticate() {
        if ("admin".equals(this.username) && "admin".equals(this.password)) {
            return VIEW_SUCCESS;
        }
        addActionError(getErrorMessage());
        return VIEW_ERROR;
    }

    private String getErrorMessage() {
        return super.getText("error.login");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
