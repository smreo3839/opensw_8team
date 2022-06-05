package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node; //node를 사용하기위해 추가
import org.w3c.dom.NodeList; //nodelist를 사용하기위해 추가
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ApiExplorer {


    public static String xmlDownload(String searchValue, String searchField) throws IOException {
        System.out.println("test_xmlDownload : " + searchValue);
        System.out.println("test_xmlDownload : " + searchField);
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=wxqzx0cNT1VuuHT1VKBHZ0lqoTf0hnLP58xaJH2Mf4teDIv2drl%2Frl0%2FWlJuWHVO13b58mvMtKcB07CBU3jk4A%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /*한 페이지 결과 수*/
        if (searchField.equals("itmname")) {//상품이름으로 검색
            urlBuilder.append("&" + URLEncoder.encode("itemName", "UTF-8") + "=" + URLEncoder.encode(searchValue, "UTF-8")); /*제품명*/
        } else if (searchField.equals("symptom")) {//증상으로 검색
            urlBuilder.append("&" + URLEncoder.encode("efcyQesitm", "UTF-8") + "=" + URLEncoder.encode(searchValue, "UTF-8")); /*이 약의 효능은 무엇입니까?*/
        } else if (searchField.equals("manufacturer")) {
            urlBuilder.append("&" + URLEncoder.encode("entpName", "UTF-8") + "=" + URLEncoder.encode(searchValue, "UTF-8")); /*업체명*/
        }
//        urlBuilder.append("&" + URLEncoder.encode("itemSeq","UTF-8") + "=" + URLEncoder.encode("200003092", "UTF-8")); /*품목기준코드*/

//        urlBuilder.append("&" + URLEncoder.encode("useMethodQesitm","UTF-8") + "=" + URLEncoder.encode("성인은 1회 1정, 1일 1회 복용합니다..", "UTF-8")); /*이 약은 어떻게 사용합니까?*/
//        urlBuilder.append("&" + URLEncoder.encode("atpnWarnQesitm","UTF-8") + "=" + URLEncoder.encode("매일 세잔 이상 정기적 음주자가 이 약 또는 다른 해열진통제를 복용할 때는...", "UTF-8")); /*이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까?*/
//        urlBuilder.append("&" + URLEncoder.encode("atpnQesitm","UTF-8") + "=" + URLEncoder.encode("이 약 또는 다른 살리실산제제, 진통제, 소염제, 항류마티스제에 대한 과민증 환자...", "UTF-8")); /*이 약의 사용상 주의사항은 무엇입니까?*/
//        urlBuilder.append("&" + URLEncoder.encode("intrcQesitm","UTF-8") + "=" + URLEncoder.encode("다른 비스테로이드성 소염진통제 및 살리실산 제제, 일주일 동안 메토트렉세이트 15밀리그람...", "UTF-8")); /*이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까?*/
        //  urlBuilder.append("&" + URLEncoder.encode("seQesitm", "UTF-8") + "=" + URLEncoder.encode("호흡곤란", "UTF-8")); /*이 약은 어떤 이상반응이 나타날 수 있습니까?*/
//        urlBuilder.append("&" + URLEncoder.encode("depositMethodQesitm","UTF-8") + "=" + URLEncoder.encode("습기를 피해 실온에서 보관하십시오.", "UTF-8")); /*이 약은 어떻게 보관해야 합니까?*/
//        urlBuilder.append("&" + URLEncoder.encode("openDe","UTF-8") + "=" + URLEncoder.encode("20200901", "UTF-8")); /*공개일자*/
//        urlBuilder.append("&" + URLEncoder.encode("updateDe","UTF-8") + "=" + URLEncoder.encode("20200905", "UTF-8")); /*수정일자*/
//        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/
        System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println("test_xmlDownload_02" + sb.toString());
        return sb.toString();
    }

    public ArrayList<Item> getItemList(String searchValue, String searchField) throws IOException, ParserConfigurationException, SAXException {
        ArrayList<Item> list = new ArrayList<Item>();
        String xml = ApiExplorer.xmlDownload(searchValue, searchField);
        /* xml 파싱 -> List<item>*/
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = (Document) builder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));

        NodeList nodeList = doc.getElementsByTagName("item");/*xml태그이름 중  item 부분을 전부 긁어모음*/
        for (int i = 0; i < nodeList.getLength(); i++) {
            Item item = new Item();
            Node node = nodeList.item(i);
            //태그안에 있는 요소를 가져오기위해 Element를 형변환 하여 다시 담아줌
            Element e = (Element) node;
            item.setItemName(e.getElementsByTagName("itemName").item(0).getTextContent());
            item.setEntpName(e.getElementsByTagName("entpName").item(0).getTextContent());
            item.setItemImage(e.getElementsByTagName("itemImage").item(0).getTextContent());
            item.setEfcyQesitm(e.getElementsByTagName("efcyQesitm").item(0).getTextContent());
            item.setAtpnWarnQesitm(e.getElementsByTagName("atpnWarnQesitm").item(0).getTextContent());
            item.setUseMethodQesitm(e.getElementsByTagName("useMethodQesitm").item(0).getTextContent());
            item.setSeQesitm(e.getElementsByTagName("seQesitm").item(0).getTextContent());
            item.setAtpnQesitm(e.getElementsByTagName("atpnQesitm").item(0).getTextContent());
            item.setDepositMethodQesitm(e.getElementsByTagName("depositMethodQesitm").item(0).getTextContent());
            item.setIntrcQesitm(e.getElementsByTagName("intrcQesitm").item(0).getTextContent());
            list.add(item);
        }

        return list;
    }
}