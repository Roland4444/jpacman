package jpac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

public class JPacman implements Serializable {


    public void extractRPM() throws IOException {
         Runtime.getRuntime().exec("ps -ef");
    }
    public Process call(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public String returnPath(String path){
        for (int i = (int) path.length()-1; i>0; i--){
            var empty=""+path.charAt(i);
            if (empty.equals(File.separator)){
                return (path.substring(0,i+1));
            }
        }
        return null;
    }

    public void install(String prefix, String file) throws IOException {
        var Arr = Files.readAllBytes(new File(file).toPath());
        new File(returnPath(prefix+file)).mkdirs();
        System.out.println("Creates dirs..."+returnPath(prefix+file));
        var fos = new FileOutputStream(prefix+file);
        fos.write(Arr);
        fos.close();
        System.out.println("Writes file =>"+(prefix+file));
    }

    public static void main(String[] args){
        var base = args[0];
        var where = args[1];

    }
}
