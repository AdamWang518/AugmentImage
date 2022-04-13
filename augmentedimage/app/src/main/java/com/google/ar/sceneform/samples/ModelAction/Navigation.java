package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.ar.sceneform.samples.Models.buildingModel;
import com.google.ar.sceneform.samples.augmentedimage.R;
import com.google.ar.sceneform.samples.augmentedimage.ResponseCallBack;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    View view = null;
    Context context = null;
    RequestQueue mQueue =null;
    ListView NavigationList;
    TextView industryTag,medical1Tag,medical2Tag,manageTag;
    private  ArrayList<buildingModel> list;
    public Navigation(Context context , View view,View Industry,View Medical1,View Medical2,View Manage,View Map,ArrayList<buildingModel> buildingList){
        this.context = context;
        this.view = view;
        this.mQueue = Volley.newRequestQueue(context);
        buildingAdapter adapter = new buildingAdapter(context, buildingList);
        NavigationList = view.findViewById(R.id.NavigationList);
        NavigationList.setAdapter(adapter);
        NavigationList.setOnItemClickListener(itemClickListener);
        industryTag=Industry.findViewById(R.id.industry_text);
        medical1Tag=Medical1.findViewById(R.id.medical_one_text);
        medical2Tag=Medical2.findViewById(R.id.medical_two_text);
        manageTag=Manage.findViewById(R.id.manage_text);
        industryTag.setVisibility(View.INVISIBLE);
        medical1Tag.setVisibility(View.INVISIBLE);
        medical2Tag.setVisibility(View.INVISIBLE);
        manageTag.setVisibility(View.INVISIBLE);
    }
    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
            for (int i = 0; i < list.size(); i++) {
                setDefault(NavigationList, i);
            }
            setSelectedItem(view);
            buildingModel model = list.get(j);
            setTag(model);
            Log.d("departmentClick",String.valueOf(model));
            //getOptionStage1("7D8514F0-41BE-4757-9AAE-256C789FDC92");//獲取介紹

        }
    };
    private void setTag(buildingModel model){
        String BuildingName=model.BuildingName;
        String Department=model.Department;
        industryTag.setVisibility(View.INVISIBLE);
        medical1Tag.setVisibility(View.INVISIBLE);
        medical2Tag.setVisibility(View.INVISIBLE);
        manageTag.setVisibility(View.INVISIBLE);
        int Floor=model.Floor;
        switch (BuildingName){
            case"第一醫學大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.VISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                medical1Tag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"第二醫學大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.VISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                medical2Tag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"工學大樓":
                industryTag.setVisibility(View.VISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                industryTag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"管理大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.VISIBLE);
                manageTag.setText(BuildingName+" "+Floor+"樓");
                break;
        }
    }
    private void setSelectedItem(View v){
        if(v!=null) {
            Log.d("setDefault","select");
            TextView title = v.findViewById(R.id.title_item);
            TextView author =v.findViewById(R.id.author_item);
            title.setTextColor(0xFFDBAA33);
            author.setTextColor(0xFFDBAA33);

        }


    }
    private void setDefault(ListView listView,int index){
        View v = listView.getChildAt(index);
        if(v!=null) {
            Log.d("setDefault","default");
            //v.findViewById(R.id.contentItem).setBackgroundColor(0xFFC9C9C8);
            TextView title = v.findViewById(R.id.title_item);
            TextView author =v.findViewById(R.id.author_item);
            LinearLayout img=v.findViewById(R.id.image);
            img.setBackgroundResource(R.drawable.list);
            title.setTextColor(0xFF8FE3FC);
            author.setTextColor(0xFF8FE3FC);
            float mDpi = context.getResources().getDisplayMetrics().densityDpi;
            Log.d("mdpi", String.valueOf(mDpi));
        }

    }
    public void refreshList(ArrayList<buildingModel> list){
        this.list=list;
        buildingAdapter adapter = new buildingAdapter(context, list);
        NavigationList.setAdapter(adapter);
    }

}
