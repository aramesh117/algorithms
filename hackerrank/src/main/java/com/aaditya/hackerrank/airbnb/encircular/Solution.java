package com.aaditya.hackerrank.airbnb.encircular;

public class Solution {
    static String[] doesCircleExist(String[] commands) {
        String[] result = new String[commands.length];
        for (int i1 = 0; i1 < commands.length; i1++) {
            String command = commands[i1];
            // If the command repeated four times ends up at the origin, there is a circle, otherwise no.
            int x = 0;
            int y = 0;
            Direction curDir = Direction.N;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < command.length(); j++) {
                    switch (command.charAt(j)) {
                        case 'G':
                            switch (curDir) {
                                case N:
                                    y++;
                                    break;
                                case S:
                                    y--;
                                    break;
                                case E:
                                    x++;
                                    break;
                                case W:
                                    x--;
                                    break;
                            }
                            break;
                        case 'R':
                            switch (curDir) {
                                case N:
                                    curDir = Direction.E;
                                    break;
                                case S:
                                    curDir = Direction.W;
                                    break;
                                case E:
                                    curDir = Direction.S;
                                    break;
                                case W:
                                    curDir = Direction.N;
                                    break;
                            }
                            break;
                        case 'L':
                            switch (curDir) {
                                case N:
                                    curDir = Direction.W;
                                    break;
                                case S:
                                    curDir = Direction.E;
                                    break;
                                case E:
                                    curDir = Direction.N;
                                    break;
                                case W:
                                    curDir = Direction.S;
                                    break;
                            }
                            break;
                        default:
                            System.out.println("WTF");
                    }
                }
            }
            if (x == 0 && y == 0) {
                result[i1] = "YES";
            } else {
                result[i1] = "NO";
            }
        }
        return result;
    }

    public enum Direction {
        N, S, E, W
    }
}
