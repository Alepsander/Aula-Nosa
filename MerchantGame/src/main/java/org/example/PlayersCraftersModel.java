package org.example;

public class PlayersCraftersModel {

    private int ID;
    private int PlayerID;
    private int CrafterTypeID;
    private int Level;
    private int CurrentXP;
    private int NextLevelXP;


    public PlayersCraftersModel() {
    }

    public PlayersCraftersModel(int ID, int playerID, int crafterTypeID, int level, int currentXP, int nextLevelXP) {
        this.ID = ID;
        PlayerID = playerID;
        CrafterTypeID = crafterTypeID;
        Level = level;
        CurrentXP = currentXP;
        NextLevelXP = nextLevelXP;
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

    public int getCrafterTypeID() {
        return CrafterTypeID;
    }

    public void setCrafterTypeID(int crafterTypeID) {
        CrafterTypeID = crafterTypeID;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getCurrentXP() {
        return CurrentXP;
    }

    public void setCurrentXP(int currentXP) {
        CurrentXP = currentXP;
    }

    public int getNextLevelXP() {
        return NextLevelXP;
    }

    public void setNextLevelXP(int nextLevelXP) {
        NextLevelXP = nextLevelXP;
    }

    @Override
    public String toString() {
        return "PlayersCraftersModel{" +
                "ID=" + ID +
                ", PlayerID=" + PlayerID +
                ", CrafterTypeID=" + CrafterTypeID +
                ", Level=" + Level +
                ", CurrentXP=" + CurrentXP +
                ", NextLevelXP=" + NextLevelXP +
                '}';
    }
}
