package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {

    private static String myMaze = "maze.txt";
    private static int[][] MainMaze = MazeTxtToInt.MazeReader(myMaze);
    private static final List<Integer> path = new ArrayList<Integer>();

    public View(){
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Solve.findPath(MainMaze,  MazeTxtToInt.startY, MazeTxtToInt.startY, path);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.translate(50, 50);

        //drawing the maze
        for(int i=0; i < MainMaze.length; i++){
            for(int j=0; j < MainMaze[0].length; j++){
                Color color;
                switch(MainMaze[i][j]){
                    case 1: color = Color.black; break;
                    case 3 : color = Color.BLUE; break;
                    default: color = Color.white;
                }
                g.setColor(color);
                g.fillRect(10*j, 10*i, 10,10);
                g.setColor(Color.BLACK);
                g.drawRect(10*j, 10*i, 10,10);

            }
        }

        //draw path
        for (int p=0; p<path.size();p+= 2){
            int pathX = path.get(p);
            int pathY = path.get(p+1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX*10, pathY*10, 10,10);
        }
    }


    public static void main(String[] arg){
        if (Solve.findPath(MainMaze,  MazeTxtToInt.startY, MazeTxtToInt.startY, path) == false) {
            System.out.println("there is no solution to this maze");
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
            }});
    }

}
