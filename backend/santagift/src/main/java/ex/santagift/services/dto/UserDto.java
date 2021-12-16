package ex.santagift.services.dto;

import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String pseudo;
    private String password;
    private List<GiftDto> gifts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<GiftDto> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftDto> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", gifts=" + gifts +
                '}';
    }
}
