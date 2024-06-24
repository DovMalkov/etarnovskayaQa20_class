package com.telran.qa20.model;

public class Team {
  private  String teamName;
  private  String teamDescription;



  public String getTeamName() {
    return teamName;
  }

  public String getTeamDescription() {
    return teamDescription;
  }

  public Team withTeamName(String teamName) {
    this.teamName = teamName;
    return  this;
  }

  public Team withTeamDescription(String teamDescription) {
    this.teamDescription = teamDescription;
    return this;
  }

  @Override
  public String toString() {
    return "Team{" +
            "teamName='" + teamName + '\'' +
            ", teamDescription='" + teamDescription + '\'' +
            '}';
  }
}
