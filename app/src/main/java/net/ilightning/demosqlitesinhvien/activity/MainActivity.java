package net.ilightning.demosqlitesinhvien.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.ilightning.demosqlitesinhvien.R;
import net.ilightning.demosqlitesinhvien.database.MyDatabaseHelper;
import net.ilightning.demosqlitesinhvien.model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtId;
    private EditText edtName;
    private EditText edtOld;
    private EditText edtAddress;
    private EditText edtNameClass;

    private Button btnAddSV;
    private Button btnUpdateSV;
    private Button btnDeleteSV;
    private Button btnShowAllSV;

    private ArrayList<StudentModel> studentModels;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        this.studentModels = new ArrayList<>();
        this.myDatabaseHelper = new MyDatabaseHelper(MainActivity.this);

        this.myDatabaseHelper.createDataBaseDefault();
    }

    private void initView() {
        this.edtId = findViewById(R.id.edtId);
        this.edtName = findViewById(R.id.edtName);
        this.edtOld = findViewById(R.id.edtOld);
        this.edtAddress = findViewById(R.id.edtAddress);
        this.edtNameClass = findViewById(R.id.edtNameClass);

        this.btnAddSV = findViewById(R.id.btnAddSV);
        this.btnUpdateSV = findViewById(R.id.btnUpdateSV);
        this.btnDeleteSV = findViewById(R.id.btnDeleteSV);
        this.btnShowAllSV = findViewById(R.id.btnShowAllSV);

        this.btnAddSV.setOnClickListener(this);
        this.btnUpdateSV.setOnClickListener(this);
        this.btnDeleteSV.setOnClickListener(this);
        this.btnShowAllSV.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddSV:
                StudentModel modelAdd = new StudentModel();
                modelAdd.setName(edtName.getText().toString());
                modelAdd.setOld(Integer.parseInt(edtOld.getText().toString()));
                modelAdd.setAddress(edtAddress.getText().toString());
                modelAdd.setNameClass(edtNameClass.getText().toString());
                myDatabaseHelper.addStudent(modelAdd);
                break;

            case R.id.btnUpdateSV:
                StudentModel modelUpdate = new StudentModel();
                modelUpdate.setName(edtName.getText().toString());
                modelUpdate.setOld(Integer.parseInt(edtOld.getText().toString()));
                modelUpdate.setAddress(edtAddress.getText().toString());
                modelUpdate.setNameClass(edtNameClass.getText().toString());
                int id = Integer.parseInt(edtId.getText().toString());
                myDatabaseHelper.updateStudent(id, modelUpdate);
                break;

            case R.id.btnDeleteSV:
                int idDelete = Integer.parseInt(edtId.getText().toString());
                myDatabaseHelper.deleteStudent(idDelete);
                break;

            case R.id.btnShowAllSV:
//
                Intent i  = new Intent(MainActivity.this, ListStudentActivity.class);
                startActivity(i);
                break;
        }
    }
}
