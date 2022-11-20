import java.io.*;
import java.util.*;


class mkfil{
    static String name = "frag";
    static int fn = 1; 
    File fdir;
    String dir;
    ArrayList<String> strarr;
    mkfil(ArrayList<String> strarr,String dir)
    {
        this.dir = dir;
        this.strarr = strarr;
    }
    void make(){
        try{
        for(String k : strarr){
            String newname = new String(name+Integer.toString(fn));
            fn++;
            File f = new File("C:\\Users\\gollo\\github-classroom\\cnslab-kangwoon\\02_7_file_io-honeybears\\"+dir+"\\"+newname+".txt");
            if(f.exists()){
                f.delete();
            }
            if(!(fdir = new File(dir)).exists()){
                fdir.mkdir();
            }
            if(f.createNewFile()){
            FileWriter fw = new FileWriter(f);
            fw.write(k);
            fw.flush();
            fw.close();
            }else{
                System.out.println("error");
            }

        }
       
        
        }catch(Exception e){}
    }
}

public class FileSplitter {
    public static void main(String [] args){
       
        if(args.length!=3||!new File(args[0]).isFile()){
            System.out.println("usage: java FileSplitter [input_file] [output_directory] [number_of_lines]");
            System.exit(1);
        }
        else{
            File fileinput = new File(args[0]);
            BufferedReader bfi;
            FileInputStream fi;
            String read = "";
            String isread;
            int split ,count=0;
            split = Integer.valueOf(args[2]);
            ArrayList<String> ReadLine = new ArrayList<String>();
            try{
                fi = new FileInputStream(fileinput);
                bfi = new BufferedReader(new InputStreamReader(fi));
                while ((isread = bfi.readLine())!=null)
                {
                    if(read ==""){
                        read+=isread;
                        count++;
                    }
                    else{
                        read=read+"\n"+ isread;
                        count++;
                    }
                    
                    if(split == count){
                        ReadLine.add(read);
                        read="";
                        count =0;
                       
                    }
                }
               
        }   catch(IOException e){}
            
            ReadLine.add(read+"\n");
            
            
            mkfil result = new mkfil(ReadLine,args[1]);
            result.make();
            

        }
        
    }
}
