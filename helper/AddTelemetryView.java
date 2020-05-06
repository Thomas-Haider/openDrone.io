package webClasses;


import data.Car;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@SessionScoped
public class AddTelemetryView {
    private double latitude;
    private double longitude;
    private double capacity;
    private double speed;
    private int id;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    @PostConstruct
    public void init(){

    }

    public String addTelemetry(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String carId = paramMap.get("id");
        System.out.println(carId + " dsffff");
        try {
            id = Integer.parseInt(carId);
        }
        catch (Exception e) {
            id = -1;
        }

        if (id != -1) {
            Car customerType = Controller.getCar(id);

            if (customerType == null){
                Controller.addTelemetry(id,latitude, longitude, capacity, speed);
            }
        }

        System.out.println("Telemetry added!");


        return "back";
    }
}
