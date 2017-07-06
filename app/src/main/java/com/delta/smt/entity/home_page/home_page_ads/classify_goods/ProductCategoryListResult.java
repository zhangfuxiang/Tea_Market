package com.delta.smt.entity.home_page.home_page_ads.classify_goods;

import java.util.List;

/**
 * Created by wushufeng on 2017/4/24.
 */

public class ProductCategoryListResult {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"list":[{"id":1,"parent_id":0,"name":"茶叶汇","type":"product","sort":1,"sub":[{"id":2,"parent_id":1,"name":"绿茶","type":"product","sort":2},{"id":5,"parent_id":1,"name":"红茶","type":"product","sort":5}]},{"id":4,"parent_id":0,"name":"茶点茶食","type":"product","sort":4,"sub":[{"id":7,"parent_id":4,"name":"茶室","type":"product","sort":1}]},{"id":3,"parent_id":0,"name":"茶器具","type":"product","sort":3,"sub":[{"id":8,"parent_id":3,"name":"喝茶","type":"product","sort":1}]}]}
     */

    private String app_code;
    private String app_msg;
    private ResultBean result;

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getApp_msg() {
        return app_msg;
    }

    public void setApp_msg(String app_msg) {
        this.app_msg = app_msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * parent_id : 0
             * name : 茶叶汇
             * type : product
             * sort : 1
             * sub : [{"id":2,"parent_id":1,"name":"绿茶","type":"product","sort":2},{"id":5,"parent_id":1,"name":"红茶","type":"product","sort":5}]
             */

            private String id;
            private String parent_id;
            private String name;
            private String type;
            private String sort;
            private List<SubBean> sub;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public List<SubBean> getSub() {
                return sub;
            }

            public void setSub(List<SubBean> sub) {
                this.sub = sub;
            }

            public static class SubBean {
                /**
                 * id : 2
                 * parent_id : 1
                 * name : 绿茶
                 * type : product
                 * sort : 2
                 */

                private String id;
                private String parent_id;
                private String name;
                private String type;
                private String sort;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getParent_id() {
                    return parent_id;
                }

                public void setParent_id(String parent_id) {
                    this.parent_id = parent_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSort() {
                    return sort;
                }

                public void setSort(String sort) {
                    this.sort = sort;
                }
            }
        }
    }
}
