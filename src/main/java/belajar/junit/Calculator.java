package belajar.junit;

public class Calculator {
	public Integer tambah(Integer x, Integer y){
		if(x == null || y == null) {
			throw new IllegalArgumentException("Input tidak boleh null");
		}
		return x + y;
	}
	
	public Integer kurang(Integer x, Integer y){
		return 0;
	}
	
	public Integer kali(Integer x, Integer y){
		return 0;
	}
}
