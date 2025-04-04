package com.kitm.penktadienio_darbas.cli;

import com.kitm.penktadienio_darbas.dao.NtDAO;
import com.kitm.penktadienio_darbas.entity.NTObject;
import com.kitm.penktadienio_darbas.utility.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Component
public class CLI {

    private NtDAO ntDAO;

    @Autowired
    public CLI(NtDAO ntDAO)
    {
        this.ntDAO = ntDAO;
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true)
        {
            System.out.println("===== NT Sistemos Meniu =====");
            System.out.println("1.Importuoti NT duomenis iš CSV");
            System.out.println("2. Rodyti visus NT objektus");
            System.out.println("3. Rodyti geriausius NT objektus (ivertinimas >= 8");
            System.out.println("4. Pažymėti geriausius objektus kaip VIP");
            System.out.println("5. Rūšuoti pagal kainą");
            System.out.println("6. Rūšuoti pagal plotą");
            System.out.println("7. Rūšuoti pagal įvertinimą");
            System.out.println("8. Rasti pagal tipą");
            System.out.println("9. Išeiti");

            choice = scanner.nextInt();

            if (choice == 9)
            {
                System.out.println("Viso gero.");
                break;
            }
            else if (choice == 1)
            {
                scanner.nextLine();

                System.out.println("Iveskite failo vieta");
                String file = scanner.nextLine();

                importFile(file);
            }
            else if (choice == 2)
            {
                showAll();
            }
            else if (choice == 3)
            {
                showBest();
            }
            else if (choice == 4)
            {
                updateBest();
            }
            else if (choice == 5)
            {
                sortByPrice();
            }
            else if (choice == 6)
            {
                sortByArea();
            }
            else if (choice == 7)
            {
                sortByRating();
            }
            else if (choice == 8)
            {
                scanner.nextLine();

                System.out.println("Iveskite tipą");
                String type = scanner.nextLine();

                findByType(type);
            }
        }

    }

    private void importFile(String file)
    {
        List<NTObject> ntObjectList = Reader.read(file);

        for (NTObject i : ntObjectList)
        {
            ntDAO.save(i);
        }
    }

    private void showAll()
    {
        List<NTObject> ntObjectList = ntDAO.findAll();
        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {
            System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());
        }
    }

    private void showBest()
    {
        List<NTObject> ntObjectList = ntDAO.findAll();
        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {
            if (i.getRating() >= 8)
            {
                System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());
            }
        }
    }

    private void updateBest()
    {
        ntDAO.updateBest();
        System.out.println("Atnaujinta");
    }

    private void sortByPrice()
    {
        List<NTObject> ntObjectList = ntDAO.findAll();

        ntObjectList.sort(Comparator.comparing(NTObject::getPrice).reversed());

        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {

            System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());

        }
    }

    private void sortByArea()
    {
        List<NTObject> ntObjectList = ntDAO.findAll();

        ntObjectList.sort(Comparator.comparing(NTObject::getArea).reversed());

        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {

            System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());

        }
    }

    private void sortByRating()
    {
        List<NTObject> ntObjectList = ntDAO.findAll();

        ntObjectList.sort(Comparator.comparing(NTObject::getRating).reversed());

        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {

            System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());

        }
    }

    private void findByType(String type)
    {
        List<NTObject> ntObjectList = ntDAO.findByType(type);

        System.out.println("id,adresas,plotas_kv_m,kaina_eur,ivertinimas,tipas,vip");
        for (NTObject i : ntObjectList)
        {
            System.out.println(i.getId() + " " + i.getAddress() + " " + i.getArea() + " " + i.getPrice() + " " + i.getRating() + " " + i.getType() + " " + i.isVip());
        }
    }
}
