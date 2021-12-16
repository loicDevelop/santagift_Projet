package ex.santagift.services.dto;

public class GiftDto {
    private Long id;
    private String name;
    private String url;
    private String prix;
    private String img;
    private UserDtoResponse userIdWant;
    private UserDtoResponse userIdOffer;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public UserDtoResponse getUserIdWant() {
        return userIdWant;
    }

    public void setUserIdWant(UserDtoResponse userIdWant) {
        this.userIdWant = userIdWant;
    }

    public UserDtoResponse getUserIdOffer() {
        return userIdOffer;
    }

    public void setUserIdOffer(UserDtoResponse userIdOffer) {
        this.userIdOffer = userIdOffer;
    }

    @Override
    public String toString() {
        return "GiftDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", prix='" + prix + '\'' +
                ", img='" + img + '\'' +
                ", userIdWant=" + userIdWant +
                ", userIdOffer=" + userIdOffer +
                '}';
    }
}
