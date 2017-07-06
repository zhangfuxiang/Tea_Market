package com.delta.smt.entity;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/3/24.
 */

public class CommdityClassifyItem {
    private String msg;
    private String code;
    private List<Result> list_result;

    public CommdityClassifyItem(String msg, String code, List<Result> list_result) {
        this.msg = msg;
        this.code = code;
        this.list_result = list_result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Result> getList_result() {
        return list_result;
    }

    public void setList_result(List<Result> list_result) {
        this.list_result = list_result;
    }

    @Override
    public String toString() {
        return "CommdityClassifyItem{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", list_result=" + list_result.toString() +
                '}';
    }

    public static class Result {
        private String commdity_big_classify;
        private List<String> commdity_small_classify;

        public Result(String commdity_big_classify, List<String> commdity_small_classify) {
            this.commdity_big_classify = commdity_big_classify;
            this.commdity_small_classify = commdity_small_classify;
        }

        public String getCommdity_big_classify() {
            return commdity_big_classify;
        }

        public void setCommdity_big_classify(String commdity_big_classify) {
            this.commdity_big_classify = commdity_big_classify;
        }

        public List<String> getCommdity_small_classify() {
            return commdity_small_classify;
        }

        public void setCommdity_small_classify(List<String> commdity_small_classify) {
            this.commdity_small_classify = commdity_small_classify;
        }

        @Override
        public String toString() {
            return "PushableActivityResult{" +
                    "commdity_big_classify='" + commdity_big_classify + '\'' +
                    ", commdity_small_classify=" + commdity_small_classify +
                    '}';
        }
    }
}
