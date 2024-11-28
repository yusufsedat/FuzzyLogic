package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Pencere {
	
	private FIS fis;
	private double oksijenSeviyesi;
	private double yagisDurumu;

	
	public Pencere(double oksijenSeviyesi,double yagisDurumu) throws URISyntaxException {
		this.oksijenSeviyesi=oksijenSeviyesi;
		this.yagisDurumu=yagisDurumu;
		
		File dosya = new File(getClass().getResource("PencereModel.fcl").toURI());
		fis = FIS.load(dosya.getPath());
		fis.setVariable("oksijenSeviyesi", oksijenSeviyesi);
		fis.setVariable("yagisDurumu", yagisDurumu);
		fis.evaluate();
	}
	public FIS getModel(){
		return fis;
	}
	@Override
	public String toString() {
		String cikti;
		cikti = "Pencere Açıklığı = "+ Math.round(fis.getVariable("pencereAcikligi").getValue())+" cm" ;
		return cikti;
	}

}

