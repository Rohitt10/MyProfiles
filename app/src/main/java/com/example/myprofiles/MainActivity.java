package com.example.myprofiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Profiles> al;
    HashMap<String,String> hm;
    private static MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        al=new ArrayList<>();
        hm=new HashMap<>();
        al.add(new Profiles(R.drawable.codechef,"CodeChef"));
        al.add(new Profiles(R.drawable.gfg,"Geeks for Geeks"));
        al.add(new Profiles(R.drawable.codeforces,"CodeForces"));
        al.add(new Profiles(R.drawable.leetcode,"LeetCode"));
        al.add(new Profiles(R.drawable.hackerrank,"HackerRank"));
        al.add(new Profiles(R.drawable.github,"GitHub"));
        al.add(new Profiles(R.drawable.coding_ninja,"CodingNinja"));
        hm.put("CodeChef","https://www.codechef.com/users/rrohitt");
        hm.put("CodeForces","https://codeforces.com/profile/Therohit");
        hm.put("LeetCode","https://leetcode.com/therohit7/");
        hm.put("GitHub","https://github.com/Rohitt10");
        hm.put("Geeks for Geeks","https://auth.geeksforgeeks.org/user/therohit7/");
        hm.put("CodingNinja","https://www.codingninjas.com/codestudio/profile/b167fbc5-e497-42f9-a6d3-8f4d81671db7");
        hm.put("HackerRank","https://www.hackerrank.com/rrohitt33");
        adapter=new MyAdapter(al,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent j=new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse(hm.get(adapter.getItem(i).name)));
                startActivity(j);
            }
        });

    }

}