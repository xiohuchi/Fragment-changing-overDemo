package com.frag.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frag.app.fragment.FragChat;
import com.frag.app.fragment.FragMe;
import com.frag.app.fragment.FrgTab;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.frameLayout)
    LinearLayout frameLayout;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.llay_home)
    LinearLayout llayHome;
    @BindView(R.id.iv_chat)
    ImageView ivChat;
    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.llay_chat)
    LinearLayout llayChat;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.llay_me)
    LinearLayout llayMe;

    @BindColor(R.color.greytab)
    int greytabColor;
    @BindColor(R.color.colorPrimary)
    int colorPrimaryColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        onClick(llayHome);//默认显示第一个
    }

    @OnClick({R.id.llay_home, R.id.llay_chat, R.id.llay_me})
    public void onClick(View view) {
        reInitTabView();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        FrgTab frgTab = (FrgTab) fm.findFragmentByTag(FrgTab.class.getName());
        FragChat fragChat = (FragChat) fm.findFragmentByTag(FragChat.class.getName());
        FragMe fragMe = (FragMe) fm.findFragmentByTag(FragMe.class.getName());

        if (frgTab != null) ft.hide(frgTab);
        if (fragChat != null) ft.hide(fragChat);
        if (fragMe != null) ft.hide(fragMe);
        switch (view.getId()) {
            case R.id.llay_home:
                tvHome.setTextColor(colorPrimaryColor);
                ivHome.setImageResource(R.mipmap.tablehome_pre);
                if (frgTab == null) {
                    frgTab = FrgTab.newInstance("home");
                    ft.add(R.id.frameLayout, frgTab, FrgTab.class.getName());
                }
                ft.show(frgTab);
                break;
            case R.id.llay_chat:
                ivChat.setImageResource(R.mipmap.tablechat_pre);
                tvChat.setTextColor(colorPrimaryColor);
                if (fragChat == null) {
                    fragChat = FragChat.newInstance("chat");
                    ft.add(R.id.frameLayout, fragChat, FragChat.class.getName());
                }
                ft.show(fragChat);
                break;
            case R.id.llay_me:
                ivMe.setImageResource(R.mipmap.tableme_pre);
                tvMe.setTextColor(colorPrimaryColor);
                if (fragMe == null) {
                    fragMe = FragMe.newInstance("me");
                    ft.add(R.id.frameLayout, fragMe, FragMe.class.getName());
                }
                ft.show(fragMe);
                break;
            default:
                break;
        }
        ft.commit();
    }

    /**
     * 刷新底部切换状态
     */
    private void reInitTabView() {
        ivHome.setImageResource(R.mipmap.tablehome_nor);
        ivChat.setImageResource(R.mipmap.tablechat_nor);
        ivMe.setImageResource(R.mipmap.tableme_nor);

        tvHome.setTextColor(greytabColor);
        tvChat.setTextColor(greytabColor);
        tvMe.setTextColor(greytabColor);
    }
}
