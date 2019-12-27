package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Martin Frederiksen
 */
@Entity
@NamedQuery(name = "Whisky.deleteAllRows", query = "DELETE FROM Whisky")
public class Whisky implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int price;
    private int ourPrice;
    private int rating;
    private String imgUrl;

    public Whisky() {
    }

    public Whisky(String title, String description, int price, int ourPrice, int rating, String imgUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.ourPrice = ourPrice;
        this.rating = rating;
        this.imgUrl = imgUrl;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    

}
