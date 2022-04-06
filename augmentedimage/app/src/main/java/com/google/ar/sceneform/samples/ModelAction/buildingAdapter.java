package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.ar.sceneform.samples.Models.buildingModel;
import com.google.ar.sceneform.samples.augmentedimage.R;

import java.util.ArrayList;

public class buildingAdapter  extends BaseAdapter {
    Context context;
    ArrayList<buildingModel> list;
    private LayoutInflater myInflater;
    public buildingAdapter(Context context, ArrayList<buildingModel> list){
        this.context = context;
        this.list = list;
        myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = myInflater.inflate(R.layout.list_content, null);
        buildingModel buildingModel = list.get(i);
        String building=buildingModel.BuildingName+String.valueOf(buildingModel.Floor);
        TextView title = v.findViewById(R.id.title_item);
        TextView author = v.findViewById(R.id.author_item);
        title.setText(buildingModel.Department);
        author.setText(building);
        return v;
    }
}
