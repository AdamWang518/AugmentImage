package com.google.ar.sceneform.samples.ModelAction;

import com.google.ar.sceneform.samples.augmentedimage.R;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

public class ModelALL {
    View view = null;
    Context context = null;
    at.markushi.ui.CircleButton intro,overview,department;

    public ModelALL(String type,Context context ,View view){
        this.context = context;
        this.view = view;
        intro=this.view.findViewById(R.id.intro);
        overview=this.view.findViewById(R.id.overview);
        department=this.view.findViewById(R.id.department);
        intro.setOnClickListener(buttonlistener);
        overview.setOnClickListener(buttonlistener);
        department.setOnClickListener(buttonlistener);
    }
    private ArrayList<dataModel> introList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告1","教務處"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告2","總務處"));
        return  list;
    }
    private ArrayList<dataModel> overviewList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告1","教務處"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告2","總務處"));
        return  list;
    }
    private ArrayList<dataModel> departmentList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告1","教務處"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告2","總務處"));
        return  list;
    }
    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.intro:
                        break;
                    case R.id.overview:
                        break;
                    case R.id.department:
                        break;
                }
        }
    };
}
