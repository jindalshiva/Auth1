package com.examples.android.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    Spinner spinnerItems, spinnerPlaces;
    Button buttonAdd;

    CheckBox checkBox;
    DatabaseReference databaseReference;

    ListView listView;

    List<Appliances> applianceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main3);

        spinnerItems = (Spinner) findViewById (R.id.spinner_items);
        spinnerPlaces = (Spinner) findViewById (R.id.spinner_places);
        buttonAdd = (Button) findViewById (R.id.add_button);
        checkBox = (CheckBox) findViewById (R.id.checkbox_On);
        listView = (ListView) findViewById (R.id.listitemAppliances);
        applianceList = new ArrayList<> ();
        databaseReference = FirebaseDatabase.getInstance ().getReference ("applliance");

        buttonAdd.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                appliance();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart ( );
        databaseReference.addValueEventListener (new ValueEventListener ( ) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                applianceList.clear ();
                for (DataSnapshot applianceSnapshot : dataSnapshot.getChildren ()){
                    Appliances appliance = applianceSnapshot.getValue (Appliances.class);
                    applianceList.add (appliance);
                }
                Appliance_List adapter = new Appliance_List (Main3Activity.this, applianceList);
                listView.setAdapter (adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void appliance()
    {
        String items = spinnerItems.getSelectedItem ().toString ().trim ();
        String places = spinnerPlaces.getSelectedItem ().toString ().trim ();
        boolean status = checkBox.isChecked ();
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }



        String id = databaseReference.push ().getKey ();
        Appliances appliances = new Appliances (id,items,places,status);

        databaseReference.child (id).setValue (appliances);

        Toast.makeText (this, "Appliance added",Toast.LENGTH_LONG).show ();
    }
}
