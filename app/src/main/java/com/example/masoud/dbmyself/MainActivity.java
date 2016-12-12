package com.example.masoud.dbmyself;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.masoud.dbmyself.adpter.adapter;
import com.example.masoud.dbmyself.db.DataBaseOperation;
import com.example.masoud.dbmyself.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Person> personList;
    Adapter adapter;


    EditText edname , edfamily , edphonnum;
    Button btncam , btngalery , btnInsert ;
    ImageView imageview ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseOperation dataBaseOperation = new DataBaseOperation(this);

        listView = (ListView) findViewById(R.id.listview);
        personList = new ArrayList<Person>();
        adapter = new adapter(this , R.layout.row_list_view , personList);
        listView.setAdapter((ListAdapter) adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_add_person: {
                showDialog();
                break;
            }
            case R.id.action_close: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog(){

        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        View rootview = View.inflate(this , R.layout.dialog_add_person , null);
        builder.setView(rootview);

        edname = (EditText) rootview.findViewById(R.id.edname);
        edfamily = (EditText) rootview.findViewById(R.id.edfamily);
        edphonnum = (EditText) rootview.findViewById(R.id.edphonenum);
        btncam = (Button) rootview.findViewById(R.id.btncam);
        btngalery = (Button) rootview.findViewById(R.id.btngalery);
        btnInsert = (Button) rootview.findViewById(R.id.btnInsert);
        imageview = (ImageView) rootview.findViewById(R.id.imageView);

        builder.setPositiveButton("add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                String name = edname.getText().toString().trim();
                String family = edfamily.getText().toString().trim();
                String phonenum = edphonnum.getText().toString().trim();

                Person person = new Person(name , family , phonenum);

                person.setName(name);
                person.setFamily(family);
                person.setPhonenum(phonenum);




                myapplication myapplication = new myapplication();
                myapplication.getPersonDBDAO().AddPerson(person);
                personList.add(person);
                adapter.notifyAll();


            }
        });

        builder.setNegativeButton("cancel" , null);
        builder.show();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageview.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageview.setImageURI(selectedImage);
                }
                break;
        }
    }

    public void camera(View view) {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);
    }

    public void gallery(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);
    }
}
