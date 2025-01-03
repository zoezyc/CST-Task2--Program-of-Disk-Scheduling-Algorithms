
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static int firstComeFirstServe(int currentPos, int totalNumberOfCylinder, ArrayList<Integer> cylinderNumbersSeq) {
        int totalSeekTime = 0;
        return totalSeekTime;
    }

    public static int shortestSeekTimeFirst(int currentPos, int totalNumberOfCylinder, ArrayList<Integer> cylinderNumbersSeq) {
        ArrayList<Integer> sortedCylinderNumbersSeq = new ArrayList<>(cylinderNumbersSeq);
        int totalSeekTime = 0;
        Collections.sort(sortedCylinderNumbersSeq);
        System.out.print("The order in which requests are processed: ");

        while (!sortedCylinderNumbersSeq.isEmpty()) {
            int minDifference = 2147483647;
            int index = -1;

            for (int i = 0; i < sortedCylinderNumbersSeq.size(); ++i) {
                int difference = Math.abs(currentPos - sortedCylinderNumbersSeq.get(i));
                if (difference < minDifference) {
                    minDifference = difference;
                    index = i;
                }
            }
            totalSeekTime += minDifference;
            System.out.print(sortedCylinderNumbersSeq.get(index) + " ");
            currentPos = sortedCylinderNumbersSeq.get(index);
            sortedCylinderNumbersSeq.remove(index);
        }
        System.out.println("");
        return totalSeekTime;
    }

    public static void main(String[] args) {
        ArrayList<Integer> cylinderNumbersSeq = new ArrayList<>();
        Collections.addAll(cylinderNumbersSeq, 85, 73, 37, 153, 26, 59, 36, 68);
        int totalNumberOfCylinder = cylinderNumbersSeq.size();

        int initialHeadPosition = 28;

        System.out.println("The disk's initial head position: " + initialHeadPosition);
        System.out.println("The original sequence of cylinder numbers (list of I/O requests ): " + cylinderNumbersSeq);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Shortest Seek Time First Algorithms:");
        int seekTimeSSTF = shortestSeekTimeFirst(initialHeadPosition, totalNumberOfCylinder, cylinderNumbersSeq);
        System.out.println("The total number of cylinders on the disk: " + totalNumberOfCylinder);
        System.out.println("Total seek time using Shortest Seek Time First (SSTF): " + seekTimeSSTF);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        boolean isOwnData = false;
        System.out.println("Do you wish to input your own data? (true/false)");
        isOwnData = scanner.nextBoolean();

        while (isOwnData) {
            cylinderNumbersSeq.clear();

            System.out.println("Please enter the initial position of the disk's head: ");
            initialHeadPosition = scanner.nextInt();

            System.out.println("Please enter the total number of cylinders on the disk: ");
            totalNumberOfCylinder = scanner.nextInt();

            System.out.println("Please enter the cylinder numbers (I/O requests) one by one: ");
            for (int i = 0; i < totalNumberOfCylinder; i++) {
                System.out.print((i + 1) + ": ");
                cylinderNumbersSeq.add(scanner.nextInt());
            }

            System.out.println("The disk's initial head position: " + initialHeadPosition);
            System.out.println("The original sequence of cylinder numbers (list of I/O requests ): " + cylinderNumbersSeq);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

            System.out.println("Shortest Seek Time First Algorithms:");
            seekTimeSSTF = shortestSeekTimeFirst(initialHeadPosition, totalNumberOfCylinder, cylinderNumbersSeq);
            System.out.println("The total number of cylinders on the disk: " + totalNumberOfCylinder);
            System.out.println("Total seek time using Shortest Seek Time First (SSTF): " + seekTimeSSTF);

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Do you wish to input your own data again? (true/false)");
            isOwnData = scanner.nextBoolean();
        }

        System.out.println("Program ended. Thank you.");

    }
}
