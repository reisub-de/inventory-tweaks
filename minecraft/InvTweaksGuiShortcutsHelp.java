import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class InvTweaksGuiShortcutsHelp extends qr {

    private final static String SCREEN_TITLE = "Shortcuts help";
    
    private final static int ID_DONE = 0;

    private InvTweaksObfuscation obf;
    private qr parentScreen;
    private InvTweaksConfig config;
    
    public InvTweaksGuiShortcutsHelp(Minecraft mc, 
            qr parentScreen, InvTweaksConfig config) {
        this.obf = new InvTweaksObfuscation(mc);
        this.parentScreen = parentScreen;
        this.config = config;
    }

    public void initGui() {
        // Create Done button
        List<vj> controlList = new LinkedList<vj>();
        controlList.add(new vj(ID_DONE, 
                obf.getWidth(this) / 2 - 100, 
                obf.getHeight(this) / 6 + 168, "Done"));
        obf.setControlList(this, controlList);
    }

    public void drawScreen(int i, int j, float f) {
        
        k(); // drawDefaultBackground
        drawCenteredString(obf.getFontRenderer(), SCREEN_TITLE, obf.getWidth(this) / 2, 20, 0xffffff);
        
        int y = obf.getHeight(this) / 6;

        drawShortcutLine("Move", "Left click", 0x0000EEFF, y);
        y += 12;
        drawShortcutLine("Move to empty slot", "Right click", 0x0000EEFF, y);
        y += 20;
        
        drawShortcutLine("Move one stack",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_ONE_STACK) + " + Click",
                0x00FFFF00, y);
        y += 12;
        drawShortcutLine("Move one item only",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_ONE_ITEM) + " + Click",
                0x00FFFF00, y);
        y += 12;
        drawShortcutLine("Move all items of same type",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_ALL_ITEMS) + " + Click",
                0x00FFFF00, y);
        y += 20;

        drawShortcutLine("Move to upper section",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_UP) + " + Click",
                0x0000FF33, y);
        y += 12;
        drawShortcutLine("Move to lower section",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_DOWN) + " + Click",
                0x0000FF33, y);
        y += 12;
        drawShortcutLine("Move to hotbar", "0-9 + Click", 0x0000FF33, y);
        y += 20;

        drawShortcutLine("Drop",
                config.getProperty(InvTweaksConfig.PROP_SHORTCUT_DROP) + " + Click",
                0x00FF8800, y);
        y += 12;
        drawShortcutLine("Craft all", "LSHIFT, RSHIFT + Click", 0x00FF8800, y);
        y += 12;
        drawShortcutLine("Select sorting configuration", "0-9 + " +
                Keyboard.getKeyName(obf.getKeyCode(InvTweaksConst.SORT_KEY_BINDING)), 0x00FF8800, y);
        y += 12;
        
        super.a(i, j, f); // drawScreen
    }
    
    private void drawShortcutLine(String label, String value, int color, int y) {
        a(obf.getFontRenderer(), label, 50, y, -1); // drawString
        a(obf.getFontRenderer(), value.contains("DEFAULT") ? "-" : value, 
                obf.getWidth(this) / 2 + 40, y, color); // drawString
    }

    protected void actionPerformed(vj guibutton) {

        switch (obf.getId(guibutton)) {

        case ID_DONE:
            obf.displayGuiScreen(parentScreen);
            break;
        
        }
    }
    
}
