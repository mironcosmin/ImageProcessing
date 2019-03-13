import java.awt.image.BufferedImage;

public class Rotates implements RotateMeth {
	int height;//inalitimeaa imaginii
	int width;//latimea 
	BufferedImage img;
	
	public Rotates(int height,int width, BufferedImage img2){
		this.height = height;
		this.width = width;
		this.img = img2;
		
	}
	//translatarea matricei cu un unghi de 90
	@Override
	public BufferedImage Rotate90() {
		
		BufferedImage aux = new BufferedImage(height, width, img.getType());
		int j;
		for(int i = 0; i<width; i++)
			for(j=0; j<height; j++){
				aux.setRGB(j,i,img.getRGB(i, height-j-1));
				
		
	}
		return aux;
		
	}
	//translatarea matricei cu un unghi de 180
	@Override
	public BufferedImage Rotate180() {
		
	
		BufferedImage aux= new BufferedImage(width, height, img.getType());
		int j;
		for(int i = 0; i<height; i++)
			for(j=0; j<width; j++){
				aux.setRGB(j,i,img.getRGB(width-j-1, height-i-1));
			}
		return aux;
	}
	//translatarea matricei cu un unghi de 270
	@Override
	public BufferedImage Rotate270() {
		BufferedImage aux= new BufferedImage(height, width, img.getType());
		int j;
		for(int i = 0; i<width; i++)
			for(j=0; j<height; j++){
				aux.setRGB(j,i,img.getRGB(width-i-1, j));
			}
		return aux;
	}

}
