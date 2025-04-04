package com.kitm.penktadienio_darbas.utility;

import com.kitm.penktadienio_darbas.entity.NTObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Float.NaN;

public class Reader {

    public static List<NTObject> read(String file)
    {
        List<NTObject> ntObjects = new ArrayList<>();

        String line;

        int klaidos = 0;

        String addres;
        Double area;
        Double price;
        Integer rating;
        String type;
        boolean vip;

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine();

            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");

                if (values[1].isEmpty() || values[2].isEmpty() || values[3].isEmpty() || values[4].isEmpty() || values[5].isEmpty() || values[6].isEmpty())
                {
                    klaidos++;
                    continue;
                }

                addres = values[1];

                try
                {
                    area = Double.parseDouble(values[2]);
                }catch (Exception e)
                {
                    klaidos++;
                    continue;
                }

                try
                {
                    price = Double.parseDouble(values[3]);
                }catch (Exception e)
                {
                    klaidos++;
                    continue;
                }

                try
                {
                    rating = Integer.parseInt(values[4]);
                }catch (Exception e)
                {
                    klaidos++;
                    continue;
                }

                type = values[5];

                if (values[6].equals("false"))
                {
                    vip = false;
                }
                else if (values[6].equals("true"))
                {
                    vip = true;
                }
                else
                {
                    klaidos++;
                    continue;
                }

                if (area.isNaN() || price.isNaN() || price.isNaN())
                {
                    klaidos++;
                    continue;
                }

                NTObject ntObject = new NTObject(addres, area, price, rating, type, vip);

                ntObjects.add(ntObject);

            }
        }catch (Exception e)
        {
            System.out.println("Failas " + file + " nerastas ");
        }

        System.out.println("Atrinkta " + klaidos + " klaidos");

        return ntObjects;
    }
}
