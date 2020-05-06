package webClasses;


import data.Car;
import data.TelemetryDatas;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class TelemetryView {
    private int id;
    private TelemetryDatas telemetryDatas;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String carId = paramMap.get("id");

        try {
            id = Integer.parseInt(carId);
        }
        catch (Exception e) {
            id = -1;
        }

        if (id != -1) {
            Car customerType = Controller.getCar(id);

            if (customerType != null){
                telemetryDatas = Controller.getTelemetry(id);
            }
        }
    }

    public TelemetryDatas getTelemetryDatas() {
        return telemetryDatas;
    }

    public int getId() {
        System.out.println(id);
        return id;
    }
}
