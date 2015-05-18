package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JPanel colorPanel;
	private Color color;
	DrawListener pencil;
	DrawRectangle rectangle;
	private JPanel tools;
	Cursor cursor;
	Toolkit toolkit;

	public PaintFrame() {

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);

		setLayout(new BorderLayout());
		Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

		pencil = new DrawListener(canvas);
		addMouseListener(pencil);
		addMouseMotionListener(pencil);

		colorPanel = new JPanel();
		colorButtons();
		add(colorPanel, BorderLayout.SOUTH);

		tools = new JPanel();
		tools.setBackground(Color.GRAY);
		tools.setLayout(new BoxLayout(tools, BoxLayout.PAGE_AXIS));
		add(tools, BorderLayout.EAST);

		JButton rectangleTool = addButtonToTools("DrawRectangle.png");
		rectangleTool.addActionListener(drawRectangle);
		
		JButton pencilTool = addButtonToTools("pencilCursor.png");
		pencilTool.addActionListener(draw);

		tools.add(rectangleTool);
		tools.add(pencilTool);

		rectangle = new DrawRectangle(canvas);
		
		toolkit = Toolkit.getDefaultToolkit();
		
		Image pencil = toolkit.getImage("pencilCursor.png");
		cursor = toolkit.createCustomCursor(pencil, new Point(getX(),
				getY()), "img");
		setCursor(cursor);

	}

	private void colorButtons() {
		colorPanel.setLayout(new FlowLayout());

		List<ColorButton> colorButtons = new ArrayList<ColorButton>();

		colorButtons.add(new ColorButton(Color.RED));
		colorButtons.add(new ColorButton(Color.ORANGE));
		colorButtons.add(new ColorButton(Color.YELLOW));
		colorButtons.add(new ColorButton(Color.GREEN));
		colorButtons.add(new ColorButton(Color.BLUE));
		colorButtons.add(new ColorButton(Color.PINK));
		colorButtons.add(new ColorButton(Color.BLACK));
		colorButtons.add(new ColorButton(Color.WHITE));
		colorButtons.add(new ColorButton(Color.GRAY));

		for (ColorButton x : colorButtons) {
			colorPanel.add(x);
			x.addActionListener(buttonPressed);
		}

	}
	
	public JButton addButtonToTools(String imageName){
		JButton tool = new JButton();
		ImageIcon image = new ImageIcon(imageName);
		tool.setSize(new Dimension(60, 60));
		tool.setOpaque(true);
		tool.setIcon(image);
		tool.setVisible(true);
		return tool;
	}


	ActionListener buttonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ColorButton button = (ColorButton) e.getSource();

			pencil.changeColor(button.getColor());
			rectangle.changeColor(button.getColor());
		}

	};
	
	ActionListener draw = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			removeMouseListener(rectangle);
			removeMouseMotionListener(rectangle);
			addMouseListener(pencil);
			addMouseMotionListener(pencil);

			
			Image image = toolkit.getImage("pencilCursor.png");
			cursor = toolkit.createCustomCursor(image, new Point(getX(),
					getY()), "img");
			setCursor(cursor);

		}

	};

	ActionListener drawRectangle = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			removeMouseListener(pencil);
			removeMouseMotionListener(pencil);
			addMouseListener(rectangle);
			addMouseMotionListener(rectangle);

			
			Image image = toolkit.getImage("rectangleCursor.png");
			cursor = toolkit.createCustomCursor(image, new Point(getX(),
					getY()), "img");
			setCursor(cursor);

		}

	};

	

	public static void main(String args[]) {

		new PaintFrame().setVisible(true);

	}
}
