package graphics;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PickColorMarble implements ActionListener {
	public static JRadioButton rMarble = new JRadioButton();
	public static JRadioButton bMarble = new JRadioButton();
	public static JRadioButton gMarble = new JRadioButton();
	public static JRadioButton pMarble = new JRadioButton();
	public static JRadioButton yMarble = new JRadioButton();

	@Override
	public void actionPerformed(ActionEvent e) {
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();

		JPanel radioPanel = new JPanel();
		radioPanel.setOpaque(false);
		JPanel imgPanel = new JPanel();
		imgPanel.setOpaque(false);
		JPanel promptPanel = new JPanel();
		promptPanel.setOpaque(false);
		
		ColorOption rm = new ColorOption();
		rm.setOpaque(false);
		rm.setColor("Red");
		ColorOption bm = new ColorOption();
		bm.setOpaque(false);
		bm.setColor("Blue");
		ColorOption gm = new ColorOption();
		gm.setOpaque(false);
		gm.setColor("Green");
		ColorOption pm = new ColorOption();
		pm.setOpaque(false);
		pm.setColor("Pink");
		ColorOption ym = new ColorOption();
		ym.setOpaque(false);
		ym.setColor("Yellow");
		
		JPanel outerPanel = new JPanel();
		outerPanel.setOpaque(false);
		
		JButton createBoard = new JButton("Press to Continue");
		createBoard.addActionListener(new CreateBoard());
		
		ButtonGroup group = new ButtonGroup();
		
		rMarble.setMnemonic('R');
		rMarble.addActionListener(new ColorChosen());
		rMarble.setOpaque(false);
		rMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		bMarble.setMnemonic('B');
		bMarble.addActionListener(new ColorChosen());
		bMarble.setOpaque(false);
		bMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		pMarble.setMnemonic('P');
		pMarble.addActionListener(new ColorChosen());
		pMarble.setOpaque(false);
		pMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		yMarble.setMnemonic('Y');
		yMarble.addActionListener(new ColorChosen());
		yMarble.setOpaque(false);
		yMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		gMarble.setMnemonic('G');
		gMarble.setOpaque(false);
		gMarble.setHorizontalAlignment(SwingConstants.CENTER);
		gMarble.addActionListener(new ColorChosen());
		
		outerPanel.setLayout(new GridLayout(6,1));
		imgPanel.setLayout(new GridLayout(1,5, 10, 10));
		radioPanel.setLayout(new GridLayout(1,5,0,0));
		promptPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		imgPanel.add(rm);
		imgPanel.add(bm);
		imgPanel.add(pm);
		imgPanel.add(ym);
		imgPanel.add(gm);
		
		promptPanel.add(createBoard);
		
		JLabel prompt = new JLabel("Select a color of Marble");
		
		outerPanel.add(prompt);
		outerPanel.add(imgPanel);
		outerPanel.add(radioPanel);
		outerPanel.add(promptPanel);
		
		JPanel redPanel = new JPanel();
		redPanel.setOpaque(false);
		
		//radioPanel.add(panel);
		group.add(rMarble);
		radioPanel.add(rMarble);
		group.add(bMarble);
		radioPanel.add(bMarble);
		group.add(pMarble);
		radioPanel.add(pMarble);
		group.add(yMarble);
		radioPanel.add(yMarble);
		group.add(gMarble);
		radioPanel.add(gMarble);
		
		Init.center.setLayout(new GridLayout(1,1));
		Init.center.add(outerPanel);

		Init.frame.setVisible(true);
	}

}
