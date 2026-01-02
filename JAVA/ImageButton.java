import java.awt.*;
import java.net.URL;

public class ImageButton extends Component {
	
	private String label;
	private Image image;
	
	public ImageButton() {
		this(null, null);
	}
	
	public ImageButton(String label) {
		this(label, null);
	}
	
	public ImageButton(Image image) {
		this(null, image);
	}
	
	public ImageButton(String label, Image image) {
		this.label = label;
		this.image = image;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setLabel(String label) {
		if(!label.equals(this.label)) {
			this.label = label;
			repaint();
		}
	}
	
	public void setImage(Image image) {
		if(!image.equals(this.image)) {
			this.image = image;
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		Color b = getBackground();
		Font f = g.getFont();
                Rectangle r = g.getClipBounds();
		
		super.paint(g);
		
		// Draw the image.
		// Scale it so it fits in the clip rectangle and centre it vertically.
		if(image != null && r.width>4 && r.height>4) {
			Dimension d = new Dimension(image.getWidth(this), image.getHeight(this));
			float scale = 1;
			float fdwidth = (new Integer(d.width)).floatValue();
			float frwidth = (new Integer(r.width)).floatValue();
			float fdheight = (new Integer(d.height)).floatValue();
			float frheight = (new Integer(r.height)).floatValue();
			if((fdwidth*scale) > (frwidth*scale))
				scale = scale * (frwidth/fdwidth);
			if((fdheight*scale) > (frheight*scale))
				scale = scale * (frheight/fdheight);
			int ndwidth = (new Float(fdwidth * scale)).intValue() - 4;
			int ndheight = (new Float(fdheight * scale)).intValue() - 4;
			int yOffset = (r.height - ndheight) / 2;
			g.drawImage(image, 2, yOffset, ndwidth, ndheight, this);
		}
		
		// Draw the label.
		// Centre it in the clip rectangle.
		if(label!=null) {
			FontMetrics fm = g.getFontMetrics();
			g.drawString(label, (r.width - fm.stringWidth(label)) / 2, (r.height/2) + (fm.getAscent()/2));
		}
		
		// Draw the button bevel.
		// We need to draw the lines twice to make them thicker.
		g.setColor(b.brighter());
		g.drawLine(0, r.height-1, 0, 0);
		g.drawLine(1, r.height-2, 1, 1);
		g.drawLine(0, 0, r.width-1, 0);
		g.drawLine(1, 1, r.width-2, 1);
		g.setColor(b.darker());
		g.drawLine(r.width-1, 0, r.width-1, r.height-1);
		g.drawLine(r.width-2, 1, r.width-2, r.height-2);
		g.drawLine(r.width-1, r.height-1, 0, r.height-1);
		g.drawLine(r.width-2, r.height-2, 1, r.height-2);
	}
}
