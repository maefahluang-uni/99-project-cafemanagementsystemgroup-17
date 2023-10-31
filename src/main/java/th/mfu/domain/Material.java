package th.mfu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mat_name;
    private Integer mat_amount;

    public Material(Long id, String mat_name, Integer mat_amount) {
        this.id = id;
        this.mat_name = mat_name;
        this.mat_amount = mat_amount;
    }

    public Material(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMat_name() {
        return mat_name;
    }

    public void setMat_name(String mat_name) {
        this.mat_name = mat_name;
    }

    public Integer getMat_amount() {
        return mat_amount;
    }

    public void setMat_amount(Integer mat_amount) {
        this.mat_amount = mat_amount;
    }

    
}