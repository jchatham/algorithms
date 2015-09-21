package com.khaannn;

/**
 * Created by jeff on 9/15/15.
 */
public class PairData implements Comparable<PairData>{
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public PairData(int num, String name){
        this.num = num;
        this.name = name;
    }
    public PairData(){
    }
    public String toString(){
        return num + " " + name;
    }
    public int compareTo(PairData a){
        if(this.num > a.getNum()){
            return 1;
        } else if(this.num < a.getNum()){
            return -1;
        }
        //equals
        return 0;

    }


}
