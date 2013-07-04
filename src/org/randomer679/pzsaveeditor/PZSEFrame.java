/*******************************************************************************
 * Copyright © 2013 Ben Taylor.
 * 
 * This file is part of PZSaveEditor.
 * 
 * PZSaveEditor is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * PZSaveEditor is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * PZSaveEditor. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.randomer679.pzsaveeditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.randomer679.pzsaveeditor.Util.OldWorldException;

@SuppressWarnings("serial")
public class PZSEFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					final PZSEFrame frame = new PZSEFrame();
					frame.setVisible(true);
				} catch(final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private final JPanel contentPane;
	private final JLabel worldVersionLabel;
	private final JComboBox<String> zombieDensityCB;
	private final JComboBox<String> zombieDistributionCB;
	private final JComboBox<String> survivorsCB;
	private final JComboBox<String> speedCB;
	private final JComboBox<String> dayLengthCB;
	private final JComboBox<String> startMonthCB;
	private final JComboBox<String> startTimeCB;
	private final JComboBox<String> waterShutoffCB;
	private final JComboBox<String> electricShutoffCB;
	private final JComboBox<String> lootAmountCB;
	private final JComboBox<String> temperatureCB;
	private final JComboBox<String> rainCB;
	private final JComboBox<String> zombieSpeedCB;
	private final JComboBox<String> zombieStrengthCB;
	private final JComboBox<String> zombieToughnessCB;
	private final JComboBox<String> zombieTransmissionCB;
	private final JComboBox<String> zombieMortalityCB;
	private final JComboBox<String> zombieReanimationCB;
	private final JComboBox<String> zombieCognitionCB;
	private final JComboBox<String> zombieMemoryCB;
	private final JComboBox<String> zombieDecompisitionCB;
	private final JComboBox<String> zombieSightCB;
	private final JComboBox<String> zombieHearingCB;
	private final JComboBox<String> zombieSmellCB;
	private final ButtonGroup enableAdvancedOptionsGroup;
	private final JRadioButton enableAdvancedYes;
	private final JRadioButton enableAdvancedNo;
	private final JButton properZombiesButton;
	private WorldValues worldValues;
	private final JButton resetAllButton;
	private String worldName;
	private JMenuItem fileMenuSave;
	private JMenuItem fileMenuSaveAs;
	private File worldFile;
	private boolean worldIsLoaded = false;

	private final String windowTitle = "PZSaveEditor";
	protected Component pzseFrame;

	/**
	 * Create the frame.
	 */
	public PZSEFrame() {
		this.pzseFrame = this;
		this.setResizable(false);
		final WindowListener exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				final int confirm = JOptionPane.showConfirmDialog(PZSEFrame.this.contentPane, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		};
		this.addWindowListener(exitListener);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 570, 450);

		this.createMenu();

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {46, 10};
		gbl_contentPane.rowHeights = new int[] {30, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[] {0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[] {0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);

		final Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		final GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox.anchor = GridBagConstraints.WEST;
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		this.contentPane.add(horizontalBox, gbc_horizontalBox);

		final Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut_2);

		final JLabel lblNewLabel = new JLabel("World Version:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		horizontalBox.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));

		final Component horizontalStrut = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut);

		this.worldVersionLabel = new JLabel("0");
		this.worldVersionLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.worldVersionLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.worldVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(this.worldVersionLabel);
		this.worldVersionLabel.setBackground(new Color(255, 255, 255));

		final Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut_1);

		final Box horizontalBox_26 = Box.createHorizontalBox();
		horizontalBox_26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		final GridBagConstraints gbc_horizontalBox_26 = new GridBagConstraints();
		gbc_horizontalBox_26.anchor = GridBagConstraints.WEST;
		gbc_horizontalBox_26.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalBox_26.gridx = 2;
		gbc_horizontalBox_26.gridy = 0;
		this.contentPane.add(horizontalBox_26, gbc_horizontalBox_26);

		final Component horizontalStrut_79 = Box.createHorizontalStrut(5);
		horizontalBox_26.add(horizontalStrut_79);

		final JLabel lblNewLabel_2 = new JLabel("Zombie Lore");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		horizontalBox_26.add(lblNewLabel_2);

		final Component horizontalStrut_80 = Box.createHorizontalStrut(5);
		horizontalBox_26.add(horizontalStrut_80);

		final Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		final GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.anchor = GridBagConstraints.WEST;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 1;
		this.contentPane.add(verticalBox, gbc_verticalBox);

		final Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		final Component horizontalStrut_9 = Box.createHorizontalStrut(5);
		horizontalBox_3.add(horizontalStrut_9);

		final JLabel lblZombieDensity = new JLabel("Zombie Density:");
		lblZombieDensity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZombieDensity.setVerticalAlignment(SwingConstants.BOTTOM);
		lblZombieDensity.setBackground(Color.WHITE);
		lblZombieDensity.setAlignmentX(0.5f);
		horizontalBox_3.add(lblZombieDensity);

		final Component horizontalStrut_7 = Box.createHorizontalStrut(31);
		horizontalBox_3.add(horizontalStrut_7);

		this.zombieDensityCB = new JComboBox<String>();
		this.zombieDensityCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieDensity(PZSEFrame.this.zombieDensityCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieDensityCB.setEnabled(false);
		this.zombieDensityCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Insane", "High", "Normal", "Low", "None"}));
		this.zombieDensityCB.setMaximumRowCount(5);
		horizontalBox_3.add(this.zombieDensityCB);

		final Component horizontalStrut_11 = Box.createHorizontalStrut(5);
		horizontalBox_3.add(horizontalStrut_11);

		final Component verticalStrut = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut);

		final Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		final Component horizontalStrut_6 = Box.createHorizontalStrut(5);
		horizontalBox_2.add(horizontalStrut_6);

		final JLabel lblZombieDistribution = new JLabel("Zombie Distribution:");
		lblZombieDistribution.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZombieDistribution.setVerticalAlignment(SwingConstants.BOTTOM);
		lblZombieDistribution.setBackground(Color.WHITE);
		lblZombieDistribution.setAlignmentX(0.5f);
		horizontalBox_2.add(lblZombieDistribution);

		final Component horizontalStrut_10 = Box.createHorizontalStrut(10);
		horizontalBox_2.add(horizontalStrut_10);

		this.zombieDistributionCB = new JComboBox<String>();
		this.zombieDistributionCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieDistribution(PZSEFrame.this.zombieDistributionCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieDistributionCB.setEnabled(false);
		this.zombieDistributionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Rural", "Uniform"}));
		this.zombieDistributionCB.setMaximumRowCount(2);
		horizontalBox_2.add(this.zombieDistributionCB);

		final Component horizontalStrut_8 = Box.createHorizontalStrut(5);
		horizontalBox_2.add(horizontalStrut_8);

		final Component verticalStrut_1 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_1);

		final Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		final Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		horizontalBox_1.add(horizontalStrut_3);

		final JLabel lblSurvivors = new JLabel("Survivors:");
		lblSurvivors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurvivors.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSurvivors.setBackground(Color.WHITE);
		lblSurvivors.setAlignmentX(0.5f);
		horizontalBox_1.add(lblSurvivors);

		final Component horizontalStrut_4 = Box.createHorizontalStrut(67);
		horizontalBox_1.add(horizontalStrut_4);

		this.survivorsCB = new JComboBox<String>();
		this.survivorsCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setSurvivors(PZSEFrame.this.survivorsCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.survivorsCB.setModel(new DefaultComboBoxModel<String>(new String[] {"None"}));
		this.survivorsCB.setMaximumRowCount(1);
		this.survivorsCB.setEnabled(false);
		horizontalBox_1.add(this.survivorsCB);

		final Component horizontalStrut_5 = Box.createHorizontalStrut(5);
		horizontalBox_1.add(horizontalStrut_5);

		final Component verticalStrut_2 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_2);

		final Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		final Component horizontalStrut_12 = Box.createHorizontalStrut(5);
		horizontalBox_4.add(horizontalStrut_12);

		final JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeed.setBackground(Color.WHITE);
		lblSpeed.setAlignmentX(0.5f);
		horizontalBox_4.add(lblSpeed);

		final Component horizontalStrut_13 = Box.createHorizontalStrut(80);
		horizontalBox_4.add(horizontalStrut_13);

		this.speedCB = new JComboBox<String>();
		this.speedCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setSpeed(PZSEFrame.this.speedCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.speedCB.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		this.speedCB.setMaximumRowCount(5);
		this.speedCB.setEnabled(false);
		horizontalBox_4.add(this.speedCB);

		final Component horizontalStrut_14 = Box.createHorizontalStrut(5);
		horizontalBox_4.add(horizontalStrut_14);

		final Component verticalStrut_3 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_3);

		final Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);

		final Component horizontalStrut_15 = Box.createHorizontalStrut(5);
		horizontalBox_5.add(horizontalStrut_15);

		final JLabel lblDayLength = new JLabel("Day Length:");
		lblDayLength.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDayLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDayLength.setBackground(Color.WHITE);
		lblDayLength.setAlignmentX(0.5f);
		horizontalBox_5.add(lblDayLength);

		final Component horizontalStrut_16 = Box.createHorizontalStrut(52);
		horizontalBox_5.add(horizontalStrut_16);

		this.dayLengthCB = new JComboBox<String>();
		this.dayLengthCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setDayLength(PZSEFrame.this.dayLengthCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.dayLengthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"1/2 Hour", "1 Hour", "2 Hours", "3 Hours", "4 Hours", "5 Hours", "12 Hours", "Real-Time"}));
		this.dayLengthCB.setEnabled(false);
		horizontalBox_5.add(this.dayLengthCB);

		final Component horizontalStrut_17 = Box.createHorizontalStrut(5);
		horizontalBox_5.add(horizontalStrut_17);

		final Component verticalStrut_4 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_4);

		final Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);

		final Component horizontalStrut_18 = Box.createHorizontalStrut(5);
		horizontalBox_6.add(horizontalStrut_18);

		final JLabel lblStartMonth = new JLabel("Start Month:");
		lblStartMonth.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStartMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartMonth.setBackground(Color.WHITE);
		lblStartMonth.setAlignmentX(0.5f);
		horizontalBox_6.add(lblStartMonth);

		final Component horizontalStrut_19 = Box.createHorizontalStrut(49);
		horizontalBox_6.add(horizontalStrut_19);

		this.startMonthCB = new JComboBox<String>();
		this.startMonthCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setStartMonth(PZSEFrame.this.startMonthCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.startMonthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		this.startMonthCB.setMaximumRowCount(12);
		this.startMonthCB.setEnabled(false);
		horizontalBox_6.add(this.startMonthCB);

		final Component horizontalStrut_20 = Box.createHorizontalStrut(5);
		horizontalBox_6.add(horizontalStrut_20);

		final Component verticalStrut_5 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_5);

		final Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);

		final Component horizontalStrut_21 = Box.createHorizontalStrut(5);
		horizontalBox_7.add(horizontalStrut_21);

		final JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartTime.setBackground(Color.WHITE);
		lblStartTime.setAlignmentX(0.5f);
		horizontalBox_7.add(lblStartTime);

		final Component horizontalStrut_22 = Box.createHorizontalStrut(57);
		horizontalBox_7.add(horizontalStrut_22);

		this.startTimeCB = new JComboBox<String>();
		this.startTimeCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setStartTime(PZSEFrame.this.startTimeCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.startTimeCB.setModel(new DefaultComboBoxModel<String>(new String[] {"7 am", "9 am", "12 pm", "2 pm", "5 pm", "9 pm", "12 am", "2 am", "5 am"}));
		this.startTimeCB.setMaximumRowCount(9);
		this.startTimeCB.setEnabled(false);
		horizontalBox_7.add(this.startTimeCB);

		final Component horizontalStrut_23 = Box.createHorizontalStrut(5);
		horizontalBox_7.add(horizontalStrut_23);

		final Component verticalStrut_6 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_6);

		final Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_8);

		final Component horizontalStrut_24 = Box.createHorizontalStrut(5);
		horizontalBox_8.add(horizontalStrut_24);

		final JLabel lblWaterShutoff = new JLabel("Water Shutoff:");
		lblWaterShutoff.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWaterShutoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWaterShutoff.setBackground(Color.WHITE);
		lblWaterShutoff.setAlignmentX(0.5f);
		horizontalBox_8.add(lblWaterShutoff);

		final Component horizontalStrut_25 = Box.createHorizontalStrut(36);
		horizontalBox_8.add(horizontalStrut_25);

		final String[] lots = new String[1801];
		for(int i = 0; i < 1801; i++) {
			lots[i] = Integer.toString(i);
		}

		this.waterShutoffCB = new JComboBox<String>();
		this.waterShutoffCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setWaterShutoff(PZSEFrame.this.waterShutoffCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.waterShutoffCB.setModel(new DefaultComboBoxModel<String>(lots));
		this.waterShutoffCB.setMaximumRowCount(6);
		this.waterShutoffCB.setEnabled(false);
		horizontalBox_8.add(this.waterShutoffCB);

		final Component horizontalStrut_26 = Box.createHorizontalStrut(5);
		horizontalBox_8.add(horizontalStrut_26);

		final Component verticalStrut_7 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_7);

		final Box horizontalBox_9 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_9);

		final Component horizontalStrut_27 = Box.createHorizontalStrut(5);
		horizontalBox_9.add(horizontalStrut_27);

		final JLabel lblElectricShutoff = new JLabel("Electric Shutoff:");
		lblElectricShutoff.setVerticalAlignment(SwingConstants.BOTTOM);
		lblElectricShutoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElectricShutoff.setBackground(Color.WHITE);
		lblElectricShutoff.setAlignmentX(0.5f);
		horizontalBox_9.add(lblElectricShutoff);

		final Component horizontalStrut_28 = Box.createHorizontalStrut(31);
		horizontalBox_9.add(horizontalStrut_28);

		this.electricShutoffCB = new JComboBox<String>();
		this.electricShutoffCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setElectricShutoff(PZSEFrame.this.electricShutoffCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.electricShutoffCB.setModel(new DefaultComboBoxModel<String>(lots));
		this.electricShutoffCB.setMaximumRowCount(6);
		this.electricShutoffCB.setEnabled(false);
		horizontalBox_9.add(this.electricShutoffCB);

		final Component horizontalStrut_29 = Box.createHorizontalStrut(5);
		horizontalBox_9.add(horizontalStrut_29);

		final Component verticalStrut_8 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_8);

		final Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_10);

		final Component horizontalStrut_30 = Box.createHorizontalStrut(5);
		horizontalBox_10.add(horizontalStrut_30);

		final JLabel lblLoot = new JLabel("Loot:");
		lblLoot.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLoot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoot.setBackground(Color.WHITE);
		lblLoot.setAlignmentX(0.5f);
		horizontalBox_10.add(lblLoot);

		final Component horizontalStrut_31 = Box.createHorizontalStrut(90);
		horizontalBox_10.add(horizontalStrut_31);

		this.lootAmountCB = new JComboBox<String>();
		this.lootAmountCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setLootAmount(PZSEFrame.this.lootAmountCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.lootAmountCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Extremely Rare", "Rare", "Normal", "Common", "Abundant"}));
		this.lootAmountCB.setMaximumRowCount(5);
		this.lootAmountCB.setEnabled(false);
		horizontalBox_10.add(this.lootAmountCB);

		final Component horizontalStrut_32 = Box.createHorizontalStrut(5);
		horizontalBox_10.add(horizontalStrut_32);

		final Component verticalStrut_9 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_9);

		final Box horizontalBox_11 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_11);

		final Component horizontalStrut_33 = Box.createHorizontalStrut(5);
		horizontalBox_11.add(horizontalStrut_33);

		final JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemperature.setBackground(Color.WHITE);
		lblTemperature.setAlignmentX(0.5f);
		horizontalBox_11.add(lblTemperature);

		final Component horizontalStrut_34 = Box.createHorizontalStrut(43);
		horizontalBox_11.add(horizontalStrut_34);

		this.temperatureCB = new JComboBox<String>();
		this.temperatureCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setTemperature(PZSEFrame.this.temperatureCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.temperatureCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Very Cold", "Cold", "Normal", "Hot", "Very Hot"}));
		this.temperatureCB.setMaximumRowCount(5);
		this.temperatureCB.setEnabled(false);
		horizontalBox_11.add(this.temperatureCB);

		final Component horizontalStrut_35 = Box.createHorizontalStrut(5);
		horizontalBox_11.add(horizontalStrut_35);

		final Component verticalStrut_10 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_10);

		final Box horizontalBox_12 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_12);

		final Component horizontalStrut_36 = Box.createHorizontalStrut(5);
		horizontalBox_12.add(horizontalStrut_36);

		final JLabel lblRain = new JLabel("Rain:");
		lblRain.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRain.setBackground(Color.WHITE);
		lblRain.setAlignmentX(0.5f);
		horizontalBox_12.add(lblRain);

		final Component horizontalStrut_37 = Box.createHorizontalStrut(93);
		horizontalBox_12.add(horizontalStrut_37);

		this.rainCB = new JComboBox<String>();
		this.rainCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setRain(PZSEFrame.this.rainCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.rainCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Very Dry", "Dry", "Normal", "Rainy", "Very Rainy"}));
		this.rainCB.setMaximumRowCount(5);
		this.rainCB.setEnabled(false);
		horizontalBox_12.add(this.rainCB);

		final Component horizontalStrut_38 = Box.createHorizontalStrut(5);
		horizontalBox_12.add(horizontalStrut_38);

		final Component verticalStrut_11 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_11);

		final Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		final GridBagConstraints gbc_verticalBox_1 = new GridBagConstraints();
		gbc_verticalBox_1.anchor = GridBagConstraints.WEST;
		gbc_verticalBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox_1.gridx = 2;
		gbc_verticalBox_1.gridy = 1;
		this.contentPane.add(verticalBox_1, gbc_verticalBox_1);

		final Box horizontalBox_13 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_13);

		final Component horizontalStrut_39 = Box.createHorizontalStrut(5);
		horizontalBox_13.add(horizontalStrut_39);

		final JLabel lblSpeed_1 = new JLabel("Speed:");
		lblSpeed_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeed_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeed_1.setBackground(Color.WHITE);
		lblSpeed_1.setAlignmentX(0.5f);
		horizontalBox_13.add(lblSpeed_1);

		final Component horizontalStrut_40 = Box.createHorizontalStrut(80);
		horizontalBox_13.add(horizontalStrut_40);

		this.zombieSpeedCB = new JComboBox<String>();
		this.zombieSpeedCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieSpeed(PZSEFrame.this.zombieSpeedCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieSpeedCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Sprinters", "Fast Shamblers", "Shamblers"}));
		this.zombieSpeedCB.setMaximumRowCount(3);
		this.zombieSpeedCB.setEnabled(false);
		horizontalBox_13.add(this.zombieSpeedCB);

		final Component horizontalStrut_41 = Box.createHorizontalStrut(5);
		horizontalBox_13.add(horizontalStrut_41);

		final Component verticalStrut_12 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_12);

		final Box horizontalBox_14 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_14);

		final Component horizontalStrut_42 = Box.createHorizontalStrut(5);
		horizontalBox_14.add(horizontalStrut_42);

		final JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStrength.setBackground(Color.WHITE);
		lblStrength.setAlignmentX(0.5f);
		horizontalBox_14.add(lblStrength);

		final Component horizontalStrut_43 = Box.createHorizontalStrut(66);
		horizontalBox_14.add(horizontalStrut_43);

		this.zombieStrengthCB = new JComboBox<String>();
		this.zombieStrengthCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieStrength(PZSEFrame.this.zombieStrengthCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieStrengthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Superhuman", "Normal", "Weak"}));
		this.zombieStrengthCB.setMaximumRowCount(3);
		this.zombieStrengthCB.setEnabled(false);
		horizontalBox_14.add(this.zombieStrengthCB);

		final Component horizontalStrut_44 = Box.createHorizontalStrut(5);
		horizontalBox_14.add(horizontalStrut_44);

		final Component verticalStrut_13 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_13);

		final Box horizontalBox_15 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_15);

		final Component horizontalStrut_45 = Box.createHorizontalStrut(5);
		horizontalBox_15.add(horizontalStrut_45);

		final JLabel lblToughness = new JLabel("Toughness:");
		lblToughness.setVerticalAlignment(SwingConstants.BOTTOM);
		lblToughness.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblToughness.setBackground(Color.WHITE);
		lblToughness.setAlignmentX(0.5f);
		horizontalBox_15.add(lblToughness);

		final Component horizontalStrut_46 = Box.createHorizontalStrut(55);
		horizontalBox_15.add(horizontalStrut_46);

		this.zombieToughnessCB = new JComboBox<String>();
		this.zombieToughnessCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieToughness(PZSEFrame.this.zombieToughnessCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieToughnessCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Tough", "Normal", "Fragile"}));
		this.zombieToughnessCB.setMaximumRowCount(3);
		this.zombieToughnessCB.setEnabled(false);
		horizontalBox_15.add(this.zombieToughnessCB);

		final Component horizontalStrut_47 = Box.createHorizontalStrut(5);
		horizontalBox_15.add(horizontalStrut_47);

		final Component verticalStrut_14 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_14);

		final Box horizontalBox_16 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_16);

		final Component horizontalStrut_48 = Box.createHorizontalStrut(5);
		horizontalBox_16.add(horizontalStrut_48);

		final JLabel lblTransmission = new JLabel("Transmission:");
		lblTransmission.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTransmission.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTransmission.setBackground(Color.WHITE);
		lblTransmission.setAlignmentX(0.5f);
		horizontalBox_16.add(lblTransmission);

		final Component horizontalStrut_49 = Box.createHorizontalStrut(47);
		horizontalBox_16.add(horizontalStrut_49);

		this.zombieTransmissionCB = new JComboBox<String>();
		this.zombieTransmissionCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieInfectionTransmission(PZSEFrame.this.zombieTransmissionCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieTransmissionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Blood + Saliva", "Everyone's Infected", "None"}));
		this.zombieTransmissionCB.setMaximumRowCount(3);
		this.zombieTransmissionCB.setEnabled(false);
		horizontalBox_16.add(this.zombieTransmissionCB);

		final Component horizontalStrut_50 = Box.createHorizontalStrut(5);
		horizontalBox_16.add(horizontalStrut_50);

		final Component verticalStrut_15 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_15);

		final Box horizontalBox_17 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_17);

		final Component horizontalStrut_51 = Box.createHorizontalStrut(5);
		horizontalBox_17.add(horizontalStrut_51);

		final JLabel lblMortality = new JLabel("Infection Mortality:");
		lblMortality.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMortality.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMortality.setBackground(Color.WHITE);
		lblMortality.setAlignmentX(0.5f);
		horizontalBox_17.add(lblMortality);

		final Component horizontalStrut_52 = Box.createHorizontalStrut(16);
		horizontalBox_17.add(horizontalStrut_52);

		this.zombieMortalityCB = new JComboBox<String>();
		this.zombieMortalityCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieInfectionMortality(PZSEFrame.this.zombieMortalityCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieMortalityCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Instant", "30 Seconds", "1 Minute", "12 Hours", "2-3 Days", "1-2 Weeks"}));
		this.zombieMortalityCB.setMaximumRowCount(6);
		this.zombieMortalityCB.setEnabled(false);
		horizontalBox_17.add(this.zombieMortalityCB);

		final Component horizontalStrut_53 = Box.createHorizontalStrut(5);
		horizontalBox_17.add(horizontalStrut_53);

		final Component verticalStrut_16 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_16);

		final Box horizontalBox_18 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_18);

		final Component horizontalStrut_54 = Box.createHorizontalStrut(5);
		horizontalBox_18.add(horizontalStrut_54);

		final JLabel lblReanimate = new JLabel("Reanimation Time:");
		lblReanimate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblReanimate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReanimate.setBackground(Color.WHITE);
		lblReanimate.setAlignmentX(0.5f);
		horizontalBox_18.add(lblReanimate);

		final Component horizontalStrut_55 = Box.createHorizontalStrut(18);
		horizontalBox_18.add(horizontalStrut_55);

		this.zombieReanimationCB = new JComboBox<String>();
		this.zombieReanimationCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieReanimate(PZSEFrame.this.zombieReanimationCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieReanimationCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Instant", "30 Seconds", "1 Minute", "12 Hours", "2-3 Days", "1-2 Weeks"}));
		this.zombieReanimationCB.setMaximumRowCount(6);
		this.zombieReanimationCB.setEnabled(false);
		horizontalBox_18.add(this.zombieReanimationCB);

		final Component horizontalStrut_56 = Box.createHorizontalStrut(5);
		horizontalBox_18.add(horizontalStrut_56);

		final Component verticalStrut_17 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_17);

		final Box horizontalBox_19 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_19);

		final Component horizontalStrut_57 = Box.createHorizontalStrut(5);
		horizontalBox_19.add(horizontalStrut_57);

		final JLabel lblCognition = new JLabel("Cognition:");
		lblCognition.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCognition.setBackground(Color.WHITE);
		lblCognition.setAlignmentX(0.5f);
		horizontalBox_19.add(lblCognition);

		final Component horizontalStrut_58 = Box.createHorizontalStrut(64);
		horizontalBox_19.add(horizontalStrut_58);

		this.zombieCognitionCB = new JComboBox<String>();
		this.zombieCognitionCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieCognition(PZSEFrame.this.zombieCognitionCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieCognitionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Navigate + Use Doors", "Navigate", "Basic Navigation"}));
		this.zombieCognitionCB.setMaximumRowCount(3);
		this.zombieCognitionCB.setEnabled(false);
		horizontalBox_19.add(this.zombieCognitionCB);

		final Component horizontalStrut_59 = Box.createHorizontalStrut(5);
		horizontalBox_19.add(horizontalStrut_59);

		final Component verticalStrut_18 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_18);

		final Box horizontalBox_20 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_20);

		final Component horizontalStrut_60 = Box.createHorizontalStrut(5);
		horizontalBox_20.add(horizontalStrut_60);

		final JLabel lblCognition_1 = new JLabel("Memory:");
		lblCognition_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognition_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCognition_1.setBackground(Color.WHITE);
		lblCognition_1.setAlignmentX(0.5f);
		horizontalBox_20.add(lblCognition_1);

		final Component horizontalStrut_61 = Box.createHorizontalStrut(72);
		horizontalBox_20.add(horizontalStrut_61);

		this.zombieMemoryCB = new JComboBox<String>();
		this.zombieMemoryCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieMemory(PZSEFrame.this.zombieMemoryCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieMemoryCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Long", "Normal", "Short", "None"}));
		this.zombieMemoryCB.setMaximumRowCount(4);
		this.zombieMemoryCB.setEnabled(false);
		horizontalBox_20.add(this.zombieMemoryCB);

		final Component horizontalStrut_62 = Box.createHorizontalStrut(5);
		horizontalBox_20.add(horizontalStrut_62);

		final Component verticalStrut_19 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_19);

		final Box horizontalBox_21 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_21);

		final Component horizontalStrut_63 = Box.createHorizontalStrut(5);
		horizontalBox_21.add(horizontalStrut_63);

		final JLabel lblDecomp = new JLabel("Decompisition:");
		lblDecomp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDecomp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDecomp.setBackground(Color.WHITE);
		lblDecomp.setAlignmentX(0.5f);
		horizontalBox_21.add(lblDecomp);

		final Component horizontalStrut_64 = Box.createHorizontalStrut(40);
		horizontalBox_21.add(horizontalStrut_64);

		this.zombieDecompisitionCB = new JComboBox<String>();
		this.zombieDecompisitionCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieDecomp(PZSEFrame.this.zombieDecompisitionCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieDecompisitionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Slows + Weakens", "Slows", "Weakens", "No Effect"}));
		this.zombieDecompisitionCB.setMaximumRowCount(4);
		this.zombieDecompisitionCB.setEnabled(false);
		horizontalBox_21.add(this.zombieDecompisitionCB);

		final Component horizontalStrut_65 = Box.createHorizontalStrut(5);
		horizontalBox_21.add(horizontalStrut_65);

		final Component verticalStrut_20 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_20);

		final Box horizontalBox_22 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_22);

		final Component horizontalStrut_66 = Box.createHorizontalStrut(5);
		horizontalBox_22.add(horizontalStrut_66);

		final JLabel lblSight = new JLabel("Sight:");
		lblSight.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSight.setBackground(Color.WHITE);
		lblSight.setAlignmentX(0.5f);
		horizontalBox_22.add(lblSight);

		final Component horizontalStrut_67 = Box.createHorizontalStrut(87);
		horizontalBox_22.add(horizontalStrut_67);

		this.zombieSightCB = new JComboBox<String>();
		this.zombieSightCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieSight(PZSEFrame.this.zombieSightCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieSightCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Eagle", "Normal", "Poor"}));
		this.zombieSightCB.setMaximumRowCount(3);
		this.zombieSightCB.setEnabled(false);
		horizontalBox_22.add(this.zombieSightCB);

		final Component horizontalStrut_68 = Box.createHorizontalStrut(5);
		horizontalBox_22.add(horizontalStrut_68);

		final Component verticalStrut_21 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_21);

		final Box horizontalBox_23 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_23);

		final Component horizontalStrut_69 = Box.createHorizontalStrut(5);
		horizontalBox_23.add(horizontalStrut_69);

		final JLabel lblHearing = new JLabel("Hearing:");
		lblHearing.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHearing.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHearing.setBackground(Color.WHITE);
		lblHearing.setAlignmentX(0.5f);
		horizontalBox_23.add(lblHearing);

		final Component horizontalStrut_70 = Box.createHorizontalStrut(74);
		horizontalBox_23.add(horizontalStrut_70);

		this.zombieHearingCB = new JComboBox<String>();
		this.zombieHearingCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieHearing(PZSEFrame.this.zombieHearingCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieHearingCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Pinpoint", "Normal", "Poor"}));
		this.zombieHearingCB.setMaximumRowCount(3);
		this.zombieHearingCB.setEnabled(false);
		horizontalBox_23.add(this.zombieHearingCB);

		final Component horizontalStrut_71 = Box.createHorizontalStrut(5);
		horizontalBox_23.add(horizontalStrut_71);

		final Component verticalStrut_22 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_22);

		final Box horizontalBox_24 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_24);

		final Component horizontalStrut_72 = Box.createHorizontalStrut(5);
		horizontalBox_24.add(horizontalStrut_72);

		final JLabel lblSmell = new JLabel("Smell:");
		lblSmell.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSmell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSmell.setBackground(Color.WHITE);
		lblSmell.setAlignmentX(0.5f);
		horizontalBox_24.add(lblSmell);

		final Component horizontalStrut_73 = Box.createHorizontalStrut(87);
		horizontalBox_24.add(horizontalStrut_73);

		this.zombieSmellCB = new JComboBox<String>();
		this.zombieSmellCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PZSEFrame.this.worldValues.setZombieSmell(PZSEFrame.this.zombieSmellCB.getSelectedIndex() + 1);
				if(PZSEFrame.this.worldValues.hasChanged()) {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName + " *");
					PZSEFrame.this.fileMenuSave.setEnabled(true);
				} else {
					PZSEFrame.this.setTitle(PZSEFrame.this.windowTitle + " - " + PZSEFrame.this.worldName);
					PZSEFrame.this.fileMenuSave.setEnabled(false);
				}
			}
		});
		this.zombieSmellCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Bloodhound", "Normal", "Poor"}));
		this.zombieSmellCB.setMaximumRowCount(3);
		this.zombieSmellCB.setEnabled(false);
		horizontalBox_24.add(this.zombieSmellCB);

		final Component horizontalStrut_74 = Box.createHorizontalStrut(5);
		horizontalBox_24.add(horizontalStrut_74);

		final Component verticalStrut_23 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_23);

		final Box horizontalBox_25 = Box.createHorizontalBox();
		horizontalBox_25.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		final GridBagConstraints gbc_horizontalBox_25 = new GridBagConstraints();
		gbc_horizontalBox_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalBox_25.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_25.gridx = 0;
		gbc_horizontalBox_25.gridy = 2;
		this.contentPane.add(horizontalBox_25, gbc_horizontalBox_25);

		final Component horizontalStrut_75 = Box.createHorizontalStrut(5);
		horizontalBox_25.add(horizontalStrut_75);

		final JLabel lblNewLabel_1 = new JLabel("Advanced Settings:");
		horizontalBox_25.add(lblNewLabel_1);

		final Component horizontalStrut_76 = Box.createHorizontalStrut(20);
		horizontalBox_25.add(horizontalStrut_76);

		this.enableAdvancedOptionsGroup = new ButtonGroup();

		this.enableAdvancedYes = new JRadioButton("Yes");
		this.enableAdvancedYes.setToolTipText("Enable Advanced Settings");
		this.enableAdvancedYes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				PZSEFrame.this.enableAdvanced();
			}
		});
		horizontalBox_25.add(this.enableAdvancedYes);

		final Component horizontalStrut_78 = Box.createHorizontalStrut(1);
		horizontalBox_25.add(horizontalStrut_78);

		this.enableAdvancedNo = new JRadioButton("No");
		this.enableAdvancedNo.setToolTipText("Disable Advanced Settings");
		this.enableAdvancedNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				PZSEFrame.this.disableAdvanced();
			}
		});
		this.enableAdvancedNo.setSelected(true);
		horizontalBox_25.add(this.enableAdvancedNo);

		this.enableAdvancedOptionsGroup.add(this.enableAdvancedNo);
		this.enableAdvancedOptionsGroup.add(this.enableAdvancedYes);

		final Component horizontalStrut_77 = Box.createHorizontalStrut(5);
		horizontalBox_25.add(horizontalStrut_77);

		final Box horizontalBox_27 = Box.createHorizontalBox();
		horizontalBox_27.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		final GridBagConstraints gbc_horizontalBox_27 = new GridBagConstraints();
		gbc_horizontalBox_27.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_27.gridx = 2;
		gbc_horizontalBox_27.gridy = 2;
		this.contentPane.add(horizontalBox_27, gbc_horizontalBox_27);

		this.properZombiesButton = new JButton("Proper Zombies");
		this.properZombiesButton.setEnabled(false);
		this.properZombiesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				PZSEFrame.this.properZombies();
			}
		});
		this.properZombiesButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		horizontalBox_27.add(this.properZombiesButton);

		this.resetAllButton = new JButton("Reset All");
		this.resetAllButton.setEnabled(false);
		this.resetAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				PZSEFrame.this.firstTime();
			}
		});
		this.resetAllButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		horizontalBox_27.add(this.resetAllButton);

		this.setTitle(this.windowTitle);
	}

	private void createMenu() {
		final JMenuBar menuBar = new JMenuBar();
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem fileMenuOpen = new JMenuItem("Open File...");
		final JSeparator separator = new JSeparator();
		this.fileMenuSave = new JMenuItem("Save");
		this.fileMenuSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final int confirm = JOptionPane.showConfirmDialog(PZSEFrame.this.pzseFrame, "Are you sure you want to overwrite the current world options?", "Confirm Overwrite", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					Util.saveSandbox(PZSEFrame.this.worldFile, PZSEFrame.this.worldValues);
					JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, "World options saved successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					PZSEFrame.this.reloadWorld();
				}
			}
		});
		this.fileMenuSave.setEnabled(false);
		this.fileMenuSaveAs = new JMenuItem("Save As...");
		this.fileMenuSaveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean complete = false;
				File prevLocation = null;
				while(!complete) {
					final JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Please choose a file to save to.");
					if(prevLocation != null) {
						fc.setCurrentDirectory(prevLocation);
					}
					if(fc.showSaveDialog(PZSEFrame.this.pzseFrame) == JFileChooser.APPROVE_OPTION) {
						if(fc.getSelectedFile().isDirectory()) {
							JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, "Please choose a file to save to, not a directory.", "Invalid save location.", JOptionPane.WARNING_MESSAGE);
							prevLocation = fc.getSelectedFile();
						} else {
							if(fc.getSelectedFile().exists()) {
								final int confirm = JOptionPane.showConfirmDialog(PZSEFrame.this.contentPane, "Are you sure you want to overwrite the chosen file?", "Confirm Overwrite", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(confirm == JOptionPane.YES_OPTION) {
									Util.saveSandbox(PZSEFrame.this.worldFile, PZSEFrame.this.worldValues);
									JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, "World options saved successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
									complete = true;
								} else {
									JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, "Please choose a different file.", "Overwrite cancelled.", JOptionPane.INFORMATION_MESSAGE);
									prevLocation = fc.getSelectedFile().getParentFile();
								}
							} else {
								Util.saveSandbox(fc.getSelectedFile(), PZSEFrame.this.worldValues);
								JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, "World options saved successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
								complete = true;
							}
						}
					} else {
						complete = true;
					}
				}
			}
		});
		this.fileMenuSaveAs.setEnabled(false);
		final JSeparator separator_1 = new JSeparator();
		final JMenuItem fileMenuExit = new JMenuItem("Quit");

		fileMenuOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PZSEFrame.this.openFile();
			}
		});
		fileMenuExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final int confirm = JOptionPane.showConfirmDialog(PZSEFrame.this.contentPane, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(fileMenuOpen);
		fileMenu.add(separator);
		fileMenu.add(this.fileMenuSave);
		fileMenu.add(this.fileMenuSaveAs);
		fileMenu.add(separator_1);
		fileMenu.add(fileMenuExit);

		final JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		final JMenuItem helpMenuAbout = new JMenuItem("About");
		helpMenuAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(PZSEFrame.this.pzseFrame, Util.copyright, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		helpMenu.add(helpMenuAbout);
	}

	private void disableAdvanced() {
		if(this.worldIsLoaded) {
			this.startMonthCB.setEnabled(false);
			this.startTimeCB.setEnabled(false);
			this.electricShutoffCB.setEnabled(false);
			this.waterShutoffCB.setEnabled(false);
			this.speedCB.setEnabled(false);
		}
	}

	private void enableAdvanced() {
		if(this.worldIsLoaded) {
			this.startMonthCB.setEnabled(true);
			this.startTimeCB.setEnabled(true);
			this.electricShutoffCB.setEnabled(true);
			this.waterShutoffCB.setEnabled(true);
			this.speedCB.setEnabled(true);
		}
	}

	private void firstTime() {
		this.worldVersionLabel.setText(Integer.toString(this.worldValues.getWorldVersion()));
		this.zombieDensityCB.setSelectedIndex(this.worldValues.getOrigZombieDensity() - 1);
		this.zombieDistributionCB.setSelectedIndex(this.worldValues.getOrigZombieDistribution() - 1);
		this.speedCB.setSelectedIndex(this.worldValues.getOrigSpeed() - 1);
		this.dayLengthCB.setSelectedIndex(this.worldValues.getOrigDayLength() - 1);
		this.startMonthCB.setSelectedIndex(this.worldValues.getOrigStartMonth() - 1);
		this.startTimeCB.setSelectedIndex(this.worldValues.getOrigStartTime() - 1);
		this.waterShutoffCB.setSelectedIndex(this.worldValues.getOrigWaterShutoff() - 1);
		this.electricShutoffCB.setSelectedIndex(this.worldValues.getOrigElectricShutoff() - 1);
		this.lootAmountCB.setSelectedIndex(this.worldValues.getOrigLootAmount() - 1);
		this.temperatureCB.setSelectedIndex(this.worldValues.getOrigTemperature() - 1);
		this.rainCB.setSelectedIndex(this.worldValues.getOrigRain() - 1);
		this.zombieSpeedCB.setSelectedIndex(this.worldValues.getOrigZombieSpeed() - 1);
		this.zombieStrengthCB.setSelectedIndex(this.worldValues.getOrigZombieStrength() - 1);
		this.zombieToughnessCB.setSelectedIndex(this.worldValues.getOrigZombieToughness() - 1);
		this.zombieTransmissionCB.setSelectedIndex(this.worldValues.getOrigZombieInfectionTransmission() - 1);
		this.zombieMortalityCB.setSelectedIndex(this.worldValues.getOrigZombieInfectionMortality() - 1);
		this.zombieReanimationCB.setSelectedIndex(this.worldValues.getOrigZombieReanimate() - 1);
		this.zombieCognitionCB.setSelectedIndex(this.worldValues.getOrigZombieCognition() - 1);
		this.zombieMemoryCB.setSelectedIndex(this.worldValues.getOrigZombieMemory() - 1);
		this.zombieDecompisitionCB.setSelectedIndex(this.worldValues.getOrigZombieDecomp() - 1);
		this.zombieSightCB.setSelectedIndex(this.worldValues.getOrigZombieSight() - 1);
		this.zombieHearingCB.setSelectedIndex(this.worldValues.getOrigZombieHearing() - 1);
		this.zombieSmellCB.setSelectedIndex(this.worldValues.getOrigZombieSmell() - 1);
		this.zombieDensityCB.setEnabled(true);
		this.zombieDistributionCB.setEnabled(true);
		this.dayLengthCB.setEnabled(true);
		this.lootAmountCB.setEnabled(true);
		this.temperatureCB.setEnabled(true);
		this.rainCB.setEnabled(true);
		this.zombieSpeedCB.setEnabled(true);
		this.zombieStrengthCB.setEnabled(true);
		this.zombieToughnessCB.setEnabled(true);
		this.zombieTransmissionCB.setEnabled(true);
		this.zombieMortalityCB.setEnabled(true);
		this.zombieReanimationCB.setEnabled(true);
		this.zombieCognitionCB.setEnabled(true);
		this.zombieMemoryCB.setEnabled(true);
		this.zombieDecompisitionCB.setEnabled(true);
		this.zombieSightCB.setEnabled(true);
		this.zombieHearingCB.setEnabled(true);
		this.zombieSmellCB.setEnabled(true);
		if(this.enableAdvancedYes.isSelected()) {
			this.enableAdvanced();
		}
		this.resetAllButton.setEnabled(true);
		this.properZombiesButton.setEnabled(true);
		this.fileMenuSaveAs.setEnabled(true);
	}

	private void openFile() {
		final JFileChooser fc = new JFileChooser();
		fc.setDialogType(JFileChooser.OPEN_DIALOG);
		fc.setDialogTitle("Please select a world to edit.");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fc.showOpenDialog(this.pzseFrame) == JFileChooser.APPROVE_OPTION) {
			try {
				this.worldValues = Util.loadSandbox(fc.getSelectedFile());
			} catch(final OldWorldException e) {
				JOptionPane.showMessageDialog(this.pzseFrame, "The world you attempted to load isn't supported, sorry.", "World version not supported.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			this.worldName = fc.getSelectedFile().getName();
			this.worldFile = new File(fc.getSelectedFile() + File.separator + "map_sand.bin");
			this.firstTime();
			this.setTitle(this.windowTitle + " - " + this.worldName);
			this.worldIsLoaded = true;
		}
	}

	private void properZombies() {
		this.zombieCognitionCB.setSelectedIndex(Util.ProperZombieCognition - 1);
		this.zombieDecompisitionCB.setSelectedIndex(Util.ProperZombieDecomp - 1);
		this.zombieHearingCB.setSelectedIndex(Util.ProperZombieHearing - 1);
		this.zombieMemoryCB.setSelectedIndex(Util.ProperZombieMemory - 1);
		this.zombieMortalityCB.setSelectedIndex(Util.ProperZombieInfectionMortality - 1);
		this.zombieReanimationCB.setSelectedIndex(Util.ProperZombieReanimate - 1);
		this.zombieSightCB.setSelectedIndex(Util.ProperZombieSight - 1);
		this.zombieSmellCB.setSelectedIndex(Util.ProperZombieSmell - 1);
		this.zombieSpeedCB.setSelectedIndex(Util.ProperZombieSpeed - 1);
		this.zombieStrengthCB.setSelectedIndex(Util.ProperZombieStrength - 1);
		this.zombieTransmissionCB.setSelectedIndex(Util.ProperZombieInfectionTransmission - 1);
	}

	private void reloadWorld() {
		try {
			this.worldValues = Util.loadSandbox(this.worldFile);
		} catch(final OldWorldException e) {
			// Should NEVER happen. If it does, something has been modified. O_o
		}
		this.firstTime();
		this.setTitle(this.windowTitle + " - " + this.worldName);
		this.worldIsLoaded = true;
	}
}
