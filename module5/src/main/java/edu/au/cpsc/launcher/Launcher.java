package edu.au.cpsc.launcher;

import edu.au.cpsc.miscstyle.Part1Application;

/**
 * Project: project5
 * Author: Christopher Boartfield
 * Auburn Email: clb0214@auburn.edu
 * Date: 2/7/2026
 * Description: Launcher for Project 5. Can start Part1Application or LauncherApplication.
 */
public class Launcher {

    public static void main(String[] args) {
        // Option 1: Launch Part1Application (Part 1 of the assignment)
        Part1Application.main(args);

        // Option 2: Launch LauncherApplication (Part 2 of the assignment)
        // Uncomment the following line if you want to start the launcher instead
        // Application.launch(LauncherApplication.class, args);
    }
}
