package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/5/23.
 */

public class ImageHeaderBean {

    /**
     * app_code : 22000
     * app_msg :
     * result : {"image":{"id":158,"storage_type":2,"path":"image@2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png","md5":"386e781aaa70ff9038e6a4d8b49d9481","sha1":"046ad73e7e25666cc3e78004f6454579b65cb5e7","create_time":1495518294,"type":"png","mime_type":"image/png","title":"light_open.png","create_merchant_id":0,"url":"http://opbeh9tlb.bkt.clouddn.com/2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png"}}
     */

    private int app_code;
    private String app_msg;
    private ResultBean result;

    public int getApp_code() {
        return app_code;
    }

    public void setApp_code(int app_code) {
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
        /**
         * image : {"id":158,"storage_type":2,"path":"image@2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png","md5":"386e781aaa70ff9038e6a4d8b49d9481","sha1":"046ad73e7e25666cc3e78004f6454579b65cb5e7","create_time":1495518294,"type":"png","mime_type":"image/png","title":"light_open.png","create_merchant_id":0,"url":"http://opbeh9tlb.bkt.clouddn.com/2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png"}
         */

        private ImageBean image;

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public static class ImageBean {
            /**
             * id : 158
             * storage_type : 2
             * path : image@2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png
             * md5 : 386e781aaa70ff9038e6a4d8b49d9481
             * sha1 : 046ad73e7e25666cc3e78004f6454579b65cb5e7
             * create_time : 1495518294
             * type : png
             * mime_type : image/png
             * title : light_open.png
             * create_merchant_id : 0
             * url : http://opbeh9tlb.bkt.clouddn.com/2017/05/23/386e781aaa70ff9038e6a4d8b49d9481.png
             */

            private int id;
            private int storage_type;
            private String path;
            private String md5;
            private String sha1;
            private int create_time;
            private String type;
            private String mime_type;
            private String title;
            private int create_merchant_id;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStorage_type() {
                return storage_type;
            }

            public void setStorage_type(int storage_type) {
                this.storage_type = storage_type;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getMime_type() {
                return mime_type;
            }

            public void setMime_type(String mime_type) {
                this.mime_type = mime_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCreate_merchant_id() {
                return create_merchant_id;
            }

            public void setCreate_merchant_id(int create_merchant_id) {
                this.create_merchant_id = create_merchant_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
