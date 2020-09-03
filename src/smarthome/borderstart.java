/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import static smarthome.Button.login_continue;
import static smarthome.Button.login_submit;
import static smarthome.Label.jLabel1;
import static smarthome.Label.jp;
import static smarthome.Panel.*;

public class borderstart {
 public borderstart()
 {
 AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);
 AbstractBorder brdr1 = new TextBubbleBorder(Color.DARK_GRAY,5,16,0);
 AbstractBorder brdr2 = new TextBubbleBorder(Color.RED,3,75,0);
 a.setBorder(brdr);
 //jp.setBorder(brdr);
 b.setBorder(brdr);
 
 house.setBorder(brdr);
 house2.setBorder(brdr);
 house3.setBorder(brdr);
 login.setBorder(brdr);
 search.setBorder(brdr);
 notification.setBorder(brdr);
 cctv.setBorder(brdr);
 music2.setBorder(brdr);
 pic.setBorder(brdr1);
 login_continue.setBorder(brdr);
  login_submit.setBorder(brdr);
 jLabel1.setBorder(brdr2);
     //Label.picslider.setBorder(brdr1);
 new smarthome.Smarthome();
 }
  public static void main(String[] args) {
 new borderstart();
 
}}

class TextBubbleBorder extends AbstractBorder {

    private Color color;
    private int thickness = 4;
    private int radii = 8;
    private int pointerSize = 7;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    RenderingHints hints;

    TextBubbleBorder(
            Color color) {
        new TextBubbleBorder(color, 4, 8, 7);
    }

    TextBubbleBorder(
            Color color, int thickness, int radii, int pointerSize) {
        this.thickness = thickness;
        this.radii = radii;
        this.pointerSize = pointerSize;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + pointerSize + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x, int y,
            int width, int height) {

        Graphics2D g2 = (Graphics2D) g;

        int bottomLineY = height - thickness - pointerSize;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY,
                radii,
                radii);

        Polygon pointer = new Polygon();

        // left point
        pointer.addPoint(
                strokePad + radii + pointerPad,
                bottomLineY);
        // right point
        pointer.addPoint(
                strokePad + radii + pointerPad + pointerSize,
                bottomLineY);
        // bottom point
        pointer.addPoint(
                strokePad + radii + pointerPad + (pointerSize / 2),
                height - strokePad);

        Area area = new Area(bubble);
        area.add(new Area(pointer));

        g2.setRenderingHints(hints);

        Area spareSpace = new Area(new Rectangle(0, 0, width, height));
        spareSpace.subtract(area);
        g2.setClip(spareSpace);
        g2.clearRect(0, 0, width, height);
        g2.setClip(null);

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}