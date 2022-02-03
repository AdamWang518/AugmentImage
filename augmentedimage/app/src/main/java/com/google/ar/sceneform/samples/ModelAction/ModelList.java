package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.ar.sceneform.samples.augmentedimage.R;

import java.util.ArrayList;

public class ModelList {

    View parentView = null;
    View contentView = null;
    Context context = null;
    String[] department_name = null;
    ListView listView = null;
    public ModelList(Context context ,View view,View contentView){
        this.context = context;
        this.parentView = view;
        this.contentView=contentView;
        listView = view.findViewById(R.id.mList);
        ArrayList<dataModel> list = initList();
        ModelAdapter adapter = new ModelAdapter(context,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);

    }


    private ArrayList<dataModel> initList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告1","教務處"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告2","總務處"));
        return  list;
    }



    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("onItemClick","AAAAAAAA");
            Toast.makeText(context,"ListItem",Toast.LENGTH_SHORT);
            parentView.setVisibility(View.INVISIBLE);
            contentView.setVisibility(View.VISIBLE);
        }
    };


}
