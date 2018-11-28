package jpac;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Uninstall {
    public void clean() throws IOException {
        var Arr = Files.readAllBytes(new File("hist.bin").toPath());
        History hs = History.restoreHistory(Arr);
        for (int i =0 ; i<hs.dump.size(); i++){
            System.out.println("DELETING ==>"+hs.dump.get(i));
            if  (new File(hs.dump.get(i)).exists())
                new File(hs.dump.get(i)).delete();

        }
    }
    public static void main(String[] args) throws IOException {
        var un = new Uninstall();
        un.clean();
    }
}
