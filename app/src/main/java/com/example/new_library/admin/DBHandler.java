package com.example.new_library.admin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "Library";

    // below int is our database version
    private static final int DB_VERSION = 2;

    // below variable is for our table name.
    private final Context context;
    private SQLiteDatabase db;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }


    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        db.execSQL("CREATE TABLE Publisher(" +
                "pub_name TEXT PRIMARY KEY ," +
                "pub_address TEXT," +
                "pub_phone TEXT);");

        db.execSQL("CREATE TABLE Branch(" +
                "branch_id TEXT PRIMARY KEY," +
                "branch_name TEXT," +
                "branch_address TEXT);");

        db.execSQL("CREATE TABLE Author(" +
                "author_id INTEGER PRIMARY KEY," +
                "author_name TEXT);");


        db.execSQL("CREATE TABLE Member(" +
                "card_no TEXT PRIMARY KEY," +
                "mem_name TEXT," +
                "mem_address TEXT," +
                "mem_phone TEXT," +
                "unpaid_dues NUMBER(5,2));");


        db.execSQL("CREATE TABLE Book("+
                "book_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "book_title TEXT," +
                "book_authorid INTEGER,"+
                "book_desc TEXT ,"+
                "book_publisher TEXT," +
                "FOREIGN KEY(book_publisher) REFERENCES Publisher(pub_name),"+
                "FOREIGN KEY(book_authorid) REFERENCES Author(author_id));");


        db.execSQL("CREATE TABLE Book_Copy(" +
                "book_id INTEGER," +
                "branch_id TEXT ," +
                "access_number TEXT PRIMARY KEY," +
                "FOREIGN KEY(book_id) REFERENCES Book(book_id)," +
                "FOREIGN KEY(branch_id) REFERENCES Branch(branch_id));");

        db.execSQL("CREATE TABLE Book_Loan(" +
                "access_number TEXT," +
                "branch_id TEXT," +
                "card_no TEXT," +
                "date_out DATE," +
                "date_due DATE," +
                "date_returned DATE," +
                "PRIMARY KEY(access_number, branch_id, card_no, date_out)," +
                "FOREIGN KEY(access_number) REFERENCES Book_Copy(book_id)," +
                "FOREIGN KEY(card_no) REFERENCES Member(card_no)," +
                "FOREIGN KEY(branch_id) REFERENCES Branch(branch_id));");
    }

    // this method is use to add new course to our sqlite database.

    public void addNewMember(String card_no, String name, String address, String phone, Double dues) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("card_no",card_no);
        values.put("mem_name", name);
        values.put("mem_address", address);
        values.put("mem_phone", phone);
        values.put("unpaid_dues", dues);

        // after adding all values we are passing
        // content values to our table.
        db.insert("Member", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }

    public void addNewAuthor(int id, String name) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("author_id",id);
        values.put("author_name", name);

        // after adding all values we are passing
        // content values to our table.
        db.insert("Author", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }

    public void addNewPublisher( String name, String address, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("pub_name", name);
        values.put("pub_address", address);
        values.put("pub_phone", phone);


        // after adding all values we are passing
        // content values to our table.
        db.insert("Publisher", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }

    public void addNewBook(int id, String title, String desc, String publisher, int author) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("book_id",id);
        values.put("book_title", title);
        values.put("book_authorid", author);
        values.put("book_desc", desc);
        values.put("book_publisher", publisher);

        // after adding all values we are passing
        // content values to our table.
        db.insert("Book", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    public void addNewBranch(String id, String name, String addr) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("branch",id);
        values.put("branch_name", name);
        values.put("branch_address", addr);

        // after adding all values we are passing
        // content values to our table.
        db.insert("Branch", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    public void addNewCopies(int bookid, String branchid, String acc_no) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("book_id",bookid);
        values.put("branch_id", branchid);
        values.put("access_number", acc_no);

        // after adding all values we are passing
        // content values to our table.
        db.insert("Book_Copy", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }


        public boolean LoginUser(String cno) {
            SQLiteDatabase myDB =this.getWritableDatabase();
            Cursor cursor = myDB.rawQuery("select * from Member where card_no = ?",new String[]{cno});
            if(cursor.getCount() > 0){
                return true;
            }
            else{
                return false;
            }
        }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS Book_Loan;");
        db.execSQL("DROP TABLE IF EXISTS Book_Copy;");
        db.execSQL("DROP TABLE IF EXISTS Author;");
        db.execSQL("DROP TABLE IF EXISTS Member;");
        db.execSQL("DROP TABLE IF EXISTS Branch;");
        db.execSQL("DROP TABLE IF EXISTS Publisher;");
        db.execSQL("DROP TABLE IF EXISTS Book;");
        onCreate(db);
    }

}