import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Diaz, Jericho Hans
 * On 2/28/2018
 */
public class Controller implements Initializable {
    @FXML
    private ProgressIndicator piResource;
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
    private boolean isForward = true;


    private void inputChartData() {

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

        double x = Double.parseDouble(txtResource.getText());
        double y = Double.parseDouble(txtHR.getText());
        double z = Double.parseDouble(txtOverhead.getText());
        double a = x + y + z;
        piResource.setProgress(x / a);
    }

    protected void calculate() {
        transformNullToZero();
        inputTextData();
        inputChartData();
    }


    private void initCharts() {
        chart.setLabelsVisible(false);
        chart.setLegendVisible(true);
        chart.setLegendSide(Side.RIGHT);
        chartHR.setLabelLineLength(5);
        chartOverhead.setLabelLineLength(5);
        chartHR.setLegendVisible(false);
        chartOverhead.setLegendVisible(false);

    }

    @FXML private void setForward(){
        isForward = true;
        calculate();
    }
    @FXML private void setBackward(){
        isForward = false;
        calculate();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCharts();
    }

    private void transformNullToZero() {
        txtResource.setText(txtResource.getText().isEmpty() ? "0" : txtResource.getText());
        txtHR.setText(txtHR.getText().isEmpty() ? "0" : txtHR.getText());
        txtOverhead.setText(txtOverhead.getText().isEmpty() ? "0" : txtOverhead.getText());
        txtMaterials.setText(txtMaterials.getText().isEmpty() ? "0" : txtMaterials.getText());
        txtMaterialCost.setText(txtMaterialCost.getText().isEmpty() ? "0" : txtMaterialCost.getText());
        txtTotalCost.setText(txtTotalCost.getText().isEmpty() ? "0" : txtTotalCost.getText());
        txtEmployeeCount.setText(txtEmployeeCount.getText().isEmpty() ? "0" : txtEmployeeCount.getText());
        txtSalary.setText(txtSalary.getText().isEmpty() ? "0" : txtSalary.getText());
        txtOperationExpense.setText(txtOperationExpense.getText().isEmpty() ? "0" : txtOperationExpense.getText());
        txtQuota.setText(txtQuota.getText().isEmpty() ? "0" : txtQuota.getText());
        txtRent.setText(txtRent.getText().isEmpty() ? "0" : txtRent.getText());
        txtAdvertising.setText(txtAdvertising.getText().isEmpty() ? "0" : txtAdvertising.getText());
        txtMaintenance.setText(txtMaintenance.getText().isEmpty() ? "0" : txtMaintenance.getText());
        txtExpense.setText(txtExpense.getText().isEmpty() ? "0" : txtExpense.getText());
        txtProducts.setText(txtProducts.getText().isEmpty() ? "0" : txtProducts.getText());
        txtPrice.setText(txtPrice.getText().isEmpty() ? "0" : txtPrice.getText());
        txtRevenue.setText(txtRevenue.getText().isEmpty() ? "0" : txtRevenue.getText());
    }

    public void inputTextData() {
        double resource = Double.parseDouble(txtResource.getText()),
                hr = Double.parseDouble(txtHR.getText()),
                overhead = Double.parseDouble(txtOverhead.getText()),
                materials = Double.parseDouble(txtMaterials.getText()),
                materialCost = Double.parseDouble(txtMaterialCost.getText()),
                totalCost = Double.parseDouble(txtTotalCost.getText()),
                employeeCount = Double.parseDouble(txtEmployeeCount.getText()),
                salary = Double.parseDouble(txtSalary.getText()),
                operationalExpense = Double.parseDouble(txtOperationExpense.getText()),
                quota = Double.parseDouble(txtQuota.getText()),
                rent = Double.parseDouble(txtRent.getText()),
                advertising = Double.parseDouble(txtAdvertising.getText()),
                maintenance = Double.parseDouble(txtMaintenance.getText()),
                expense = Double.parseDouble(txtExpense.getText()),
                products = Double.parseDouble(txtProducts.getText()),
                price = Double.parseDouble(txtPrice.getText()),
                revenue = Double.parseDouble(txtRevenue.getText());
        if (rResource.isSelected() || rTotalCost.isSelected()) {
            double ans = Calculate.totalCost(materials, materialCost);
            if (!isForward) {
                txtResource.setText(Calculate.resources(expense, hr, overhead) + "");
                txtTotalCost.setText(Calculate.resources(expense, hr, overhead) + "");
            } else {
                txtResource.setText(ans + "");
                txtTotalCost.setText(ans + "");
            }
        } else if (rHR.isSelected()) {
            double ans = Calculate.hrManagement(employeeCount, salary, operationalExpense);
            if (!isForward)
                txtHR.setText(Calculate.hrManagementAlternate(expense, resource, overhead) + "");
            else
                txtHR.setText(ans + "");
        } else if (rOverhead.isSelected()) {
            double ans = Calculate.overheadBills(rent, advertising, maintenance);
            if (!isForward) {
                txtOverhead.setText(Calculate.overheadBillsAlternate(expense, resource, hr) + "");
            } else
                txtOverhead.setText(ans + "");
        } else if (rExpense.isSelected()) {
            double ans = Calculate.expenses(resource, hr, overhead);
            if (!isForward)
                txtExpense.setText(Calculate.expensesAlternate(revenue, price, products) + "");
            else
                txtExpense.setText(ans + "");
        } else if (rRevenue.isSelected())
            txtRevenue.setText(Calculate.revenue(expense, products, price) + "");
        else if (rProducts.isSelected())
            txtProducts.setText(Calculate.totalProducts(expense, price, revenue) + "");
        else if (rPrice.isSelected())
            txtPrice.setText(Calculate.price(expense, products, revenue) + "");
        else if (rMaterials.isSelected())
            txtMaterials.setText(Calculate.materialCount(materialCost, totalCost) + "");
        else if (rMaterialCost.isSelected())
            txtMaterialCost.setText(Calculate.materialCost(materials, totalCost) + "");
        else if (rEmployeeCount.isSelected())
            txtEmployeeCount.setText(Calculate.employeeCount(hr, salary, operationalExpense) + "");
        else if (rSalary.isSelected())
            txtSalary.setText(Calculate.salary(hr, employeeCount, operationalExpense) + "");
        else if (rOperationExpense.isSelected())
            txtOperationExpense.setText(Calculate.operationalExpenses(hr, employeeCount, salary) + "");
        else if (rQuota.isSelected())
            txtQuota.setText(Calculate.productionQuota(employeeCount, products) + "");
        else if (rRent.isSelected()) {
            txtRent.setText(Calculate.rent(overhead, advertising, maintenance) + "");
            if (txtRent.getText().equals("0.0"))
                txtOverhead.setText(Calculate.overheadBills(Double.parseDouble(txtRent.getText()), advertising, maintenance) + "");
        } else if (rAdvertising.isSelected()) {
            txtAdvertising.setText(Calculate.advertising(overhead, rent, maintenance) + "");
            if (txtAdvertising.getText().equals("0.0"))
                txtOverhead.setText(Calculate.overheadBills(rent, Double.parseDouble(txtAdvertising.getText()), maintenance) + "");
        } else if (rMaintenance.isSelected()) {
            txtMaintenance.setText(Calculate.maintenance(overhead, rent, advertising) + "");
            if (txtMaintenance.getText().equals("0.0"))
                txtOverhead.setText(Calculate.overheadBills(rent, advertising, Double.parseDouble(txtMaintenance.getText())) + "");
        }
    }
}
