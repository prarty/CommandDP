import com.dth.CommandMenu;
import com.dth.command.ViewBalance;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CommandMenuTest {
    @Test
    void shouldRunTheGivenMenuOption() {
        CommandMenu commandMenu = new CommandMenu();
        ViewBalance viewBalance = mock(ViewBalance.class);
        commandMenu.setMenuOption(1, viewBalance);

        commandMenu.runMenuOption(1);

        verify(viewBalance).execute();
    }
}