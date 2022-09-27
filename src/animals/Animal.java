package animals;

/**
 * You can modify the contents of this class, but you cannot:
 * - change the name, parameters or return types of provided methods
 * - change it to an interface or concrete class
 * - remove it entirely
 */
public abstract class Animal {

	private String nickName;

	public Animal() {}
	public Animal(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return Returns this animal's given name.
	 */
	public String getNickname() {
		return nickName;
	};
	/**
	 * Check whether two animals can live together.
	 * @param animal The animal for which to check compatibility with this animal.
	 * @return Returns true for compatible animals and false otherwise.
	 */
	public abstract boolean isCompatibleWith(Animal animal);
}
