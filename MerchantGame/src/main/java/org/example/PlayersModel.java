package org.example;

public class PlayersModel {

    private int ID;
    private String User;
    private String Password;
    private int Gold;

    public PlayersModel() {
    }

    public PlayersModel(int ID, String user, String password, int gold) {
        this.ID = ID;
        User = user;
        Password = password;
        Gold = gold;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    @Override
    public String toString() {
        return "PlayersModel{" +
                "ID=" + ID +
                ", User='" + User + '\'' +
                ", Password='" + Password + '\'' +
                ", Gold=" + Gold +
                '}';
    }
}
