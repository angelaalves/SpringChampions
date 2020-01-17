package com.academyproject.championsacademyleague.accesingdatamysql.guild;

import javax.persistence.*;

@Entity
@Table(name="guild")
public class Guild {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID_Guild")
    private Integer IDGuild;
    @Column(name="Guildname")
    private String guildName;
    @Column(name="Startdate")
    private String startDate;
    @Column(name="Enddate")
    private String endDate;
    @Column(name="Guildflag")
    private String guildFlag;
    @Column(name="Status")
    private String status;

    public Integer getIDGuild() {
        return IDGuild;
    }

    public String getGuildName() {
        return guildName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getGuildFlag() {
        return guildFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setIDGuild(Integer IDGuild) {
        this.IDGuild = IDGuild;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setGuildFlag(String guildFlag) {
        this.guildFlag = guildFlag;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
