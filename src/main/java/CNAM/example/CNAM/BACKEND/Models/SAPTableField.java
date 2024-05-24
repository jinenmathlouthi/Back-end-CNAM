package CNAM.example.CNAM.BACKEND.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SAPTableField {
    private String tablename;
	private String fieldname;
	private int position;
	private int length;
	private String datatype;
	private String convexit;
	private boolean isselected;


	public SAPTableField() {

	}
}
