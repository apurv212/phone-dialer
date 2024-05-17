package com.example.phonedial;
//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import static android.Manifest.permission..CALL_PHONE;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one, two, three, four, five, six, seven, eight, nine, zero, call, save, delete, star, hash;
    EditText phoneNumber;
    String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button)findViewById(R.id.one);
        one.setOnClickListener(this);

        two = (Button)findViewById(R.id.two);
        two.setOnClickListener(this);

        three = (Button)findViewById(R.id.three);
        three.setOnClickListener(this);

        four = (Button)findViewById(R.id.four);
        four.setOnClickListener(this);

        five = (Button)findViewById(R.id.five);
        five.setOnClickListener(this);

        six = (Button)findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = (Button)findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = (Button)findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = (Button)findViewById(R.id.nine);
        nine.setOnClickListener(this);

        zero = (Button)findViewById(R.id.zero);
        zero.setOnClickListener(this);

        call = (Button)findViewById(R.id.call);
        call.setOnClickListener(this);

        save = (Button)findViewById(R.id.save);
        save.setOnClickListener(this);

        delete = (Button)findViewById(R.id.del);
        delete.setOnClickListener(this);

        star = (Button)findViewById(R.id.star);
        star.setOnClickListener(this);

        hash = (Button)findViewById(R.id.hash);
        hash.setOnClickListener(this);

        phoneNumber = (EditText)findViewById(R.id.txt_phonenumber);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(one))
        {
            num += "1";
            phoneNumber.setText((num));
        }
        else if(v.equals(two))
        {
            num += "2";
            phoneNumber.setText((num));
        }
        else if(v.equals(three))
        {
            num += "3";
            phoneNumber.setText((num));
        }
        else if(v.equals(four))
        {
            num += "4";
            phoneNumber.setText((num));
        }
        else if(v.equals(five))
        {
            num += "5";
            phoneNumber.setText((num));
        }
        else if(v.equals(six))
        {
            num += "6";
            phoneNumber.setText((num));
        }
        else if(v.equals(seven))
        {
            num += "7";
            phoneNumber.setText((num));
        }
        else if(v.equals(eight))
        {
            num += "8";
            phoneNumber.setText((num));
        }
        else if(v.equals(nine))
        {
            num += "9";
            phoneNumber.setText((num));
        }
        else if(v.equals(zero))
        {
            num += "0";
            phoneNumber.setText((num));
        }
        else if(v.equals(star))
        {
            num += "*";
            phoneNumber.setText((num));
        }
        else if(v.equals(hash))
        {
            num += "#";
            phoneNumber.setText((num));
        }
        else if(v.equals(delete))
        {
            String data = phoneNumber.getText().toString();
            if(data.length()>0) //if length >0n then only do
            {
                phoneNumber.setText(data.substring(0,data.length()-1));
                num = data.substring(0,data.length()-1); //we use substring begin index,till end -1 we get 0-9 9th index not consider
            }
            else //otherwise set text null
            {
                phoneNumber.setText("");
                num = "";
            }
        }
        else if(v.equals(save))
        {   String data= phoneNumber.getText().toString();
            Intent contactIntent= new Intent(ContactsContract.Intents.Insert.ACTION); //pass contactsContract.must
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);   //u have to use set type with raw contact that will provide yoyu table structure in this there is content type
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"unkown");  //for passing phone no. use putExtra
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,data);
            startActivity(contactIntent);
        }
        else if(v.equals(call))
        {
            String data = phoneNumber.getText().toString(); //for getting thenumber //to passs the dial paid use set data and uri
            Intent intent = new Intent(Intent.ACTION_DIAL); // for opening dial pad intent.action dial wuth uri.parse for passing the phone number
            intent.setData(Uri.parse("tel:"+ data));
            startActivity(intent);
        }
    }
}


