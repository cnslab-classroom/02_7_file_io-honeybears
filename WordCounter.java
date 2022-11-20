import java.io.*;


class show{
    char s= 'z';
    static String []k = new String[3];
    int l,w,c;
    show(char s,int l,int w, int c){
        this.s=s;
        this.l=l;
        this.w=w;
        this.c=c;
    }
    show(int l,int w, int c){
        this.l=l;
        this.w=w;
        this.c=c;
    }
    void sot(){
        if(s=='w'){
            k[1] = Integer.toString(w)+"|";
        }
        else if(s=='l'){
            k[0]= Integer.toString(l)+"|";
        }
        else if(s=='c'){
            k[2]=Integer.toString(c)+"|";
        }
        else if(s=='z'){
            k[1] = Integer.toString(w)+"|";
            k[0] = Integer.toString(l)+"|";
            k[2] = Integer.toString(c)+"|";
        }
    }
    String retVal(){
        String st = new String();
        st ="";
        for(String s:k){
            if(s!=null){
                st+= s;
            }
        }
        return st;
    }
}

public class WordCounter {
    public static void main(String [] args)throws IOException{
        FileInputStream fl=null ;
        String str = new String();
        int i;
        int w=0, l=0, c =0;
        show sh;
        if(args.length==0){
            System.out.println("usage: java WordCounter [options] [input_file]");
            System.exit(0);
        }
        if(args.length==1&&args[0].charAt(0)!='-'){
            try{
                fl = new FileInputStream(args[0]);
            }catch(IOException e){}
            try{
                do{
                    i=fl.read();
                    c++;
                    if(i == 32){
                    w++;
                    }
                    else if(i == 10){
                        l++;
                    }
                }
                while(i!=-1);
            }catch(IOException e){}
            c--;
            sh = new show(l, w, c);
            sh.sot();
            str =sh.retVal();
            str+=args[0];
            System.out.println(str);
            System.exit(0);
        }
        if(args.length>1&&args[0].charAt(0)=='-'){
            
            
                char[] key = new char[args[0].length()-1];
                for(int j=0; j<args[0].length()-1; j++){
                    key[j]=args[0].charAt(j+1);
                }
                try{
                    fl = new FileInputStream(args[1]);
                }catch(IOException e){}
                try{
                    do{
                        i=fl.read();
                        c++;
                        if(i == 32){
                        w++;
                        }
                        else if(i == 10){
                            l++;
                        }
                    }
                    while(i!=-1);
                }catch(IOException e){}
                c--;
                sh = new show(l, w, c);
                for(char k:key){
                    sh = new show(k, l, w, c);
                    sh.sot();
                
                
                str = sh.retVal();
                str +=args[1];
            }
            System.out.println(str);
            System.exit(0);
        }
        else{
            System.out.println("usage: java WordCounter [options] [input_file]");
            System.exit(0);
        }
        
}
}