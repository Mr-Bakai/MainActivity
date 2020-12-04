package com.hfad.mainactivity;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication  extends Application {

 private  static List<President> presidentList = new ArrayList<President>();
 private static int nextId = 10;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {

        President p0 = new President(0 , "George Washington");
        President p1 = new President(1, "John Adam");
        President p2 = new President(2, "Baatur");
        President p3 = new President(3, "ismail");
        President p4 = new President(4, "Elish");
        President p5 = new President(5, "Beka");
        President p6 = new President(6, "Mirazh");
        President p7 = new President(7, "Danil");
        President p8 = new President(8, "Kantoro");
        President p9 = new President(9, "Bekmurat");
        President p10 = new President(10,"Tashtanbek");

        presidentList.addAll(Arrays.asList( new President[] {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
