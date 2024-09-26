package Task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TravelPlanner {
     public class Destination {
        String name;
        Date startDate;
        Date endDate;
        double budget;

        public Destination(String name, Date startDate, Date endDate, double budget) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.budget = budget;
        }
    }
    
    private List<Destination> destinations;
    private Scanner scanner;

    public TravelPlanner() {
        destinations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addDest() {
        System.out.print("\nEnter destination name :  ");
        String name = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD) :  ");
        Date start = getDateFromUser();
        System.out.print("Enter end   date (YYYY-MM-DD) :  ");
        Date end = getDateFromUser();
        System.out.print("Enter budget :  ");
        double budget = scanner.nextDouble();

        Destination dest = new Destination(name, start, end, budget);
        destinations.add(dest);
        System.out.println("\nDestination added successfully!");
    }

    private Date getDateFromUser() {
        Date date = null;   
        while (date == null) {
            try {
                String dateString = scanner.nextLine();
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException e) {
                System.out.println("\nInvalid date format. Please enter date in YYYY-MM-DD format:");
            }
        }
        return date;
    }

    public void genPlan() {
        System.out.println("\nYour travel plan ==>> ");
        for (Destination dest : destinations) {
            System.out.println("Destination :   " + dest.name);
            System.out.println("Start Date :   " + dest.startDate);
            System.out.println("End Date :   " + dest.endDate);
            System.out.println("Budget :   $" + dest.budget);
            System.out.println("Weather :   " + getWeather(dest.name)); // Fetch weather info
            System.out.println("----------------------------");
        }
    }

    // Placeholder method to simulate fetching weather data
    private String getWeather(String destName) {
        // In a real application, you would call a weather API to get actual weather
        // information
        // This is just a placeholder to demonstrate the concept
        // return "cold" ;
        return "Sunny";
    }

    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();
        planner.addDest();
        planner.genPlan();
    }
}