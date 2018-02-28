import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Created by Diaz, Jericho Hans
 * On 2/28/2018
 */
public class Controller {
    @FXML private ProgressIndicator piResource;
    @FXML
    private RadioButton rResource, rHR, rOverhead, rMaterials, rMaterialCost,
            rTotalCost, rEmployeeCount, rSalary, rOperationExpense, rQuota, rRent,
            rAdvertising, rMaintenance, rExpense, rProducts, rPrice, rRevenue;
    @FXML
    private TextField txtResource, txtHR, txtOverhead, txtMaterials, txtMaterialCost,
            txtTotalCost, txtEmployeeCount, txtSalary, txtOperationExpense, txtQuota, txtRent,
            txtAdvertising, txtMaintenance, txtExpense, txtProducts, txtPrice, txtRevenue;
    @FXML
    private PieChart chart, chartHR, chartOverhead;
    private ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> hrData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> overheadData = FXCollections.observableArrayList();

    private void inputChartData() {

        chart.setLabelsVisible(false);
        chart.setLegendVisible(true);
        chart.setLegendSide(Side.RIGHT);
        chartHR.setLabelLineLength(5);
        chartOverhead.setLabelLineLength(5);
        chartHR.setLegendVisible(false);
        chartOverhead.setLegendVisible(false);



        chart.setData(data);
        data.clear();
        data.addAll(
                new PieChart.Data("Resource", Double.parseDouble(txtResource.getText())),
                new PieChart.Data("HR Management", Double.parseDouble(txtHR.getText())),
                new PieChart.Data("Overhead Bills", Double.parseDouble(txtOverhead.getText()))
        );
        chartHR.setData(hrData);
        hrData.clear();
        hrData.addAll(
                new PieChart.Data("Salary", Double.parseDouble(txtSalary.getText())),
                new PieChart.Data("Operation", Double.parseDouble(txtOperationExpense.getText()))
        );
        chartOverhead.setData(overheadData);
        overheadData.clear();
        overheadData.addAll(
                new PieChart.Data("Rent", Double.parseDouble(txtRent.getText())),
                new PieChart.Data("Advertising", Double.parseDouble(txtAdvertising.getText())),
                new PieChart.Data("Maintenance", Double.parseDouble(txtMaintenance.getText()))
        );
    }

    protected void calculate() {
        inputChartData();
        double x = Double.parseDouble(txtResource.getText());
        double y = Double.parseDouble(txtHR.getText());
        double z = Double.parseDouble(txtOverhead.getText());
        double a = x+y+z;
        piResource.setProgress(x/a);
    }
}
