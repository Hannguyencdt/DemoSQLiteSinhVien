package net.ilightning.demosqlitesinhvien.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import net.ilightning.demosqlitesinhvien.R;
import net.ilightning.demosqlitesinhvien.StudenAdapter;
import net.ilightning.demosqlitesinhvien.database.MyDatabaseHelper;
import net.ilightning.demosqlitesinhvien.model.StudentModel;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {
    private RecyclerView rcStudent;
    private MyDatabaseHelper myDatabaseHelper;
    private ArrayList<StudentModel> studentModel;
    private StudenAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        rcStudent = findViewById(R.id.rcStudent);

        myDatabaseHelper = new MyDatabaseHelper(ListStudentActivity.this);

//        studentModel = myDatabaseHelper.getAllStudent();
        studentModel = new ArrayList<>();

        adapter = new StudenAdapter(this, studentModel);
        rcStudent.setLayoutManager(new LinearLayoutManager(ListStudentActivity.this));
        rcStudent.setAdapter(adapter);

        LoadDataBase loadDataBase = new LoadDataBase();
        loadDataBase.execute();
    }
    private static ProgressDialog progress;

    public void showProgressBar() {
        if (progress != null && progress.isShowing()) return;
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setIndeterminate(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }

    public void hideProgressBar() {
        if (progress != null)
            progress.dismiss();
    }


    private class LoadDataBase extends AsyncTask<Void, Integer, ArrayList<StudentModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressBar();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<StudentModel> doInBackground(Void... voids) {
            ArrayList<StudentModel> studentModels = myDatabaseHelper.getAllStudent();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return studentModels;
        }

        @Override
        protected void onPostExecute(ArrayList<StudentModel> studentModels) {
            super.onPostExecute(studentModels);
            for (StudentModel model : studentModels) {
                Log.d("HoangTV", model.getName());

            }
            adapter.sinhVien(studentModels);
            hideProgressBar();
        }
    }
}
