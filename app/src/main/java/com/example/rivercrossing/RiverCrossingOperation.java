//package com.example.rivercrossing;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.animation.Animator;
//import android.os.Bundle;
//
//import com.google.android.material.snackbar.Snackbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class RiverCrossingOperation extends AppCompatActivity {
//
//    List<String> upperSide = new ArrayList<>();
//    List<String> lowerSide = new ArrayList<>();
//
//    List<String> boat = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        boolean play = true;
//        boolean isAllow = true;
//        int boatSide = 1; //1 is lowerside, 2 is upperside
//
//        while (play) {
//            reset();
//            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//            System.out.println("Pick a character to get on the boat");
//
//            while (isAllow) {
//                //Pick a character to get on boat
//                String character = myObj.nextLine();
//                lowerSide.remove(character);
//                boat.add(character);
//
//                //User clicks "GO" Button to move the boat
//                System.out.println("Do you want to go to the other side?");
//                String isGoing = myObj.nextLine();
//
//                if (isGoing == "yes") {
//                    if (boatSide == 1) {
//                        boatSide = 2;   //Move boat the upperside
//                        upperSide.add(boat.remove(0));
//
//                    } else {
//                        boatSide = 1;   //Move boat the upperside
//                        //Can remove one or both
//                        lowerSide.add(boat.remove(0));
//                    }
//                }
//
//                //Check if the current state is allowed
//                if ((upperSide.contains("Wolf") && upperSide.contains("Sheep"))
//                    || (lowerSide.contains("Wolf") && lowerSide.contains("Sheep")) ) {
//                    isAllow = false;
//                } else if ((upperSide.contains("Sheep") && upperSide.contains("Cabbage"))
//                        || (lowerSide.contains("Sheep") && lowerSide.contains("Cabbage")) ) {
//                    isAllow = false;
//                } else if (isCorrect()) {
//                    isAllow = false;
//                } else {
//                    continue;
//                }
//            }
//
//            if (isCorrect()) System.out.println("Congratulations!");
//            else System.out.println("Sorry, the answer is not correct!");
//
//            System.out.println("Do you want to play again?");
//            String userAnswer = myObj.nextLine();
//            if (userAnswer == "Yes") play = true;
//            else play = false;
//        }
//    }
//
//    protected void reset() {
//        lowerSide.add("Wolf");
//        lowerSide.add("Sheep");
//        lowerSide.add("Cabbage");
//    }
//
//    protected boolean isCorrect () {
//        if (upperSide.contains("Wolf") && upperSide.contains("Sheep")
//            && upperSide.contains("Cabbage")) return true;
//
//        return false;
//    }
//
//}
