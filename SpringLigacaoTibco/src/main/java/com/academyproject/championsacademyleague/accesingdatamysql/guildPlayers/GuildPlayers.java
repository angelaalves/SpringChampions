package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import javax.persistence.*;

@Entity
@Table(name="guildplayers")
public class GuildPlayers {
    @EmbeddedId
    private GuildPlayersId guildPlayersId;

    public GuildPlayers() {
    }

    public GuildPlayers(GuildPlayersId guildPlayersId) {
        this.guildPlayersId = guildPlayersId;
    }

    public GuildPlayersId getGuildPlayersId() {
        return guildPlayersId;
    }

    public void setGuildPlayersId(GuildPlayersId guildPlayersId) {
        this.guildPlayersId = guildPlayersId;
    }
}
