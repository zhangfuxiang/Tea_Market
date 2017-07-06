package com.delta.smt.entity.home_page.activity;

import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/6/2.
 */

public class ActivityCategoryResult {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ActivityCategoryResult{" +
                "list=" + list +
                '}';
    }

    public static class ListBean {
        /**
         * id : 9
         * parent_id : 0
         * name : 茶旅
         * type : act
         * sort : 0
         */

        private int id;
        private int parent_id;
        private String name;
        private String type;
        private int sort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", parent_id=" + parent_id +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", sort=" + sort +
                    '}';
        }
    }
}
