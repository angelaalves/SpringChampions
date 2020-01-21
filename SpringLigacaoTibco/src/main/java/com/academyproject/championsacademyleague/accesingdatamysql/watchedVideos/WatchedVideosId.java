package com.academyproject.championsacademyleague.accesingdatamysql.watchedVideos;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.video.Video;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WatchedVideosId implements Serializable {

    @ManyToOne
    @JoinColumn(name="ID_Video_FK", referencedColumnName = "ID_Video")
    private Video IDVideo;
    @ManyToOne
    @JoinColumn(name="ID_Player_FK", referencedColumnName = "ID_Player")
    private Player IDPlayer;

    public Video getIDVideo() {
        return IDVideo;
    }

    public Player getIDPlayer() {
        return IDPlayer;
    }

    public void setIDVideo(Video IDVideo) {
        this.IDVideo = IDVideo;
    }

    public void setIDPlayer(Player IDPlayer) {
        this.IDPlayer = IDPlayer;
    }
}
