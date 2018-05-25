package parcelp;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paket {
	private int length;
	private int width;
	private int height;
	private String size;

	public Paket() {
		super();
	}

	public Paket(int length, int width, int height, String size) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.size = size;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
