package com.company;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;


public class MazeTxtToInt {
    /*  lets have 0 = road or " " not visited
                  1 = wall or block character
                  2 = visited
                  3 = start = "s"
                  4 = end = "e"

         lets use the simplest method of depth first search
     */
    public static int rows = 0;
    public static int cols = 0;
    public static int[][] maze = null; // 2d integer array maze
    public static int startX; //column index of starting place
    public static int startY; //row index of start
    public static int endX;
    public static int endY;
    public static Scanner readFile;

    public static int[][] MazeReader(String FileName) {

        // get dimensions of the maze
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            String s;
            while ((s = br.readLine()) != null) {
                cols = s.length();
                //System.out.println(s);
                rows++;
            }
            br.close();
            //System.out.println(rows); //check if its correct
            //System.out.println(cols);


            maze = new int[rows][cols];           //initialize

        } catch (IOException e) {
            System.out.println("error in maze storing");
        }



        //now we read the file with a scanner to change characters to simple numbers and represent
        //it with a 2d integer array.

        try {
            readFile = new Scanner(new File(FileName));
            int numOfRow = 0;
            while (readFile.hasNextLine()) {
                //System.out.println(readFile.hasNextLine());
                String s2 = readFile.nextLine();
                for (int j = 0; j < cols; j++) {
                    String sLetter = "s";
                    String eLetter = "e";
                    String path = " ";
                    if (s2.charAt(j) == sLetter.charAt(0)) {
                        maze[numOfRow][j] = 3;
                        startX = j;
                        startY = numOfRow;
                    }
                    if (s2.charAt(j) == eLetter.charAt(0)) {
                        maze[numOfRow][j] = 4;
                        endX = j;
                        endY = numOfRow;
                    }
                    if (s2.charAt(j) == path.charAt(0)) {
                        maze[numOfRow][j] = 0;
                    } else if (s2.charAt(j) == (char) 9608){
                        maze[numOfRow][j] = 1;
                    }
                    System.out.println("Path coord = (" + numOfRow + " , " + j +
                           ") Value at coord = " + maze[numOfRow][j]); // check coordinates!!
                }
                numOfRow++;
            }
            //System.out.println(startX); //check if correct
            //System.out.println(startY);
            //System.out.println(endX);
            //System.out.println(endY);
            readFile.close();
        } catch (FileNotFoundException e){
            System.out.print("error, no solution!");
        }
        return maze;
    }




}

