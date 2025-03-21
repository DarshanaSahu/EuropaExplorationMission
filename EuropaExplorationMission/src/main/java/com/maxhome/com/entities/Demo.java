package src.main.java.com.maxhome.com.entities;

import src.main.java.com.maxhome.com.enums.CompassDirection;

import java.util.*;

public class Demo {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int plateauCount = scanner.nextInt();
        Map<Integer, Plateau> map = new HashMap<>();
        while (plateauCount > map.size()) {
            int id = scanner.nextInt();
            int length = scanner.nextInt();
            int breadth = scanner.nextInt();

            Plateau plateau = new Plateau(id, length, breadth);
            map.put(id, plateau);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            CompassDirection orientation = CompassDirection.valueOf(scanner.next());
            int fuelQuantity = 100;
            Explorer robot = new Robot("robot 1", x, y, orientation, fuelQuantity);
            plateau.addExplorer(robot);
        }

        while (scanner.hasNext()) {

            int id = scanner.nextInt();
            Plateau plateau = map.get(id);
            String instructions = scanner.next();
            Robot robot = plateau.getRobot();
            plateau.followInstruction(robot, instructions);
            System.out.println(robot.getPosition().getX() + "," + robot.getPosition().getY() + " " + robot.getCompassDirection() + " " + robot.fuelQuantity);

        }
        scanner.close();
    }
}
