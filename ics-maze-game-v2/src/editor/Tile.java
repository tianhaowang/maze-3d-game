package editor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends Clickable {

    private int id;
    //Tile constructor
    public Tile(EditorApplication app, BufferedImage i, int x, int y, int w, int h, int id) {
        super(app, i, x, y, w, h);
        this.id = id;
    }
    //sets button picture
    public void render(Graphics g, int x, int y, int td) {
        if(!hide) {
            setBounds(x, y, td, td);
            g.drawImage(image, x, y, td, td, null);
            if (x+width < app.getCanvWidth() * app.getEditor().getMainWidth() && clickable()) {
                click();
                disableClick();
            }
            resetClick();
        }
    }
    //clicks the button, set image
    protected void click() {
        int select = app.getEditor().getSelect();
        if (select != -1 && select != 2 && select != 3) {
            id = select;
            image = app.getEditor().getImg(select);
        }
        else if (select == 2 && Editor.s ==0){
            id = select;
            image = app.getEditor().getImg(select);
            Editor.s++;
        }
        else if (select == 3 && Editor.e ==0){
            id = select;
            image = app.getEditor().getImg(select);
            Editor.e++;
        }
    }

    public int id() {
        return id;
    }

    // DEBUG
    public String toString() {
        return Integer.toString(id);
    }

}