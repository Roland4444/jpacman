import jpac.JPacman;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void abstoRel() throws IOException {
        Files.walk(Paths.get(jpac.path))
                .filter(p->Files.isRegularFile(p))
                .forEach(a-> {
                    System.out.println("===>"+a.toAbsolutePath().toString());
                    assertEquals("hello",jpac.absTorel(a.toAbsolutePath().toString()));
                });
    }

    @Test
    void returnPath() {
        assertEquals(prefix, jpac.returnPath(prefix+file));
    }
}