package th.mfu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String dish_name;
    private String dishtype;
    private String dish_picture;
    private Integer  dish_stock;
    private Integer  dish_price;
    public Dishes(){
        
        
    }
    public Dishes(Long id, String dish_name, String dishtype, String dish_picture, Integer dish_stock,
            Integer dish_price) {
        this.id = id;
        this.dish_name = dish_name;
        this.dishtype = dishtype;
        this.dish_picture = dish_picture;
        this.dish_stock = dish_stock;
        this.dish_price = dish_price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDish_name() {
        return dish_name;
    }
    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
    public String getDishtype() {
        return dishtype;
    }
    public void setDishtype(String dishtype) {
        this.dishtype = dishtype;
    }
    public String getDish_picture() {
        return dish_picture;
    }
    public void setDish_picture(String dish_picture) {
        this.dish_picture = dish_picture;
    }
    public Integer getDish_stock() {
        return dish_stock;
    }
    public void setDish_stock(Integer dish_stock) {
        this.dish_stock = dish_stock;
    }
    public Integer getDish_price() {
        return dish_price;
    }
    public void setDish_price(Integer dish_price) {
        this.dish_price = dish_price;
    }
    public int getQuantity() {
        return 0;
    }
    
}
