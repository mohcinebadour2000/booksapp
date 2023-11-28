package com.googleplay.books;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.googleplay.books.Fragments.Home;
import com.googleplay.books.Fragments.Notification;
import com.googleplay.books.Fragments.Profile;
import com.googleplay.books.Fragments.Search;


public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    BubbleNavigationLinearView bubbleNavigationLinearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code for enable full screen
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#28272c"));
        //end

        bubbleNavigationLinearView = findViewById(R.id.bubblenavigationbar);

        bubbleNavigationLinearView.setBadgeValue(0, "8");
        bubbleNavigationLinearView.setBadgeValue(1, "0");
//        bubbleNavigationLinearView.setBadgeValue(2, "1");
//        bubbleNavigationLinearView.setBadgeValue(3, "1");

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new Home());
        fragmentTransaction.commit();
//
//        bubbleNavigationLinearView.setCurrentActiveItem(2);

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position) {
                    case 0:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new Home());
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new Notification());
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, new Profile());
                        fragmentTransaction.commit();
                        break;
//                    case 3:
//                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.fragment_container, new Profile());
//                        fragmentTransaction.commit();
//                        break;
                }
            }
        });
    }

}