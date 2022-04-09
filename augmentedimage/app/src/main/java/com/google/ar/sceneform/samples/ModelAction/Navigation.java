package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.ar.sceneform.samples.Models.buildingModel;
import com.google.ar.sceneform.samples.augmentedimage.R;
import java.util.ArrayList;
import java.util.List;

public class Navigation {

    View view = null;
    Context context = null;
    RequestQueue mQueue =null;
    ListView NavigationList;
    ArrayList<buildingModel> department = new ArrayList<buildingModel>();
    public Navigation(Context context , View view,View industry,View Medical1,View Medical2,View Manage,View Map){
        this.context = context;
        this.view = view;
        this.mQueue = Volley.newRequestQueue(context);
        department.add(new buildingModel(3,4,"資工系","管理大樓"));
        department.add(new buildingModel(3,4,"電機系","管理大樓"));
        department.add(new buildingModel(3,4,"機械系","管理大樓"));
        buildingAdapter adapter = new buildingAdapter(context, department);
        ListView listView = view.findViewById(R.id.NavigationList);
        listView.setAdapter(adapter);
    }

}
