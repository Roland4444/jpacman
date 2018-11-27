package jpac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JPacman implements Serializable {
    public final String path ="install";
    public String rootInstall;
    private String absPath;
    public JPacman(){

    };
    public JPacman(String base){
        this.rootInstall =base;
    }
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
        System.out.println(prefix+file);
        var Arr = Files.readAllBytes(new File(absPath).toPath());
        new File(returnPath(prefix+file)).mkdirs();
        System.out.println("Creates dirs..."+returnPath(prefix+file));
        var fos = new FileOutputStream(prefix+file);
        fos.write(Arr);
        fos.close();
        System.out.println("Writes file =>"+(prefix+file));
    }

    public String absToRel(String abs){
        System.out.println(abs);
        return abs.substring(abs.lastIndexOf(path)+path.length()+1);
    }
    public void install_abs(String input) throws IOException {
        absPath=input;
        install(rootInstall, absToRel(input));


    }

    public static void run() throws IOException {
        String root="/home/roland/";
     //   if (args[0]!=null)
      //      root = args[0];
        JPacman jpac = new JPacman(root);
        if (!new File(jpac.path).exists()){
            System.out.println("Nothing to do=>Install directory not exist");
            return;
        }
        Files.walk(Paths.get(jpac.path))
                .filter(b->Files.isRegularFile(b))
                .forEach(a-> {
                    try {
                        jpac.install_abs(a.toAbsolutePath().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    }

    public static void main(String[] args) throws IOException {
       JPacman.run();

    }
}
