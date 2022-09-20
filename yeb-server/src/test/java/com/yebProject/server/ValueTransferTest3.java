package com.yebProject.server;

/**
 * @author 此间凉汐
 * @date 2022/3/25 16:35
 */
public class ValueTransferTest3 {
    public static void main(String[] args) {
        String s = "100";
        System.out.println(String.format("%08d",
                Integer.parseInt(s)+1));
//        ValueTransferTest3 test = new ValueTransferTest3();
//        test.first();
    }
    public void first() {
        int i= 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println(v.i);
    }
    public void second(Value v,int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i+" "+i);
    }
}

class Value{
    int i =15;
}
