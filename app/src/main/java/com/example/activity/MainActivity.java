package com.example.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Toast toast = null;
    private static TextView textView = null;
    private boolean isShowToast = false;

    public void showToast(String str) {
        textView.setText(str);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,32);
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        toast.show();
        isShowToast = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = new Toast(this);
        textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(textView);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        AlertDialog alertDialog = new AlertDialog.Builder(this)
//                .setTitle("onStart")
//                .setMessage("onStart")
//                .setIcon(R.mipmap.ic_launcher)
//                .create();
//        alertDialog.show();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        showToast("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        showToast("onPause");
    }

    @Override
    protected  void onRestart() {
        super.onRestart();
        showToast("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        showToast("onDestory");
        if(isShowToast == true) {
            toast.cancel();
        }
    }
}