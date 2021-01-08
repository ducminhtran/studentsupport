package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class RequestObject {
    private String requestId;
    private String apiKey;
    private RegisterCompetition registerCompetition;
    private LoginAccount loginAccount;
    private ChangePassAccount changePassAccount;
    private CalculateMarks calculateMarks;
    private EnrollCancel enrollCancel;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public RegisterCompetition getRegisterCompetition() {
        return registerCompetition;
    }

    public void setRegisterCompetition(RegisterCompetition registerCompetition) {
        this.registerCompetition = registerCompetition;
    }

    public LoginAccount getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(LoginAccount loginAccount) {
        this.loginAccount = loginAccount;
    }

    public ChangePassAccount getChangePassAccount() {
        return changePassAccount;
    }

    public void setChangePassAccount(ChangePassAccount changePassAccount) {
        this.changePassAccount = changePassAccount;
    }

    public CalculateMarks getCalculateMarks() {
        return calculateMarks;
    }

    public void setCalculateMarks(CalculateMarks calculateMarks) {
        this.calculateMarks = calculateMarks;
    }

    public EnrollCancel getEnrollCancel() {
        return enrollCancel;
    }

    public void setEnrollCancel(EnrollCancel enrollCancel) {
        this.enrollCancel = enrollCancel;
    }
}
