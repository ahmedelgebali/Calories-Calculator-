import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Goal Based Onboarding Questionnaire, first party upon the app initial open");

                // age question
                System.out.println("1. What is your age?");
                System.out.println("1) Under 18");
                System.out.println("2) 18-30");
                System.out.println("3) 31-50");
                System.out.println("4) Over 50");
                int ageGroup = scanner.nextInt();

                // current weight question
                System.out.print("2. What is your current weight (in kg)? ");
                double currentWeight = scanner.nextDouble();

                // height question
                System.out.print("3. What is your height (in cm)? ");
                double height = scanner.nextDouble();

                // gender question
                System.out.println("4. What is Your Gender?");
                System.out.println("1) Male");
                System.out.println("2) Female");
                int gender = scanner.nextInt();

                // goal question
                System.out.println("5. What is Your Goal?");
                System.out.println("1) Lose Fat");
                System.out.println("2) Gain Weight");
                System.out.println("3) Be Healthier");
                int goal = scanner.nextInt();

                // approach question
                System.out.println("6. Which approach is gonna be followed?");
                System.out.println("1) Moderate Approach");
                System.out.println("2) Intensive Approach");
                System.out.println("3) Balanced Approach");
                int approach = scanner.nextInt();

                // Follow-up Questions
                // question no 4: daily calorie reduction aim
                System.out.println("7. How many calories are you aiming to reduce daily?");
                System.out.println("1) Minimal reduction");
                System.out.println("2) Moderate reduction");
                System.out.println("3) Significant reduction");
                int calorieReduction = scanner.nextInt();

                // question no 5: tme to see results
                System.out.println("8. How soon do you want to see results?");
                System.out.println("1) No rush");
                System.out.println("2) Within 3 months");
                System.out.println("3) Within 1 month");
                int timeToResults = scanner.nextInt();

                // question no 7: willingness to track food intake
                System.out.println("9. Are you willing to track your food intake daily?");
                System.out.println("1) No");
                System.out.println("2) Yes, but with minimal effort");
                System.out.println("3) Yes, consistently and in detail");
                int foodTracking = scanner.nextInt();

                // question no 14: time commitment for exercise
                System.out.println("10. How much time can you commit to exercise daily?");
                System.out.println("1) Less than 20 minutes");
                System.out.println("2) 20-40 minutes");
                System.out.println("3) 40+ minutes");
                int exerciseTimeCommitment = scanner.nextInt();

                // calculate daily caloric needs
                double BMR = calculateBMR(currentWeight, height, ageGroup, gender);
                double TDEE = calculateTDEE(BMR, exerciseTimeCommitment);
                double calorieGoal = adjustCalories(TDEE, goal, calorieReduction);

                // process the user input and print results
                processInput(ageGroup, currentWeight, height, gender, goal, approach, calorieReduction, timeToResults, foodTracking, exerciseTimeCommitment, calorieGoal);

                // closing scanner
                scanner.close();
            }

            private static double calculateBMR(double weight, double height, int ageGroup, int gender) {
                // BMR calculation based on Mifflin-St Jeor Equation
                double bmr;
                if (gender == 1) { // Male
                    bmr = 10 * weight + 6.25 * height - 5 * getAgeFromGroup(ageGroup) + 5;
                } else { // Female
                    bmr = 10 * weight + 6.25 * height - 5 * getAgeFromGroup(ageGroup) - 161;
                }
                return bmr;
            }

            private static double calculateTDEE(double bmr, int exerciseTimeCommitment) {
                // activity multipliers
                double activityMultiplier;
                if (exerciseTimeCommitment == 1) { // Less than 20 minutes
                    activityMultiplier = 1.2; // Sedentary
                } else if (exerciseTimeCommitment == 2) { // 20-40 minutes
                    activityMultiplier = 1.375; // Lightly active
                } else { // 40+ minutes
                    activityMultiplier = 1.55; // Moderately active
                }
                return bmr * activityMultiplier;
            }

            private static double adjustCalories(double tdee, int goal, int calorieReduction) {
                double adjustedCalories = tdee;
                if (goal == 1) { // Lose Fat
                    switch (calorieReduction) {
                        case 1: // Minimal reduction
                            adjustedCalories -= 250;
                            break;
                        case 2: // Moderate reduction
                            adjustedCalories -= 500;
                            break;
                        case 3: // Significant reduction
                            adjustedCalories -= 750;
                            break;
                    }
                } else if (goal == 2) { // Gain Weight
                    adjustedCalories += 500; // General increase for weight gain
                }
                return adjustedCalories;
            }

            private static double getAgeFromGroup(int ageGroup) {
                return switch (ageGroup) {
                    case 1 -> 17; // Under 18
                    case 2 -> 25; // 18-30
                    case 3 -> 40; // 31-50
                    case 4 -> 60; // Over 50
                    default -> 25; // Default age
                };
            }

            private static void processInput(int ageGroup, double currentWeight, double height, int gender, int goal, int approach, int calorieReduction, int timeToResults, int foodTracking, int exerciseTimeCommitment, double calorieGoal) {
                // print the values
                System.out.println("\nUser Input Summary:");
                System.out.printf("Age Group: %d\nCurrent Weight: %.2f kg\nHeight: %.2f cm\nGender: %d\nGoal: %d\nApproach: %d\nCalorie Reduction Aim: %d\nTime to Results: %d\nFood Tracking: %d\nExercise Time Commitment: %d\nTarget Daily Calories: %.2f kcal\n",
                        ageGroup, currentWeight, height, gender, goal, approach, calorieReduction, timeToResults, foodTracking, exerciseTimeCommitment, calorieGoal);
            }
        }


    }
}