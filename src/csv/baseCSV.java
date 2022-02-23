package csv;

import java.io.BufferedReader;
import java.io.FileReader;

public class baseCSV {



    public  void recupererAtome()
    {


        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Darks/Desktop/CSV/ressources/csv/atomes.csv"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(",");


                Atome atome = new Atome(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15]);
                System.out.println(atome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        baseCSV csv = new baseCSV();
        csv.recupererAtome();


    }
}
