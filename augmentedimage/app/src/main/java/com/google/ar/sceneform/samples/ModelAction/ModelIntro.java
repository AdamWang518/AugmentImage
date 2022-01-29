package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.ar.sceneform.samples.augmentedimage.R;

public class ModelIntro {

    View view = null;
    Context context = null;
    TextView content = null;
    String type = "";

    public ModelIntro(String type,Context context ,View view){
        this.context = context;
        this.view = view;
        this.type = type;
        Button charBtn = this.view.findViewById(R.id.char_button);
        Button timeBtn = this.view.findViewById(R.id.time_button);
        Button awardBtn = this.view.findViewById(R.id.award_button);
        charBtn.setOnClickListener(listener);
        timeBtn.setOnClickListener(listener);
        awardBtn.setOnClickListener(listener);
        this.content =  this.view.findViewById(R.id.content);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.char_button:
                    if (type.equals("industry")){
                        content.setText(R.string.cgu_industry_characteristic);
                    } else if(type.equals("manage")) {
                        content.setText(R.string.cgu_manage_characteristic);
                    } else if (type.equals("medical")) {
                        content.setText(R.string.cgu_medical_characteristic);
                    }
                    break;
                case R.id.time_button:
                    if (type.equals("industry")){
                        content.setText(R.string.cgu_industry_time);
                    } else if(type.equals("manage")) {
                        content.setText(R.string.cgu_manage_time);
                    } else if (type.equals("medical")) {
                        content.setText(R.string.cgu_medical_time);
                    }
                    break;
                case R.id.award_button:
                    if (type.equals("industry")){
                        content.setText(R.string.cgu_industry_award);
                    } else if(type.equals("manage")) {
                        content.setText(R.string.cgu_manage_award);
                    } else if (type.equals("medical")) {
                        content.setText(R.string.cgu_medical_award);
                    }
                    break;
            }
        }
    };
}
