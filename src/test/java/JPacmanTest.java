import jpac.JPacman;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JPacmanTest {
    JPacman jpac = new JPacman();
    String prefix="/home/roland/";
    String file="ns.bin";


    @Test
    void testInstall() throws IOException {
        jpac.install(prefix,file);
        var F = new File(prefix+file);
        assertEquals(true, F.exists());
        F.delete();
    }
    @Test
    void advanceCreate() throws IOException {
        String with_dir = "pics/1.jpg";
        jpac.install(prefix,with_dir);
        var F2 = new File(prefix+with_dir);
        System.out.println(prefix+with_dir);
        assertEquals(true, F2.exists());
        F2.delete();

    }

    @Test
    void returnPath() {
        assertEquals(prefix, jpac.returnPath(prefix+file));
    }
}