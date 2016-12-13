package com.chippy.letsandroid.reportcardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ReportCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_card);ArrayList<Data> datas = new ArrayList<Data>();
        datas.add(new Data("abhishek","A","PASS"));
        datas.add(new Data("swati","A","PASS"));
        datas.add(new Data("jain","A","PASS"));
        datas.add(new Data("sudhir","A","PASS"));
        datas.add(new Data("archana","A","PASS"));
        datas.add(new Data("himanshu","A","PASS"));
        datas.add(new Data("akansha","A","PASS"));

        DataAdapter  adapter =new DataAdapter(this,datas);
        ListView lv= (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }

    public class Data{
        private String mName;
        private String mGrade;
        private String mStatus;

        public Data(String name,String grade,String status){
            mName = name;
            mGrade = grade;
            mStatus = status;
        }
        public String getName(){
            return mName.toString();
        }
        public String getGrade(){
            return mGrade.toString();
        }
        public String getStatus(){
            return mStatus.toString();
        }
    }

    public class  DataAdapter extends ArrayAdapter<Data>{

        public DataAdapter(Activity context, ArrayList<Data> datas) {
            super(context, 0, datas);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.activity_report_card, parent, false);
            }

            Data currentData = getItem(position);

            TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
            nameTextView.setText(currentData.getName());

            TextView gradeTextView = (TextView) listItemView.findViewById(R.id.grade);
            gradeTextView.setText(currentData.getGrade());

            TextView statusTextView = (TextView) listItemView.findViewById(R.id.status);
            statusTextView.setText(currentData.getStatus());
            return listItemView;
        }

    }

}