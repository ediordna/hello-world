package parcelp;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paket {
	@Override //automatisch von Eclipse generiert
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + length;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + width;
		return result;
	}

	@Override //automatisch von Eclipse generiert
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paket other = (Paket) obj;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	private String size;
	private int length;
	private int width;
	private int height;

	public Paket() {
		super();
	}

	public Paket(String size, int length, int width, int height) {
		super();
		this.size = size;
		this.length = length;
		this.width = width;
		this.height = height;
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
