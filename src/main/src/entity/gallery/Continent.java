/**
 * 
 */
package main.src.entity.gallery;

/**
 * @author Administrator
 *Continent
 */
public enum Continent {
NorthAmerica(0,"北美"),MiddleAmerica(1,"中美"),SouthAmerica(2,"南美"),EastAsia(3,"东亚"),SoutheastAsia(4,"东南亚"),
SouthAsia(5,"南亚"),MiddleAsia(6,"中亚"),EasternEurope(7,"东欧"),NorthernEurope(8,"北欧"),
WesternEurope(9,"西欧"),Oceania(10,"大洋洲"),Africa(11,"非洲"),Antarctica(12,"南极洲");
	private String name;
	private int index;
	private Continent(int index,String name){
		this.name = name;
		this.index = index;
	}
	public String getName() {
		System.out.println("continent getName");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	static public Continent get(String name) {
		for(Continent c:Continent.values())
		{
			if(c.getName().equals(name)){
				return c;
			}
		}
		return Continent.Antarctica;
	}
	static public Continent get(int index) {
		for(Continent c:Continent.values())
		{
			if(c.getIndex() == index){
				return c;
			}
		}
		return Continent.Antarctica;
	}
	
}
