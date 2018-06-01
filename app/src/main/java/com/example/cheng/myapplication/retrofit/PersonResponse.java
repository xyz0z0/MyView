package com.example.cheng.myapplication.retrofit;


/**
 * {
 * "msg": "样本录入成功！",
 * "result": 0,
 * "success": false
 * }
 * <p>
 * 倪帅 2018/5/23 11:11:13
 * {
 * "msg": "工号重复！",
 * "result": 1,
 * "success": false
 * }
 */
public class PersonResponse {
    private String msg;
    private int result;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
