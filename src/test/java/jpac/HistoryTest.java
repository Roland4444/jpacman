package jpac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void saveHistory() {
        var hs = new History();
        hs.dump.add("first");
        var restored = History.restoreHistory(History.saveHistory(hs));
        assertEquals(restored.dump.get(0), hs.dump.get(0));
    }
}