package CountWord;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class View extends JFrame {

	private JPanel contentPane;
	private File file;
	private JTextArea resultArea;
	private JTextArea textArea;
	private JButton btnChonFile;
	private JButton btnCountWord;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField filePathField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					View frame = new View();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("\u0110\u00EA\u0301m t\u01B0\u0300 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{38, 104, 0, 104, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFile = new JLabel("File:");
		GridBagConstraints gbc_lblFile = new GridBagConstraints();
		gbc_lblFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblFile.anchor = GridBagConstraints.WEST;
		gbc_lblFile.gridx = 0;
		gbc_lblFile.gridy = 0;
		contentPane.add(lblFile, gbc_lblFile);
		
		filePathField = new JTextField();
		GridBagConstraints gbc_filePathField = new GridBagConstraints();
		gbc_filePathField.insets = new Insets(0, 0, 5, 5);
		gbc_filePathField.fill = GridBagConstraints.HORIZONTAL;
		gbc_filePathField.gridx = 1;
		gbc_filePathField.gridy = 0;
		contentPane.add(filePathField, gbc_filePathField);
		filePathField.setColumns(10);
		
		btnChonFile = new JButton("Cho\u0323n File");
//		btnChonFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser chooser = new JFileChooser();
//				int returnVal= chooser.showOpenDialog((JButton) e.getSource());
//				if (returnVal == JFileChooser.APPROVE_OPTION){
//					file = chooser.getSelectedFile();
//				}
//			}
//		});
		GridBagConstraints gbc_btnChonFile = new GridBagConstraints();
		gbc_btnChonFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnChonFile.gridx = 2;
		gbc_btnChonFile.gridy = 0;
		contentPane.add(btnChonFile, gbc_btnChonFile);
		
		JLabel lblText = new JLabel("Text:");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.WEST;
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 1;
		contentPane.add(lblText, gbc_lblText);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnCountWord = new JButton("\u0110\u00EA\u0301m t\u01B0\u0300");
		GridBagConstraints gbc_btnCountWord = new GridBagConstraints();
		gbc_btnCountWord.anchor = GridBagConstraints.WEST;
		gbc_btnCountWord.insets = new Insets(0, 0, 5, 5);
		gbc_btnCountWord.gridx = 1;
		gbc_btnCountWord.gridy = 2;
		contentPane.add(btnCountWord, gbc_btnCountWord);
		
		JLabel lblResult = new JLabel("Result:");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 0, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 3;
		contentPane.add(lblResult, gbc_lblResult);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		resultArea = new JTextArea();
		scrollPane_1.setViewportView(resultArea);
		
		
		
		
	}
	public void setResult(String result){
		resultArea.setText(result);
	}
	public void setText(String text){
		textArea.setText(text);
	}
	
	public File getFile() {
		return file;
	}
	
	
	public void setFile(File file) {
		this.file = file;
	}

	
	public void setFilePathField(String filePath) {
		this.filePathField.setText(filePath);
	}
	
	public void addActionListener(ActionListener btnChoooseAL, ActionListener btnCountAL){
		btnChonFile.addActionListener(btnChoooseAL);
		btnCountWord.addActionListener(btnCountAL);
	}

	public void displayError(String error){
		JOptionPane.showMessageDialog(this, error);
	}
}
