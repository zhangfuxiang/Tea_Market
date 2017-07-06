package com.delta.smt.entity;

import java.util.List;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 9:10
 */


public class LoginResult {

    /**
     * status : true
     * message : {"userId":1002,"roleId":2,"userName":"Admin","token":"ba2b0066-4812-495f-8c7e-bf559216d341","menu":{"userType":2,"indexPage":"RecircleMonitor.html","indexName":"实时监控","indexId":1002,"listItems":[{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}],"listMenu":[{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}]}}
     */

    private boolean status;
    /**
     * userId : 1002
     * roleId : 2
     * userName : Admin
     * token : ba2b0066-4812-495f-8c7e-bf559216d341
     * menu : {"userType":2,"indexPage":"RecircleMonitor.html","indexName":"实时监控","indexId":1002,"listItems":[{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}],"listMenu":[{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}]}
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
        private int userId;
        private int roleId;
        private String userName;
        private String token;
        /**
         * userType : 2
         * indexPage : RecircleMonitor.html
         * indexName : 实时监控
         * indexId : 1002
         * listItems : [{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}]
         * listMenu : [{"menuId":1001,"menuName":"养殖线管理","url":null,"listItmes":[{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]},{"menuId":1025,"menuName":"视频监控","url":"VideoMonitor.html","listItmes":null},{"menuId":1026,"menuName":"设备管理","url":null,"listItmes":[{"menuId":1027,"menuName":"设备类型","url":"DeviceType.html","listItmes":null},{"menuId":1028,"menuName":"循环水设备","url":null,"listItmes":[{"menuId":1029,"menuName":"设备注册","url":"DeviceRegistered.html","listItmes":null}]},{"menuId":1030,"menuName":"投饵设备","url":null,"listItmes":[{"menuId":1031,"menuName":"鼓风机","url":"Blower.html","listItmes":null},{"menuId":1032,"menuName":"料斗/剂量器","url":"Silo.html","listItmes":null},{"menuId":1033,"menuName":"选择器","url":"Selector.html","listItmes":null},{"menuId":1034,"menuName":"温度传感器","url":"TemperatureSensor.html","listItmes":null}]},{"menuId":1035,"menuName":"设备维护","url":null,"listItmes":[{"menuId":1036,"menuName":"故障处理规则","url":"FaultHandling.html","listItmes":null},{"menuId":1037,"menuName":"维修记录","url":"RepairRecords.html","listItmes":null}]}]},{"menuId":1055,"menuName":"系统维护","url":null,"listItmes":[{"menuId":1060,"menuName":"个人信息","url":"OrdinaryUserManage.html","listItmes":null},{"menuId":1058,"menuName":"用户管理","url":"Usermanage.html","listItmes":null},{"menuId":1056,"menuName":"车间配置","url":"WorkshopConfig.html","listItmes":null},{"menuId":1057,"menuName":"鱼池配置","url":"FishpondConfig.html","listItmes":null},{"menuId":1054,"menuName":"运行日志","url":"SysLog.html","listItmes":null}]}]
         */

        private MenuBean menu;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public MenuBean getMenu() {
            return menu;
        }

        public void setMenu(MenuBean menu) {
            this.menu = menu;
        }

        public static class MenuBean {
            private int userType;
            private String indexPage;
            private String indexName;
            private int indexId;
            /**
             * menuId : 1001
             * menuName : 养殖线管理
             * url : null
             * listItmes : [{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]
             */

            private List<ListItemsBean> listItems;
            /**
             * menuId : 1001
             * menuName : 养殖线管理
             * url : null
             * listItmes : [{"menuId":1002,"menuName":"实时监控","url":"RecircleMonitor.html","listItmes":null},{"menuId":1020,"menuName":"环境监控","url":null,"listItmes":[{"menuId":1021,"menuName":"实时数据","url":"EnvironmentRealtime.html","listItmes":null},{"menuId":1022,"menuName":"历史数据","url":"EnvironmentHistory.html","listItmes":null}]}]
             */

            private List<ListMenuBean> listMenu;

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getIndexPage() {
                return indexPage;
            }

            public void setIndexPage(String indexPage) {
                this.indexPage = indexPage;
            }

            public String getIndexName() {
                return indexName;
            }

            public void setIndexName(String indexName) {
                this.indexName = indexName;
            }

            public int getIndexId() {
                return indexId;
            }

            public void setIndexId(int indexId) {
                this.indexId = indexId;
            }

            public List<ListItemsBean> getListItems() {
                return listItems;
            }

            public void setListItems(List<ListItemsBean> listItems) {
                this.listItems = listItems;
            }

            public List<ListMenuBean> getListMenu() {
                return listMenu;
            }

            public void setListMenu(List<ListMenuBean> listMenu) {
                this.listMenu = listMenu;
            }

            public static class ListItemsBean {
                private int menuId;
                private String menuName;
                private Object url;
                /**
                 * menuId : 1002
                 * menuName : 实时监控
                 * url : RecircleMonitor.html
                 * listItmes : null
                 */

                private List<ListItmesBean> listItmes;

                public int getMenuId() {
                    return menuId;
                }

                public void setMenuId(int menuId) {
                    this.menuId = menuId;
                }

                public String getMenuName() {
                    return menuName;
                }

                public void setMenuName(String menuName) {
                    this.menuName = menuName;
                }

                public Object getUrl() {
                    return url;
                }

                public void setUrl(Object url) {
                    this.url = url;
                }

                public List<ListItmesBean> getListItmes() {
                    return listItmes;
                }

                public void setListItmes(List<ListItmesBean> listItmes) {
                    this.listItmes = listItmes;
                }

                public static class ListItmesBean {
                    private int menuId;
                    private String menuName;
                    private String url;
                    private Object listItmes;

                    public int getMenuId() {
                        return menuId;
                    }

                    public void setMenuId(int menuId) {
                        this.menuId = menuId;
                    }

                    public String getMenuName() {
                        return menuName;
                    }

                    public void setMenuName(String menuName) {
                        this.menuName = menuName;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Object getListItmes() {
                        return listItmes;
                    }

                    public void setListItmes(Object listItmes) {
                        this.listItmes = listItmes;
                    }
                }
            }

            public static class ListMenuBean {
                private int menuId;
                private String menuName;
                private Object url;
                /**
                 * menuId : 1002
                 * menuName : 实时监控
                 * url : RecircleMonitor.html
                 * listItmes : null
                 */

                private List<ListItmesBean> listItmes;

                public int getMenuId() {
                    return menuId;
                }

                public void setMenuId(int menuId) {
                    this.menuId = menuId;
                }

                public String getMenuName() {
                    return menuName;
                }

                public void setMenuName(String menuName) {
                    this.menuName = menuName;
                }

                public Object getUrl() {
                    return url;
                }

                public void setUrl(Object url) {
                    this.url = url;
                }

                public List<ListItmesBean> getListItmes() {
                    return listItmes;
                }

                public void setListItmes(List<ListItmesBean> listItmes) {
                    this.listItmes = listItmes;
                }

                public static class ListItmesBean {
                    private int menuId;
                    private String menuName;
                    private String url;
                    private Object listItmes;

                    public int getMenuId() {
                        return menuId;
                    }

                    public void setMenuId(int menuId) {
                        this.menuId = menuId;
                    }

                    public String getMenuName() {
                        return menuName;
                    }

                    public void setMenuName(String menuName) {
                        this.menuName = menuName;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public Object getListItmes() {
                        return listItmes;
                    }

                    public void setListItmes(Object listItmes) {
                        this.listItmes = listItmes;
                    }
                }
            }
        }
    }
}
