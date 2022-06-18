package com.uguryasa.Bagliliste;

import java.util.Scanner;

public class liste {
    private int veri;
    private liste next;

    public liste getNext() {
        return next;
    }

    public void setVeri(int veri) {
        this.veri = veri;
    }

    public void setNext(liste next) {
        this.next = next;
    }

    public int getVeri() {
        return veri;
    }

    public liste(int veri, liste next) {
        this.veri = veri;
        this.next = next;
    }

    public liste() {
    }

    @Override
    public String toString() {
        return "liste{" +
                "veri=" + veri +
                ", next=" + next +
                '}';
    }
}
