package zx.foodeffects;

public class UM {
    public static int cc(String string){
        int r=0;
        String n="0123456789";
        for (int i=0;i<string.length();i++){
            if (n.contains(string.charAt(i)+"")){
                r=r*10+(Integer.parseInt(string.charAt(i)+""));
            } else {
                if (string.charAt(i)=='+'){ r+=cc(string.substring(i+1));}
                if (string.charAt(i)=='-'){ r-=cc(string.substring(i+1));}
                if (string.charAt(i)=='*'){ r*=cc(string.substring(i+1));}
                if (string.charAt(i)=='/'){ try{r/=cc(string.substring(i+1));}
                catch (Exception e){
                    System.out.println("meow meow nga!");}
                    return 20;
                }
                break;
            }
        }
        return r;
    }
    public static int r(int min , int max) {
        int r = (int)Math.floor(Math.random()*(max-min+1)+min);
        return r;
    }
    public static boolean isN(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static int[] rr(String s){
        int [] tr = new int[0];
        int m = 1;
        int mx = 2;
        if (s.contains("-")){
            String[] a = s.split("-");
            if (isN(a[0])){
                m = Integer.valueOf(a[1]);
            }
            if (isN(a[1])){
                mx = Integer.valueOf(a[2]);
            }
        } else {
            System.out.println("ERROR! LINE 49 UM ");
        }
        tr[0] = m;
        tr[1] = mx;
        return tr;
    }
}
