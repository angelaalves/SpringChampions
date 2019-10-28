package com.academyproject.championsacademyleague.constants;

public class Constants {

    public String  getAllURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/GetAllVideoPortEndpoint1";
    public String  getURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/GetVideoPortEndpoint1";
    public String  updateURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/VideoPortUpdateEndpoint1";
    public String  deleteURL= "http://localhost:8882/Service/Video/VideoService.serviceagent/DeleteVideoPortEndpoint1" ;
    public String  createURL= "http://localhost:8882/Service/Video/VideoService.serviceagent/CreateVideoPortEndpoint1" ;
    public String  SOAPURL = "http://schemas.xmlsoap.org/soap/http";

    public String getGetAllURL() {
        return getAllURL;
    }

    public String getGetURL() {
        return getURL;
    }

    public String getUpdateURL() {
        return updateURL;
    }

    public String getDeleteURL() {
        return deleteURL;
    }

    public String getCreateURL() {
        return createURL;
    }

    public String getSOAPURL() {
        return SOAPURL;
    }

}
