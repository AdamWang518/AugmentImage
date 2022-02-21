package com.google.ar.sceneform.samples.ModelAction;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.google.ar.sceneform.samples.augmentedimage.R;
public class DepartmentButton {
    View view = null,medicalview= null;
    Context context = null;
    Button manage,medical,industry;
    public DepartmentButton( Context context,View medicalview,View view){
        this.context = context;
        this.view = view;
        this.medicalview=medicalview;
        manage=this.view.findViewById(R.id.manage_button);
        medical=this.view.findViewById(R.id.medical_button);
        industry=this.view.findViewById(R.id.industry_button);
        manage.setOnClickListener(buttonlistener);
        medical.setOnClickListener(buttonlistener);
        industry.setOnClickListener(buttonlistener);
        medicalview.setVisibility(View.INVISIBLE);
    }
    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId())
            {
                case R.id.manage_button:
                    manage.setBackgroundColor(0xffD59B00);
                    industry.setBackgroundColor(0xFFC9C9C8);
                    medical.setBackgroundColor(0xFFC9C9C8);
                    medicalview.setVisibility(View.INVISIBLE);

                    break;
                case R.id.industry_button:
                    manage.setBackgroundColor(0xFFC9C9C8);
                    industry.setBackgroundColor(0xffD59B00);
                    medical.setBackgroundColor(0xFFC9C9C8);
                    medicalview.setVisibility(View.INVISIBLE);

                    break;
                case R.id.medical_button:
                    medical.setBackgroundColor(0xffD59B00);
                    industry.setBackgroundColor(0xFFC9C9C8);
                    manage.setBackgroundColor(0xFFC9C9C8);
                    medicalview.setVisibility(View.VISIBLE);

                    break;
            }
        }
    };
}
