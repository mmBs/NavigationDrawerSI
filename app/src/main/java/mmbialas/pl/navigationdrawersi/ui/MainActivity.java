package mmbialas.pl.navigationdrawersi.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import mmbialas.pl.navigationdrawersi.R;
import mmbialas.pl.navigationdrawersi.data.Fragments;
import mmbialas.pl.navigationdrawersi.data.model.NavigationDrawerItem;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentAbout;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentOne;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentThree;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentTwo;
import mmbialas.pl.navigationdrawersi.ui.navigationdrawer.NavigationDrawerView;
import timber.log.Timber;

/**
 * Created by Michal Bialas on 19/07/14.
 *
 * @author Michal Bialas
 */


public class MainActivity extends ActionBarActivity {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private int currentSelectedPosition = 0;

    @InjectView(R.id.navigationDrawerListViewWrapper)
    NavigationDrawerView mNavigationDrawerListViewWrapper;

    @InjectView(R.id.linearDrawer)
    LinearLayout mLinearDrawerLayout;

    @InjectView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.leftDrawerListView)
    ListView leftDrawerListView;

    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mTitle;

    private CharSequence mDrawerTitle;

    private List<NavigationDrawerItem> navigationItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mTitle = mDrawerTitle = getTitle();
        getSupportActionBar().setIcon(R.drawable.ic_action_ab_transparent);

        Timber.tag("LifeCycles");
        Timber.d("Activity Created");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame,
                    Fragment.instantiate(MainActivity.this, Fragments.ONE.getFragment())).commit();
        } else {
            currentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }

        navigationItems = new ArrayList<>();
        navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_one), true));
        navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_two), true));
        navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_three), true));
        navigationItems.add(new NavigationDrawerItem(getString(R.string.fragment_about),
                R.drawable.ic_action_about, false));

        mNavigationDrawerListViewWrapper.replaceWith(navigationItems);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_navigation_drawer, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        selectItem(currentSelectedPosition);

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, currentSelectedPosition);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnItemClick(R.id.leftDrawerListView)
    public void OnItemClick(int position, long id) {
        if (mDrawerLayout.isDrawerOpen(mLinearDrawerLayout)) {
            mDrawerLayout.closeDrawer(mLinearDrawerLayout);
            onNavigationDrawerItemSelected(position);

            selectItem(position);
        }
    }

    private void selectItem(int position) {

        if (leftDrawerListView != null) {
            leftDrawerListView.setItemChecked(position, true);

            navigationItems.get(currentSelectedPosition).setSelected(false);
            navigationItems.get(position).setSelected(true);

            currentSelectedPosition = position;
            getSupportActionBar()
                    .setTitle(navigationItems.get(currentSelectedPosition).getItemName());
        }

        if (mLinearDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mLinearDrawerLayout);
        }
    }

    private void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                if (!(getSupportFragmentManager().getFragments()
                        .get(0) instanceof FragmentOne)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.ONE.getFragment()))
                            .commit();
                }
                break;
            case 1:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FragmentTwo)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.TWO.getFragment()))
                            .commit();
                }
                break;
            case 2:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FragmentThree)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.THREE.getFragment()))
                            .commit();
                }
                break;
            case 3:
                if (!(getSupportFragmentManager().getFragments().get(0) instanceof FragmentAbout)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame, Fragment
                                    .instantiate(MainActivity.this, Fragments.ABOUT.getFragment()))
                            .commit();
                }
                break;
        }

    }

}
