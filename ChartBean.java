package at.renest.controller;

import at.renest.shared.Price;
import at.renest.shared.Product;
import org.primefaces.model.chart.*;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@ViewScoped
@ManagedBean
public class ChartBean implements Serializable {

    public LineChartModel getPriceChart(Product product) {
        //Process Chart and return the Price-Way
        LineChartModel lineModel = new LineChartModel();
        ChartSeries prices = new ChartSeries();
        prices.setLabel("Price");
        List<Price> priceList = product.getPrices().getPrice();
        Collections.sort(priceList, (o1, o2) -> (int) (o1.getTimestamp() - o2.getTimestamp()));
        for (Price p : priceList) {
            prices.set(p.getTimestamp(), p.getPrice());
        }
        lineModel.addSeries(prices);
        lineModel.setTitle("Price Chart");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Timestamp"));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("Price");
        yAxis.setMin(0);
        yAxis.setMax(2000);
        return lineModel;
    }
}
