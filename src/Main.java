import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int logs_number;
        String outputChatbox;
        ArrayList<Object> logs = new ArrayList<>();
        try (Scanner parser = new Scanner(System.in)) {
            outputChatbox = "Please insert the number of logs:";
            System.out.println(outputChatbox);
            logs_number = parser.nextInt();
            if (logs_number < 2) {
                outputChatbox = "The minimum number of logs must be 2. Your input was: " + logs_number + ".  We have automatically switched to 2.";
                System.out.println(outputChatbox);
                logs_number = 2;
            }
            int years_of_company = 50, customer_id = 0;
            String[] validPlans = {"a", "b", "c"};
            while (customer_id <= logs_number) {
                outputChatbox = "Customer #" + customer_id + ". " + "Please insert cellphone number, plan type (a, b, c) and customer years separated by comma:";
                System.out.println(outputChatbox);
                String data = parser.next();
                if (!data.contains(",")) {
                    outputChatbox = "Wrong format for the user-input data. Try again, remember to separate by comma.";
                    System.out.println(outputChatbox);
                    System.exit(-1);
                }
                String[] dataValues = data.split(",");
                if (dataValues.length < 3) {
                    outputChatbox = "Insufficient data to work with. Try again...";
                    System.out.println(outputChatbox);
                    System.exit(-1);
                }
                for (String value: dataValues) {
                    String[] substring = value.split(" ");
                    if (substring.length > 1) {
                        outputChatbox = "Data cannot have spaces. Field name: " + value;
                        System.out.println(outputChatbox);
                        System.exit(-1);
                    }
                }
                int plan_value, cellphone_number = Integer.parseInt(dataValues[0]), years_as_customer = Integer.parseInt(dataValues[2]);
                if (dataValues[0].length() != 10) {
                    outputChatbox = "Invalid cellphone number: 10 digits (min/max). Try again:";
                    System.out.println(outputChatbox);
                    System.exit(-1);
                }
                String plan_type = dataValues[1].toLowerCase();
                if (!Arrays.toString(validPlans).contains(plan_type)) {
                    outputChatbox = "Invalid plan type. Pick either a, b OR c. Try again:";
                    System.out.println(outputChatbox);
                    System.exit(-1);
                }
                if (years_as_customer > years_of_company) {
                    outputChatbox = "Our company is not older than " + years_of_company + "years. Try again:";
                    System.out.println(outputChatbox);
                    System.exit(-1);
                }
                float total, netTotal, IVA, discount = 0;
                switch (plan_type) {
                    case "a":
                        plan_value = 60000;
                        break;
                    case "b":
                        plan_value = 80000;
                        break;
                    default:
                        plan_value = 100000;
                        break;
                }
                float value_after_discount = plan_value;
                if (years_as_customer >= 2) {
                    discount = 0.1f;
                    value_after_discount = value_after_discount/(discount + 1);
                }
                netTotal = plan_value + (plan_value * 0.19f);
                IVA = value_after_discount * 0.19f;
                total = value_after_discount + IVA;
                Log log = new Log(customer_id, plan_value, total, netTotal, discount, cellphone_number, plan_type, years_as_customer);
                logs.add(log);
                outputChatbox = logs.get(customer_id).toString() + " | NET SALE: $" + netTotal + " | TOTAL: $" + total + " | TAX (IVA 19%): $" + IVA + " | DISCOUNT: " + discount * 100 + "%";
                System.out.println(outputChatbox);
                customer_id = customer_id + 1;
                }
            }
        }
}