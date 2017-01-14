import javax.swing.JFrame;
import javax.swing.JList;

public class interfaceShape {
	JFrame frame;
	JList list;
	private String _String;
	private String _Kind;
	private String _getDetail;
	private int _ID;

	public void initialize() {
		readtextfile r = new readtextfile();
		r.readtolist();
	}

	public interfaceShape() {
		initialize();
	}

	public String toString() {
		return _String;
	}

	public String getKind() {
		return _Kind;
	}

	public String getDetailString() {
		return _getDetail;
	}

	public int getID() {
		return _ID;
	}

	public static void main(String[] args) {
		interfaceShape is = new interfaceShape();
	}
}
