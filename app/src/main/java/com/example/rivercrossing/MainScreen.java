package com.example.rivercrossing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.rivercrossing.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    //private ActivityMainBinding binding;

    Button goButt1;
    Button goButt2;
    Button goButt3;
    ImageView farmerUp;
    ImageView farmerLow;
    ImageView boat;

    //List of characters - level 1
    Button wolf;
    Button sheep;
    Button cabbage;

    Button boatWolf;
    Button boatSheep;
    Button boatCabbage;

    Button boatWolfUpper;
    Button boatSheepUpper;
    Button boatCabbageUpper;

    Button wolf2;
    Button sheep2;
    Button cabbage2;

    //List of two sides of the river
    private ArrayList<Button> lowerSide;
    private ArrayList<Button> upperSide;
    private ArrayList<Button> boatList;


    int sideBoat = 1; //lower

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //COMMENT THIS CODE OUT TO DISPLAY THE BACK BUTTON
//        ActionBar actionBar = getSupportActionBar();
//        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);

        //set view for characters and Go button
        farmerUp = findViewById(R.id.farmerImage2);
        farmerLow = findViewById(R.id.farmerImage1);
        farmerLow.setVisibility(View.INVISIBLE);

        boat = findViewById(R.id.boatImage);
        wolf = findViewById(R.id.wolfImage);
        sheep = findViewById(R.id.sheepImage);
        cabbage = findViewById(R.id.cabbageImage);

        boatWolf = findViewById(R.id.wolfOnBoat);
        boatWolf.setVisibility(View.INVISIBLE);
        boatSheep = findViewById(R.id.sheepOnBoat);
        boatSheep.setVisibility(View.INVISIBLE);
        boatCabbage = findViewById(R.id.cabbageOnBoat);
        boatCabbage.setVisibility(View.INVISIBLE);

        boatWolfUpper = findViewById(R.id.wolfOnUpperBoat);
        boatWolfUpper.setVisibility(View.INVISIBLE);
        boatSheepUpper = findViewById(R.id.sheepOnUpperBoat);
        boatSheepUpper.setVisibility(View.INVISIBLE);
        boatCabbageUpper = findViewById(R.id.cabbageOnUpperBoat);
        boatCabbageUpper.setVisibility(View.INVISIBLE);

        wolf2 = findViewById(R.id.wolfUpperSide);
        wolf2.setVisibility(View.INVISIBLE);
        sheep2 = findViewById(R.id.sheepUpperSide);
        sheep2.setVisibility(View.INVISIBLE);
        cabbage2 = findViewById(R.id.cabbageUpperSide);
        cabbage2.setVisibility(View.INVISIBLE);

        //Add all the characters to the original side list
        lowerSide = new ArrayList<>();
        lowerSide.add(wolf);
        lowerSide.add(sheep);
        lowerSide.add(cabbage);

        upperSide = new ArrayList<>();
        boatList = new ArrayList<>();

        // GO BUTTON TO CROSS THE RIVER
        goButt1 = (Button)findViewById(R.id.goButton1);
        goButt1.setVisibility(View.INVISIBLE);
        goButt2 = (Button)findViewById(R.id.goButton2);
        goButt2.setVisibility(View.INVISIBLE);
        goButt3 = (Button)findViewById(R.id.goButton3);
        goButt3.setVisibility(View.INVISIBLE);


        // Make GO button associates with the boat
        // goButt1 for WOLF
        goButt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sideBoat == 1 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatWolf, boatWolfUpper, 1);
                    sideBoat = 2;
                } else if (sideBoat == 2 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatWolf, boatWolfUpper, 2);
                    sideBoat = 1;
                }
                setFarmerVisibility();
                isAllowed();
            }
        });

        // goButt2 for SHEEP
        goButt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sideBoat == 1 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatSheep, boatSheepUpper, 1);
                    sideBoat = 2;
                } else if (sideBoat == 2 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatSheep, boatSheepUpper, 2);
                    sideBoat = 1;
                }
                setFarmerVisibility();
                isAllowed();
            }
        });

        // goButt3 for CABBAGE
        goButt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sideBoat == 1 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatCabbage, boatCabbageUpper, 1);
                    sideBoat = 2;
                } else if (sideBoat == 2 && boatList.size() == 1) {
                    moveFromLowerToUpperBoat(boatCabbage, boatCabbageUpper, 2);
                    sideBoat = 1;
                }
                setFarmerVisibility();
                isAllowed();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

//        COMMENT THIS CODE OUT TO DISPLAY THE BACK BUTTON
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // SET UP BUTTON VISIBILITY
    public void setButtonVisibility (Button btn1, Button btn2, Button btn3) {
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
    }

    public void setFarmerVisibility () {
        if (sideBoat == 1) {
            farmerUp.setVisibility(View.VISIBLE);
            farmerLow.setVisibility(View.INVISIBLE);
        } else {
            farmerUp.setVisibility(View.INVISIBLE);
            farmerLow.setVisibility(View.VISIBLE);
        }
    }

    // CHECK ALLOW STATE (WHEN THERE ARE LESS THAN 3 CHARACTERS ON THE UPPER SIDE)
    public void isAllowed () {
        if ((upperSide.contains(wolf2) && upperSide.contains(sheep2) && sideBoat == 1)
            || (lowerSide.contains(wolf) && lowerSide.contains(sheep) && sideBoat == 2)) {
            toastMessage("Wolf ate the sheep. Please try again!");
        } else if ((upperSide.contains(sheep2) && upperSide.contains(cabbage2) && sideBoat == 1)
            || (lowerSide.contains(sheep) && lowerSide.contains(cabbage) && sideBoat == 2)) {
            toastMessage("Sheep ate the cabbage. Please try again!");
        } else if (upperSide.size() == 3)  {
            alertView("Would you like to play again?");
        }

    }

    private void alertView( String message ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainScreen.this);
        dialog.setTitle( "YOU WIN!" )
                .setMessage(message)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    dialoginterface.cancel();
                    }})
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        reset();
                    }
                }).show();
    }

    public void toastMessage (String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        reset();
    }

    // RESET METHOD TO RESET THE GAME
    public void reset () {
        sideBoat = 1;
        upperSide.clear();
        boatList.clear();

        lowerSide.add(wolf);
        lowerSide.add(sheep);
        lowerSide.add(cabbage);

        farmerUp.setVisibility(View.VISIBLE);
        farmerLow.setVisibility(View.INVISIBLE);

        wolf.setVisibility(View.VISIBLE);
        sheep.setVisibility(View.VISIBLE);
        cabbage.setVisibility(View.VISIBLE);

        boatWolf.setVisibility(View.INVISIBLE);
        boatSheep.setVisibility(View.INVISIBLE);
        boatCabbage.setVisibility(View.INVISIBLE);

        boatWolfUpper.setVisibility(View.INVISIBLE);
        boatSheepUpper.setVisibility(View.INVISIBLE);
        boatCabbageUpper.setVisibility(View.INVISIBLE);

        wolf2.setVisibility(View.INVISIBLE);
        sheep2.setVisibility(View.INVISIBLE);
        cabbage2.setVisibility(View.INVISIBLE);
    }

    // MOVE CHARACTER FROM LOWER SIDE TO BOAT
    public void wolfOnClick(View view) {
        moveFromLowerToBoat(wolf, boatWolf);
        setButtonVisibility(goButt1, goButt2, goButt3);
    }

    public void moveSheepFromLowToBoat (View view) {
        moveFromLowerToBoat(sheep, boatSheep);
        setButtonVisibility(goButt2, goButt1, goButt3);
    }

    public void moveCabbageFromLowToBoat (View view) {
        moveFromLowerToBoat(cabbage, boatCabbage);
        setButtonVisibility(goButt3, goButt1, goButt2);
    }

    public void moveFromLowerToBoat (Button character, Button charOnBoat) {
        if (boatList.size() == 0) {
            lowerSide.remove(character);
            character.setVisibility(View.INVISIBLE);

            boatList.add(character);
            charOnBoat.setVisibility(View.VISIBLE);
        }
    }


    //MOVE CHARACTER FROM BOAT TO LOWER SIDE

    public void moveWolfFromBoatToLow (View view) {
        moveFromBoatToLowerSide(boatWolf, wolf);
    }

    public void moveSheepFromBoatToLow (View view) {
        moveFromBoatToLowerSide(boatSheep, sheep);
    }

    public void moveCabbageFromBoatToLow (View view) {
        moveFromBoatToLowerSide(boatCabbage, cabbage);
    }

    public void moveFromBoatToLowerSide (Button character, Button charOnLower) {
        boatList.clear();
        character.setVisibility(View.INVISIBLE);

        lowerSide.add(charOnLower);
        charOnLower.setVisibility(View.VISIBLE);
    }


    // CHARACTER GO TO THE OTHER SIDE BY CLICKING THE GO BUTTON
    public void moveFromLowerToUpperBoat (Button lowerBoatChar, Button upperBoatChar, int side) {
        if (side == 1) {
            lowerBoatChar.setVisibility(View.INVISIBLE);
            upperBoatChar.setVisibility(View.VISIBLE);
            boatList.clear();
            boatList.add(upperBoatChar);
        } else if (side == 2) {
            lowerBoatChar.setVisibility(View.VISIBLE);
            upperBoatChar.setVisibility(View.INVISIBLE);
            boatList.clear();
            boatList.add(lowerBoatChar);
        }
    }

    // MOVE CHARACTER FROM BOAT TO UPPER SIDE
    public void moveWolfFromBoatToUpper (View view) {
        moveFromBoatToUpperSide(boatWolfUpper, wolf2);
    }

    public void moveSheepFromBoatToUpper (View view) {
        moveFromBoatToUpperSide(boatSheepUpper, sheep2);
    }

    public void moveCabbageFromBoatToUpper (View view) {
        moveFromBoatToUpperSide(boatCabbageUpper, cabbage2);
    }

    public void moveFromBoatToUpperSide (Button character, Button charOnUpper) {
        boatList.clear();
        character.setVisibility(View.INVISIBLE);

        upperSide.add(charOnUpper);
        charOnUpper.setVisibility(View.VISIBLE);
    }

    // MOVE CHARACTER FROM UPPER SIDE TO BOAT
    public void moveWolfFromUpperToBoat (View view) {
        moveFromUpperToBoat(wolf2, boatWolfUpper);
        setButtonVisibility(goButt1, goButt2, goButt3);
    }

    public void moveSheepFromUpperToBoat (View view) {
        moveFromUpperToBoat(sheep2, boatSheepUpper);
        setButtonVisibility(goButt2, goButt1, goButt3);
    }

    public void moveCabbageFromUpperToBoat (View view) {
        moveFromUpperToBoat(cabbage2, boatCabbageUpper);
        setButtonVisibility(goButt3, goButt1, goButt2);
    }

    public void moveFromUpperToBoat (Button character, Button charOnBoat) {
        if (boatList.size() == 0) {
            upperSide.remove(character);
            character.setVisibility(View.INVISIBLE);

            boatList.add(character);
            charOnBoat.setVisibility(View.VISIBLE);
        }
    }


}