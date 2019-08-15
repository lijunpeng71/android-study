package com.cyinfo.android.study;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {


    @BindView(R.id.true_button)
    public Button trueButton;

    @BindView(R.id.false_button)
    public Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        trueButton.setOnClickListener((view) ->
                Toast.makeText(MainActivity.this, "点击确定按钮", Toast.LENGTH_SHORT).show());
    }
}
