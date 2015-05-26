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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	private JPanel bottomPanel;
	private Color color;
	private BrushListener pencil;
	private BrushListener rectangle;
	private JPanel tools;
	private Cursor cursor;
	private Toolkit toolkit;
	private ModeButton pencilButton;
	private ModeButton RectangleButton;
	private Canvas canvas;
	private JSlider brushWidthSlider;
	private BrushListener currentListener;

	public PaintFrame() {

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);

		setLayout(new BorderLayout());
		canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

		pencil = new PencilListener(canvas);
		currentListener = pencil;
		canvas.setBrushListener(pencil);
		//canvas.addMouseListener(pencil);
		//canvas.addMouseMotionListener(pencil);

		bottomPanel = new JPanel();
		brushWidthSlider = new JSlider(1, 20);
		
		brushWidthSlider.setOrientation(JSlider.HORIZONTAL);
		brushWidthSlider.addChangeListener(brushSliderListener);

		colorButtons();
		bottomPanel.add(brushWidthSlider);
		add(bottomPanel, BorderLayout.SOUTH);

		tools = new JPanel();
		tools.setBackground(Color.GRAY);
		tools.setLayout(new BoxLayout(tools, BoxLayout.PAGE_AXIS));
		add(tools, BorderLayout.EAST);
		
		rectangle = new RectangleListener(canvas);

		ModeButton rectangleTool = new ModeButton(rectangle, "DrawRectangle.png");
		rectangleTool.addActionListener(draw);
		
		ModeButton pencilTool = new ModeButton(pencil, "pencilCursor.png");
		pencilTool.addActionListener(draw);

		tools.add(rectangleTool);
		tools.add(pencilTool);


		toolkit = Toolkit.getDefaultToolkit();
		
		Image pencilIcon = toolkit.getImage("pencilCursor.png");
		cursor = toolkit.createCustomCursor(pencilIcon, new Point(getX(),
				getY()), "img");
		setCursor(cursor);

	}

	private void colorButtons() {
		bottomPanel.setLayout(new FlowLayout());

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
			bottomPanel.add(x);
			x.addActionListener(buttonPressed);
		}

	}
	
//	public ModeButton addButtonToTools(BrushListener listener, String imageName){
//		ModeButton tool = new ModeButton(listener, imageName);
//		ImageIcon image = new ImageIcon(imageName);
//		tool.setSize(new Dimension(60, 60));
//		tool.setOpaque(true);
//		tool.setIcon(image);
//		tool.setVisible(true);
//		return tool;
//	}


	ActionListener buttonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ColorButton button = (ColorButton) e.getSource();

			currentListener.changeColor(button.getColor());
			//rectangle.changeColor(button.getColor());
		}

	};
	
	ActionListener draw = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ModeButton button = (ModeButton) e.getSource();
			BrushListener listener = button.getListener();
			canvas.setBrushListener(listener);
			currentListener = listener;
			//canvas.addMouseListener(listener);
			//canvas.addMouseMotionListener(listener);

			
			Image image = toolkit.getImage(button.getImageName());
			cursor = toolkit.createCustomCursor(image, new Point(getX(),
					getY()), "img");
			setCursor(cursor);

		}

	};
	
	ChangeListener brushSliderListener = new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			currentListener.changeWidth(brushWidthSlider.getValue());
			
		}
	};

	

	public static void main(String args[]) {

		new PaintFrame().setVisible(true);

	}
}
