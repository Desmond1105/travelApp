package my.edu.utar.travelapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btmNav= findViewById(R.id.btm_navigation);
        btmNav.setOnNavigationItemSelectedListener(navlistener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.nav_account:
                            selectedFragment = new AccountFragment();
                            break;

                        case R.id.nav_list:
                            selectedFragment = new ChecklistFragment();
                            break;
                        case R.id.nav_planner:
                            selectedFragment = new PlannerFragment();
                            break;
                        case R.id.nav_spending:
                            selectedFragment = new SpendingFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}