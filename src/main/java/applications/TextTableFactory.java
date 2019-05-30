package applications;

import java.util.ArrayList;

public class TextTableFactory {

	public static final String COLUMN_SEPARATOR = "|";
	public static final String ROW_SEPARATOR = "-";
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String[] ORGANIC_PET_TABLE_COL_HEADERS = { "Name", "Health" };
	
	public static final int MAX_COLUMN_WIDTH = 14;
	public static final String COLUMN_FORMAT = "%-" + MAX_COLUMN_WIDTH + "s";
	public static final String COLUMN_SEP_FORMAT = "%-2s";
	public static final String ROW_END_FORMAT = "%2s";

	private TextTableFactory() {
	}
	
	
	
	
	public static String createTable(String[] columnLabels, ArrayList<String[]> data) {
		String[] headerAndFooter = createTableHeaderAndFooter(columnLabels);
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append(headerAndFooter[0]);
		
		for(String[] rowValues : data) {
			tableBuilder.append(createTableRow(rowValues));
			tableBuilder.append(LINE_SEPARATOR);
		}
		
		tableBuilder.append(LINE_SEPARATOR);
		tableBuilder.append(headerAndFooter[1]);
		
		return tableBuilder.toString();
	}

	public static String[] createTableHeaderAndFooter(String[] columnLabels) {
		StringBuilder headerBuilder = new StringBuilder();
		StringBuilder lineBuilder = new StringBuilder();

		String columnHeader = createTableRow(columnLabels);

		int rowLength = columnHeader.length();
		for (int i = 0; i < rowLength; i++) {
			lineBuilder.append(ROW_SEPARATOR);
		}

		// Build Header
		headerBuilder.append(lineBuilder.toString());
		headerBuilder.append(LINE_SEPARATOR);
		headerBuilder.append(columnHeader);
		headerBuilder.append(LINE_SEPARATOR);
		headerBuilder.append(lineBuilder.toString());
		headerBuilder.append(LINE_SEPARATOR);

		// Returns 2 Strings - First is table header, 2nd is the table footer.
		return (new String[] { headerBuilder.toString(), lineBuilder.toString() });
	}

	public static String createTableRow(String[] columnValues) {
		StringBuilder formatStringBuilder = new StringBuilder();
		ArrayList<String> columnValuesList = new ArrayList<String>(columnValues.length + 2 + (columnValues.length - 1));

		// Opening frame line
		columnValuesList.add(COLUMN_SEPARATOR);
		formatStringBuilder.append(COLUMN_SEP_FORMAT);

		// Add column values with spacing, separated by separators
		int i = 0;
		for (String colValue : columnValues) {
			i++;
			// Add next column value
			if (colValue.length() > (MAX_COLUMN_WIDTH - 2)) {
				// Clip column value to acceptable length
				colValue = colValue.substring(0, MAX_COLUMN_WIDTH - 2);
			}
			columnValuesList.add(colValue);
			formatStringBuilder.append(COLUMN_FORMAT);

			// Add next separator
			if (i != columnValues.length) {
				columnValuesList.add(COLUMN_SEPARATOR);
				formatStringBuilder.append(COLUMN_SEP_FORMAT);
			}
		}
		// Closing frame line
		columnValuesList.add(COLUMN_SEPARATOR);
		formatStringBuilder.append(ROW_END_FORMAT);

		String formattedRow = String.format(formatStringBuilder.toString(), columnValuesList.toArray());
		return formattedRow;
	}

}
