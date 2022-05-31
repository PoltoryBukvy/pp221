package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column (name = "series")
    private Integer series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, Integer series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(int series){
        this.series = series;
    }

    public int getSeries() {return series; }

    public void setSeries(int series) {this.series = series; }


    public void setId(Long id) {
        this.id = id;
    }
}
