package com.materialuiux.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.materialuiux.databindingexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Ad_Recycler_View adapter = new Ad_Recycler_View(getDummyData(), this);
        binding.recyclerview.setAdapter(adapter);

    }

    private List<Post> getDummyData() {
        List<Post> list = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++){
            list.add(new Post("title " + i, "body " + i));
        }
        return list;
    }
}
