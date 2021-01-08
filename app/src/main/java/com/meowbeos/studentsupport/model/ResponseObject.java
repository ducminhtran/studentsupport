package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class ResponseObject {
    private String resultCode;
    private String resultMessage;
    private RequestObject requestData;
    private ResponseLoginAccount responseLoginAccount;
    private ResponseCalculateMarks responseCalculateMarks;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public RequestObject getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestObject requestData) {
        this.requestData = requestData;
    }

    public ResponseLoginAccount getResponseLoginAccount() {
        return responseLoginAccount;
    }

    public void setResponseLoginAccount(ResponseLoginAccount responseLoginAccount) {
        this.responseLoginAccount = responseLoginAccount;
    }

    public ResponseCalculateMarks getResponseCalculateMarks() {
        return responseCalculateMarks;
    }

    public void setResponseCalculateMarks(ResponseCalculateMarks responseCalculateMarks) {
        this.responseCalculateMarks = responseCalculateMarks;
    }
}
