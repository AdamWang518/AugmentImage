package com.google.ar.sceneform.samples.ModelAction;

import com.google.ar.sceneform.samples.augmentedimage.R;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ModelALL {
    View view = null;
    Context context = null;
    at.markushi.ui.CircleButton intro,department,overview;
    ListView list1 = null,list2 = null;
    boolean buttonisclicked;
    public ModelALL(String type,Context context ,View view){
        this.context = context;
        this.view = view;
        buttonisclicked=false;
        intro=this.view.findViewById(R.id.intro);
        overview=this.view.findViewById(R.id.overview);
        department=this.view.findViewById(R.id.department);
        list1=this.view.findViewById(R.id.list);
        list2=this.view.findViewById(R.id.child_list);
        intro.setOnClickListener(buttonlistener);
        department.setOnClickListener(buttonlistener);
        overview.setOnClickListener(buttonlistener);
        list1.setVisibility(View.INVISIBLE);
        list2.setVisibility(View.INVISIBLE);
    }
    private ArrayList<dataModel> introList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告1","測試1"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告2","測試2"));
        return  list;
    }
    private ArrayList<dataModel> overviewList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告3","測試3"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告4","測試4"));
        return  list;
    }
    private ArrayList<dataModel> departmentList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告5","測試5"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","公告6","測試6"));
        return  list;
    }
    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                buttonisclicked=!buttonisclicked;
                switch (view.getId()) {
                    case R.id.intro:
                        if(buttonisclicked)
                        {
                            intro.setColor(0xFFD59B00);
                            department.setColor(0xFF888988);
                            overview.setColor(0xFF888988);
                            list1.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            intro.setColor(0xFF888988);
                            department.setColor(0xFF888988);
                            overview.setColor(0xFF888988);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case R.id.department:

                        if(buttonisclicked)
                        {
                            intro.setColor(0xFF888988);
                            department.setColor(0xFFD59B00);
                            overview.setColor(0xFF888988);
                            list1.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            intro.setColor(0xFF888988);
                            department.setColor(0xFF888988);
                            overview.setColor(0xFF888988);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case R.id.overview:

                        if(buttonisclicked)
                        {
                            intro.setColor(0xFF888988);
                            department.setColor(0xFF888988);
                            overview.setColor(0xFFD59B00);
                            list1.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            intro.setColor(0xFF888988);
                            department.setColor(0xFF888988);
                            overview.setColor(0xFF888988);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                        }
                        break;
                }
        }
    };
}
