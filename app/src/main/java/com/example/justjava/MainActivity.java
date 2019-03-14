package com.example.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffee=0;
    String Chocolate="";
    String WhippedCream="";
    String result="";
    int price1=0;
    int price2=0;
    int price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
/*        displayName();
        // Figure out if the user wants whipped cream topping
          CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream==true)
        {
            WhippedCream="\nWhipped Cream Added: $"+numberOfCoffee;
            price1=numberOfCoffee;
        }
        else
        {
            WhippedCream="";
            price1=0;
        }

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        if (hasChocolate)
        {
            Chocolate="\nChocolate Added: $"+numberOfCoffee;
            price2=numberOfCoffee;
        }
        else
        {
            Chocolate="";
            price2=0;
        }
        // Display the order summary on the screen
        String message = displayOrderSummary(hasWhippedCream,hasChocolate);
        displayMessage(message);

        */
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6.-122.3"));
        if(intent.resolveActivity(Context.getPackageManager()!=null))
            {
                startActivity(intent);
            }
    }

    public void increment(View view) {
        numberOfCoffee++;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);

    }
    public void decrement(View view) {
        if(numberOfCoffee>0){
            numberOfCoffee--;
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + numberOfCoffee);
        }
    }


    public int calculatePrice(int n)
    {
        price =price1 + price2 + numberOfCoffee*5;
        return price;
    }

    public void displayName() {
        EditText edit = (EditText)findViewById(R.id.name);
        //TextView tview = (TextView)findViewById(R.id.order_summary);
        result = edit.getText().toString();
    }

    public String displayOrderSummary(boolean hasWhippedCream,boolean  hasChocolate) {
        String priceMessage="Name:"+result;
        priceMessage+="\nQuantity:"+numberOfCoffee;
        priceMessage+="\nCoffee: $"+numberOfCoffee*5;
        priceMessage+=WhippedCream;
        priceMessage+=Chocolate;
        priceMessage+="\nTotal =$" + calculatePrice(numberOfCoffee);
        priceMessage+="\nThank you!";
        return priceMessage;

    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary);
        orderSummaryTextView.setText(message);
   }
}