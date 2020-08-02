package com.joker.venkat.rojiclothstore;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper v_flipper;
    ListView mListView;
    int[] images = {R.drawable.ami,R.drawable.amii,R.drawable.amiii,R.drawable.amiiii,R.drawable.amiiiii,R.drawable.amo,
            R.drawable.amoo,R.drawable.amu,R.drawable.amuu,R.drawable.amd};
    private CardView third,fourth,fifth,sixth;

    private Button popupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        third = (CardView) findViewById(R.id.card_view_booking);
        fourth = (CardView) findViewById(R.id.card_view_cart);
        fifth = (CardView) findViewById(R.id.card_view_history);
        sixth = (CardView) findViewById(R.id.card_view_notification);



        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fifth.setOnClickListener(this);
        sixth.setOnClickListener(this);


        mListView = (ListView)findViewById(R.id.listView);
        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);

        int images[] = {R.drawable.clothbann8,
                R.drawable.clothbann4,R.drawable.clothbann6,R.drawable.clothbann9,R.drawable.clothbann10,
                R.drawable.clothbann11,R.drawable.clothbann12,R.drawable.a,R.drawable.aa};


        v_flipper = findViewById(R.id.v_flipper);

        for (int i = 0; i<images.length;i++){
            flipperImages(images[i]);
        }
        for (int image:images ){
            flipperImages(image);

        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.logu);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMassage();

            }
        });
    }
    public void openMassage(){
        Intent intent = new Intent(this,Massaage.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView mImageView = (ImageView) view.findViewById(R.id.imageView2);
            mImageView.setImageResource(images[position]);
            return view;
        }
    }
    public void flipperImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
            case R.id.action_webpage:
                startActivity(new Intent(MainActivity.this,Webpage.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.card_view_booking : i = new Intent(this,ScrollingActivity.class);startActivity(i);break;
            case R.id.card_view_cart : i = new Intent(this,FourthActivity.class);startActivity(i);break;
            case R.id.card_view_history : i = new Intent(this,FifthActivity.class);startActivity(i);break;
            case R.id.card_view_notification : i = new Intent(this,SecondActivity.class);startActivity(i);break;

            default:break;
        }
    }
}
