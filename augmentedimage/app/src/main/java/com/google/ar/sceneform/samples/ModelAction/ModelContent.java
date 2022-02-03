package com.google.ar.sceneform.samples.ModelAction;

import com.google.ar.sceneform.samples.augmentedimage.R;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ModelContent {
    View parentView = null;
    View listView = null;
    ListView list = null;
    Context context = null;
    public ModelContent(Context context , View view,View listView){
        this.context = context;
        this.parentView = view;
        this.listView=listView;
        Button button=view.findViewById(R.id.button);
        ImageView imageView= view.findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.close);
        button.setOnClickListener(buttonClickListener);
        list = this.listView.findViewById(R.id.mList);
        list.setOnItemClickListener(itemClickListener);
    }
    public View.OnClickListener buttonClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listView.setVisibility(View.VISIBLE);
            parentView.setVisibility(View.INVISIBLE);
        }
    };
    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("leoList","listItem");
        }
    };
}
