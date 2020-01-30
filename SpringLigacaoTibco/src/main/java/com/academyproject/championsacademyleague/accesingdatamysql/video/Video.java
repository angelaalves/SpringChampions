package com.academyproject.championsacademyleague.accesingdatamysql.video;

import javax.persistence.*;

@Entity
@Table(name="video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Video")
    private int idVideo;
    @Column(name="Videoname")
    private String videoName;
    @Column(name="Duration")
    private int duration;
    @Column(name="topic")
    private String topic;

    public Video() {}

    public Video(int idVideo, String videoName, int duration, String topic) {
        this.idVideo = idVideo;
        this.videoName = videoName;
        this.duration = duration;
        this.topic = topic;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public String getVideoName() {
        return videoName;
    }

    public int getDuration() {
        return duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}