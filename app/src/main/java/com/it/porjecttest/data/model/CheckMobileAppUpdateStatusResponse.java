package com.it.porjecttest.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.it.porjecttest.utils.Constants;

import java.io.Serializable;

public class CheckMobileAppUpdateStatusResponse extends StatusResponse implements Serializable {

    @SerializedName("Data")
    @Expose
    private Data Data;


    public Data getData() {
        if (Data==null)
            Data=new Data();
        return Data;
    }

    public void setData(Data data) {
        Data = data;
    }

    public class Data  implements Serializable {
        private String UserGuidePath ,UserGuidePathAr ;

        public String getUserGuidePath() {
            return UserGuidePath;
        }

        public void setUserGuidePath(String userGuidePath) {
            UserGuidePath = userGuidePath;
        }

        public String getUserGuidePathAr() {
            return UserGuidePathAr;
        }

        public void setUserGuidePathAr(String userGuidePathAr) {
            UserGuidePathAr = userGuidePathAr;
        }
        @SerializedName("Version")
        @Expose
        private String Version;
private String BaseUrl= Constants.BASE_URL,StaticUrl=Constants.BASE_URL;

        public String getBaseUrl() {
            if (BaseUrl==null)
                BaseUrl= Constants.BASE_URL ;
            return BaseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            BaseUrl = baseUrl;
        }

        public String getStaticUrl() {
            if (StaticUrl==null)
                StaticUrl=getBaseUrl();
            return StaticUrl;
        }

        public void setStaticUrl(String staticUrl) {
            StaticUrl = staticUrl;
        }

        @SerializedName("IsUpdateMand")
        @Expose
        private Boolean IsUpdateMand;

        @SerializedName("DescriptionAr")
        @Expose
        private String DescriptionAr;

        @SerializedName("Description")
        @Expose
        private String Description;

        @SerializedName("AppUrl")
        @Expose
        private String AppUrl;


        public String getVersion() {
            return Version;
        }

        public void setVersion(String version) {
            Version = version;
        }

        public Boolean isUpdateMand() {
            return IsUpdateMand;
        }

        public void setUpdateMand(Boolean updateMand) {
            IsUpdateMand = updateMand;
        }

        public String getDescriptionAr() {
            return DescriptionAr;
        }

        public void setDescriptionAr(String descriptionAr) {
            DescriptionAr = descriptionAr;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getAppUrl() {
            return AppUrl;
        }

        public void setAppUrl(String appUrl) {
            AppUrl = appUrl;
        }
    }
}
//    let version = self.util.nullValueToDefaultValue(value: dataObj?["Version"] as AnyObject? , defaultValue: "" as AnyObject) as! String
//        let isUpdateMand = self.util.nullValueToDefaultValue(value: dataObj?["IsUpdateMand"] as AnyObject? , defaultValue: false as AnyObject) as! Bool
//        let descriptionAr = self.util.nullValueToDefaultValue(value: dataObj?["DescriptionAr"] as AnyObject? , defaultValue: "" as AnyObject) as! String
//        let description = self.util.nullValueToDefaultValue(value: dataObj?["Description"] as AnyObject? , defaultValue: "" as AnyObject) as! String
//        let appUrl = self.util.nullValueToDefaultValue(value: dataObj?["AppUrl"] as AnyObject? , defaultValue: "" as AnyObject) as! String