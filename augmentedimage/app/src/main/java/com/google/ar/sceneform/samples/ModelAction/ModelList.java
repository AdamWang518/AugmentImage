package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.ar.sceneform.samples.augmentedimage.R;

public class ModelList {

    View view = null;
    View InfoLayout = null;
    Context context = null;
    String[] department_name = null;
    public ModelList(Context context ,View view,View InfoLayout){
        this.context = context;
        this.view = view;
        this.InfoLayout = InfoLayout;
    }

    public void setListView(String[] department_name){
        this.department_name = department_name;
        ListView list=this.view.findViewById(R.id.listview1);
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this.context, android.R.layout.simple_list_item_1,department_name);
        list.setAdapter(adapter);
        list.setOnItemClickListener(itemClickListener);
    }

    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String name = department_name[i];
            ImageView imageView = InfoLayout.findViewById(R.id.cguimageview);
            switch (name) {
                case "電子":
                    imageView.setImageResource(R.drawable.cgu);
                    break;
                case"電機":
                    imageView.setImageResource(R.drawable.cguee);
                    break;
                case"資工":
                    imageView.setImageResource(R.drawable.cgucs);
                    break;
                case"機械":
                    imageView.setImageResource(R.drawable.cgume);
                    break;
                case"化材":
                    imageView.setImageResource(R.drawable.cgueb);
                    break;
            }
        }
    };


}
