package de.dailab.jiactng.sercho.rulesengine;

import java.io.Serializable;

public class SheaRule implements Serializable {

	private static final long serialVersionUID = 5782612605867232474L;
	
	public static final int ACTIVATED= 0;
	public static final int NOT_ACTIVATED= 1;
	
	public static final int CATEGORY_ECO= 0;
	public static final int CATEGORY_SECURITY= 1;
	public static final int CATEGORY_COMFORT= 2;
	
	private int _id;
	private int _state;
	private int _category;
	private Object _drlRule;
	private String _title;
	private String _text;
	private String _additionalText;
	
	public SheaRule() {
	}
	
	public SheaRule(Object drlRule, String text, String addText, String title, int id, int cat, int state) {
		_drlRule= drlRule;
		_text= text;
		_additionalText= addText;
		_title= title;
		_id= id;
		_category= cat;
		_state= state;
	}
	
	
	public int getId() {
		return _id;
	}

	public int getState() {
		return _state;
	}
	
	public void setState(int state) {
		this._state= state;
	}
	
	public int getCategory() {
		return _category; 
	}

	public Object getDroolsRule() {
		return _drlRule;
	}

	public String getTitle() {
		return _title;
	}

	public String getHudText() {
		return _text;
	}

	public String getAdditionalText() {
		return _additionalText;
	}
	
	public void setAdditionalText(String s) {
		_additionalText= s;
	}
	
	public boolean isActive() {
		return _state == ACTIVATED;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof SheaRule) && ((SheaRule)o)._id == this._id;
	}
	
	@Override
	public String toString() {
		return _title + " (" + _text  +"): " + (_state == ACTIVATED ? "on" : "off");
	}
	
}
