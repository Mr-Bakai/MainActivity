package com.hfad.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_ok;
    Button btn_canceled;
    EditText et_presName;
    TextView tv_presId;
    int id;
     

    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);
        init();
    }

    private void init() {
        et_presName = findViewById(R.id.et_PresidentName);
        tv_presId = findViewById(R.id.tv_presidentidNumber);
        btn_ok = findViewById(R.id.btn_ok);

        presidentList = myApplication.getPresidentList();

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1); //4 : 33  7th video
        President president = null;

        if(id  >= 0 ){
            // edit the president

            for (President p : presidentList) {
                if(p.getId() == id){
                    president = p;
                }
            }

            et_presName.setText(president.getName());
            tv_presId.setText(String.valueOf(id));
        } else {
            // create one
        }


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create president object

                // add the object to the global list of presidents

                // go back to main activity


                if(id >= 0){
                    //update
                    President updatedPresident = new President(id, et_presName.getText().toString());
                    presidentList.set(id, updatedPresident);


                } else {

                    //add new pres
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(nextId, et_presName.getText().toString());

                    presidentList.add(newPresident);
                    myApplication.setNextId(nextId++);
                }

                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}