package com.example.dangfiztssi.flicks.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dangfiztssi.flicks.R;
import com.example.dangfiztssi.flicks.presenter.MainActivityPresenter;
import com.example.dangfiztssi.flicks.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rvMain) RecyclerView rvMain;
    @BindView(R.id.swipeRefresh)
    public SwipeRefreshLayout swipeRefreshLayout;

    public Dialog dialog;

    MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dialog = Utils.getWaitingDialog(this);
        dialog.show();

        presenter = new MainActivityPresenter(this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(manager);
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setAdapter(presenter.getAdapter());

        presenter.getData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });
    }
}
