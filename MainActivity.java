package emeretgcom.example.a34;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import emeretgcom.example.a34.adapter.FragmentVP;


public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private List<Fragment> mFragmentList;
    private FragmentVP mFragmentadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.vp);
        mBottomNavigationView = findViewById(R.id.bottom_nav);
        initData();
        mFragmentadapter = new FragmentVP(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mFragmentadapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        mBottomNavigationView.setSelectedItemId(R.id.menu_weixin);
                        break;
                    case 1:
                        mBottomNavigationView.setSelectedItemId(R.id.menu_tongxun);
                        break;
                    case 2:
                        mBottomNavigationView.setSelectedItemId(R.id.menu_faxian);
                        break;
                    case 3:
                        mBottomNavigationView.setSelectedItemId(R.id.menu_wo);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_weixin) {
                    mViewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.menu_tongxun) {
                    mViewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.menu_faxian) {
                    mViewPager.setCurrentItem(2);
                } else if (item.getItemId() == R.id.menu_wo) {
                    mViewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }

    private void initData() {
        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add(new Fragment1_weixin());
        mFragmentList.add(new Fragment2_tongxun());
        mFragmentList.add(new Fragment3_fax());
        mFragmentList.add(new Fragment4_wo());
    }
}