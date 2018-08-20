package net.hb.test;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstFragmentDosirak extends Fragment {
    ArrayList<Dosirak> al = new ArrayList<Dosirak>();
    String content[] = {"깔끔한 맛의 궁중한정식","국내산 갈비로 구성된 도시락","명이나물과 오리의 조합",
                        "제주도의 특산물로 이루어진 도시락","불고기로 구성된 조합"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v =inflater.inflate(R.layout.fragment_first,container,false);

        al.add(new Dosirak(R.drawable.do_1,"궁중한정식 도시락",false,"12000","2018.08.12"));
        al.add(new Dosirak(R.drawable.do_2,"명품갈비구이 도시락",false,"8000","2018.08.05"));
        al.add(new Dosirak(R.drawable.do_3,"명이오리구이쌈 도시락",true,"15000","2018.08.10"));
        al.add(new Dosirak(R.drawable.do_4,"제주별식 도시락",true,"11000","2018.08.03"));
        al.add(new Dosirak(R.drawable.do_5,"일품불고기 도시락",false,"8000","2018.08.12"));

        //adapter
        final KakaoAdapter adapter = new KakaoAdapter(
                getContext(),//현재화면의 제어권자
                R.layout.kakao,//한행을 그려줄 layout
                al//다량의 데이터
        );
        ListView iv = v.findViewById(R.id.listView1);
        iv.setAdapter(adapter);

        //리스트뷰는 itemp클릭리스너, item클릭이벤트 처리
        iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                Log.d("LG","아이템클릭, position: "+position+" id: "+id);

                Dosirak dd = (Dosirak)adapter.getItem(position);
                int m = dd.img;
                String aa = dd.name;

                View dlg = View.inflate(getContext(),R.layout.display,null);
                ImageView poster = dlg.findViewById(R.id.ivPoster);
                poster.setImageResource(m);
                Log.d("al","position="+m);

                AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
                ab.setTitle(aa);
                ab.setIcon(R.drawable.bonlogo);
                ab.setMessage(content[position]);
                ab.setView(dlg);
                ab.setNegativeButton("close",null);
                ab.show();
            }//onItemClick end
        });//iv.setOnItemClickListener end
    return v;
    }//onCreate end
 }//MainActivity end

class KakaoAdapter extends BaseAdapter{
    Context context;//현재화면의 제어권자
    int layout;//한행을 그려줄 layout
    ArrayList<Dosirak> al;
    LayoutInflater inf;//화면을 그려줄 때 필요

    public KakaoAdapter(Context context, int layout,ArrayList<Dosirak> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        this.inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {//총 데이터의 개수를 리턴
        return al.size();
    }

    @Override
    public Object getItem(int position) {//해당번째 데이터 값
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {//해당번째 고유한 id 값
        return position;
    }

    @Override
    //해당번째의 행에 내용을 셋팅(데이터와 레이아웃의 연결관계 정의)
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inf.inflate(layout, null);
        }
            ImageView iv = convertView.findViewById(R.id.imageView1);
            TextView tvName = convertView.findViewById(R.id.tvName);
            TextView tvSex = convertView.findViewById(R.id.tvOrigin);
            TextView tvWorld = convertView.findViewById(R.id.tvWorld);
            TextView tvBirthday = convertView.findViewById(R.id.tvShelfLife);

        Dosirak m = al.get(position);

            iv.setImageResource(m.img);
            tvName.setText(m.name);
            tvSex.setText(m.isDomestic ? "매움" : "안매움");
            tvWorld.setText("가격:"+m.tvWorld);
            tvBirthday.setText("유통기한:"+m.tvShelfLife);

        return convertView;
    }//end
}//KakaoAdapter end

class Dosirak{//자바 빈
    int img;
    String name="";
    boolean isDomestic;
    String tvWorld="";
    String tvShelfLife="";

    //생성자가 있으면 객체 생성시 편리하다
    public Dosirak(int img, String name, boolean isDomestic, String tvWorld,String tvShelfLife) {

        this.img = img;
        this.name = name;
        this.isDomestic = isDomestic;
        this.tvWorld = tvWorld;
        this.tvShelfLife = tvShelfLife;
    }
    public Dosirak(){}//기존 코드와 호환을 위해서 생성자 작업시 기본 생성자도 추가
}