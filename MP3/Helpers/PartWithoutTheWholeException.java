package MP3.Helpers;

public class PartWithoutTheWholeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PartWithoutTheWholeException() {
	}
	
	public String toString(){
		return "Część nie może istnieć bez całości!";
	}
}
