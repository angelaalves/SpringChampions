package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import javax.persistence.*;

@Entity
@Table(name="guildplayer")
public class GuildPlayers {
    @EmbeddedId
    private GuildPlayersId guildPlayersId;

    public GuildPlayersId getGuildPlayersId() {
        return guildPlayersId;
    }

    public void setGuildPlayersId(GuildPlayersId guildPlayersId) {
        this.guildPlayersId = guildPlayersId;
    }
}
