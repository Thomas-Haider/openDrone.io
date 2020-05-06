package webClasses;

import data.Car;
import data.Fahrzeugdaten;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "CarBean")
@RequestScoped
public class Connect4Bean {

    private Fahrzeugdaten.Cars cars;

    @PostConstruct
    public void init() {
        cars = Controller.getCars();
    }

    public Fahrzeugdaten.Cars getCars() {
        return cars;
    }
}
