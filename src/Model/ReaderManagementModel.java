package Model;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ReaderManagementModel {
	private DefaultTableModel tableModel;

	public ReaderManagementModel() {
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã độc giả", "Họ và tên", "Số ĐT", "Email", "Giới tính" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void addReader(Vector<Object> row) {
		tableModel.addRow(row);
	}

	public void removeReader(String maDocGia) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
				tableModel.removeRow(i);
				break;
			}
		}
	}

	public int findReader(String maDocGia) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 1).equals(maDocGia)) {
				return i;
			}
		}
		return -1;
	}

	public void refreshReaders(Vector<Vector<Object>> dataVector) {
		tableModel.setRowCount(0);
		for (Vector<Object> row : dataVector) {
			tableModel.addRow(row);
		}
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.setValueAt(i + 1, i, 0);
		}
	}
}
