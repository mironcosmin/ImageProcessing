import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.*;
public class Imagine extends Abstract {
	private String path;//calea spre imagine
	private BufferedImage img=null;//creerea unui nou element de tip imagine
	int height;//inaltimea imaginii
    int width;//latimea imaginii
     
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public void openPath() {
		try{
			img=ImageIO.read(new File(path));//elementul de tip imagine primeste vloarea specificata prin calea folosita
			height = img.getHeight();//sunt setatea inaltimea silatimea imaginii
		    width = img.getWidth();
	
		}
		catch(IOException e){
			System.out.println("Adresa invalida");
		}
		
	}
	public void rotate(String k){
		
		
	   
		BufferedImage aux=null;//crearea unei imagni auxiliare in care va fi stocat rezultatul
		String pathDestinatie;//destinata rezultatului 
		String numeFisier;//noul nume al rezultatului
		File file = null;//fisierul destinatie
	
		//apelul metodelor de rptire in functoe de valoarea unghiului
		Rotates test = new Rotates(height,width,img);
		if(k.equals("90")){
			aux = test.Rotate90();
		}
		else if(k.equals("180")){
			aux = test.Rotate180();
		}
		else if(k.equals("270")){
			aux = test.Rotate270();
		}

			//introducerea destinatiei noii fotografii
			System.out.println("Introduceti calea imaginii rezultat:");
			Scanner scan = new Scanner(System.in);
			pathDestinatie=scan.nextLine();
			System.out.println("Introduceti numele imaginii rezultat:");
			
			numeFisier=scan.nextLine()+".bmp";
			scan.close();
			//aflarea timpului d eexecutie al programului
			long startTime = System.currentTimeMillis();	
			file = new File(pathDestinatie, numeFisier);
			try{
				ImageIO.write(aux, "bmp", file);
				System.out.println("Succes!");
				long stopTime = System.currentTimeMillis();//timpul e executie se calculeaza c adiferenta a 
				long elapsedTime = stopTime - startTime;//momentului de timp la care se lanseaza 
				System.out.println("Transformare efectuata in "+elapsedTime + "ms");//programul si momentul de timp la care se termina executia cestuia 
				}
				catch(IOException e){
					System.out.println("Adresa invalida");
				}
		
			
		
 
	}
	public int getType() {
		return img.getType();
		
	}
	public int getRGB(int i, int j) {
		// TODO Auto-generated method stub
		return img.getRGB(i, j);//metodace returneaza pixelul[i][j] al imaginii
		
	}
	
	public int getRGB(int i) {
		// TODO Auto-generated method stub
		return img.getRGB(i, i);//metodace returneaza pixelul[i][i] al imaginii
		
	}
	
	
	
}
