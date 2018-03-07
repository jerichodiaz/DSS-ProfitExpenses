/**
 * Created by Diaz, Jericho Hans
 * On 3/2/2018
 */
public class Calculate {
    public static double resources(double expenses, double hr, double overhead) {
        return expenses - (hr + overhead);
    }

    public static double totalCost(double materialCount, double materialCost) {
        return materialCost * materialCount;
    }

    public static double hrManagement(double employeeCount, double salary, double operationalExpenses) {
        return employeeCount * salary + employeeCount * operationalExpenses;
    }
    public static double hrManagementAlternate(double expenses, double resources, double overhead){
        return expenses - (resources+overhead);
    }

    public static double overheadBills(double rent, double advertising, double maintenance) {
        return rent + advertising + maintenance;
    }
    public static double overheadBillsAlternate(double expenses, double resources, double hr){
        return expenses - (resources+hr);
    }

    public static double expenses(double resources, double totalCost, double hrManagement) {
        return resources + totalCost + hrManagement;
    }
    public static double expensesAlternate(double revenue, double price, double products){
        return (price*products) - revenue;
    }

    public static double revenue(double expenses, double totalProducts, double price) {
        return totalProducts * price - expenses;
    }

    public static double totalProducts(double expenses, double price, double revenue) {
        return (revenue + expenses) / price;
    }

    public static double price(double expenses, double totalProducts, double revenue) {
        return (expenses + revenue) / totalProducts;
    }

    public static double materialCount(double materialCost, double totalCost) {
        return totalCost / materialCost;
    }

    public static double materialCost(double materialCount, double totalCost) {
        return totalCost / materialCount;
    }

    public static double employeeCount(double hr, double salary, double operationalExpenses) {
        return hr / (salary + operationalExpenses);
    }

    public static double salary(double hr, double employee, double operationalExpenses) {
        return (hr - (employee * operationalExpenses)) / employee;
    }

    public static double operationalExpenses(double hr, double employee, double salary) {
        return (hr - (employee * salary)) / employee;
    }

    public static double rent(double overhead, double advertising, double maintenance) {
        double ans = overhead - (advertising + maintenance);
        if (ans < 0)
            return 0;
        return ans;
    }

    public static double advertising(double overhead, double rent, double maintenance) {
        double ans = overhead - (rent + maintenance);
        if (ans < 0)
            return 0;
        return ans;
    }

    public static double maintenance(double overhead, double rent, double advertising) {
        double ans = overhead - (rent + advertising);
        if (ans < 0)
            return 0;
        return ans;
    }
    public static double productionQuota(double employeeCount, double totalProducts){
        return totalProducts/employeeCount;
    }

}
