package com.sissichen.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {

    private EditText etEditItem;
    private int itemPosition;
    private String originalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        etEditItem = (EditText) findViewById(R.id.etEditItem);
        originalValue = getIntent().getStringExtra("item_value");

        //Place cursor at the end of text
        etEditItem.setText("");
        etEditItem.append(originalValue);
        // Set the default position to be -1 if the data is not available
        itemPosition = getIntent().getIntExtra("item_position", -1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View v) {
        // closes current screen and returns to main list screen
        this.finish();
    }

    public void onSaveChange(View view) {
        String input = etEditItem.getText().toString();

        // No need to update the list if the value is
        if (originalValue.equals(input)) {
            setResult(RESULT_CANCELED);
        } else {
            Intent data = new Intent();
            data.putExtra("new_value", input);
            data.putExtra("current_position", itemPosition);
            setResult(RESULT_OK, data);
        }

        this.finish();
    }
}
