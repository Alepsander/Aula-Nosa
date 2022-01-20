package org.example;

public class PlayerHeroesModel {
    private int ID;
    private int PlayerID;
    private int HeroClassID;

    public PlayerHeroesModel() {
    }

    public PlayerHeroesModel(int ID, int playerID, int heroClassID) {
        this.ID = ID;
        PlayerID = playerID;
        HeroClassID = heroClassID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public int getHeroClassID() {
        return HeroClassID;
    }

    public void setHeroClassID(int heroClassID) {
        HeroClassID = heroClassID;
    }

    @Override
    public String toString() {
        return "PlayerHeroesModel{" +
                "ID=" + ID +
                ", PlayerID=" + PlayerID +
                ", HeroClassID=" + HeroClassID +
                '}';
    }
}
