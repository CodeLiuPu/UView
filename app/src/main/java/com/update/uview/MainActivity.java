package com.update.uview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.update.uview.adapter.FmPagerAdapter;
import com.update.uview.layout.flowlayout.FlowLayoutFragment;

import java.util.Arrays;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainActivity extends AppCompatActivity {
    private List<String> titles = Arrays.asList(
            "AAAAA",
            "FlowLayout"
    );

    private List<Fragment> fragments = Arrays.asList(
            new AFragment(),
            new FlowLayoutFragment()
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new FmPagerAdapter<>(titles, fragments, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager, false);
    }
}
