package net.hb.test;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class ThreeFragment extends Fragment {
    //    LinearLayout linear;
    Button btn_start;
    Button [] bt = new Button[25];
    int [] btn = {  R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6,R.id.btn_7,R.id.btn_8,R.id.btn_9,R.id.btn_10,
                    R.id.btn_11,R.id.btn_12,R.id.btn_13,R.id.btn_14,R.id.btn_15,R.id.btn_16,R.id.btn_17,R.id.btn_18,R.id.btn_19,R.id.btn_20,
                    R.id.btn_21,R.id.btn_22,R.id.btn_23,R.id.btn_24,R.id.btn_25
                    };
    int totalCount=25, count=0;
    TextView tv_res;
    Chronometer chronometer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_three, container, false);
/*        this.linear=v.findViewById(R.id.linear);
        this.linear.setBackgroundResource(R.drawable.base);*/

        btn_start = v.findViewById(R.id.btn_start);
        for(int i= 0; i< btn.length;i++) {
            bt[i] = v.findViewById(btn[i]);
        }
        tv_res = v.findViewById(R.id.tv_res);
        chronometer = v.findViewById(R.id.chronometer);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.btn_start:
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.start();
                        count=1;
                        for(int i=0;i<btn.length;i++){
                            bt[i].setEnabled(true);
                        }
                        tv_res.setText("");
                        int[] array = new int[btn.length];//난수 받을 배열
                        for (int i = 0; i < btn.length; i++) {
                            array[i] = (int)(Math.random()*25)+1;
                            for (int j = 0; j < i; j++) {
                                if (array[i] == array[j]) {
                                    i--;
                                }//if end
                            }//for end
                        }//for end
                        for (int i = 0; i < btn.length; i++) {
                            bt[i].setText(String.valueOf(array[i]));
                        }
                        break;
                }
                for(int i=0;i<btn.length;i++) {
                    if (v.getId()==btn[i]){
                        int num = Integer.parseInt(String.valueOf(bt[i].getText()));
                        if(num == count){
                            bt[i].setEnabled(false);
                            count++;
                            if(count==(totalCount+1)){
                                chronometer.stop();
                                tv_res.setText(chronometer.getText()+"초 성공");
                            }
                        }
                    }
                }
            }
        };
        btn_start.setOnClickListener(cl);
        for(int i = 0; i<bt.length; i++) {
            bt[i].setOnClickListener(cl);
        }
        return v;
    }// onCreate end

}//class END
