package com.tyagiabhinav.dialogflowchat.utility;

/**
 * Created by Md Akib on 2/19/2019.
 */

public class MathCalculate {
    static String[] numb={"শূন্য","এক","দুই","তিন","চার","পাঁচ","ছয়","সাত","নয়"};
    static String[] digitnum={"দশ","শত","হাজার"};
    public static String add(String s){
        try {
            String[] parts = s.split(" ");
            if (isNumeric(parts[0]) && isNumeric(parts[2])) {
                return Integer.toString(Integer.parseInt(parts[0]) + Integer.parseInt(parts[2]));
            }
        }catch (Exception e){
            return "আমি বুঝতে পারিনি আবার বলেন";
        }
        return "আমি বুঝতে পারিনি আবার বলেন";
    }
    public static String multiply(String s){

        int[] res={0};
        try {
            if(s.indexOf("গুণ") != -1){
                 res=findNumber(s,"গুণ");
            }else{
                 res=findNumber(s,"গুন");
            }


            if(res[0] != -1) {
                int first = res[0];
                int second = res[1];

                    return Integer.toString(first * second);

            }
        } catch (Exception e) {
            return "আমি বুঝতে পারিনি আবার বলেন";
        }
            return "আমি বুঝতে পারিনি আবার বলেন";
    }


    public  static String division(String s){
        int[] res=findNumber(s,"ভাগ");
        if(res[0] != -1) {
            int first = res[0];
            int second = res[1];
            System.out.println("f "+first);
            System.out.println("s "+second);

            // float result=(float) first/second;
            try {
                if (first % second == 0) {

                    return Integer.toString(first / second);
                } else {

                    float result = (float) first / second;
                    String strDouble = String.format("%.1f", result);
                    //System.out.println(strDouble);
                    return "About " + strDouble;
                }

            } catch (Exception e) {
                return "আমি বুঝতে পারিনি আবার বলেন";
            }


        }
            return "আমি বুঝতে পারিনি আবার বলেন";

    }
    public static int[] findNumber(String s,String a){
        int first = 0, second = 0;
        int res[]={0,0};
        try {
            String[] part = s.split(a);
            String[] parts = {""};
            String[] parts2 = {""};


//        //first
            if (isNumeric(part[0].trim())) {
                first = Integer.parseInt(part[0].trim());
            } else {
                if (part[0].indexOf("দশ") != -1) {
                    first = 10;
                } else {
                    int fla = 0;
                    if (part[0].indexOf("শত") != -1) {
                        first = 100;
                        parts = part[0].split("শত");
                        fla = 1;
                    } else if (part[0].indexOf("হাজার") != -1) {
                        first = 1000;
                        parts = part[0].split("হাজার");
                        fla = 1;
                    }

                    if (fla == 0) {
                        if (isNumeric(part[0].trim())) {
                            first = first * Integer.parseInt(part[0].trim());
                        } else {
                            for (int i = 0; i < numb.length; i++) {
                                //System.out.println(numb[i].equals(parts[0].trim()));

                                if (numb[i].equals(part[0].trim())) {
                                    if (first > 0) {
                                        first = first * i;
                                    } else {
                                        first = i;
                                    }
                                    //flag=1;

                                    break;
                                } else {
                                    //flag=0;
                                }
                            }
                        }

                    } else {
                        if (isNumeric(parts[0].trim())) {
                            first = first * Integer.parseInt(parts[0].trim());
                        } else {
                            for (int i = 0; i < numb.length; i++) {
                                //System.out.println(numb[i].equals(parts[0].trim()));
                                //  System.out.println();
                                if (numb[i].equals(parts[0].trim())) {
                                    if (first > 0) {
                                        first = first * i;
                                    } else {
                                        first = i;
                                    }
                                    //flag=1;

                                    break;
                                } else {
                                    //flag=0;
                                }
                            }
                        }
                        if (parts[1] != "") {
                            if (isNumeric(parts[1].trim())) {
                                first = first + Integer.parseInt(parts[1].trim());
                            } else {
                                for (int i = 0; i < numb.length; i++) {
                                    //System.out.println(numb[i].equals(parts[0].trim()));
                                    //  System.out.println();
                                    if (numb[i].equals(parts[1].trim())) {

                                        first = first + i;

                                        //flag=1;

                                        break;
                                    } else {
                                        //flag=0;
                                    }
                                }
                            }
                        }
                    }
                }
            }


//            }
//        }

            //end first
            //second
            if (isNumeric(part[1].trim())) {
                second = Integer.parseInt(part[1].trim());
            } else {
                if (part[1].indexOf("দশ") != -1) {
                    second = 10;
                } else {
                    int fla = 0;
                    if (part[1].indexOf("শত") != -1) {
                        second = 100;
                        parts2 = part[1].split("শত");
                        fla = 1;
                    } else if (part[1].indexOf("হাজার") != -1) {
                        second = 1000;
                        parts2 = part[1].split("হাজার");
                        fla = 1;
                    }

                    if (fla == 0) {
                        if (isNumeric(part[1].trim())) {
                            second = second * Integer.parseInt(part[1].trim());
                        } else {
                            for (int i = 0; i < numb.length; i++) {
                                //System.out.println(numb[i].equals(parts[0].trim()));
                                System.out.println();
                                if (numb[i].equals(part[1].trim())) {
                                    if (second > 0) {
                                        second = first * i;
                                    } else {
                                        second = i;
                                    }
                                    //flag=1;

                                    break;
                                } else {
                                    //flag=0;
                                }
                            }
                        }

                    } else {
                        if (isNumeric(parts[0].trim())) {
                            second = second * Integer.parseInt(parts[0].trim());
                        } else {
                            for (int i = 0; i < numb.length; i++) {
                                //System.out.println(numb[i].equals(parts[0].trim()));
                                //  System.out.println();
                                if (numb[i].equals(parts[0].trim())) {
                                    if (second > 0) {
                                        first = first * i;
                                    } else {
                                        second = i;
                                    }
                                    //flag=1;

                                    break;
                                } else {
                                    //flag=0;
                                }
                            }
                        }
                        if (parts[1] != "") {
                            if (isNumeric(parts[1].trim())) {
                                second = second + Integer.parseInt(parts[1].trim());
                            } else {
                                for (int i = 0; i < numb.length; i++) {
                                    //System.out.println(numb[i].equals(parts[0].trim()));
                                    //  System.out.println();
                                    if (numb[i].equals(parts[1].trim())) {

                                        second = second + i;

                                        //flag=1;

                                        break;
                                    } else {
                                        //flag=0;
                                    }
                                }
                            }
                        }
                    }


                }
            }
            res[0]=first;
            res[1]=second;
            System.out.println("fft "+res[0]);
            //System.out.println("sst "+res[1]);
        }catch (Exception e){
            res[0]=-1;
            System.out.println("fft "+res[0]);
        }
       // end second
       // res[0]=first;
       // res[1]=second;
        System.out.println("ff "+first);
        System.out.println("ss "+second);
        return res;
    }

    public static boolean isNumeric(String strNum) {
        try{
            double d = Double.parseDouble(strNum);
            } catch (NumberFormatException | NullPointerException nfe) {
                 return false;
            }
        return true;
    }

}
