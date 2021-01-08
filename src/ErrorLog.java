public class ErrorLog {

	private String machineId;
	private String description;

	/** Precondition: message is a valid Error log entry */
	public ErrorLog(String message) {
		machineId = message.substring(0,message.indexOf(':'));
		description = message.substring(message.indexOf(':') + 1);
	}

	public boolean containsKey(String keyword) {

		if(description.contains(keyword)){

			int startKey = description.indexOf(keyword);                                 //Finds the location of the first character of the keyword.
			int endKey = description.indexOf(keyword) + keyword.length() - 1;            //Finds the location of the last character of the keyword.

			if(description.startsWith(keyword) && description.charAt(endKey + 1) == ' ')                  //Case where keyword is at the beginning and is followed by a space.
				return true;
			else if (description.endsWith(keyword) && description.charAt(startKey - 1) == ' ')            //Case where keyword is at the end and is preceded by a space.
				return true;
			else if (description.charAt(startKey - 1) == ' ' && description.charAt(endKey + 1) == ' ')    //Case where keyword is preceded and followed by a space.
				return true;

			return false;

		}
		return false;
	}
	
	public String getMachineId() { return machineId;}
	public String getDescription() { return description; }

	public static void main(String[] args) {
		ErrorLog er1 = new ErrorLog("CLIENT2:security alert");
		ErrorLog er2 = new ErrorLog("Webserver:disk offline");
		ErrorLog er3 = new ErrorLog("SERVER22:file not found on disk3");
		ErrorLog er4 = new ErrorLog("SERVER15:read error on disk DSK7");
		ErrorLog er5 = new ErrorLog("SERVER22:write error on disk");
		ErrorLog er6 = new ErrorLog("Webserver:error on /dev/disk");
		
		System.out.println("message 1 " + er1.containsKey("disk"));
		System.out.println("message 2 " + er2.containsKey("disk"));
		System.out.println("message 3 " + er3.containsKey("disk"));
		System.out.println("message 4 " + er4.containsKey("disk"));
		System.out.println("message 5 " + er5.containsKey("disk"));
		System.out.println("message 6 " + er6.containsKey("disk"));
	}

}
