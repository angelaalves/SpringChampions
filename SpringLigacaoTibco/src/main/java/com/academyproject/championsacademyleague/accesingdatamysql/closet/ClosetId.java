package com.academyproject.championsacademyleague.accesingdatamysql.closet;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.skin.Skin;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ClosetId implements Serializable {

    @ManyToOne
    @JoinColumn(name="ID_Skin_FK", referencedColumnName = "ID_Skin")
    private Skin IDSkinFK;
    @ManyToOne
    @JoinColumn(name="ID_Player_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerFK;

    public Skin getIDSkinFK() {
        return IDSkinFK;
    }

    public Player getIDPlayerFK() {
        return IDPlayerFK;
    }

    public void setIDSkinFK(Skin IDSkinFK) {
        this.IDSkinFK = IDSkinFK;
    }

    public void setIDPlayerFK(Player IDPlayerFK) {
        this.IDPlayerFK = IDPlayerFK;
    }
}
