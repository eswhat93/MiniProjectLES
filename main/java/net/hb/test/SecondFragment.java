package net.hb.test;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondFragment extends Fragment {
    Button btn_reset,btn_plus,btn_minus,btn_pluss,btn_minuss;
    TextView textView;
    TextView busNumer;
    String getData;
    int busNumber = 0;
    int busNum = 503;
    String strSrch = busNumber + "";
    int count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v =inflater.inflate(R.layout.fragment_second,container,false);

        textView = v.findViewById(R.id.data);
        busNumer = v.findViewById(R.id.bus);

        btn_reset = v.findViewById(R.id.btn_reset);
        btn_plus = v.findViewById(R.id.btn_plus);
        btn_minus = v.findViewById(R.id.btn_minus);
        btn_pluss = v.findViewById(R.id.btn_pluss);
        btn_minuss = v.findViewById(R.id.btn_minuss);

        //     String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";

        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";

        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;

        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);

        //onCreatView 안에 onClick 꼭 담아야함 밖에다 쓰면 에러
        //뷰안에 버튼의 처리만 담음-->아래에 이벤트처리 따로 또 해줘야함
        //버튼 하나씩 정의할때 이벤트처리, 버튼 내용 다 담을 수 있음
        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_reset:
                        //  busNum+=1;
                        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
                        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
                        strSrch = busNum + "";

                        //가져올 정보를 strUrl에 저장함
                        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;

                        DownloadWebContent dwc = new DownloadWebContent();
                        dwc.execute(strUrl);
                        textView.setText("");
                        busNumer.setText("");
                        busNumer.append("버스번호:");
                        busNumer.append(strSrch + "\n");
                        break;

                    case R.id.btn_plus:
                        busNum += 1;

                        String serviceUrl1 = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
                        String serviceKey1 = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
                        strSrch = busNum + "";

                        //가져올 정보를 strUrl에 저장함
                        String strUrl1 = serviceUrl1 + "?ServiceKey=" + serviceKey1 + "&strSrch=" + strSrch;
//
                        DownloadWebContent dwc1 = new DownloadWebContent();
                        dwc1.execute(strUrl1);
                        textView.setText("");
                        busNumer.setText("");
                        busNumer.append("버스번호:");
                        busNumer.append(strSrch + "\n");
                        break;

                    case R.id.btn_minus:
                        busNum -= 1;

                        String serviceUrl2 = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
                        String serviceKey2 = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
                        strSrch = busNum + "";

                        //가져올 정보를 strUrl에 저장함
                        String strUrl2 = serviceUrl2 + "?ServiceKey=" + serviceKey2 + "&strSrch=" + strSrch;
//
                        DownloadWebContent dwc2 = new DownloadWebContent();
                        dwc2.execute(strUrl2);
                        textView.setText("");
                        busNumer.setText("");
                        busNumer.append("버스번호:");
                        busNumer.append(strSrch + "\n");
                        break;

                    case R.id.btn_pluss:
                        busNum += 100;
                        String serviceUrl3 = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
                        String serviceKey3 = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
                        strSrch = busNum + "";

                        //가져올 정보를 strUrl에 저장함
                        String strUrl3 = serviceUrl3 + "?ServiceKey=" + serviceKey3 + "&strSrch=" + strSrch;

                        DownloadWebContent dwc3 = new DownloadWebContent();
                        dwc3.execute(strUrl3);
                        textView.setText("");
                        busNumer.setText("");
                        busNumer.append("버스번호:");
                        busNumer.append(strSrch + "\n");
                        break;

                    case R.id.btn_minuss:
                        busNum -= 100;
                        String serviceUrl4 = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
                        String serviceKey4 = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
                        strSrch = busNum + "";

                        //가져올 정보를 strUrl에 저장함
                        String strUrl4 = serviceUrl4 + "?ServiceKey=" + serviceKey4 + "&strSrch=" + strSrch;

                        DownloadWebContent dwc4 = new DownloadWebContent();
                        dwc4.execute(strUrl4);
                        textView.setText("");
                        busNumer.setText("");
                        busNumer.append("버스번호:");
                        busNumer.append(strSrch + "\n");
                        break;
                }
            }
        };

        btn_reset.setOnClickListener(cl);
        btn_minus.setOnClickListener(cl);
        btn_plus.setOnClickListener(cl);
        btn_minuss.setOnClickListener(cl);
        btn_pluss.setOnClickListener(cl);

    return v;
    }

    public class DownloadWebContent extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadByUrl(urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        protected void onPostExecute(String result) {
            //xml 문서를 파싱하는 방법으로 본 예제에서는  Pull Parer 를 사용한다.
            String headerCd = "";
            String busRouteId = "";

            boolean bus_headerCd = false;
            boolean bus_busRouteId = false;

            // textView.append("===== 노선ID =====\n");
            try {

                //XmlPullParser 를 사용하기 위해서 XmlPullParserFactory 객체를 생성함
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xmlpp = factory.newPullParser();

                //parser 에 url를 입력함
                xmlpp.setInput(new StringReader(result));


                //parser 이벤트를 저장할 변수 지정
                int eventType = xmlpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {   //문서가 마지막이 아니면
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                        ;
                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xmlpp.getName();
                        if (tag_name.equals("headerCd"))
                            bus_headerCd = true;
                        if (tag_name.equals("busRouteId"))
                            bus_busRouteId = true;

                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bus_headerCd) {
                            headerCd = xmlpp.getText();
                            bus_headerCd = false;
                        }

                        if (headerCd.equals("0")) {
                            if (bus_busRouteId) {
                                busRouteId = xmlpp.getText();
                                bus_busRouteId = false;
                            }

                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        ;
                    }
                    eventType = xmlpp.next();
                }
            } catch (Exception e) {
                textView.setText(e.getMessage());
            }

            String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute";

            String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
            String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&busRouteId=" + busRouteId;

            DownloadWebContent2 dwc2 = new DownloadWebContent2();
            dwc2.execute(strUrl);
        }

        public String downloadByUrl(String myurl) throws IOException {
            //Http 통신: HttpURLConnection 클래스를 활용해 데이터를 얻는다.

            HttpURLConnection conn = null;
            try {
                //요청 URL, 전달받은 url string 으로 URL 객체를 만듦
                URL url = new URL(myurl);
                conn = (HttpURLConnection) url.openConnection();

                BufferedInputStream buffer = new BufferedInputStream(conn.getInputStream());

                BufferedReader buffer_reader = new BufferedReader(new InputStreamReader(buffer, "utf-8"));

                String line = null;
                getData = "";
                while ((line = buffer_reader.readLine()) != null) {
                    getData += line;

                }
                return getData;
            } finally {
                //접속 해제
                conn.disconnect();
            }
        }

    }

    public class DownloadWebContent2 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String) downloadByUrl((String) urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        protected void onPostExecute(String result) {
            String headerCd = "";
            String gpsX = "";
            String gpsY = "";
            String stationNm = "";
            String direction = "";
            String sectSpd = "";

            boolean bus_headerCd = false;
            boolean bus_gpsX = false;
            boolean bus_gpsY = false;
            boolean bus_stationNm = false;
            boolean bus_sectSpd = false;
            boolean bus_direction = false;
            ///// (2) Bus Positions
            textView.append("-버스 위치 검색 결과-\n");
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xmlpp = factory.newPullParser();

                xmlpp.setInput(new StringReader(result));
                int eventType = xmlpp.getEventType();

                count = 0;
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                        ;
                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xmlpp.getName();

                        switch (tag_name) {

                            case "headerCd":
                                bus_headerCd = true;
                                break;
                            case "gpsX":
                                bus_gpsX = true;
                                break;
                            case "gpsY":
                                bus_gpsY = true;
                                break;
                            case "sectSpd":
                                bus_sectSpd = true;
                                break;
                            case "stationNm":
                                bus_stationNm = true;
                                break;
                            case "direction":
                                bus_direction = true;
                                break;
                        }

                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bus_headerCd) {
                            headerCd = xmlpp.getText();
                            // textView.append("headerCd: " + headerCd + "\n");
                            bus_headerCd = false;
                        }

                        if (headerCd.equals("0")) {
                            if (bus_gpsX) {
                                count++;
                                textView.append("-------------------------------------------\n");

                                gpsX = xmlpp.getText();
                                textView.append("(" + count + ") gpsX: " + gpsX + "\n");
                                bus_gpsX = false;
                            }
                            if (bus_gpsY) {
                                gpsY = xmlpp.getText();
                                textView.append("(" + count + ") gpsY: " + gpsY + "\n");
                                bus_gpsY = false;
                            }

                            if (bus_stationNm) {
                                stationNm = xmlpp.getText();
                                textView.append("(" + count + ") 정류장이름: " + stationNm + "\n");
                                bus_stationNm = false;
                            }

                            if (bus_direction) {
                                direction = xmlpp.getText();
                                textView.append("(" + count + ") 진행방향: " + direction + "\n");
                                bus_direction = false;
                            }

                            if (bus_sectSpd) {
                                sectSpd = xmlpp.getText();
                                textView.append("(" + count + ") 구간속도: " + sectSpd + "\n");
                                bus_sectSpd = false;
                            }

                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        ;
                    }
                    eventType = xmlpp.next();
                }
            } catch (Exception e) {
                textView.setText(e.getMessage());
            }

        }


        public String downloadByUrl(String myurl) throws IOException {
            //Java와 Http 통신: HttpURLConnection 클래스를 활용해 데이터를 얻는다.

            HttpURLConnection conn = null;
            BufferedReader buffer_reader;
            try {
                //요청 URL, 전달받은 url string 으로 URL 객체를 만듦
                URL url = new URL(myurl);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                //결과를 InputStream으로 받아서 INputStreamReader, BufferedReader로 캐스팅한다.
                BufferedInputStream buffer = new BufferedInputStream(conn.getInputStream());
                buffer_reader = new BufferedReader(new InputStreamReader(buffer, "utf-8"));

                String line = null;
                getData = "";
                while ((line = buffer_reader.readLine()) != null) {
                    getData += line;

                }

                return getData;
            } finally {
                //접속 해제
                conn.disconnect();
            }
        }
    }

  /*  public void plusBusNumber(View v) {

        busNum += 1;

        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        strSrch = busNum + "";

        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;
//
        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);
        textView.setText("");
        busNumer.setText("");
        busNumer.append("버스번호:");
        busNumer.append(strSrch + "\n");
    }

    public void minusBusNumber(View v) {

        busNum -= 1;

        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        strSrch = busNum + "";

        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;
//
        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);
        textView.setText("");
        busNumer.setText("");
        busNumer.append("버스번호:");
        busNumer.append(strSrch + "\n");
    }

    public void resetCurrentBus(View v) {

        //  busNum+=1;
        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        strSrch = busNum + "";

        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;

        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);
        textView.setText("");
        busNumer.setText("");
        busNumer.append("버스번호:");
        busNumer.append(strSrch + "\n");
    }

    public void plusBaek(View v) {
        busNum += 100;
        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        strSrch = busNum + "";

        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;

        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);
        textView.setText("");
        busNumer.setText("");
        busNumer.append("버스번호:");
        busNumer.append(strSrch + "\n");
    }

    public void minusBaek(View v) {
        busNum -= 100;
        String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
        String serviceKey = "wvf8GOyjjlMU2%2BzN%2FZ%2BxDxA1XMB2dM1n%2BHOk%2B%2FuQjpAooXQDiYhdyesCkgd%2FBpPBz%2FFLRW0uE%2FgSRTzxOlcCeQ%3D%3D";
        strSrch = busNum + "";

        //가져올 정보를 strUrl에 저장함
        String strUrl = serviceUrl + "?ServiceKey=" + serviceKey + "&strSrch=" + strSrch;

        DownloadWebContent dwc1 = new DownloadWebContent();
        dwc1.execute(strUrl);
        textView.setText("");
        busNumer.setText("");
        busNumer.append("버스번호:");
        busNumer.append(strSrch + "\n");

    }
*/

}
