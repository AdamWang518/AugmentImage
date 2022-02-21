package com.google.ar.sceneform.samples.ModelAction;



import com.google.ar.sceneform.samples.augmentedimage.R;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModelALL {
    View view = null;
    Context context = null;
    at.markushi.ui.CircleButton intro,department,overview;
    ListView list1 = null,list2 = null;
    TextView content=null;
    LinearLayout allcontent=null;
    ArrayList<dataModel> introlist = introList();
    ArrayList<dataModel> departmentList = departmentList();
    ArrayList<dataModel> overviewList = overviewList();
    ArrayList<dataModel> childList=childList();
    ArrayList<dataModel> selectedList = null;
    int buttonID=0;
    public ModelALL(String type,Context context ,View view){
        this.context = context;
        this.view = view;
        intro=this.view.findViewById(R.id.intro);
        overview=this.view.findViewById(R.id.overview);
        department=this.view.findViewById(R.id.department);
        list1=this.view.findViewById(R.id.list);
        list2=this.view.findViewById(R.id.child_list);
        content=this.view.findViewById(R.id.content);
        allcontent=this.view.findViewById(R.id.allcontent);
        intro.setOnClickListener(buttonlistener);
        department.setOnClickListener(buttonlistener);
        overview.setOnClickListener(buttonlistener);
        list1.setOnItemClickListener(itemClickListener);
        list2.setOnItemClickListener(list2ClickListener);
        list1.setVisibility(View.INVISIBLE);
        list2.setVisibility(View.INVISIBLE);
        allcontent.setVisibility(View.INVISIBLE);
    }    private ArrayList<dataModel> introList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","發展目標","測試1"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","特色","測試2"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","成立時間","測試3"));
        return  list;
    }

    private ArrayList<dataModel>    childList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","項目1","測試1"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","項目2","測試2"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","項目3","測試3"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","項目4","測試5"));
        return  list;
    }
    private ArrayList<dataModel> departmentList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告","測試1"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","活動","測試2"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","成立時間","測試3"));
        return  list;
    }
    private ArrayList<dataModel> overviewList(){
        ArrayList<dataModel> list = new ArrayList<>();
        list.add(new dataModel("https://miro.medium.com/max/676/1*XEgA1TTwXa5AvAdw40GFow.png","公告","測試1"));
        list.add(new dataModel("https://i.pinimg.com/236x/e2/d0/af/e2d0afea804b250800fa2d7cdb8b5e1b.jpg","活動","測試2"));
        return  list;
    }
    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.intro:
                        if(buttonID==0||buttonID!=intro.getId())
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFD59B00);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentation);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,introlist);
                            list1.setAdapter(adapter);
                            selectedList = introlist;
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==intro.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==intro.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFD59B00);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentation);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,introlist);
                            list1.setAdapter(adapter);
                            selectedList = introlist;
                        }
                        break;
                    case R.id.department:
                        if(buttonID==0||buttonID!=department.getId())
                        {
                            buttonID=department.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFD59B00);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.department);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,departmentList);
                            list1.setAdapter(adapter);
                            selectedList = departmentList;
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==department.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==department.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFD59B00);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.department);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,departmentList);
                            list1.setAdapter(adapter);
                            selectedList = departmentList;
                        }
                        break;
                    case R.id.overview:
                        if(buttonID==0||buttonID!=overview.getId())
                        {
                            buttonID=overview.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFD59B00);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overview);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,overviewList);
                            list1.setAdapter(adapter);
                            selectedList = overviewList;
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==overview.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==overview.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFD59B00);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overview);
                            list1.setVisibility(View.VISIBLE);
                            ModelAdapter adapter = new ModelAdapter(context,overviewList);
                            list1.setAdapter(adapter);
                            selectedList = overviewList;
                        }
                        break;
                }
        }
    };
    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
            for (int i=0;i<selectedList.size();i++) {
                View v = list1.getChildAt(i);
                v.findViewById(R.id.contentItem).setBackgroundColor(0xFFC9C9C8);
                TextView title = v.findViewById(R.id.title_item);
                TextView author =v.findViewById(R.id.author_item);
                title.setTextColor(0xFF888988);
                author.setTextColor(0xFF888988);
            }
            list1.getChildAt(j).findViewById(R.id.contentItem).setBackgroundColor(0xFFD59B00);
            TextView title = list1.getChildAt(j).findViewById(R.id.title_item);
            TextView author =list1.getChildAt(j).findViewById(R.id.author_item);
            title.setTextColor(0xFFFFFFFF);
            author.setTextColor(0xFFFFFFFF);
            ModelAdapter adapter = new ModelAdapter(context,childList);
            list2.setAdapter(adapter);
            list2.setVisibility(View.VISIBLE);
        }
    };
    public AdapterView.OnItemClickListener list2ClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            for (int j=0;j<childList.size();j++) {
                View v = list2.getChildAt(j);
                v.findViewById(R.id.contentItem).setBackgroundColor(0xFFC9C9C8);
                TextView title = v.findViewById(R.id.title_item);
                TextView author =v.findViewById(R.id.author_item);
                title.setTextColor(0xFF888988);
                author.setTextColor(0xFF888988);
            }
            list2.getChildAt(i).findViewById(R.id.contentItem).setBackgroundColor(0xFFD59B00);
            TextView title = list2.getChildAt(i).findViewById(R.id.title_item);
            TextView author =list2.getChildAt(i).findViewById(R.id.author_item);
            title.setTextColor(0xFFFFFFFF);
            author.setTextColor(0xFFFFFFFF);
            String text="";
            switch (title.getText().toString())
            {
                case "項目1":
                    text = context.getResources().getString(R.string.cgu_industry_characteristic).toString();
                    Log.d("content",text);
                    content.setText(text);
                    content.setTextColor(0xffffffff);
                    allcontent.setVisibility(View.VISIBLE);
                    break;
                case "項目2":
                    text = context.getResources().getString(R.string.cgu_manage_characteristic).toString();
                    Log.d("content",text);
                    content.setText(text);
                    content.setTextColor(0xffffffff);
                    allcontent.setVisibility(View.VISIBLE);
                    break;
                case "項目3":
                    text = context.getResources().getString(R.string.cgu_medical_characteristic).toString();
                    Log.d("content",text);
                    content.setText(text);
                    content.setTextColor(0xffffffff);
                    allcontent.setVisibility(View.VISIBLE);
                    break;
                case "項目4":
                    text = context.getResources().getString(R.string.cgu_medical_time).toString();
                    Log.d("content",text);
                    content.setText(text);
                    content.setTextColor(0xffffffff);
                    allcontent.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
