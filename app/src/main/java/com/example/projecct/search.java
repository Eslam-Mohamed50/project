package com.example.projecct;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class search extends AppCompatActivity {
    RecyclerView mrecyclerView;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference mRef;
    ImageButton search_bu;
    EditText search_w;
    Spinner spinner;
    Spinner spinnerDropDownView;
    String text = "";
    String[] spinnerValueHoldValue = {"", "جراحه المخ والاعصاب", "الاورام والطب النووى",
            "جراحه القلب والصدر", "طب جراحه العيون", "امراض القلب",
            "الامراض الصدريه", "جراحه الشرايين", "جراحه العظام",
            "الامراض عصبيه ونفسيه", "التاهيل وامراض الروماتيزم", "الامراض الجلديه",
            "وحده السمعيات", "الجراحه العامه"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinnerDropDownView = (Spinner) findViewById(R.id.spec);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(search.this, android.R.layout.simple_list_item_1, spinnerValueHoldValue);
        spinnerDropDownView.setAdapter(adapter);
        spinnerDropDownView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text = spinnerDropDownView.getSelectedItem().toString();
                //Toast.makeText(search.this, text, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        search_bu = findViewById(R.id.search_b);
        search_w = findViewById(R.id.search_w);
        mrecyclerView = findViewById(R.id.recylerView);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mfirebaseDatabase.getReference("Data");
        mRef.keepSynced(true);
        search_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchtext = search_w.getText().toString();
                firesearch(searchtext);
                firesearch1(searchtext);
                firesearch2(searchtext);
                 firesearch3(searchtext);firesearch4(searchtext);firesearch5(searchtext);firesearch6(searchtext);firesearch7(searchtext);
               firesearch8(searchtext);firesearch9(searchtext);firesearch10(searchtext);firesearch11(searchtext);firesearch12(searchtext);firesearch13(searchtext);
            }
        });
        link();
    }
    public void firesearch(String searchtext) {
        FirebaseDatabase mfirebaseDatabase;
        DatabaseReference mRef;
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mfirebaseDatabase.getReference("Datatotall");
        mRef.keepSynced(true);
        if (text.isEmpty()) {
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff").limitToFirst(20);
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch1(String searchtext) {
        if (text.equals("الجراحه العامه")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data1");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch2(String searchtext) {
        if (text.equals("وحده السمعيات")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data2");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch3(String searchtext) {
        if (text.equals("جراحه المخ والاعصاب")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data3");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch4(String searchtext) {
        if (text.equals("الاورام والطب النووى")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data4");
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch5(String searchtext) {
        if (text.equals("جراحه القلب والصدر")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data5");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch6(String searchtext) {
        if (text.equals("طب جراحه العيون")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data6");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch7(String searchtext) {
        if (text.equals("جراحه الشرايين")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data7");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch8(String searchtext) {
        if (text.equals("الامراض عصبيه ونفسيه")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data8");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch9(String searchtext) {
        if (text.equals("الامراض الصدريه")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data9");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch10(String searchtext) {
        if (text.equals("جراحه العظام")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data10");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch11(String searchtext) {
        if (text.equals("التاهيل وامراض الروماتيزم")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data11");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch12(String searchtext) {
        if (text.equals("امراض القلب")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data12");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void firesearch13(String searchtext) {
        if (text.equals("الامراض الجلديه")) {
            FirebaseDatabase mfirebaseDatabase;
            DatabaseReference mRef;
            mfirebaseDatabase = FirebaseDatabase.getInstance();
            mRef = mfirebaseDatabase.getReference("Data13");
            mRef.keepSynced(true);
            Query fierbasesearchQury = mRef.orderByChild("name").startAt(searchtext).endAt(searchtext+"\uf8ff");
            FirebaseRecyclerAdapter<Users, UserViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Users, UserViewHolder>(
                            Users.class, R.layout.list_layout, UserViewHolder.class, fierbasesearchQury
                    ) {
                        @Override
                        protected void populateViewHolder(UserViewHolder viewHolder, Users model, int position) {
                            viewHolder.setDetails(model.getName(), model.getLocation(), model.getSpecialization(), model.getPhone1(), model.getPhone2(), model.getName_en(), model.getSpecialization_en());
                        }
                    };
            mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        }
    }
    public void link()
    {        Button link = (Button) findViewById(R.id.link);
        link.setMovementMethod(LinkMovementMethod.getInstance());

    }
}




