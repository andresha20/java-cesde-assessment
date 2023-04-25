public class Log {
    public int plan_value, customer_id, years_as_customer;
    public long cellphone_number;
    public float total, netTotal, discount;
    public String plan_type;

    public Log(int customer_id, int plan_value, float total, float netTotal, float discount, long cellphone_number, String plan_type, int years_as_customer) {
        this.cellphone_number = cellphone_number;
        this.customer_id = customer_id;
        this.netTotal = netTotal;
        this.plan_type = plan_type;
        this.plan_value = plan_value;
        this.total = total;
        this.discount = discount;
        this.years_as_customer = years_as_customer;
    }
}
