package pl.sda.library.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pl.sda.library.table.model.CrudDataTableModel;

public class BookSearchButtonListener implements ActionListener {

	private CrudDataTableModel model;

	private JTextField searchTextField;

	public BookSearchButtonListener(CrudDataTableModel model, JTextField searchTextField) {
		this.model = model;
		this.searchTextField = searchTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.filterByName(searchTextField.getText());
	}

}
