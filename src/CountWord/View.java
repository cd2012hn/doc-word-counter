package CountWord;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class View extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mnhAbout;
	private JPanel mainPane;
	private File file;
	private JEditorPane resultArea;
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
		setTitle("Word count");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		mnHelp = new JMenu("Help");
		mnhAbout = new JMenuItem("About group");
		mnHelp.add(mnhAbout);
		menuBar.add(mnHelp);
		getContentPane().add(menuBar, BorderLayout.PAGE_START);
		
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(mainPane, BorderLayout.CENTER);
		
		GridBagLayout gbl_mainPane = new GridBagLayout();
		gbl_mainPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_mainPane.rowHeights = new int[]{38, 104, 0, 104, 0};
		gbl_mainPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_mainPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		JLabel lblFile = new JLabel("File:");
		GridBagConstraints gbc_lblFile = new GridBagConstraints();
		gbc_lblFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblFile.anchor = GridBagConstraints.WEST;
		gbc_lblFile.gridx = 0;
		gbc_lblFile.gridy = 0;
		mainPane.add(lblFile, gbc_lblFile);
		
		filePathField = new JTextField();
		GridBagConstraints gbc_filePathField = new GridBagConstraints();
		gbc_filePathField.insets = new Insets(0, 0, 5, 5);
		gbc_filePathField.fill = GridBagConstraints.HORIZONTAL;
		gbc_filePathField.gridx = 1;
		gbc_filePathField.gridy = 0;
		mainPane.add(filePathField, gbc_filePathField);
		filePathField.setColumns(10);
		
		btnChonFile = new JButton("Choose File");
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
		mainPane.add(btnChonFile, gbc_btnChonFile);
		
		JLabel lblText = new JLabel("Text:");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.WEST;
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 1;
		mainPane.add(lblText, gbc_lblText);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		mainPane.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btnCountWord = new JButton("Count");
		GridBagConstraints gbc_btnCountWord = new GridBagConstraints();
		gbc_btnCountWord.anchor = GridBagConstraints.WEST;
		gbc_btnCountWord.insets = new Insets(0, 0, 5, 5);
		gbc_btnCountWord.gridx = 1;
		gbc_btnCountWord.gridy = 2;
		mainPane.add(btnCountWord, gbc_btnCountWord);
		
		JLabel lblResult = new JLabel("Result:");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 0, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 3;
		mainPane.add(lblResult, gbc_lblResult);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		mainPane.add(scrollPane_1, gbc_scrollPane_1);
		
		resultArea = new JEditorPane();
		DefaultCaret caret = (DefaultCaret)resultArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		resultArea.setContentType("text/html");
		resultArea.setEditable(false);
		scrollPane_1.setViewportView(resultArea);
		
		changeFont(contentPane, 18, true, Font.PLAIN);
		
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
	
	public void addActionListener(ActionListener btnChoooseAL, ActionListener btnCountAL, ActionListener btnAbout){
		btnChonFile.addActionListener(btnChoooseAL);
		btnCountWord.addActionListener(btnCountAL);
		mnhAbout.addActionListener(btnAbout);
	}

	public void displayError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", 0);
	}
	
	private static void changeFont(Component component, int fontSize, boolean fixStyle, int style) {
	    Font f = component.getFont();
	    int styleSet = f.getStyle();
	    if (fixStyle) {
	    	styleSet = style;
	    }
	    component.setFont(new Font(f.getName(),styleSet,fontSize));
	    if (component instanceof Container) {
	        for (Component child : ((Container) component).getComponents()) {
	            changeFont(child, fontSize, fixStyle, style);
	        }
	    }
	}
}
