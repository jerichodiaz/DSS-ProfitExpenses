/**
 * Created by Diaz, Jericho Hans
 * On 3/2/2018
 */
public class Calculate {
    public static double resources(double totalCost) {
        return totalCost;
    }

    public static double totalCost(double materialCount, double materialCost) {
        return materialCost * materialCount;
    }

    public static double hrManagement(double employeeCount, double salary, double operationalExpenses) {
        return employeeCount * salary + employeeCount * operationalExpenses;
    }

    public static double overheadBills(double rent, double advertising, double maintenance) {
        return rent + advertising + maintenance;
    }

    public static double expenses(double resources, double totalCost, double hrManagement) {
        return resources + totalCost + hrManagement;
    }

    public static double revenue(double expenses, double totalProducts, double price) {
        return totalProducts * price - expenses;
    }

    public static double totalProducts(double expenses, double price, double revenue) {
        return (revenue + expenses) / price;
    }

    public static double price(double expenses, double totalProducts, double revenue) {
        return expenses * revenue / totalProducts;
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
        return (hr - (employee - operationalExpenses)) / employee;
    }

    public static double operationalExpenses(double hr, double employee, double salary) {
        return (hr - (employee - salary)) / employee;
    }

    public static double rent(double overhead, double advertising, double maintenance) {
        return overhead - (advertising + maintenance);
    }

    public static double advertising(double overhead, double rent, double maintenance) {
        return overhead - (rent + maintenance);
    }

    public static double maintenance(double overhead, double rent, double advertising) {
        return overhead - (rent + advertising);
    }

}
