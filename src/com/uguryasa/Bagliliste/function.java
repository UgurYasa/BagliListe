package com.uguryasa.Bagliliste;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class function {
    public  liste baslangic=null;
    public  void basaEkle(int sayi){
        if (baslangic==null){
            baslangic=new liste(sayi,null);
        }
        else{
            liste yeni=new liste(sayi,baslangic);
            baslangic=yeni;
        }
    }

    public void sonaEkle(int eklenecek){
        liste temp= baslangic;
        if (temp==null){
            liste yeni=new liste(eklenecek,null);
            baslangic=yeni;
        }

        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        liste yeni=new liste(eklenecek,null);
        temp.setNext(yeni);
    }
    public void sonaEkle(liste result,int eklenecek){
        liste temp= result;
        if (temp==null){
            liste yeni=new liste(eklenecek,null);
            baslangic=yeni;
        }

        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        liste yeni=new liste(eklenecek,null);
        temp.setNext(yeni);
    }



    public void sil(int silinecek){
        liste onceki=null;
        liste simdiki=baslangic;
        boolean check=false;

        if (baslangic == null)
        {
            System.out.println("Liste Bos !");
            return;
        }

        if (baslangic.getVeri()==silinecek)
        {
            baslangic=baslangic.getNext();
            return;
        }



        while(simdiki.getNext()!=null){
            if (simdiki.getVeri()==silinecek){
                  onceki.setNext(simdiki.getNext());
                  check=true;
                  return;
            }
            else{
                onceki=simdiki;
                simdiki=simdiki.getNext();
            }
        }
        if (simdiki.getVeri()==silinecek)
        {
            onceki.setNext(simdiki.getNext());
            check=true;
        }
        if (check==false)
            System.out.println("Listede "+silinecek+" sayisini bulamadim !");

    }

    public  void listele(){
        liste temp=baslangic;
        if (baslangic == null)
        {
            System.out.println("Liste Bos !");
            return;
        }

        do{
            System.out.print(temp.getVeri()+" - ");
            temp=temp.getNext();
        }while(temp.getNext()!=null);
        if (temp.getNext()==null)
            System.out.println(temp.getVeri()+" - ");
    }
    public  void listele(liste result){
        liste temp=result;
        if (result == null)
        {
            System.out.println("Liste Bos !");
            return;
        }

        do{
            System.out.print(temp.getVeri()+" - ");
            temp=temp.getNext();
        }while(temp.getNext()!=null);
        if (temp.getNext()==null)
            System.out.println(temp.getVeri()+" - ");
    }

    public void yazdir(int size,List<Integer> liste){
        for (int i=0;i<size;++i){
            System.out.print(liste.get(i)+" - ");
        }
        System.out.println();
    }

    public void sirala(){
        List<Integer> list=new ArrayList<Integer>();
        liste temp = baslangic;
        liste result=null;
        int sayac=1;
        if (baslangic == null)
        {
            System.out.println("Liste Bos !");
            return;
        }
        while (temp.getNext()!=null){
            list.add(temp.getVeri());
            temp=temp.getNext();
            sayac++;
        }
        list.add(temp.getVeri());

        list=list.stream()
                .sorted()
                .toList();

        yazdir(sayac,list);

        liste yeni=new liste(list.get(0),null);

        for (int i=1;i<sayac;i++)
        {
            sonaEkle(yeni,list.get(i));
        }

        baslangic=yeni;
        listele(yeni);


    }


}
