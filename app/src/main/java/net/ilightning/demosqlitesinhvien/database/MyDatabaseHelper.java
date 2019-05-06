package net.ilightning.demosqlitesinhvien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import net.ilightning.demosqlitesinhvien.R;
import net.ilightning.demosqlitesinhvien.model.StudentModel;

import java.util.ArrayList;

/**
 * Created by Admin on 10/5/2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {


    // Phiên bản
    private static final int DATABASE_VERSION = 1;
    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Student_Manager";
    // Tên bảng: Note.
    private static final String TABLE_STUDENT = "table_student";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_OLD = "old";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_NAME_CLASS = "nameClass";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE " + TABLE_STUDENT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_OLD + " INTEGER,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_NAME_CLASS + " TEXT" + ")";
        // Chạy lệnh tạo bảng.
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        // Và tạo lại.
        onCreate(sqLiteDatabase);
    }

    public void addStudent(StudentModel model) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, model.getName());
        values.put(COLUMN_OLD, model.getOld());
        values.put(COLUMN_ADDRESS, model.getAddress());
        values.put(COLUMN_NAME_CLASS, model.getNameClass());
        writableDatabase.insert(TABLE_STUDENT, null, values);
        writableDatabase.close();

        Log.d("HoangTV", "insert thanh cong");
        Log.d("HoangTV", "name    :" + model.getName());
        Log.d("HoangTV", "old     :" + model.getOld());
        Log.d("HoangTV", "address :" + model.getAddress());
        Log.d("HoangTV", "class   :" + model.getNameClass());
    }


    public int updateStudent(int id, StudentModel model) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, model.getName());
        values.put(COLUMN_OLD, model.getOld());
        values.put(COLUMN_ADDRESS, model.getAddress());
        values.put(COLUMN_NAME_CLASS, model.getNameClass());
        return writableDatabase.update(TABLE_STUDENT, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public ArrayList<StudentModel> getAllStudent() {
        ArrayList<StudentModel> studentModels = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT;
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                StudentModel model = new StudentModel();
                model.setId(Integer.parseInt(cursor.getString(0)));
                model.setName(cursor.getString(1));
                model.setOld(Integer.parseInt(cursor.getString(2)));
                model.setAddress(cursor.getString(3));
                model.setNameClass(cursor.getString(4));
                studentModels.add(model);
            } while (cursor.moveToNext());
        }
        return studentModels;
    }
    public void createDataBaseDefault() {
        int count = this.getNotesCount();
//        if (count == 0) {
//            for (int i = 0; i < 50; i++) {
//                StudentModel model = new StudentModel("HoangTV" + i, 10 + i, "HN", "Android");
//                addStudent(model);
//            }
        StudentModel model = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model1 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model2 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model3 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model4 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model5 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model6 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model7 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model8 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model9 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        StudentModel model0 = new StudentModel("Hân", 18,"HaiDuong","12b", R.drawable.ic_launcher_background);
        addStudent(model);
        addStudent(model2);
        addStudent(model3);
        addStudent(model4);
        addStudent(model5);
        addStudent(model6);



        }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

}
