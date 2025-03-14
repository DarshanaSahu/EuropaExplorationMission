package com.maxhome.com.entities;

import com.maxhome.com.enums.CompassDirection;

import java.util.Scanner;

public class Demo {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        Plateau plateau = new Plateau(length, breadth);

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            CompassDirection orientation = CompassDirection.valueOf(scanner.next());

//            String name = scanner.next();
            Explorer robot = new Robot("robot 1", x, y, orientation);
            plateau.addExplorer(robot);
            String instructions = scanner.next();
            plateau.followInstruction(robot, instructions);
            System.out.println(robot.position.getX() + "," + robot.position.getY() + " " + robot.compassDirection);
        }
        scanner.close();
    }
}
