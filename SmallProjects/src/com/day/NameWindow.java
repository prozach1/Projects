package com.day;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NameWindow {

	private JFrame frmDayOfWeek;
	private final JLabel lblSelectDateTo = new JLabel("Select date to see the day of the week");
	private JTextField txtDayOfWeek;
	private JTextField txtYear;
	private int day;
	private int month;
	private int year;
	private int[] monthLength={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameWindow window = new NameWindow();
					window.frmDayOfWeek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDayOfWeek = new JFrame();
		frmDayOfWeek.setTitle("Day of Week");
		frmDayOfWeek.setBounds(100, 100, 470, 300);
		frmDayOfWeek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDayOfWeek.getContentPane().setLayout(null);
		
		JComboBox cmbMonth = new JComboBox();
		cmbMonth.setBounds(115, 73, 49, 27);
		cmbMonth.setMaximumRowCount(12);
		cmbMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", 
				"Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
				"Oct", "Nov", "Dec"}));
		frmDayOfWeek.getContentPane().add(cmbMonth);
		
		JComboBox cmbDay = new JComboBox();
		cmbDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cmb = (JComboBox)e.getSource();
				setDay(Integer.parseInt((String)cmb.getSelectedItem()));
			}
		});
		cmbDay.setEnabled(false);
		cmbDay.setModel(new DefaultComboBoxModel());
		cmbDay.setBounds(174, 73, 68, 27);
		frmDayOfWeek.getContentPane().add(cmbDay);
		lblSelectDateTo.setBounds(115, 41, 223, 21);
		frmDayOfWeek.getContentPane().add(lblSelectDateTo);
		
		txtYear = new JTextField();
		txtYear.setBounds(252, 73, 86, 27);
		frmDayOfWeek.getContentPane().add(txtYear);
		txtYear.setColumns(10);
		
		cmbMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				setMonth(getMonthNumber((String)cb.getSelectedItem()));
				cmbDay.setEnabled(true);
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
				{
					cmbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", 
							"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", 
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", 
							"25", "26", "27", "28", "29", "30", "31"}));
				}
				else if (month==4||month==6||month==9||month==11) {
					cmbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", 
							"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", 
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", 
							"25", "26", "27", "28", "29", "30"}));
				}
				else {
					cmbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", 
							"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", 
							"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", 
							"25", "26", "27", "28", "29"}));
				}
			}
		});
		
		txtDayOfWeek = new JTextField();
		txtDayOfWeek.setEditable(false);
		txtDayOfWeek.setBounds(157, 190, 136, 20);
		frmDayOfWeek.getContentPane().add(txtDayOfWeek);
		txtDayOfWeek.setColumns(10);
		
		JButton btnWhatDayWas = new JButton("What day was it?");
		btnWhatDayWas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					setYear(Integer.parseInt(txtYear.getText()));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(frmDayOfWeek,
						    "Please enter a date between March 1900 and Feb 2100",
						    "Invalid Date",
						    JOptionPane.ERROR_MESSAGE);
				}
				if((year<1900)||(year>2100)||((year==1900)&&(month<3))||((year==2100)&&(month>2))){
					JOptionPane.showMessageDialog(frmDayOfWeek,
						    "Please enter a date between March 1900 and Feb 2100",
						    "Invalid Date",
						    JOptionPane.ERROR_MESSAGE);					
				}
				else {
					getDayOfWeek(month, day, year);
				}
			}
		});
		btnWhatDayWas.setBounds(157, 141, 136, 23);
		frmDayOfWeek.getContentPane().add(btnWhatDayWas);
	}
	/*
	 * Converts the String for month into an int
	 */
	protected int getMonthNumber(String month) {
		switch (month) {
		case "Jan":
			return 1;
		case "Feb":
			return 2;
		case "Mar":
			return 3;
		case "Apr":
			return 4;
		case "May":
			return 5;
		case "Jun":
			return 6;
		case "Jul":
			return 7;
		case "Aug":
			return 8;
		case "Sep":
			return 9;
		case "Oct":
			return 10;
		case "Nov":
			return 11;
		case "Dec":
			return 12;
		default:
			return 0;
		}
		
	}

	/*
	 * Calculate the day of the week
	 */
	protected void getDayOfWeek(int month, int day, int year) {
		
		String[] daysOfWeek = {"Sunday", "Monday" , "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		if(isLeapYear(year)){
			int dayNum = ((year-1900)*365)+((year-1900)/4);
			if(month<3)
				dayNum+=1;
			for(int i=0; i<month-1; i++)  // might be off by 1
			{
				dayNum+=monthLength[i];
			}
			dayNum+=day;
			dayNum%=7;
			txtDayOfWeek.setText(daysOfWeek[dayNum]);
		}
		else {
			if((month==2)&&(day==29)) {
				JOptionPane.showMessageDialog(frmDayOfWeek,
					    year+" was not a leap year",
					    "Invalid Year",
					    JOptionPane.ERROR_MESSAGE);
			}
			else {
				int dayNum = ((year-1900)*365)+((year-1900)/4);
				
				for(int i=0; i<month-1; i++)  // might be off by 1
				{
					dayNum+=monthLength[i];
				}
				dayNum+=day;
				dayNum%=7;
				txtDayOfWeek.setText(daysOfWeek[dayNum]);
			}
		}
		
	}

	private boolean isLeapYear(int year) {
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}
}
