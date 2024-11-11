import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * Author: Bemnet Aboye
 * Date: 3/31/2024
 * Purpose: This class paints the flag of Norway and the Olympic rings.
 */

public class BTA_Flags extends JFrame
{
    private static final int FRAME_HEIGHT = 750;
    private static final int FRAME_WIDTH = 500;

    /**
     * Constructs a Flags object
     */
    public BTA_Flags()
    {
        Panel panel1 = new Panel();
        panel1.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        CountryFlag flag = new CountryFlag();
        flag.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        panel1.add(flag);

        this.add(panel1);
        this.pack();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    class CountryFlag extends JComponent
    {
        public void paint(Graphics g)
        {
            Graphics2D graph = (Graphics2D) g;

            drawNorwayFlag(graph, 70, 75, 350);
            drawOlympicsFlag(graph, 70, 400, 350);
        }

        /**
         * This method paint an italian flag given a x and y axis, and a width
         * @param g the graphic object
         * @param xAxis the x-coordinate of the flag
         * @param yAxis the y-coordinate of the flag
         * @param width the width of the flag
         */

        void drawNorwayFlag(Graphics g, int xAxis, int yAxis, int width)
        {
            Graphics2D graph = (Graphics2D) g;

            Color norwegianRed = new Color(186,12,47); // "186-12-47" is the RGB code for Norwegian Red
            Color norwegianBlue = new Color(0,32,91); // "0,32,91" is the RGB code for Norwegian Blue
            Stroke blueStripStroke = new BasicStroke(28f);
            Stroke whiteStripStroke = new BasicStroke(45f);

            graph.setPaint(norwegianRed);
            graph.fillRect(xAxis, yAxis, width, width / 2);

            graph.setPaint(Color.white);
            graph.setStroke(whiteStripStroke);
            graph.drawLine(xAxis + 100, yAxis + 22, xAxis + 100, yAxis + 153);

            graph.drawLine(xAxis + 21, yAxis + 85, xAxis + 328, yAxis + 85);

            graph.setPaint(norwegianBlue);
            graph.setStroke(blueStripStroke);
            graph.drawLine(xAxis + 100, yAxis + 15, xAxis + 100, yAxis + 160);
            graph.drawLine(xAxis + 13, yAxis + 85, xAxis + 336, yAxis + 85);

        }

        /**
         * This methods paints the Olympic flag given a coordinate and a width
         * @param g the graphic object
         * @param xAxis the x-coordinate
         * @param yAxis the y-coordinate
         * @param width the width of the flag
         */
        void drawOlympicsFlag(Graphics g, int xAxis, int yAxis, int width)
        { 
            Graphics2D graph = (Graphics2D) g;

            int ringWidth = 60;
            graph.setPaint(Color.white);
            graph.fillRect(xAxis, yAxis, width, width / 2);

            drawRings(graph, "blue", xAxis + 75, yAxis + 40, ringWidth);
            drawRings(graph, "black", xAxis + ringWidth + 85 , yAxis + 40, ringWidth);
            drawRings(graph, "red", xAxis + (ringWidth * 2) + 95 , yAxis + 40, ringWidth);

            drawRings(graph, "yellow", xAxis + 110, yAxis + 70, ringWidth);
            drawRings(graph, "green", xAxis + ringWidth + 120, yAxis + 70, ringWidth);

        }
         
        /**
         * This method draws a ring given a coordinate, a color, and a diameter
         * @param g the graphic object
         * @param color the color of the ring
         * @param xAxis the x-coordinate
         * @param yAxis the y-coordinate
         * @param diameter the diameter of the ring
         */
        private void drawRings(Graphics g, String color, int xAxis, int yAxis, int diameter)
        {
            Graphics2D graph = (Graphics2D) g;
            
            Stroke ringStroke = new BasicStroke(5f);
            Color color1;

            switch (color.toUpperCase())
            {
                case "RED": color1 = Color.red; break;
                case "BLUE": color1 = Color.blue; break;
                case "YELLOW": color1 = Color.yellow; break;
                case "GREEN": color1 = Color.green; break;
                default : color1 = Color.black; break;
            }

            graph.setPaint(color1);
            graph.setStroke(ringStroke);
            graph.drawOval(xAxis, yAxis, diameter, diameter);

        }

    }

}
 