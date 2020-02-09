package main.java;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String args[]) {
        String value = null;
        String nominal = null;
        Document doc;
        try {
            doc = Jsoup.connect("http://www.cbr.ru/scripts/XML_daily.asp").get();
            value = doc.getElementById("R01200").getElementsByTag("value").text();
            nominal = doc.getElementById("R01200").getElementsByTag("nominal").text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Float.parseFloat(value.replace(',','.')) / Integer.parseInt(nominal));
    }
}