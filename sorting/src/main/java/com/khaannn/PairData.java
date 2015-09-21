package com.khaannn;

/**
 * Created by jeff on 9/15/15.
 */
public class PairData implements Comparable<PairData>{
    private int key;
    private String name;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public PairData(int key, String name){
        this.key = key;
        this.name = name;
    }
    public PairData(){
    }
    public String toString(){
        return key + " " + name;
    }
    public int compareTo(PairData a){
        if(this.key > a.getKey()){
            return 1;
        } else if(this.key < a.getKey()){
            return -1;
        }
        //equals
        return 0;

    }


}
