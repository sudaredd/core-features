package lambdas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Subscription {
    public int id;
    private int customerId;
    private int monthlyPriceInDollars;

    public Subscription(int id, int customerId, int monthlyPriceInDollars) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMonthlyPriceInDollars() {
        return monthlyPriceInDollars;
    }
}

class User {
    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    private int customerId;
    public User() {
    }
    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }
}

class Challenge {

    Subscription newPlan = new Subscription(1, 1, 4);

    User[] noUsers = new User[0];

    User[] constantUsers = {
            new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
            new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1)
    };

    User[] userSignedUp = {
            new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
            new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1),
            new User(3, "Employee #3", LocalDate.of(2019, 01, 10), null, 1),
    };
    public static void main(String[] args) {


    }
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        BigDecimal total = new BigDecimal("");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate currentDate = currentLocalDate(month + "-01");
        int totalDaysInMonth = currentDate.lengthOfMonth();

        int monthlyPriceInDollars = activeSubscription.getMonthlyPriceInDollars();

        BigDecimal perDay = new BigDecimal(monthlyPriceInDollars).divide(new BigDecimal(totalDaysInMonth), 2, RoundingMode.HALF_UP);


        Map<LocalDate, List<User>> noOFUsers = new HashMap<>();
        for (int i = 0; users != null && i < users.length; i++) {
            User user = users[i];

            if (user.getCustomerId() == activeSubscription.getCustomerId()) {
                noOFUsers.computeIfAbsent(user.activatedOn, k -> new ArrayList()).add(user);
            }
        }

        for (int i = 1; i <= totalDaysInMonth; i++) {
            LocalDate day = currentLocalDate(month + "-" + i);
            long totalToCalc = numberOfUsers(day, Arrays.asList(users));
            total = total.add(perDay.multiply(new BigDecimal(totalToCalc)), MathContext.DECIMAL64);
        }

        return total.setScale(2).doubleValue();

    }

    private static long numberOfUsers(LocalDate current, List<User> users) {

        return users.stream().filter(u -> isBeforeOrEqual(current, u)).count();
    }

    private static boolean isBeforeOrEqual(LocalDate current, User user) {
        return (user.activatedOn.isBefore(current) || user.activatedOn.isEqual(current)) && (user.deactivatedOn == null || user.deactivatedOn.isAfter(current));
    }


    private static LocalDate currentLocalDate(String month) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(month);
    }
    /*******************
     * Helper functions *
     *******************/

    /**
     * Takes a LocalDate object and returns a LocalDate which is the first day
     * of that month. For example:
     * <p>
     * firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the last day
     * of that month. For example:
     * <p>
     * lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the next day.
     * For example:
     * <p>
     * nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
     * nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}