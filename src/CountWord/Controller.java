package CountWord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller {
	private Model theModel;
	private View theView;

	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addActionListener(new  btnChooseActionListener(), new btnCountActionListener(), new btnAboutActionListener());
	}

	public class btnCountActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			theView.setResult(theModel.getResult());

		}
	}

	public class btnChooseActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Word File", "doc", "docx");
				chooser.setFileFilter(extFilter);
				
				int returnVal = chooser.showOpenDialog((JButton) e.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					theView.setFile(chooser.getSelectedFile());
					theView.setFilePathField(chooser.getSelectedFile().getPath());
				}
				theModel.countWord(theView.getFile());
				theView.setText(theModel.getText());
				theView.setResult("");
			} catch (IOException e1) {
				e1.printStackTrace();
				theView.displayError("Loi trong qua trinh doc file");
			}
		}

	}
	
	public class btnAboutActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JOptionPane.showMessageDialog(null, "Thành viên nhóm \n - Huỳnh Minh Dũng \n - Nguyễn Thọ Công Minh \n - Cao Thọ Hiếu", "About group", 1);

		}
	}
}