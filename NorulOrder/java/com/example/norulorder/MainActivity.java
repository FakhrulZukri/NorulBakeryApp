package com.example.norulorder;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.core.view.viewCompat;

public class MainActivity extends AppCompatActivity {

    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrementquantity(View view){
        quantity=quantity-1;
        if (quantity<0){
            Toast.makeText(getApplicationContext(),"Less 1 not valid", Toast.LENGTH_SHORT.show();
        }
        else
        {displayquantity(quantity);}
    }

    public void incrementquantity(View view){
        quantity=quantity+1;
        if (quantity>50) {
            Toast.makeText(getApplicationContext(), "more 50 is not valid", Toast.LENGTH_SHORT).show();
        }
        else{
            displayquantity(quantity);}
    }

    private void displayquantity(int quantity){
        TextView quantity1=(TextView) findViewById(R.id.quantitychange_value);
        quantity1.setText(""+quantity);
    }

    public void OrderButton(View view){
        EditText name= (EditText) findViewById(R.id.Enter_your_name);

        String name = name.getText().toString();
        CheckBox butter = (CheckBox) findViewById(R.id.butter_cookie);
        Boolean butter = butter.isChecked();
        CheckBox choco = (CheckBox) findViewById(R.id.dark_choco);
        Boolean choco = choco.isChecked();
        int price = calculatePrice(butter,choco);
        String finalMessage=createFinalMessage(names,butter,choco,price);
        displayMessage(finalMessage);
    }

    private void displayMessage(String finalMessage){
        TextView Message = (TextView) finalViewById(R.id.Total_Expense);
        Message.setText(""+finalMessage);
    }

    private String createFinalMessage(String name, Boolean butter, Boolean choco, int price) {
        String Message = "Name: "+names+"\n"+"Brown Butter Salted Caramel Chocolate Chunk ordered:  "+butter+"\n"+
                "Dark Chocolate with Nutella ordered: "+ choco+"\n" + "Total Price: " + price+ "\n";
        return Message;
    }

    private int calculatePrice(Boolean butter, Boolean choco){

        int price=10;
        if (butter){
            price=price+2;
        }
        if (choco){
            price=price+3;
        }
        return price*quantity;
    }

}
