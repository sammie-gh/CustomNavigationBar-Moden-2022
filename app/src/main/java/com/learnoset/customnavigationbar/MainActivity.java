package com.learnoset.customnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.learnoset.material.ui.learnosetnavigationbar.LearnosetNavItem;
import com.learnoset.material.ui.learnosetnavigationbar.LearnosetNavigationBar;
import com.learnoset.material.ui.learnosetnavigationbar.NavItemsGroup;
import com.learnoset.material.ui.learnosetnavigationbar.NavigationEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LearnosetNavigationBar learnosetNavigationBar = findViewById(R.id.navigationBar);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        final AppCompatButton drawerOpenBtn = findViewById(R.id.drawerOpenBtn);

        // Adding Items to the Navigation Bar
        learnosetNavigationBar.addNavItem(LearnosetNavItem.BuiltInItems.HOME, new HomeFragment(), R.id.fragmentContainer);
        learnosetNavigationBar.addNavItem(LearnosetNavItem.BuiltInItems.MESSAGE, new MessageFragment(), R.id.fragmentContainer);
        learnosetNavigationBar.addNavItem(LearnosetNavItem.BuiltInItems.PROFILE, new ProfileFragment(), R.id.fragmentContainer);


        // create group
        NavItemsGroup communicationGroup = new NavItemsGroup("Communication");
        communicationGroup.addGroupItem(LearnosetNavItem.BuiltInItems.SEND);
        communicationGroup.addGroupItem(LearnosetNavItem.BuiltInItems.SHARE);

        // Creating another group
        NavItemsGroup toolsGroup = new NavItemsGroup("Tools");
        toolsGroup.addGroupItem(LearnosetNavItem.BuiltInItems.SETTINGS, new SettingsFragment(), R.id.fragmentContainer);
        toolsGroup.addGroupItem(LearnosetNavItem.BuiltInItems.TOOLS);

        // adding groups to the navigation bar
        learnosetNavigationBar.addItemsGroup(communicationGroup);
        learnosetNavigationBar.addItemsGroup(toolsGroup);

        // setting theme
        learnosetNavigationBar.setTheme(LearnosetNavigationBar.NavThemes.DARK);

        // change icons color
        learnosetNavigationBar.setIconsColor(LearnosetNavigationBar.NavColors.ORANGE);

        // change selected item background color
        learnosetNavigationBar.setSelectedItemBackground(LearnosetNavigationBar.NavColors.ORANGE);
        
        // You can also set custom Items with your own name and icon
        //learnosetNavigationBar.addNavItem(new LearnosetNavItem("Item Name", R.mipmap.ic_launcher));

        learnosetNavigationBar.setEventListener(new NavigationEventListener() {
            @Override
            public void onItemSelected(int position, LearnosetNavItem selectedNavItem) {

                // TODO handle your code here
            }
        });

        // setting drawer layout to the navigation bar with navigation open animation. Left means navigation opens from the Left side
        learnosetNavigationBar.setDrawerLayout(drawerLayout, LearnosetNavigationBar.DrawerGravity.LEFT);


        drawerOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        // setting header details
        learnosetNavigationBar.setHeaderData("John Corner");

        // setting header details with profile name and profile pic. Uncomment below line
        //learnosetNavigationBar.setHeaderData("John Corner", R.mipmap.ic_launcher);

        // setting header details with profile name and profile pic from url.  Uncomment below line
        //learnosetNavigationBar.setHeaderData("John Corner", "profile pic url here");

        // Visit our GitHub repository for more information. Link in description box

    }
}