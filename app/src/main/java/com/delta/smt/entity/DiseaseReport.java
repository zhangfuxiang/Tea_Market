package com.delta.smt.entity;

import java.util.List;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:21
 */


public class DiseaseReport {

    /**
     * status : true
     * message : {"recordsCount":10,"records":[{"morbidityId":1224,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":1,"deadAmount":2,"drugDosage":"34","drugEffect":"949496965","userName":"Admin","img":"20160812_151701.jpg,20160812_151656.jpg,20160812_151706.jpg","imgAlias":"201608120319591470986399299.jpg,201608120319591470986399299.jpg,201608120319591470986399315.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:19:59","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1223,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"546464694","userName":"Admin","img":"20160812_151602.jpg,20160812_151542.jpg,20160812_151556.jpg","imgAlias":"201608120318531470986333795.jpg,201608120318531470986333795.jpg,201608120318531470986333810.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:18:53","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1222,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456","userName":"Admin","img":"20160812_151242.jpg,20160812_151311.jpg,20160812_151237.jpg","imgAlias":"201608120317311470986251567.jpg,201608120317311470986251583.jpg,201608120317311470986251583.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:17:31","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1221,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456","userName":"Admin","img":"20160812_144552.jpg,20160812_144608.jpg,20160812_144600.jpg","imgAlias":"201608120248571470984537236.jpg,201608120248571470984537236.jpg,201608120248571470984537236.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:48:57","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1220,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456789","userName":"Admin","img":"20160812_144248.jpg,20160812_144239.jpg,20160812_144223.jpg","imgAlias":"201608120245371470984337416.jpg,201608120245371470984337416.jpg,201608120245371470984337416.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:45:37","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1219,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456789","userName":"Admin","img":"20160812_144040.jpg,20160812_144058.jpg,20160812_144047.jpg","imgAlias":"201608120243471470984227623.jpg,201608120243471470984227623.jpg,201608120243471470984227623.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:43:47","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1218,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"少数浮游(浮头)","deadNumber":1,"deadAmount":1,"drugDosage":"42","drugEffect":"946464646465","userName":"Admin","img":"20160812_102404.jpg,20160812_102355.jpg","imgAlias":"201608121026401470968800658.jpg,201608121026401470968800658.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 10:26:40","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1217,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"39388393idkdd","userName":"Admin","img":null,"imgAlias":null,"directory":null,"updateDate":"2016-08-12 09:27:22","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1216,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"0","userName":"Admin","img":"20160810_154218.jpg,20160810_154152.jpg,20160810_154145.jpg","imgAlias":"201608100345241470815124341.jpg,201608100345241470815124341.jpg,201608100345241470815124341.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-10 15:45:24","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1215,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"无","userName":"Admin","img":"20160810_154049.jpg,20160810_154033.jpg","imgAlias":"201608100343431470815023222.jpg,201608100343431470815023222.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-10 15:43:43","directoryIP":"172.22.35.164:8000/ams"}],"pageCount":19,"pageCurrent":1,"pageSize":10,"totalRecords":183}
     */

    private boolean status;
    /**
     * recordsCount : 10
     * records : [{"morbidityId":1224,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":1,"deadAmount":2,"drugDosage":"34","drugEffect":"949496965","userName":"Admin","img":"20160812_151701.jpg,20160812_151656.jpg,20160812_151706.jpg","imgAlias":"201608120319591470986399299.jpg,201608120319591470986399299.jpg,201608120319591470986399315.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:19:59","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1223,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"546464694","userName":"Admin","img":"20160812_151602.jpg,20160812_151542.jpg,20160812_151556.jpg","imgAlias":"201608120318531470986333795.jpg,201608120318531470986333795.jpg,201608120318531470986333810.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:18:53","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1222,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456","userName":"Admin","img":"20160812_151242.jpg,20160812_151311.jpg,20160812_151237.jpg","imgAlias":"201608120317311470986251567.jpg,201608120317311470986251583.jpg,201608120317311470986251583.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 15:17:31","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1221,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456","userName":"Admin","img":"20160812_144552.jpg,20160812_144608.jpg,20160812_144600.jpg","imgAlias":"201608120248571470984537236.jpg,201608120248571470984537236.jpg,201608120248571470984537236.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:48:57","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1220,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456789","userName":"Admin","img":"20160812_144248.jpg,20160812_144239.jpg,20160812_144223.jpg","imgAlias":"201608120245371470984337416.jpg,201608120245371470984337416.jpg,201608120245371470984337416.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:45:37","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1219,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"123456789","userName":"Admin","img":"20160812_144040.jpg,20160812_144058.jpg,20160812_144047.jpg","imgAlias":"201608120243471470984227623.jpg,201608120243471470984227623.jpg,201608120243471470984227623.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 14:43:47","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1218,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"少数浮游(浮头)","deadNumber":1,"deadAmount":1,"drugDosage":"42","drugEffect":"946464646465","userName":"Admin","img":"20160812_102404.jpg,20160812_102355.jpg","imgAlias":"201608121026401470968800658.jpg,201608121026401470968800658.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-12 10:26:40","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1217,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"39388393idkdd","userName":"Admin","img":null,"imgAlias":null,"directory":null,"updateDate":"2016-08-12 09:27:22","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1216,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"0","userName":"Admin","img":"20160810_154218.jpg,20160810_154152.jpg,20160810_154145.jpg","imgAlias":"201608100345241470815124341.jpg,201608100345241470815124341.jpg,201608100345241470815124341.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-10 15:45:24","directoryIP":"172.22.35.164:8000/ams"},{"morbidityId":1215,"fishpondId":1014,"breedId":1008,"speciesName":"三文鱼","fishpondName":"C01","workshopName":"车间1","symptomDetail":"零星死亡(捡尾)","deadNumber":0,"deadAmount":0,"drugDosage":"00","drugEffect":"无","userName":"Admin","img":"20160810_154049.jpg,20160810_154033.jpg","imgAlias":"201608100343431470815023222.jpg,201608100343431470815023222.jpg","directory":"\\morbidity\\201608","updateDate":"2016-08-10 15:43:43","directoryIP":"172.22.35.164:8000/ams"}]
     * pageCount : 19
     * pageCurrent : 1
     * pageSize : 10
     * totalRecords : 183
     */

    private MessageBean message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class MessageBean {
        private int recordsCount;
        private int pageCount;
        private int pageCurrent;
        private int pageSize;
        private int totalRecords;
        /**
         * morbidityId : 1224
         * fishpondId : 1014
         * breedId : 1008
         * speciesName : 三文鱼
         * fishpondName : C01
         * workshopName : 车间1
         * symptomDetail : 零星死亡(捡尾)
         * deadNumber : 1
         * deadAmount : 2
         * drugDosage : 34
         * drugEffect : 949496965
         * userName : Admin
         * img : 20160812_151701.jpg,20160812_151656.jpg,20160812_151706.jpg
         * imgAlias : 201608120319591470986399299.jpg,201608120319591470986399299.jpg,201608120319591470986399315.jpg
         * directory : \morbidity\201608
         * updateDate : 2016-08-12 15:19:59
         * directoryIP : 172.22.35.164:8000/ams
         */

        private List<RecordsBean> records;

        public int getRecordsCount() {
            return recordsCount;
        }

        public void setRecordsCount(int recordsCount) {
            this.recordsCount = recordsCount;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getPageCurrent() {
            return pageCurrent;
        }

        public void setPageCurrent(int pageCurrent) {
            this.pageCurrent = pageCurrent;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            private int morbidityId;
            private int fishpondId;
            private int breedId;
            private String speciesName;
            private String fishpondName;
            private String workshopName;
            private String symptomDetail;
            private int deadNumber;
            private int deadAmount;
            private String drugDosage;
            private String drugEffect;
            private String userName;
            private String img;
            private String imgAlias;
            private String directory;
            private String updateDate;
            private String directoryIP;

            public int getMorbidityId() {
                return morbidityId;
            }

            public void setMorbidityId(int morbidityId) {
                this.morbidityId = morbidityId;
            }

            public int getFishpondId() {
                return fishpondId;
            }

            public void setFishpondId(int fishpondId) {
                this.fishpondId = fishpondId;
            }

            public int getBreedId() {
                return breedId;
            }

            public void setBreedId(int breedId) {
                this.breedId = breedId;
            }

            public String getSpeciesName() {
                return speciesName;
            }

            public void setSpeciesName(String speciesName) {
                this.speciesName = speciesName;
            }

            public String getFishpondName() {
                return fishpondName;
            }

            public void setFishpondName(String fishpondName) {
                this.fishpondName = fishpondName;
            }

            public String getWorkshopName() {
                return workshopName;
            }

            public void setWorkshopName(String workshopName) {
                this.workshopName = workshopName;
            }

            public String getSymptomDetail() {
                return symptomDetail;
            }

            public void setSymptomDetail(String symptomDetail) {
                this.symptomDetail = symptomDetail;
            }

            public int getDeadNumber() {
                return deadNumber;
            }

            public void setDeadNumber(int deadNumber) {
                this.deadNumber = deadNumber;
            }

            public int getDeadAmount() {
                return deadAmount;
            }

            public void setDeadAmount(int deadAmount) {
                this.deadAmount = deadAmount;
            }

            public String getDrugDosage() {
                return drugDosage;
            }

            public void setDrugDosage(String drugDosage) {
                this.drugDosage = drugDosage;
            }

            public String getDrugEffect() {
                return drugEffect;
            }

            public void setDrugEffect(String drugEffect) {
                this.drugEffect = drugEffect;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getImgAlias() {
                return imgAlias;
            }

            public void setImgAlias(String imgAlias) {
                this.imgAlias = imgAlias;
            }

            public String getDirectory() {
                return directory;
            }

            public void setDirectory(String directory) {
                this.directory = directory;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getDirectoryIP() {
                return directoryIP;
            }

            public void setDirectoryIP(String directoryIP) {
                this.directoryIP = directoryIP;
            }
        }
    }
}
