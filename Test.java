package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;


import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Test {

	public static void main(String[] args) throws URISyntaxException {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Oksijen Seviyesi (0-100): ");
		double oksijenSeviyesi = in.nextDouble();
		System.out.print("Yağış Durumu (0-75): ");
		double yagisDurumu = in.nextDouble();
		
		Pencere pencere = new Pencere(oksijenSeviyesi,yagisDurumu);
		System.out.println(pencere);
		JFuzzyChart.get().chart(pencere.getModel().getVariable("pencereAcikligi").getDefuzzifier(),"Pencere Açıklığı",true);		
		
		for(Rule r: pencere.getModel().getFunctionBlock("PencereModel").getFuzzyRuleBlock("kuralBlok1").getRules()) {
			if(r.getDegreeOfSupport()> 0)
				System.out.println(r);			
				
		}
		
		JFuzzyChart.get().chart(pencere.getModel());
		
	}

}
