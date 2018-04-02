package com.example.rylynn.mywechat;

import android.support.v4.app.Fragment;
import android.app.FragmentContainer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class TabBarActivity extends FragmentActivity implements View.OnClickListener {
    Class[] cls = new Class[]{ChatsFragment.class, ContactsFragment.class, DiscoverFragment.class, MeFragment.class};

    ChatsFragment firstFrag;
    ContactsFragment secondFrag;
    DiscoverFragment thirdFrag;
    MeFragment fourthFrag;

    Fragment[] frags;

    Button firstBtn;
    Button secondBtn;
    Button thirdBtn;
    Button fourthBtn;

    Button[] itemBtns;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);

        initView();

        fragmentManager = getSupportFragmentManager();          // 开启一个事物

        // 默认加载某一个tabbarItem（第一个按钮）
        setItemSelected(0);
        ChatsFragment firstFrag = new ChatsFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.content, firstFrag).commit();
    }

    private void initView() {
        firstBtn = findViewById(R.id.chatsBtn);
        secondBtn = findViewById(R.id.contactsBtn);
        thirdBtn = findViewById(R.id.discoverBtn);
        fourthBtn = findViewById(R.id.meBtn);

        firstBtn.setOnClickListener(this);
        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
        fourthBtn.setOnClickListener(this);

        itemBtns = new Button[]{firstBtn, secondBtn, thirdBtn, fourthBtn};
        frags = new Fragment[]{null, null, null, null};
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chatsBtn:
                setItemSelected(0);
                break;
            case R.id.contactsBtn:
                setItemSelected(1);
                break;
            case R.id.discoverBtn:
                setItemSelected(2);
                break;
            case R.id.meBtn:
                setItemSelected(3);
                break;
            default:
                break;
        }
    }

    private void setItemSelected(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        int[] list = {0, 1, 2, 3};
        for (int i : list) {
            Fragment frag = frags[i];
            if (i == index) {
                itemBtns[i].setSelected(true);
                if (frag != null) {
                    transaction.show(frag).commit();
                } else {
                    try {
                        frag = (Fragment) cls[i].newInstance();
                        transaction.add(R.id.content,frag).commit();
                        frags[i] = frag;
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                itemBtns[i].setSelected(false);
                if (frag != null) {
                    transaction.hide(frag);
                }
            }
        }
    }

}
