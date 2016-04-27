package Emoji;

public class emoji {

	private String Name;
	private String emoji;
	
	public emoji(String cat,String name){
		this.setName(name);
		this.setEmoji(cat);
	}

	public String getName() {return Name;}
	public void setName(String Name) {this.Name = Name;}

	public String getEmoji() {return emoji;}
	public void setEmoji(String emoji) {this.emoji = emoji;}

}
