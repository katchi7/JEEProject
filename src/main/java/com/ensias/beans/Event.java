package com.ensias.beans;

public class Event {
	private String event_name;
	private String event_description;
	private String event_start;
	private String event_end;
	private String event_class;
	private String event_icon;
	
	public String getEvent_class() {
        return event_class;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getEvent_end() {
        return event_end;
    }

    public String getEvent_icon() {
        return event_icon;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_start() {
        return event_start;
    }

    public void setEvent_class(String event_class) {
        this.event_class = event_class;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEvent_end(String event_end) {
        this.event_end = event_end;
    }

    public void setEvent_icon(String event_icon) {
        this.event_icon = event_icon;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setEvent_start(String event_start) {
        this.event_start = event_start;
    }
	
}
