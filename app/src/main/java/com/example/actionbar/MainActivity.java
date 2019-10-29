package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    String[] country;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Country Names");

        // Adding image on Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        listView = findViewById(R.id.listView_id);
        country = getResources().getStringArray(R.array.country);

        arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.sample_view, R.id.textView_id, country);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, WelcomePage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);

        MenuItem menuItem = menu.findItem(R.id.search_id);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.setting_id){
            Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.share_id){
            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.feedback_id){
            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.aboutus_id){
            Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
