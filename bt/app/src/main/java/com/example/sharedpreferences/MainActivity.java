package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnXacNhan;
    EditText editUser,editPW;
    CheckBox cbox;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        editUser.setText(sharedPreferences.getString("tai khoan", ""));
        editPW.setText((sharedPreferences.getString("mat khau ", "")));
        cbox.setChecked(sharedPreferences.getBoolean("checked",false));
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editUser.getText().toString().trim();
                String pw = editPW.getText().toString().trim();
                if (user.equals("dinhduc")&& pw.equals("12345")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong ",Toast.LENGTH_SHORT).show();
                    if (cbox.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("tai khoan", user);
                        editor.putString("mat khau ", pw);
                        editor.putBoolean("checked", true);
                        editor.commit();

                    }
                    else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("tai khoan");
                        editor.remove("mat khau ");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else  {
                    Toast.makeText(MainActivity.this , "loi dang nhap ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void AnhXa() {
        btnXacNhan= (Button) findViewById(R.id.btn_XacNhan);
        editUser = (EditText) findViewById(R.id.editUser);
        editPW =(EditText) findViewById(R.id.editPW);
        cbox = (CheckBox) findViewById(R.id.cbox);

    }
}