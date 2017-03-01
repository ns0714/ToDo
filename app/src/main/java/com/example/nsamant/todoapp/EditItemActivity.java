package com.example.nsamant.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etEditItem;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        btnSave = (Button) findViewById(R.id.btnSave);

        String oldText = getIntent().getStringExtra("item");
        final int position = getIntent().getIntExtra("position", 0);

        etEditItem.setText(oldText);
        etEditItem.setSelection(etEditItem.getText().length());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newText = etEditItem.getText().toString();
                Intent data = new Intent(EditItemActivity.this, TodoActivity.class);
                data.putExtra("newItem", newText);
                data.putExtra("position", position);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }


}
