package net.hb.test;
//ViewPager로 상단 메뉴바만들기
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    public String THIS_FILE ="MainActivity";
    TextView[] tv = new TextView[3];
    ViewPager vp1;
    ViewPagerAdapter vpAdapter;
    Fragment[] fragment = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv[0]=findViewById(R.id.tv1);
        tv[1]=findViewById(R.id.tv2);
        tv[2]=findViewById(R.id.tv3);
        vp1=findViewById(R.id.vp1);

        this.fragment[0]=new FirstFragmentDosirak();
        this.fragment[1]=new SecondFragment();
        this.fragment[2]=new ThreeFragment();

        //여기몰,ㅁ
        vpAdapter=new ViewPagerAdapter(this.getSupportFragmentManager());
        vp1.setAdapter(vpAdapter);

        for(int i = 0;i<3;i++){
            tv[i].setOnClickListener(this);
        }
    }//end

    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv1: vp1.setCurrentItem(0);break;
            case R.id.tv2: vp1.setCurrentItem(1);break;
            case R.id.tv3: vp1.setCurrentItem(2);break;
        }
    }//end

    class ViewPagerAdapter extends FragmentStatePagerAdapter{//manager,adapter 접미사 접두사면 생성자,추상메소드 재정의

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);//348라인
        }//end

        @Override
        public Fragment getItem(int position) {
            return fragment[position];//353라인
        }//end

        @Override
        public int getCount() {
            return fragment.length;//358라인
        }//end
    }//내부클래스
}//class end
