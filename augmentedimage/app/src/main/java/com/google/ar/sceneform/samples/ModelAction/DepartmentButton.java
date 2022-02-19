package com.google.ar.sceneform.samples.ModelAction;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.google.ar.sceneform.samples.augmentedimage.R;
public class DepartmentButton {
    View view = null,manageview= null,medicalview= null,Industryview = null;
    Context context = null;
    Button manage,medical,industry;
    public DepartmentButton( Context context ,View manageview,View medicalview,View Industryview ,View view){
        this.context = context;
        this.view = view;
        this.manageview=manageview;
        this.medicalview=medicalview;
        this.Industryview=Industryview;
        manage=this.view.findViewById(R.id.manage_button);
        medical=this.view.findViewById(R.id.medical_button);
        industry=this.view.findViewById(R.id.industry_button);
        manage.setOnClickListener(buttonlistener);
        medical.setOnClickListener(buttonlistener);
        industry.setOnClickListener(buttonlistener);
        manageview.setVisibility(View.INVISIBLE);
        medicalview.setVisibility(View.INVISIBLE);
        Industryview.setVisibility(View.INVISIBLE);
    }
    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.manage_button:
                    manageview.setVisibility(View.VISIBLE);
                    medicalview.setVisibility(View.INVISIBLE);
                    Industryview.setVisibility(View.INVISIBLE);
                    break;
                case R.id.industry_button:
                    manageview.setVisibility(View.INVISIBLE);
                    medicalview.setVisibility(View.INVISIBLE);
                    Industryview.setVisibility(View.VISIBLE);
                    break;
                case R.id.medical_button:
                    manageview.setVisibility(View.INVISIBLE);
                    medicalview.setVisibility(View.VISIBLE);
                    Industryview.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };
}
