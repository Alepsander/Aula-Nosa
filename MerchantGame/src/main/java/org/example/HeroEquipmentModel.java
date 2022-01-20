package org.example;

public class HeroEquipmentModel {
    private int ID;
    private int PlayerHeroID;
    private int ItemID;

    public HeroEquipmentModel() {
    }

    public HeroEquipmentModel(int ID, int playerHeroID, int itemID) {
        this.ID = ID;
        PlayerHeroID = playerHeroID;
        ItemID = itemID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPlayerHeroID() {
        return PlayerHeroID;
    }

    public void setPlayerHeroID(int playerHeroID) {
        PlayerHeroID = playerHeroID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    @Override
    public String toString() {
        return "HeroEquipmentModel{" +
                "ID=" + ID +
                ", PlayerHeroID=" + PlayerHeroID +
                ", ItemID=" + ItemID +
                '}';
    }
}
