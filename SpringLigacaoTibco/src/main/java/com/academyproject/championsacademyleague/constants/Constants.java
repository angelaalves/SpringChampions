package com.academyproject.championsacademyleague.constants;

public class Constants {

    //Videos:

    public String  videoGetAllURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/GetAllVideoPortEndpoint1";
    public String  videoGetURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/GetVideoPortEndpoint1";
    public String  videoUpdateURL=  "http://localhost:8882/Service/Video/VideoService.serviceagent/UpdateVideoPortEndpoint1";
    public String  videoDeleteURL= "http://localhost:8882/Service/Video/VideoService.serviceagent/DeleteVideoPortEndpoint1" ;
    public String  videoCreateURL= "http://localhost:8882/Service/Video/VideoService.serviceagent/CreateVideoPortEndpoint1" ;
    public String  videoSOAPGetAll = "/Service/Video/VideoService.serviceagent/GetAllVideoPortEndpoint1/GetAll";
    public String  videoSOAPGet = "/Service/Video/VideoService.serviceagent/GetVideoPortEndpoint1/Get";
    public String  videoSOAPUpdate = "/Service/Video/VideoService.serviceagent/UpdateVideoPortEndpoint1/Update";
    public String  videoSOAPDelete = "/Service/Video/VideoService.serviceagent/DeleteVideoPortEndpoint1/Delete";
    public String  videoSOAPCreate ="/Service/Video/VideoService.serviceagent/CreateVideoPortEndpoint1/Create";

    public String getVideoGetAllURL() {
        return videoGetAllURL;
    }

    public String getVideoGetURL() {
        return videoGetURL;
    }

    public String getVideoUpdateURL() {
        return videoUpdateURL;
    }

    public String getVideoDeleteURL() {
        return videoDeleteURL;
    }

    public String getVideoCreateURL() {
        return videoCreateURL;
    }

    public String getVideoSOAPGetAll() {
        return videoSOAPGetAll;
    }

    public String getVideoSOAPGet() {
        return videoSOAPGet;
    }

    public String getVideoSOAPUpdate() {
        return videoSOAPUpdate;
    }

    public String getVideoSOAPDelete() {
        return videoSOAPDelete;
    }

    public String getVideoSOAPCreate() {
        return videoSOAPCreate;
    }
}
