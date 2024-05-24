package CNAM.example.CNAM.BACKEND.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SAPRFCTableField {
    private String fieldname;
	private int offset;
	private int length;
	
	public SAPRFCTableField() {

	}
}
