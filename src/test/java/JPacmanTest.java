import jpac.JPacman;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class JPacmanTest {

    String prefix="/home/roland/";
    String file="ns.bin";
    JPacman jpac = new JPacman(prefix);

    @Test
    void advanceCreate() throws IOException, InterruptedException {
        var jpac2 = new JPacman(prefix);
        String with_dir = "install/ns.bin";
        jpac2.install_abs(with_dir);
        var F2 = new File(prefix+jpac.absToRel(with_dir));
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
                    assertEquals("ns.bin",jpac.absToRel(a.toAbsolutePath().toString()));
                });
    }

    @Test
    void returnPath() {
        assertEquals(prefix, jpac.returnPath(prefix+file));
    }
}