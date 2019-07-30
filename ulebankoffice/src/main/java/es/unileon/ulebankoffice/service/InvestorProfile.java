package es.unileon.ulebankoffice.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import es.unileon.ulebankoffice.domain.Answer;
import es.unileon.ulebankoffice.domain.Answers;

public class InvestorProfile {
	private List<double[]> ranges;
	private HashMap<Integer, String> types;
	public static final String EMPTY = "Empty investor profile ---  You must define the types.";
	private static final Logger logger = Logger.getLogger("ulebankLogger");

	public InvestorProfile() {
		this.ranges = new ArrayList<>();
		this.types = new HashMap<>();
	    String file ="investorprofile.txt";
	    
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			try {
				String currentLine = reader.readLine();
			    while(currentLine != null) {
			    	String[] type = currentLine.split(" ");
			    	ranges.add(new double[]{
			    			Double.parseDouble(type[0]),
			    			Double.parseDouble(type[1])
			    			});
			    	
			    	StringBuilder sb = new StringBuilder();
			    	for(int i = 2; i < type.length; i++) {
			    		sb.append(type[i] + " ");
			    	}
			    	types.put(ranges.size()-1, sb.toString().substring(0, sb.toString().length()-1));
					currentLine = reader.readLine();
			    }
			} catch (IOException e) {
				return;
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		} catch (FileNotFoundException e1) {
			logger.error(e1.getMessage());
		}

	}
	
    public String getInvestorProfile(Answers answers) {
        float total = 0;
        Iterator<Answer> iterator = answers.getIterator();
        
        while(iterator.hasNext()) {
            total += iterator.next().getOption().getWeight();
        }

        for(int i = 0; i < ranges.size(); i++) {
        	if(total >= ranges.get(i)[0] && total < ranges.get(i)[1]) {
        		return types.get(i);
        	}
        }
        
        return EMPTY;
    }

	public double getResultTest(Answers answers) {
        float total = 0;
        Iterator<Answer> iterator = answers.getIterator();
        
        while(iterator.hasNext()) {
            total += iterator.next().getOption().getWeight();
        }

        return total;  
	}

	public List<double[]> getRanges() {
		return new ArrayList<>(this.ranges);
	}
	
	public HashMap<Integer, String> getTypes() {
		return (HashMap<Integer, String>) this.types.clone();
	}
	
	public void setRanges(List<double []> ranges) {
		this.ranges = ranges;
	}
	
	public void setTypes(HashMap<Integer, String> types) {
		this.types = types;
	}
}