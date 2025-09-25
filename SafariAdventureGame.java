import java.util.*;

public class SafariAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;
        final int minDailyPoints = 20;
        final int survivalGoal = 100;
        String[] validAreas = {"Jungle", "River", "Desert", "Mountains"};

        System.out.println("🦁 Welcome to the Safari Adventure!");
        System.out.println("Survive 5 days and collect at least 100 points!\n");

        // for loop - 5-day safari
        for (int day = 1; day <= 5; day++) {
            System.out.println("📅 Day " + day + " of your safari journey.");

            String chosenArea;
            boolean validInput;

            // do...while loop for valid area selection
            do {
                System.out.print("Choose an area to explore (Jungle, River, Desert, Mountains): ");
                chosenArea = scanner.nextLine().trim();
                validInput = Arrays.asList(validAreas).contains(chosenArea);
                if (!validInput) {
                    System.out.println("❌ Invalid area. Try again.");
                }
            } while (!validInput);

            System.out.println("🌍 You head into the " + chosenArea + "...\n");

            int eventCount = 0;
            int dailyPoints = 0;

            // while loop for up to 3 events
            while (eventCount < 3) {
                eventCount++;
                boolean skipToNextEvent = false;

                int eventRoll = random.nextInt(6); // 0 to 5

                switch (eventRoll) {
                    case 0:
                        System.out.println("🕊️ You spot a harmless bird. You move on.");
                        skipToNextEvent = true; // simulate continue
                        break;
                    case 1:
                        System.out.println("💎 You discover hidden resources! +15 points.");
                        dailyPoints += 15;
                        break;
                    case 2:
                        System.out.println("🍃 You find medicinal herbs. +10 points.");
                        dailyPoints += 10;
                        break;
                    case 3:
                        System.out.println("☀️ A heatwave slows you down. No progress.");
                        break;
                    case 4:
                        System.out.println("🌧️ You get caught in a storm. -5 points.");
                        dailyPoints -= 5;
                        break;
                    case 5:
                        String danger = random.nextBoolean() ? "lion" : "crocodile";
                        System.out.print("⚠️ A wild " + danger + " appears! Type \"run\" to escape: ");
                        String action = scanner.nextLine().trim().toLowerCase();
                        if (action.equals("run")) {
                            System.out.println("🏃‍♂️ You ran away from the " + danger + "!");
                        } else {
                            System.out.println("😱 You froze in fear! The " + danger + " scared you off.");
                        }
                        break; // break ends the event loop either way
                }

                // simulate continue
                if (skipToNextEvent) {
                    continue;
                }

                // break early if daily goal reached
                if (dailyPoints >= minDailyPoints) {
                    System.out.println("🎒 You've gathered enough resources for the day!\n");
                    break;
                }
            }

            totalPoints += dailyPoints;
            System.out.println("✅ End of Day " + day + ". Points collected today: " + dailyPoints);
            System.out.println("📊 Total Points so far: " + totalPoints + "\n");
        }

        // Summary
        System.out.println("🏁 Safari Adventure Complete!");
        System.out.println("📊 Final Points: " + totalPoints);
        if (totalPoints >= survivalGoal) {
            System.out.println("🎉 Congratulations! You survived the safari and completed your mission!");
        } else {
            System.out.println("😢 You didn't gather enough resources. Better luck next time!");
        }

        scanner.close();
    }
}

