package com.example.rivercrossing;

import android.widget.ImageView;

public class Characters {
    String name;
    ImageView image;
    boolean onBoat;

    public Characters (String inputName, ImageView inputImg, boolean inputOnBoat) {
        name = inputName;
        image = inputImg;
        onBoat = inputOnBoat;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setImage(ImageView newImg) {
        image = newImg;
    }

    public void updatePosition() {

    }
}
