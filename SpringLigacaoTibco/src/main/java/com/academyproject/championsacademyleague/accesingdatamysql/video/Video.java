package com.academyproject.championsacademyleague.accesingdatamysql.video;

import javax.persistence.*;

@Entity
@Table(name = "Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Video")
    private Integer IDVideo;
    @Column(name="Videoname")
    private String VideoName;
    @Column(name = "Duration")
    private Integer Duration;
    @Column(name = "topic")
    private String topic;

    public Integer getIDVideo() {
        return IDVideo;
    }

    public String getVideoName() {
        return VideoName;
    }

    public Integer getDuration() {
        return Duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setIDVideo(Integer IDVideo) {
        this.IDVideo = IDVideo;
    }

    public void setVideoName(String videoName) {
        VideoName = videoName;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
