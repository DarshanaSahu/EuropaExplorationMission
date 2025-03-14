# Europa Mission

## Introduction
NASA is planning a mission to explore Europa, one of Jupiter's moons, which is
believed to have a subsurface ocean that could potentially harbor life. We have
promised to deliver the navigation module for it. We need your help in writing this
module.

## Prerequisites
Install a text editor or an IDE like VS Code, IntelliJ IDEA, or Eclipse (optional).
Clone the repository using the following command:

    git clone https://github.com/DarshanaSahu/EuropaExplorationMission.git
    cd EuropaExplorationMission

Open the project in your IDE.

## Build instructions
Verify maven is installed by running:

    mvn -v

To build the project, run the following command in the project root directory:

    mvn clean install

## Run locally
To run the application locally:
Go to Demo class and run the main method.

When prompted, enter input as specified in the problem

    5 5
    1 2 N
    LMLMLMLMM
    3 3 E
    MMRMMRMRRM

Expected output:

    1 3 N
    5 1 E

## Assumptions
- The plateau length and breadth are positive integers.
- Robot orientation (N, E, S, W) and movement commands (L, R, M) are case-insensitive. 
- Two robots cannot occupy the same position simultaneously.
