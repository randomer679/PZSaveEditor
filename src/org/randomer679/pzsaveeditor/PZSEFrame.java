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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class PZSEFrame extends JFrame {

	private JPanel contentPane;
	private JLabel worldVersionLabel;
	private JComboBox<String> zombieDensityCB;
	private JComboBox<String> zombieDistributionCB;
	private JComboBox<String> survivorsCB;
	private JComboBox<String> speedCB;
	private JComboBox<String> dayLengthCB;
	private JComboBox<String> startMonthCB;
	private JComboBox<String> startTimeCB;
	private JComboBox<String> waterShutoffCB;
	private JComboBox<String> electricShutoffCB;
	private JComboBox<String> lootAmountCB;
	private JComboBox<String> temperatureCB;
	private JComboBox<String> rainCB;
	private JComboBox<String> zombieSpeedCB;
	private JComboBox<String> zombieStrengthCB;
	private JComboBox<String> zombieToughnessCB;
	private JComboBox<String> zombieTransmissionCB;
	private JComboBox<String> zombieMortalityCB;
	private JComboBox<String> zombieReanimationCB;
	private JComboBox<String> zombieCognitionCB;
	private JComboBox<String> zombieMemoryCB;
	private JComboBox<String> zombieDecompisitionCB;
	private JComboBox<String> zombieSightCB;
	private JComboBox<String> zombieHearingCB;
	private JComboBox<String> zombieSmellCB;
	private ButtonGroup enableAdvancedOptionsGroup;
	private JRadioButton enableAdvancedYes;
	private JRadioButton enableAdvancedNo;
	private JButton properZombiesButton;
	private WorldValues worldValues;
	private JButton resetAllButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PZSEFrame frame = new PZSEFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PZSEFrame() {
		setResizable(false);
		WindowListener exitListener = new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		};
    	this.addWindowListener(exitListener);
    	this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 570, 450);
		
		this.createMenu();

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {46, 10};
		gbl_contentPane.rowHeights = new int[] {30, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox.anchor = GridBagConstraints.WEST;
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		contentPane.add(horizontalBox, gbc_horizontalBox);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut_2);
		
		JLabel lblNewLabel = new JLabel("World Version:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		horizontalBox.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut);
		
		worldVersionLabel = new JLabel("0");
		worldVersionLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		worldVersionLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		worldVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(worldVersionLabel);
		worldVersionLabel.setBackground(new Color(255, 255, 255));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		horizontalBox.add(horizontalStrut_1);
		
		Box horizontalBox_26 = Box.createHorizontalBox();
		horizontalBox_26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_horizontalBox_26 = new GridBagConstraints();
		gbc_horizontalBox_26.anchor = GridBagConstraints.WEST;
		gbc_horizontalBox_26.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalBox_26.gridx = 2;
		gbc_horizontalBox_26.gridy = 0;
		contentPane.add(horizontalBox_26, gbc_horizontalBox_26);
		
		Component horizontalStrut_79 = Box.createHorizontalStrut(5);
		horizontalBox_26.add(horizontalStrut_79);
		
		JLabel lblNewLabel_2 = new JLabel("Zombie Lore");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		horizontalBox_26.add(lblNewLabel_2);
		
		Component horizontalStrut_80 = Box.createHorizontalStrut(5);
		horizontalBox_26.add(horizontalStrut_80);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.anchor = GridBagConstraints.WEST;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 1;
		contentPane.add(verticalBox, gbc_verticalBox);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(5);
		horizontalBox_3.add(horizontalStrut_9);
		
		JLabel lblZombieDensity = new JLabel("Zombie Density:");
		lblZombieDensity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZombieDensity.setVerticalAlignment(SwingConstants.BOTTOM);
		lblZombieDensity.setBackground(Color.WHITE);
		lblZombieDensity.setAlignmentX(0.5f);
		horizontalBox_3.add(lblZombieDensity);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(31);
		horizontalBox_3.add(horizontalStrut_7);
		
		zombieDensityCB = new JComboBox<String>();
		zombieDensityCB.setEnabled(false);
		zombieDensityCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Insane", "High", "Normal", "Low", "None"}));
		zombieDensityCB.setMaximumRowCount(5);
		horizontalBox_3.add(zombieDensityCB);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(5);
		horizontalBox_3.add(horizontalStrut_11);
		
		Component verticalStrut = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(5);
		horizontalBox_2.add(horizontalStrut_6);
		
		JLabel lblZombieDistribution = new JLabel("Zombie Distribution:");
		lblZombieDistribution.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZombieDistribution.setVerticalAlignment(SwingConstants.BOTTOM);
		lblZombieDistribution.setBackground(Color.WHITE);
		lblZombieDistribution.setAlignmentX(0.5f);
		horizontalBox_2.add(lblZombieDistribution);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(10);
		horizontalBox_2.add(horizontalStrut_10);
		
		zombieDistributionCB = new JComboBox<String>();
		zombieDistributionCB.setEnabled(false);
		zombieDistributionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Rural", "Uniform"}));
		zombieDistributionCB.setMaximumRowCount(2);
		horizontalBox_2.add(zombieDistributionCB);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(5);
		horizontalBox_2.add(horizontalStrut_8);
		
		Component verticalStrut_1 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		horizontalBox_1.add(horizontalStrut_3);
		
		JLabel lblSurvivors = new JLabel("Survivors:");
		lblSurvivors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurvivors.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSurvivors.setBackground(Color.WHITE);
		lblSurvivors.setAlignmentX(0.5f);
		horizontalBox_1.add(lblSurvivors);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(67);
		horizontalBox_1.add(horizontalStrut_4);
		
		survivorsCB = new JComboBox<String>();
		survivorsCB.setModel(new DefaultComboBoxModel<String>(new String[] {"None"}));
		survivorsCB.setMaximumRowCount(1);
		survivorsCB.setEnabled(false);
		horizontalBox_1.add(survivorsCB);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(5);
		horizontalBox_1.add(horizontalStrut_5);
		
		Component verticalStrut_2 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(5);
		horizontalBox_4.add(horizontalStrut_12);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeed.setBackground(Color.WHITE);
		lblSpeed.setAlignmentX(0.5f);
		horizontalBox_4.add(lblSpeed);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(80);
		horizontalBox_4.add(horizontalStrut_13);
		
		speedCB = new JComboBox<String>();
		speedCB.setEditable(true);
		speedCB.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		speedCB.setMaximumRowCount(5);
		speedCB.setEnabled(false);
		horizontalBox_4.add(speedCB);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(5);
		horizontalBox_4.add(horizontalStrut_14);
		
		Component verticalStrut_3 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_3);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(5);
		horizontalBox_5.add(horizontalStrut_15);
		
		JLabel lblDayLength = new JLabel("Day Length:");
		lblDayLength.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDayLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDayLength.setBackground(Color.WHITE);
		lblDayLength.setAlignmentX(0.5f);
		horizontalBox_5.add(lblDayLength);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(52);
		horizontalBox_5.add(horizontalStrut_16);
		
		dayLengthCB = new JComboBox<String>();
		dayLengthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"1/2 Hour", "1 Hour", "2 Hours", "3 Hours", "4 Hours", "5 Hours", "12 Hours", "Real-Time"}));
		dayLengthCB.setEnabled(false);
		horizontalBox_5.add(dayLengthCB);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(5);
		horizontalBox_5.add(horizontalStrut_17);
		
		Component verticalStrut_4 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_4);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(5);
		horizontalBox_6.add(horizontalStrut_18);
		
		JLabel lblStartMonth = new JLabel("Start Month:");
		lblStartMonth.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStartMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartMonth.setBackground(Color.WHITE);
		lblStartMonth.setAlignmentX(0.5f);
		horizontalBox_6.add(lblStartMonth);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(49);
		horizontalBox_6.add(horizontalStrut_19);
		
		startMonthCB = new JComboBox<String>();
		startMonthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		startMonthCB.setMaximumRowCount(12);
		startMonthCB.setEnabled(false);
		horizontalBox_6.add(startMonthCB);
		
		Component horizontalStrut_20 = Box.createHorizontalStrut(5);
		horizontalBox_6.add(horizontalStrut_20);
		
		Component verticalStrut_5 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_5);
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);
		
		Component horizontalStrut_21 = Box.createHorizontalStrut(5);
		horizontalBox_7.add(horizontalStrut_21);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartTime.setBackground(Color.WHITE);
		lblStartTime.setAlignmentX(0.5f);
		horizontalBox_7.add(lblStartTime);
		
		Component horizontalStrut_22 = Box.createHorizontalStrut(57);
		horizontalBox_7.add(horizontalStrut_22);
		
		startTimeCB = new JComboBox<String>();
		startTimeCB.setModel(new DefaultComboBoxModel<String>(new String[] {"7 am", "9 am", "12 pm", "2 pm", "5 pm", "9 pm", "12 am", "2 am", "5 am"}));
		startTimeCB.setMaximumRowCount(9);
		startTimeCB.setEnabled(false);
		horizontalBox_7.add(startTimeCB);
		
		Component horizontalStrut_23 = Box.createHorizontalStrut(5);
		horizontalBox_7.add(horizontalStrut_23);
		
		Component verticalStrut_6 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_6);
		
		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_8);
		
		Component horizontalStrut_24 = Box.createHorizontalStrut(5);
		horizontalBox_8.add(horizontalStrut_24);
		
		JLabel lblWaterShutoff = new JLabel("Water Shutoff:");
		lblWaterShutoff.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWaterShutoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWaterShutoff.setBackground(Color.WHITE);
		lblWaterShutoff.setAlignmentX(0.5f);
		horizontalBox_8.add(lblWaterShutoff);
		
		Component horizontalStrut_25 = Box.createHorizontalStrut(36);
		horizontalBox_8.add(horizontalStrut_25);
		
		String[] lots = new String[1801];
		for(int i = 0; i < 1801; i++) {
			lots[i] = Integer.toString(i);
		}
		
		waterShutoffCB = new JComboBox<String>();
		waterShutoffCB.setModel(new DefaultComboBoxModel<String>(lots));
		waterShutoffCB.setMaximumRowCount(6);
		waterShutoffCB.setEnabled(false);
		horizontalBox_8.add(waterShutoffCB);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(5);
		horizontalBox_8.add(horizontalStrut_26);
		
		Component verticalStrut_7 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_7);
		
		Box horizontalBox_9 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_9);
		
		Component horizontalStrut_27 = Box.createHorizontalStrut(5);
		horizontalBox_9.add(horizontalStrut_27);
		
		JLabel lblElectricShutoff = new JLabel("Electric Shutoff:");
		lblElectricShutoff.setVerticalAlignment(SwingConstants.BOTTOM);
		lblElectricShutoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElectricShutoff.setBackground(Color.WHITE);
		lblElectricShutoff.setAlignmentX(0.5f);
		horizontalBox_9.add(lblElectricShutoff);
		
		Component horizontalStrut_28 = Box.createHorizontalStrut(31);
		horizontalBox_9.add(horizontalStrut_28);
		
		electricShutoffCB = new JComboBox<String>();
		electricShutoffCB.setModel(new DefaultComboBoxModel<String>(lots));
		electricShutoffCB.setMaximumRowCount(6);
		electricShutoffCB.setEnabled(false);
		horizontalBox_9.add(electricShutoffCB);
		
		
		Component horizontalStrut_29 = Box.createHorizontalStrut(5);
		horizontalBox_9.add(horizontalStrut_29);
		
		Component verticalStrut_8 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_8);
		
		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_10);
		
		Component horizontalStrut_30 = Box.createHorizontalStrut(5);
		horizontalBox_10.add(horizontalStrut_30);
		
		JLabel lblLoot = new JLabel("Loot:");
		lblLoot.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLoot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoot.setBackground(Color.WHITE);
		lblLoot.setAlignmentX(0.5f);
		horizontalBox_10.add(lblLoot);
		
		Component horizontalStrut_31 = Box.createHorizontalStrut(90);
		horizontalBox_10.add(horizontalStrut_31);
		
		lootAmountCB = new JComboBox<String>();
		lootAmountCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Extremely Rare", "Rare", "Normal", "Common", "Abundant"}));
		lootAmountCB.setMaximumRowCount(5);
		lootAmountCB.setEnabled(false);
		horizontalBox_10.add(lootAmountCB);
		
		Component horizontalStrut_32 = Box.createHorizontalStrut(5);
		horizontalBox_10.add(horizontalStrut_32);
		
		Component verticalStrut_9 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_9);
		
		Box horizontalBox_11 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_11);
		
		Component horizontalStrut_33 = Box.createHorizontalStrut(5);
		horizontalBox_11.add(horizontalStrut_33);
		
		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemperature.setBackground(Color.WHITE);
		lblTemperature.setAlignmentX(0.5f);
		horizontalBox_11.add(lblTemperature);
		
		Component horizontalStrut_34 = Box.createHorizontalStrut(43);
		horizontalBox_11.add(horizontalStrut_34);
		
		temperatureCB = new JComboBox<String>();
		temperatureCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Very Cold", "Cold", "Normal", "Hot", "Very Hot"}));
		temperatureCB.setMaximumRowCount(5);
		temperatureCB.setEnabled(false);
		horizontalBox_11.add(temperatureCB);
		
		Component horizontalStrut_35 = Box.createHorizontalStrut(5);
		horizontalBox_11.add(horizontalStrut_35);
		
		Component verticalStrut_10 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_10);
		
		Box horizontalBox_12 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_12);
		
		Component horizontalStrut_36 = Box.createHorizontalStrut(5);
		horizontalBox_12.add(horizontalStrut_36);
		
		JLabel lblRain = new JLabel("Rain:");
		lblRain.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRain.setBackground(Color.WHITE);
		lblRain.setAlignmentX(0.5f);
		horizontalBox_12.add(lblRain);
		
		Component horizontalStrut_37 = Box.createHorizontalStrut(93);
		horizontalBox_12.add(horizontalStrut_37);
		
		rainCB = new JComboBox<String>();
		rainCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Very Dry", "Dry", "Normal", "Rainy", "Very Rainy"}));
		rainCB.setMaximumRowCount(5);
		rainCB.setEnabled(false);
		horizontalBox_12.add(rainCB);
		
		Component horizontalStrut_38 = Box.createHorizontalStrut(5);
		horizontalBox_12.add(horizontalStrut_38);
		
		Component verticalStrut_11 = Box.createVerticalStrut(2);
		verticalBox.add(verticalStrut_11);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_verticalBox_1 = new GridBagConstraints();
		gbc_verticalBox_1.anchor = GridBagConstraints.WEST;
		gbc_verticalBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox_1.gridx = 2;
		gbc_verticalBox_1.gridy = 1;
		contentPane.add(verticalBox_1, gbc_verticalBox_1);
		
		Box horizontalBox_13 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_13);
		
		Component horizontalStrut_39 = Box.createHorizontalStrut(5);
		horizontalBox_13.add(horizontalStrut_39);
		
		JLabel lblSpeed_1 = new JLabel("Speed:");
		lblSpeed_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSpeed_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeed_1.setBackground(Color.WHITE);
		lblSpeed_1.setAlignmentX(0.5f);
		horizontalBox_13.add(lblSpeed_1);
		
		Component horizontalStrut_40 = Box.createHorizontalStrut(80);
		horizontalBox_13.add(horizontalStrut_40);
		
		zombieSpeedCB = new JComboBox<String>();
		zombieSpeedCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Sprinters", "Fast Shamblers", "Shamblers"}));
		zombieSpeedCB.setMaximumRowCount(3);
		zombieSpeedCB.setEnabled(false);
		horizontalBox_13.add(zombieSpeedCB);
		
		Component horizontalStrut_41 = Box.createHorizontalStrut(5);
		horizontalBox_13.add(horizontalStrut_41);
		
		Component verticalStrut_12 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_12);
		
		Box horizontalBox_14 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_14);
		
		Component horizontalStrut_42 = Box.createHorizontalStrut(5);
		horizontalBox_14.add(horizontalStrut_42);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStrength.setBackground(Color.WHITE);
		lblStrength.setAlignmentX(0.5f);
		horizontalBox_14.add(lblStrength);
		
		Component horizontalStrut_43 = Box.createHorizontalStrut(66);
		horizontalBox_14.add(horizontalStrut_43);
		
		zombieStrengthCB = new JComboBox<String>();
		zombieStrengthCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Superhuman", "Normal", "Weak"}));
		zombieStrengthCB.setMaximumRowCount(3);
		zombieStrengthCB.setEnabled(false);
		horizontalBox_14.add(zombieStrengthCB);
		
		Component horizontalStrut_44 = Box.createHorizontalStrut(5);
		horizontalBox_14.add(horizontalStrut_44);
		
		Component verticalStrut_13 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_13);
		
		Box horizontalBox_15 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_15);
		
		Component horizontalStrut_45 = Box.createHorizontalStrut(5);
		horizontalBox_15.add(horizontalStrut_45);
		
		JLabel lblToughness = new JLabel("Toughness:");
		lblToughness.setVerticalAlignment(SwingConstants.BOTTOM);
		lblToughness.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblToughness.setBackground(Color.WHITE);
		lblToughness.setAlignmentX(0.5f);
		horizontalBox_15.add(lblToughness);
		
		Component horizontalStrut_46 = Box.createHorizontalStrut(55);
		horizontalBox_15.add(horizontalStrut_46);
		
		zombieToughnessCB = new JComboBox<String>();
		zombieToughnessCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Tough", "Normal", "Fragile"}));
		zombieToughnessCB.setMaximumRowCount(3);
		zombieToughnessCB.setEnabled(false);
		horizontalBox_15.add(zombieToughnessCB);
		
		Component horizontalStrut_47 = Box.createHorizontalStrut(5);
		horizontalBox_15.add(horizontalStrut_47);
		
		Component verticalStrut_14 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_14);
		
		Box horizontalBox_16 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_16);
		
		Component horizontalStrut_48 = Box.createHorizontalStrut(5);
		horizontalBox_16.add(horizontalStrut_48);
		
		JLabel lblTransmission = new JLabel("Transmission:");
		lblTransmission.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTransmission.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTransmission.setBackground(Color.WHITE);
		lblTransmission.setAlignmentX(0.5f);
		horizontalBox_16.add(lblTransmission);
		
		Component horizontalStrut_49 = Box.createHorizontalStrut(47);
		horizontalBox_16.add(horizontalStrut_49);
		
		zombieTransmissionCB = new JComboBox<String>();
		zombieTransmissionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Blood + Saliva", "Everyone's Infected", "None"}));
		zombieTransmissionCB.setMaximumRowCount(3);
		zombieTransmissionCB.setEnabled(false);
		horizontalBox_16.add(zombieTransmissionCB);
		
		Component horizontalStrut_50 = Box.createHorizontalStrut(5);
		horizontalBox_16.add(horizontalStrut_50);
		
		Component verticalStrut_15 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_15);
		
		Box horizontalBox_17 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_17);
		
		Component horizontalStrut_51 = Box.createHorizontalStrut(5);
		horizontalBox_17.add(horizontalStrut_51);
		
		JLabel lblMortality = new JLabel("Infection Mortality:");
		lblMortality.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMortality.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMortality.setBackground(Color.WHITE);
		lblMortality.setAlignmentX(0.5f);
		horizontalBox_17.add(lblMortality);
		
		Component horizontalStrut_52 = Box.createHorizontalStrut(16);
		horizontalBox_17.add(horizontalStrut_52);
		
		zombieMortalityCB = new JComboBox<String>();
		zombieMortalityCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Instant", "30 Seconds", "1 Minute", "12 Hours", "2-3 Days", "1-2 Weeks"}));
		zombieMortalityCB.setMaximumRowCount(6);
		zombieMortalityCB.setEnabled(false);
		horizontalBox_17.add(zombieMortalityCB);
		
		Component horizontalStrut_53 = Box.createHorizontalStrut(5);
		horizontalBox_17.add(horizontalStrut_53);
		
		Component verticalStrut_16 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_16);
		
		Box horizontalBox_18 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_18);
		
		Component horizontalStrut_54 = Box.createHorizontalStrut(5);
		horizontalBox_18.add(horizontalStrut_54);
		
		JLabel lblReanimate = new JLabel("Reanimation Time:");
		lblReanimate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblReanimate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReanimate.setBackground(Color.WHITE);
		lblReanimate.setAlignmentX(0.5f);
		horizontalBox_18.add(lblReanimate);
		
		Component horizontalStrut_55 = Box.createHorizontalStrut(18);
		horizontalBox_18.add(horizontalStrut_55);
		
		zombieReanimationCB = new JComboBox<String>();
		zombieReanimationCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Instant", "30 Seconds", "1 Minute", "12 Hours", "2-3 Days", "1-2 Weeks"}));
		zombieReanimationCB.setMaximumRowCount(6);
		zombieReanimationCB.setEnabled(false);
		horizontalBox_18.add(zombieReanimationCB);
		
		Component horizontalStrut_56 = Box.createHorizontalStrut(5);
		horizontalBox_18.add(horizontalStrut_56);
		
		Component verticalStrut_17 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_17);
		
		Box horizontalBox_19 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_19);
		
		Component horizontalStrut_57 = Box.createHorizontalStrut(5);
		horizontalBox_19.add(horizontalStrut_57);
		
		JLabel lblCognition = new JLabel("Cognition:");
		lblCognition.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCognition.setBackground(Color.WHITE);
		lblCognition.setAlignmentX(0.5f);
		horizontalBox_19.add(lblCognition);
		
		Component horizontalStrut_58 = Box.createHorizontalStrut(64);
		horizontalBox_19.add(horizontalStrut_58);
		
		zombieCognitionCB = new JComboBox<String>();
		zombieCognitionCB.setModel(new DefaultComboBoxModel(new String[] {"Navigate + Use Doors", "Navigate", "Basic Navigation"}));
		zombieCognitionCB.setMaximumRowCount(3);
		zombieCognitionCB.setEnabled(false);
		horizontalBox_19.add(zombieCognitionCB);
		
		Component horizontalStrut_59 = Box.createHorizontalStrut(5);
		horizontalBox_19.add(horizontalStrut_59);
		
		Component verticalStrut_18 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_18);
		
		Box horizontalBox_20 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_20);
		
		Component horizontalStrut_60 = Box.createHorizontalStrut(5);
		horizontalBox_20.add(horizontalStrut_60);
		
		JLabel lblCognition_1 = new JLabel("Memory:");
		lblCognition_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCognition_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCognition_1.setBackground(Color.WHITE);
		lblCognition_1.setAlignmentX(0.5f);
		horizontalBox_20.add(lblCognition_1);
		
		Component horizontalStrut_61 = Box.createHorizontalStrut(72);
		horizontalBox_20.add(horizontalStrut_61);
		
		zombieMemoryCB = new JComboBox<String>();
		zombieMemoryCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Long", "Normal", "Short", "None"}));
		zombieMemoryCB.setMaximumRowCount(4);
		zombieMemoryCB.setEnabled(false);
		horizontalBox_20.add(zombieMemoryCB);
		
		Component horizontalStrut_62 = Box.createHorizontalStrut(5);
		horizontalBox_20.add(horizontalStrut_62);
		
		Component verticalStrut_19 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_19);
		
		Box horizontalBox_21 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_21);
		
		Component horizontalStrut_63 = Box.createHorizontalStrut(5);
		horizontalBox_21.add(horizontalStrut_63);
		
		JLabel lblDecomp = new JLabel("Decompisition:");
		lblDecomp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDecomp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDecomp.setBackground(Color.WHITE);
		lblDecomp.setAlignmentX(0.5f);
		horizontalBox_21.add(lblDecomp);
		
		Component horizontalStrut_64 = Box.createHorizontalStrut(40);
		horizontalBox_21.add(horizontalStrut_64);
		
		zombieDecompisitionCB = new JComboBox<String>();
		zombieDecompisitionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Slows + Weakens", "Slows", "Weakens", "No Effect"}));
		zombieDecompisitionCB.setMaximumRowCount(4);
		zombieDecompisitionCB.setEnabled(false);
		horizontalBox_21.add(zombieDecompisitionCB);
		
		Component horizontalStrut_65 = Box.createHorizontalStrut(5);
		horizontalBox_21.add(horizontalStrut_65);
		
		Component verticalStrut_20 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_20);
		
		Box horizontalBox_22 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_22);
		
		Component horizontalStrut_66 = Box.createHorizontalStrut(5);
		horizontalBox_22.add(horizontalStrut_66);
		
		JLabel lblSight = new JLabel("Sight:");
		lblSight.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSight.setBackground(Color.WHITE);
		lblSight.setAlignmentX(0.5f);
		horizontalBox_22.add(lblSight);
		
		Component horizontalStrut_67 = Box.createHorizontalStrut(87);
		horizontalBox_22.add(horizontalStrut_67);
		
		zombieSightCB = new JComboBox<String>();
		zombieSightCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Eagle", "Normal", "Poor"}));
		zombieSightCB.setMaximumRowCount(3);
		zombieSightCB.setEnabled(false);
		horizontalBox_22.add(zombieSightCB);
		
		Component horizontalStrut_68 = Box.createHorizontalStrut(5);
		horizontalBox_22.add(horizontalStrut_68);
		
		Component verticalStrut_21 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_21);
		
		Box horizontalBox_23 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_23);
		
		Component horizontalStrut_69 = Box.createHorizontalStrut(5);
		horizontalBox_23.add(horizontalStrut_69);
		
		JLabel lblHearing = new JLabel("Hearing:");
		lblHearing.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHearing.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHearing.setBackground(Color.WHITE);
		lblHearing.setAlignmentX(0.5f);
		horizontalBox_23.add(lblHearing);
		
		Component horizontalStrut_70 = Box.createHorizontalStrut(74);
		horizontalBox_23.add(horizontalStrut_70);
		
		zombieHearingCB = new JComboBox<String>();
		zombieHearingCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Pinpoint", "Normal", "Poor"}));
		zombieHearingCB.setMaximumRowCount(3);
		zombieHearingCB.setEnabled(false);
		horizontalBox_23.add(zombieHearingCB);
		
		Component horizontalStrut_71 = Box.createHorizontalStrut(5);
		horizontalBox_23.add(horizontalStrut_71);
		
		Component verticalStrut_22 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_22);
		
		Box horizontalBox_24 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_24);
		
		Component horizontalStrut_72 = Box.createHorizontalStrut(5);
		horizontalBox_24.add(horizontalStrut_72);
		
		JLabel lblSmell = new JLabel("Smell:");
		lblSmell.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSmell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSmell.setBackground(Color.WHITE);
		lblSmell.setAlignmentX(0.5f);
		horizontalBox_24.add(lblSmell);
		
		Component horizontalStrut_73 = Box.createHorizontalStrut(87);
		horizontalBox_24.add(horizontalStrut_73);
		
		zombieSmellCB = new JComboBox<String>();
		zombieSmellCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Bloodhound", "Normal", "Poor"}));
		zombieSmellCB.setMaximumRowCount(3);
		zombieSmellCB.setEnabled(false);
		horizontalBox_24.add(zombieSmellCB);
		
		Component horizontalStrut_74 = Box.createHorizontalStrut(5);
		horizontalBox_24.add(horizontalStrut_74);
		
		Component verticalStrut_23 = Box.createVerticalStrut(2);
		verticalBox_1.add(verticalStrut_23);
		
		Box horizontalBox_25 = Box.createHorizontalBox();
		horizontalBox_25.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_horizontalBox_25 = new GridBagConstraints();
		gbc_horizontalBox_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalBox_25.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_25.gridx = 0;
		gbc_horizontalBox_25.gridy = 2;
		contentPane.add(horizontalBox_25, gbc_horizontalBox_25);
		
		Component horizontalStrut_75 = Box.createHorizontalStrut(5);
		horizontalBox_25.add(horizontalStrut_75);
		
		JLabel lblNewLabel_1 = new JLabel("Advanced Settings:");
		horizontalBox_25.add(lblNewLabel_1);
		
		Component horizontalStrut_76 = Box.createHorizontalStrut(20);
		horizontalBox_25.add(horizontalStrut_76);
		
		enableAdvancedOptionsGroup = new ButtonGroup();
		
		enableAdvancedYes = new JRadioButton("Yes");
		enableAdvancedYes.setToolTipText("Enable Advanced Settings");
		enableAdvancedYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				enableAdvanced();
			}
		});
		horizontalBox_25.add(enableAdvancedYes);
		
		Component horizontalStrut_78 = Box.createHorizontalStrut(1);
		horizontalBox_25.add(horizontalStrut_78);
		
		enableAdvancedNo = new JRadioButton("No");
		enableAdvancedNo.setToolTipText("Disable Advanced Settings");
		enableAdvancedNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				disabeAdvanced();
			}
		});
		enableAdvancedNo.setSelected(true);
		horizontalBox_25.add(enableAdvancedNo);
		
		enableAdvancedOptionsGroup.add(enableAdvancedNo);
		enableAdvancedOptionsGroup.add(enableAdvancedYes);
		
		Component horizontalStrut_77 = Box.createHorizontalStrut(5);
		horizontalBox_25.add(horizontalStrut_77);
		
		Box horizontalBox_27 = Box.createHorizontalBox();
		horizontalBox_27.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_horizontalBox_27 = new GridBagConstraints();
		gbc_horizontalBox_27.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_27.gridx = 2;
		gbc_horizontalBox_27.gridy = 2;
		contentPane.add(horizontalBox_27, gbc_horizontalBox_27);
		
		properZombiesButton = new JButton("Proper Zombies");
		properZombiesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				properZombies();
			}
		});
		properZombiesButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		horizontalBox_27.add(properZombiesButton);
		
		resetAllButton = new JButton("Reset All");
		resetAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				firstTime();
			}
		});
		resetAllButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		horizontalBox_27.add(resetAllButton);		
	}
	
	private void properZombies() {
		this.zombieCognitionCB.setSelectedIndex(Util.ProperZombieCognition-1);
		this.zombieDecompisitionCB.setSelectedIndex(Util.ProperZombieDecomp-1);
		this.zombieHearingCB.setSelectedIndex(Util.ProperZombieHearing-1);
		this.zombieMemoryCB.setSelectedIndex(Util.ProperZombieMemory-1);
		this.zombieMortalityCB.setSelectedIndex(Util.ProperZombieInfectionMortality-1);
		this.zombieReanimationCB.setSelectedIndex(Util.ProperZombieReanimate-1);
		this.zombieSightCB.setSelectedIndex(Util.ProperZombieSight-1);
		this.zombieSmellCB.setSelectedIndex(Util.ProperZombieSmell-1);
		this.zombieSpeedCB.setSelectedIndex(Util.ProperZombieSpeed-1);
		this.zombieStrengthCB.setSelectedIndex(Util.ProperZombieStrength-1);
		this.zombieTransmissionCB.setSelectedIndex(Util.ProperZombieInfectionTransmission-1);
	}
	
	private void enableAdvanced() {
		this.startMonthCB.setEnabled(true);
		this.startTimeCB.setEnabled(true);
		this.electricShutoffCB.setEnabled(true);
		this.waterShutoffCB.setEnabled(true);
		this.speedCB.setEnabled(true);
	}
	
	private void disabeAdvanced() {
		this.startMonthCB.setEnabled(false);
		this.startTimeCB.setEnabled(false);
		this.electricShutoffCB.setEnabled(false);
		this.waterShutoffCB.setEnabled(false);
		this.speedCB.setEnabled(false);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem fileMenuOpen = new JMenuItem("Open File...");
		JSeparator separator = new JSeparator();
		JMenuItem fileMenuSave = new JMenuItem("Save");
		JMenuItem fileMenuSaveAs = new JMenuItem("Save As...");
		JSeparator separator_1 = new JSeparator();
		JMenuItem fileMenuExit = new JMenuItem("Quit");
		
		fileMenuOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
		});
		fileMenuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(fileMenuOpen);
		fileMenu.add(separator);
		fileMenu.add(fileMenuSave);
		fileMenu.add(fileMenuSaveAs);
		fileMenu.add(separator_1);
		fileMenu.add(fileMenuExit);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem helpMenuHelp = new JMenuItem("Help");
		helpMenu.add(helpMenuHelp);
		
		JMenuItem helpMenuAbout = new JMenuItem("About");
		helpMenu.add(helpMenuAbout);
	}

	private void openFile() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			this.worldValues = Util.loadSandbox(fc.getSelectedFile());
			this.firstTime();
		}
	}

	private void firstTime() {
		this.worldVersionLabel.setText(Integer.toString(this.worldValues.getWorldVersion()));
		this.zombieDensityCB.setSelectedIndex(this.worldValues.getOrigZombieDensity()-1);
		this.zombieDistributionCB.setSelectedIndex(this.worldValues.getOrigZombieDistribution()-1);
		this.speedCB.setSelectedIndex(this.worldValues.getOrigSpeed()-1);
		this.dayLengthCB.setSelectedIndex(this.worldValues.getOrigDayLength()-1);
		this.startMonthCB.setSelectedIndex(this.worldValues.getOrigStartMonth()-1);
		this.startTimeCB.setSelectedIndex(this.worldValues.getOrigStartTime()-1);
		this.waterShutoffCB.setSelectedIndex(this.worldValues.getOrigWaterShutoff()-1);
		this.electricShutoffCB.setSelectedIndex(this.worldValues.getOrigElectricShutoff()-1);
		this.lootAmountCB.setSelectedIndex(this.worldValues.getOrigLootAmount()-1);
		this.temperatureCB.setSelectedIndex(this.worldValues.getOrigTemperature()-1);
		this.rainCB.setSelectedIndex(this.worldValues.getOrigRain()-1);
		this.zombieSpeedCB.setSelectedIndex(this.worldValues.getOrigZombieSpeed()-1);
		this.zombieStrengthCB.setSelectedIndex(this.worldValues.getOrigZombieStrength()-1);
		this.zombieToughnessCB.setSelectedIndex(this.worldValues.getOrigZombieToughness()-1);
		this.zombieTransmissionCB.setSelectedIndex(this.worldValues.getOrigZombieInfectionTransmission()-1);
		this.zombieMortalityCB.setSelectedIndex(this.worldValues.getOrigZombieInfectionMortality()-1);
		this.zombieReanimationCB.setSelectedIndex(this.worldValues.getOrigZombieReanimate()-1);
		this.zombieCognitionCB.setSelectedIndex(this.worldValues.getOrigZombieCognition()-1);
		this.zombieMemoryCB.setSelectedIndex(this.worldValues.getOrigZombieMemory()-1);
		this.zombieDecompisitionCB.setSelectedIndex(this.worldValues.getOrigZombieDecomp()-1);
		this.zombieSightCB.setSelectedIndex(this.worldValues.getOrigZombieSight()-1);
		this.zombieHearingCB.setSelectedIndex(this.worldValues.getOrigZombieHearing()-1);
		this.zombieSmellCB.setSelectedIndex(this.worldValues.getOrigZombieSmell()-1);
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
	}
}
