package id.aicode.jalanaman.homepage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.emergency.EmergencyCall;
import id.aicode.jalanaman.myplace.MyPlaceTab;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.recent.RecentTab;
import id.aicode.jalanaman.services.LocalServices;

public class MainActivity extends AppCompatActivity implements HomePageContract.View{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @BindView(R.id.tabs)
    TabLayout tabLayout;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    setTabIcon();
                } else if (position == 1){
                    setTabIcon2();
                } else {
                    setTabIcon3();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setTabIcon();

        //LocalServices.isLoggedIn(getApplicationContext());
    }

    protected void setTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.myplace_selected);
        tabLayout.getTabAt(1).setIcon(R.drawable.clock);
        tabLayout.getTabAt(2).setIcon(R.drawable.emergency);
    } protected void setTabIcon2(){
        tabLayout.getTabAt(0).setIcon(R.drawable.my_place);
        tabLayout.getTabAt(1).setIcon(R.drawable.clock_selected);
        tabLayout.getTabAt(2).setIcon(R.drawable.emergency);
    } protected void setTabIcon3(){
        tabLayout.getTabAt(0).setIcon(R.drawable.my_place);
        tabLayout.getTabAt(1).setIcon(R.drawable.clock);
        tabLayout.getTabAt(2).setIcon(R.drawable.emergency_selected);
    }



/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    MyPlaceTab tab1 = new MyPlaceTab();
                    return tab1;
                case 1:
                    RecentTab tab2 = new RecentTab();
                    return tab2;
                case 2:
                    EmergencyCall tab3 = new EmergencyCall();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 3;
        }

        /*@Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.tab1_name);
                case 1:
                    return getString(R.string.tab2_name);
                case 2:
                    return getString(R.string.tab3_name);
                case 3:
                    return getString(R.string.tab4_name);
            }
            return null;
        }*/
    }
}

