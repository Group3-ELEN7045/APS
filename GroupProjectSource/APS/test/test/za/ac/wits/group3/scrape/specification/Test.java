package test.za.ac.wits.group3.scrape.specification;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class Test {
	
	
	public static void main (String [] args){
		List<DataPair> dataPairsTrue = new ArrayList<DataPair>();
		
		dataPairsTrue.add(new DataPair("001","qaz","123456789"));
		dataPairsTrue.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairsTrue.add(new DataPair("001","qaz","12/12/2014"));
		dataPairsTrue.add(new DataPair("004","qaz","1122"));
		dataPairsTrue.add(new DataPair("005","qaz","2"));
		boolean flag = false;
		for (int i = 0; i < dataPairsTrue.size(); i++){
			for (int j = 0; j < dataPairsTrue.size(); j++){
				if(dataPairsTrue.get(i).getId().equals(dataPairsTrue.get(j).getId())){
					if (!dataPairsTrue.get(i).getValue().equals(dataPairsTrue.get(j).getValue())){
						System.out.println("not equal");
						//flag = true;
					}
				}
			}
		}
		System.out.println(flag);
	}
}
