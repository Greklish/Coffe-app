package com.example.justjava;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.NumberFormat;
import java.util.Locale;





/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.coffee3);
        videoview.setVideoURI(uri);

            videoview.start();

            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });

    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        String priceMessage="Total: $" + (quantity*5);
        displayMessage(priceMessage);
        priceMessage = priceMessage + "\nThank You!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.number_order);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.orderPrice);
        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));
    }
    public void increment(View view) {
        quantity++;
        display(quantity);
    }
    public void decrement(View view) {
        quantity--;
        if(quantity<0){
            quantity=0;
        }
        display(quantity);
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderPrice);
        priceTextView.setText(message);
    }
}
