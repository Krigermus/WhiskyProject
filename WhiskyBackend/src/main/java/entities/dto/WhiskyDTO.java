package entities.dto;

import entities.Whisky;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Martin Frederiksen
 */
@Schema(name = "Whisky")
public class WhiskyDTO {
    private long id;
    @Schema(required = true, example ="Glen Dronach 21år Parlament")
    private String title;
    @Schema(required = true, example ="This is a very good whisky with taste of the finest cherry.")
    private String description;
    @Schema(required = true, example ="1300")
    private int price;
    @Schema(required = true, example ="1100")
    private int ourPrice;
    @Schema(required = true, example ="5", minLength = 1, maxLength = 5)
    private int Rating;
    @Schema(required = true, example ="https://urlForImage")
    private String imgUrl;

    public WhiskyDTO() {
    }
    
    public WhiskyDTO(Whisky whisky) {
        this.title = whisky.getTitle();
        this.id = whisky.getId();
        this.description = whisky.getDescription();
        this.price = whisky.getPrice();
        this.ourPrice = whisky.getOurPrice();
        this.Rating = whisky.getRating();
        this.imgUrl = whisky.getImgUrl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(int ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
