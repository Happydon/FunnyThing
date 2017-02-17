import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 10.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
       /* MyHashTable t=new MyHashTable(100);
        t.put("table","стол");
        String r= t.get("table");
        System.out.println(r); */
        System.out.println(run( 600000));
        XYSeries s=new XYSeries("1");
        int [] ns = {100,500,1000};
        for (int n:ns){
            long t=run(n);
            s.add(n,t);
        }
        XYSeriesCollection c=new XYSeriesCollection(s);
        JFreeChart ch= ChartFactory.createXYLineChart("Hash","n","T",c);
        File f=new File("Corn");
        BufferedImage im = ch.createBufferedImage(800,600);
        ImageIO.write(im,"png",f);
    }

    static long run(int n) {

        int c = 10000;
        long t0=System.currentTimeMillis();
        MyHashTable ht = new MyHashTable(n);
        for (int i = 0; i < c; i++) {
            ht.put("table" + i, "стол" + i);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < c; j++) {
               ht.get("table" + j);
            }
        }
        long t1=System.currentTimeMillis();
        return t1-t0;
    }
}
