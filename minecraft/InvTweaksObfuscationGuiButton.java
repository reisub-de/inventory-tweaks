import net.minecraft.client.Minecraft;




/**
 * Obfuscation layer for gui buttons.
 * @author Jimeo Wan
 *
 */
public class InvTweaksObfuscationGuiButton extends vj /* GuiButton */ {

    public InvTweaksObfuscationGuiButton(int arg0, int arg1, int arg2, int arg3, int arg4, String arg5) {
        super(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    protected void drawGradientRect(
            int i, int j, int k, int l, int m, int n) {
        a(i, j, k, l, m, n);
    }
    protected void drawTexturedModalRect(
            int xPosition, int i, int j, int k, int l, int m) {
        b(xPosition, i, j, k, l, m);
    }
    
    protected String getDisplayString() {
        return f;
    }
    protected int getTexture(Minecraft mc, String texture) {
        return mc.renderEngine.getTexture(texture);
    }
    protected int getHoverState(boolean mouseOverButton) {
        return this.z;
    }
    
    protected boolean isEnabled2() {
        return this.i;
    }
    protected boolean isEnabled() {
        return this.h;
    }
    
    // TODO !!!!!
    protected int getXPosition() {
        return z;
    }
    protected int getYPosition() {
        return z;
    }
    protected int getWidth() {
        return z;
    }
    protected int getHeight() {
        return z;
    }
}