package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class GuildPlayersId implements Serializable {
    @ManyToOne
    @JoinColumn(name="ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild IDGuildFK;
    @ManyToOne
    @JoinColumn(name="ID_Guildmaster_FK", referencedColumnName = "ID_Player")
    private Player IDGuildMasterFK;
    @ManyToOne
    @JoinColumn(name="ID_Warrior_FK", referencedColumnName = "ID_Player")
    private Player IDWarriorFK;

    public GuildPlayersId() {
    }

    public GuildPlayersId(Guild IDGuildFK, Player IDGuildMasterFK, Player IDWarriorFK) {
        this.IDGuildFK = IDGuildFK;
        this.IDGuildMasterFK = IDGuildMasterFK;
        this.IDWarriorFK = IDWarriorFK;
    }

    public Guild getIDGuildFK() {
        return IDGuildFK;
    }

    public Player getIDGuildMasterFK() {
        return IDGuildMasterFK;
    }

    public Player getIDWarriorFK() {
        return IDWarriorFK;
    }

    public void setIDGuildFK(Guild IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public void setIDGuildMasterFK(Player IDGuildMasterFK) {
        this.IDGuildMasterFK = IDGuildMasterFK;
    }

    public void setIDWarriorFK(Player IDWarriorFK) {
        this.IDWarriorFK = IDWarriorFK;
    }
}
