package ex.santagift.services.dto;

import java.util.List;

public class UserDtoCreate {
    private String name;
    private String pseudo;
    private String password;
    private List<GiftDtoResponse> gifts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GiftDtoResponse> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftDtoResponse> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "UserDtoCreate{" +
                ", name='" + name + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", gifts=" + gifts +
                '}';
    }
}
