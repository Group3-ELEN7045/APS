package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class StatementType {
	private String name;
	private String descrption;	
	private Set<StatementAttribute> statementAttributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Set<StatementAttribute> getStatementAttributes() {
		return statementAttributes;
	}
	public void setStatementAttributes(Set<StatementAttribute> statementAttributes) {
		this.statementAttributes = statementAttributes;
	}
	
	public void addAttribute(StatementAttribute attribute) {
        assert attribute instanceof StatementAttribute;
        if (statementAttributes == null) {
        	statementAttributes = new HashSet<StatementAttribute>();
        }
        statementAttributes.add((StatementAttribute) attribute);
    }
}
