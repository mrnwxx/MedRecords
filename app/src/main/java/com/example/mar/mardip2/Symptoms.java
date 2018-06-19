package com.example.mar.mardip2;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Symptoms extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);


        Button btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://euromd.com.ua/9-khvorobi-i-stani/134-khvorobi-i-likuvannya/12-khvorobi-sertsya-i-sudin/post-792-golovniy-bil-klasifikatsiya-diagnostika-i-likuvannya/"));
                startActivity(browserIntent);
            }
        });

        Button btn1 = (Button) findViewById(R.id.button5);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                 Intent browserIntent = new
                     Intent(Intent.ACTION_VIEW, Uri.parse("https://ukrhealth.net/yak-likuvati-bil-u-gorli/"));
                 startActivity(browserIntent);
            }
        });

         Button btn2 = (Button) findViewById(R.id.button6);
          btn2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                 Intent browserIntent = new
                       Intent(Intent.ACTION_VIEW, Uri.parse("http://abrol.ua/o-kashle/"));
                         startActivity(browserIntent);
              }
          });

          Button btn3 = (Button) findViewById(R.id.button7);
           btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View view) {
                      Intent browserIntent = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("http://zdorovia.com.ua/likar/206677-vidiv-bolyu-v-zhivoti-yaki-ne-mozhna-ignoruvati.html"));
                                 startActivity(browserIntent);
                }
           });

           Button btn4 = (Button) findViewById(R.id.button7);
           btn4.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                      Intent browserIntent = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("http://zdorovia.com.ua/likar/206677-vidiv-bolyu-v-zhivoti-yaki-ne-mozhna-ignoruvati.html"));
                                 startActivity(browserIntent);
                 }
           });

            Button btn5 = (Button) findViewById(R.id.button8);
            btn5.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                       Intent browserIntent = new
                             Intent(Intent.ACTION_VIEW, Uri.parse("https://healthday.in.ua/narmed/likuiemo-bil-v-kolinakh-v-domashnikh-umovakh"));
                             startActivity(browserIntent);
                 }
            });


             Button btn6 = (Button) findViewById(R.id.button9);
             btn6.setOnClickListener(new View.OnClickListener() {
                  @Override
                   public void onClick(View view) {
                       Intent browserIntent = new
                              Intent(Intent.ACTION_VIEW, Uri.parse("https://empendium.com/ua/chapter/B27.I.1.6."));
                             startActivity(browserIntent);
                  }
             });


              Button btn7 = (Button) findViewById(R.id.button10);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://ukrhealth.net/yak-vilikuvati-nezhit-za-dva-dni/"));
                startActivity(browserIntent);
            }
        });

        Button btn8 = (Button) findViewById(R.id.button4);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://uanew.info/bil-u-spini-prichini-i-simptomi"));
                startActivity(browserIntent);
            }
        });

        Button btn9 = (Button) findViewById(R.id.button11);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://mednean.com.ua/uk/bil-u-myazah"));
                startActivity(browserIntent);
            }
        });

        Button btn10 = (Button) findViewById(R.id.button13);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://medfactor.com.ua/болять-всі-кістки-і-суглоби-що-робити.html"));
                startActivity(browserIntent);
            }
        });

    }

   }