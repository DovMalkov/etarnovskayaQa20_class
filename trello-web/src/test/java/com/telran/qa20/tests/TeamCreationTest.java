package com.telran.qa20.tests;

import com.telran.qa20.model.Team;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> teamsPositive() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(new File("src/test/resources/Teams_positive.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new Team()
                    .withTeamName(split[0])
                    .withTeamDescription(split[1])});
           line =  reader.readLine();
        }
        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn())
        app.getSession().login("elena.telran@yahoo.com", "12345.com");
    }

    @Test(dataProvider = "teamsPositive")
    public void createTeamDataProvider(Team team) throws InterruptedException {
        //  int before= app.getTeams().getTeamsCount();

        app.clickOnPlusButtonOnHeader();
        app.getTeams().selectTeamGroup();

        app.getTeams().fillTeamForm(team);


        app.getSession().pause(7000);
        app.getTeams().submitCreateTeam();
        app.returnToHomePage();
        app.returnToHomePage();
    }


    @Test(enabled = false)
    public void createTeam() throws InterruptedException {
      //  int before= app.getTeams().getTeamsCount();

        app.clickOnPlusButtonOnHeader();
        app.getTeams().selectTeamGroup();

        app.getTeams().fillTeamForm(new Team()
                .withTeamName("QA-20" + System.currentTimeMillis()));


        app.getSession().pause(7000);
        app.getTeams().submitCreateTeam();
        app.returnToHomePage();
        app.returnToHomePage();

  //      int after = app.getTeams().getTeamsCount();
      //  Assert.assertEquals(after,before+1);

    }

}

