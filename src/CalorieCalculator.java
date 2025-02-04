import java.util.Scanner;

public class CalorieCalculator {


    //calculate calories based on multiple questions

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect User Data
        System.out.println("Select your gender:");
        System.out.println("1. Male\n2. Female");
        int genderChoice = scanner.nextInt();
        String gender = (genderChoice == 1) ? "Male" : "Female";

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your height (in cm): ");
        double height = scanner.nextDouble();

        System.out.print("Enter your weight (in kg): ");
        double weight = scanner.nextDouble();

        System.out.println("Select your activity level:");
        System.out.println("1. Sedentary\n2. Lightly Active\n3. Moderately Active\n4. Very Active");
        int activityChoice = scanner.nextInt();

        System.out.println("Select your goal:");
        System.out.println("1. Lose Fat\n2. Gain Weight\n3. Be Healthier");
        int goalChoice = scanner.nextInt();

        System.out.println("Select your approach:");
        System.out.println("1. Moderate\n2. Intensive\n3. Balanced");
        int approachChoice = scanner.nextInt();

        // Calculate BMR
        double bmr;
        if (gender.equalsIgnoreCase("Male")) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        // Adjust for Activity Level
        double activityFactor;
        switch (activityChoice) {
            case 1: activityFactor = 1.2; break; // Sedentary
            case 2: activityFactor = 1.375; break; // Lightly Active
            case 3: activityFactor = 1.55; break; // Moderately Active
            case 4: activityFactor = 1.725; break; // Very Active
            default: activityFactor = 1.2; // Default to Sedentary
        }

        double tdee = bmr * activityFactor;

        // Set Caloric Target Based on Goal
        double targetCalories = tdee;
        switch (goalChoice) {
            case 1: // Lose Fat
                targetCalories = tdee - 500;
                break;
            case 2: // Gain Weight
                targetCalories = tdee + 300; // Starting with +300
                break;
            case 3: // Be Healthier
                targetCalories = tdee; // Maintenance
                break;
        }

        // Modify Based on Approach
        switch (approachChoice) {
            case 1: // Moderate
                break; // No change
            case 2: // Intensive
                targetCalories += (goalChoice == 1) ? -200 : 200;
                break;
            case 3: // Balanced
                targetCalories += (goalChoice == 1) ? -300 : 300;
                break;
        }

        // Display Calories Needed
        System.out.printf("\nTo achieve your goal, your daily calorie target is %.0f calories/day.%n", targetCalories);
        System.out.println("This includes adjustments for your activity level and goal.");

        scanner.close();
    }
}
